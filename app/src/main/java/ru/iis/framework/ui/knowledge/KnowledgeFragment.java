package ru.iis.framework.ui.knowledge;

import static ru.iis.framework.utils.Constants.INITIATIVES_ADD;
import static ru.iis.framework.utils.Constants.INITIATIVES_BASE;
import static ru.iis.framework.utils.Constants.INITIATIVES_ICONS;
import static ru.iis.framework.utils.Constants.INITIATIVES_NAME;
import static ru.iis.framework.utils.Constants.KNOWLEDGES_ADD;
import static ru.iis.framework.utils.Constants.KNOWLEDGES_BASE;
import static ru.iis.framework.utils.Constants.KNOWLEDGES_ICONS;
import static ru.iis.framework.utils.Constants.KNOWLEDGES_NAME;

import android.annotation.SuppressLint;
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
import ru.iis.framework.databinding.FragmentInitiativeBinding;
import ru.iis.framework.databinding.FragmentKnowledgeBinding;
import ru.iis.framework.ui.adapter.InitiativeAdapter;
import ru.iis.framework.ui.adapter.KnowladgeAdapter;
import ru.iis.framework.ui.base.BaseFragment;
import ru.iis.framework.ui.initiative.InitiativeContract;
import ru.iis.framework.ui.initiative.InitiativePresenter;

public class KnowledgeFragment extends BaseFragment implements KnowledgeContract.View {

    FragmentKnowledgeBinding binding;

    @Inject
    KnowledgePresenter knowledgePresenter;
    //Очки
    float points;
    //Переменная формулы
    float speed;
    //Массив купленных товаров
    boolean[] flags;
    //Адаптер
    KnowladgeAdapter knowladgeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentKnowledgeBinding.inflate(inflater, container, false);
        //Получение из памяти очков
        points= knowledgePresenter.getPoints();
        //Получение переменной формулы
        speed = knowledgePresenter.getSpeed();
        //Помещение кол-ва очков в поле
        changeCount(points);
        //Получение из памяти очков
        flags=knowledgePresenter.getKnowledges();
        //Инициализация адаптера и работа с ним
        knowladgeAdapter = new KnowladgeAdapter(KNOWLEDGES_NAME,KNOWLEDGES_BASE,KNOWLEDGES_ADD,
                                                KNOWLEDGES_ICONS, flags,this);
        GridLayoutManager glm = new GridLayoutManager(requireContext(), 2);
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        binding.knowledgeRv.setLayoutManager(glm);
        binding.knowledgeRv.setAdapter(knowladgeAdapter);

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
        knowledgePresenter.attachView(this);
    }
    //НЕ ТРОГАТЬ!
    @Override
    protected void detachPresenter() {
        knowledgePresenter.detachView();
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
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void buyButton(float speed, float minus, int position) {
        if(minus<points){
            flags[position]=true;
            knowledgePresenter.setKnowledges(flags);
            knowledgePresenter.setSpeed(speed);
            points-=minus;
            knowledgePresenter.savePoints(points);
            changeCount(points);
            knowladgeAdapter.notifyDataSetChanged();
            Toast.makeText(requireContext(), "Покупка совершена", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(requireContext(), "Не хватает средств", Toast.LENGTH_SHORT).show();
        }
    }
    //НЕ ТРОГАТЬ!
    @Override
    public void onPause() {
        knowledgePresenter.savePoints(points);
        super.onPause();
    }
    //НЕ ТРОГАТЬ!
    @Override
    public void onDestroyView() {
        knowledgePresenter.savePoints(points);
        super.onDestroyView();
    }
    //Округление
    public static double roundAvoid(float value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
