package ru.iis.framework.ui.initiative;

import static ru.iis.framework.utils.Constants.INITIATIVES_ADD;
import static ru.iis.framework.utils.Constants.INITIATIVES_BASE;
import static ru.iis.framework.utils.Constants.INITIATIVES_ICONS;
import static ru.iis.framework.utils.Constants.INITIATIVES_NAME;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import javax.inject.Inject;

import ru.iis.framework.App;
import ru.iis.framework.R;
import ru.iis.framework.databinding.FragmentClickerBinding;
import ru.iis.framework.databinding.FragmentInitiativeBinding;
import ru.iis.framework.ui.adapter.InitiativeAdapter;
import ru.iis.framework.ui.base.BaseFragment;
import ru.iis.framework.ui.clicker.ClickerContract;
import ru.iis.framework.ui.clicker.ClickerPresenter;

public class InititativeFragment extends BaseFragment implements InitiativeContract.View {

    FragmentInitiativeBinding binding;

    @Inject
    InitiativePresenter initiativePresenter;
    //Очки
    float points;
    //Переменная формулы
    float baseCoast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentInitiativeBinding.inflate(inflater, container, false);

        //Получение из памяти очков
        points= initiativePresenter.getPoints();
        baseCoast = initiativePresenter.getBaseCoast();
        //Помещение кол-ва очков в поле
        changeCount(points);
        //Инициализация адаптера и работа с ним
        InitiativeAdapter initiativeAdapter = new InitiativeAdapter(INITIATIVES_NAME,INITIATIVES_BASE,INITIATIVES_ADD,
                                                                    INITIATIVES_ICONS, this);
        GridLayoutManager glm = new GridLayoutManager(requireContext(), 2);
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        binding.initiativeRv.setLayoutManager(glm);
        binding.initiativeRv.setAdapter(initiativeAdapter);

        return binding.getRoot();
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
        initiativePresenter.attachView(this);
    }
    //НЕ ТРОГАТЬ!
    @Override
    protected void detachPresenter() {
        initiativePresenter.detachView();
    }
    //НЕ ТРОГАТЬ!
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    //Помещение текста в поле
    @Override
    public void changeCount(float sum) {
        points=sum;
        binding.pointsCount.setText(String.valueOf(roundAvoid(points,1)));
    }
    //Логика клика по кнопке в списке
    @Override
    public void buyButton(float bonus, float minus) {
        if(minus<points){
            initiativePresenter.saveBaseCoast(bonus);
            points-=minus;
            initiativePresenter.savePoints(points);
            changeCount(points);
            Toast.makeText(requireContext(), "Покупка совершена", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(requireContext(), "Не хватает средств", Toast.LENGTH_SHORT).show();
        }
    }
    //Округление
    public static double roundAvoid(float value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    //НЕ ТРОГАТЬ!
    @Override
    public void onPause() {
        initiativePresenter.savePoints(points);
        super.onPause();
    }
    //НЕ ТРОГАТЬ!
    @Override
    public void onDestroyView() {
        initiativePresenter.savePoints(points);
        super.onDestroyView();
    }
}
