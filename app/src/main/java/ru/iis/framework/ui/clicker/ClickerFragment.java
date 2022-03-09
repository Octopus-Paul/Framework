package ru.iis.framework.ui.clicker;

import static ru.iis.framework.utils.Constants.MENU_CLICKER;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import ru.iis.framework.App;
import ru.iis.framework.MainActivity;
import ru.iis.framework.R;
import ru.iis.framework.databinding.FragmentClickerBinding;
import ru.iis.framework.ui.base.BaseFragment;

public class ClickerFragment extends BaseFragment implements ClickerContract.View {

    FragmentClickerBinding binding;

    @Inject
    ClickerPresenter clickerPresenter;
    //Очки
    double points;
    //Переменная формулы
    float baseCoast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentClickerBinding.inflate(inflater, container, false);
        //Выбор айтема в bnm
        ((MainActivity)requireActivity()).setMenu(MENU_CLICKER);
        //Получение из памяти очков
        points= clickerPresenter.getPoints();
        //Получение переменной формулы
        baseCoast = clickerPresenter.getBaseCoast();
        //Листенер клика по иконке ИИС
        binding.plusButton.setOnClickListener(v-> clickerPresenter.clickPlus(baseCoast));

        timerMethod();
        return binding.getRoot();
    }
    //Логика таймера
    public void timerMethod(){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                clickerPresenter.afkPlus(baseCoast);
                clickerPresenter.savePoints((float)points);
            }
        };
        timer.schedule(timerTask,0,1000);

    }
    //НЕ ТРОГАТЬ!
    @Override
    public void inject() {
        App.getAppComponent().inject(this);
    }
    //НЕ ТРОГАТЬ!
    @Override
    public void showError(String error) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show();
    }
    //НЕ ТРОГАТЬ!
    @Override
    protected void attachView() {
        clickerPresenter.attachView(this);
    }
    //НЕ ТРОГАТЬ!
    @Override
    protected void detachPresenter() {
        clickerPresenter.detachView();
    }
    //НЕ ТРОГАТЬ!
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    //Изменение цены
    @Override
    public void changeCount(float plus) {
        requireActivity().runOnUiThread(() -> {
            points +=plus;
            binding.points.setText(requireContext().getString(R.string.pointsCount).replace("$points",String.valueOf(roundAvoid(points,1))));
        });
    }
    //НЕ ТРОГАТЬ!
    @Override
    public void onPause() {
        clickerPresenter.savePoints((float)points);
        super.onPause();
    }
    //НЕ ТРОГАТЬ!
    @Override
    public void onDestroyView() {
        clickerPresenter.savePoints((float)points);
        super.onDestroyView();
    }
    //Окпугление для демонстрации юзеру
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
