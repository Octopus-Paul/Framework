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
    float points;
    float baseCoast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentClickerBinding.inflate(inflater, container, false);
        ((MainActivity)requireActivity()).setMenu(MENU_CLICKER);

        points= clickerPresenter.getPoints();
        baseCoast = clickerPresenter.getBaseCoast();

        binding.plusButton.setOnClickListener(v-> clickerPresenter.clickPlus(baseCoast));

        timerMethod();
        return binding.getRoot();
    }

    public void timerMethod(){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                clickerPresenter.afkPlus(baseCoast);
                clickerPresenter.savePoints(points);
            }
        };
        timer.schedule(timerTask,0,1000);

    }

    @Override
    public void inject() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void attachView() {
        clickerPresenter.attachView(this);
    }

    @Override
    protected void detachPresenter() {
        clickerPresenter.detachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void changeCount(float plus) {
        requireActivity().runOnUiThread(() -> {
            points +=plus;
            binding.points.setText(requireContext().getString(R.string.pointsCount).replace("$points",String.valueOf(roundAvoid(points,1))));
        });
    }

    @Override
    public void onPause() {
        clickerPresenter.savePoints(points);
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        clickerPresenter.savePoints(points);
        super.onDestroyView();
    }

    public static double roundAvoid(float value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
