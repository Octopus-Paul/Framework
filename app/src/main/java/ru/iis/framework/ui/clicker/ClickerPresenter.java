package ru.iis.framework.ui.clicker;

import javax.inject.Inject;

import ru.iis.framework.data.repository.AuthRepository;
import ru.iis.framework.data.repository.ClickerRepository;
import ru.iis.framework.data.repository.TestRepository;
import ru.iis.framework.ui.base.BasePresenter;
import ru.iis.framework.ui.test.TestContract;

public class ClickerPresenter extends BasePresenter<ClickerContract.View> implements ClickerContract.Presenter {

    public ClickerRepository clickerRepository;
    //Инициализация
    @Inject
    public ClickerPresenter(ClickerRepository clickerRepository) {
        this.clickerRepository = clickerRepository;
    }
    //Не трогать!
    @Override
    public void attachView(ClickerContract.View view) {
        super.attachView(view);
    }
    //Пассивный доход
    public void afkPlus(float baseCost){
        getView().changeCount(clickerRepository.afkPlus(baseCost));
    }
    //Сэйв очков
    public void savePoints(float points){
        clickerRepository.saveSumm(points);
    }
    //Загрузка очков
    public float getPoints(){
        return clickerRepository.getPoints();
    }
    //Получение переменной для формулы
    public float getBaseCoast(){
        return clickerRepository.getBaseCoast();
    }
    //Доход от клика
    public void clickPlus(float baseCoast){
        getView().changeCount(clickerRepository.clickPlus(baseCoast));
    }

}
