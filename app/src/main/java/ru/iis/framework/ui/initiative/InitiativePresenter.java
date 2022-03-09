package ru.iis.framework.ui.initiative;

import javax.inject.Inject;

import ru.iis.framework.data.repository.ClickerRepository;
import ru.iis.framework.data.repository.InitiativeRepository;
import ru.iis.framework.ui.base.BasePresenter;
import ru.iis.framework.ui.clicker.ClickerContract;

public class InitiativePresenter extends BasePresenter<InitiativeContract.View> implements InitiativeContract.Presenter {

    public InitiativeRepository initiativeRepository;
    //Инициализация
    @Inject
    public InitiativePresenter(InitiativeRepository initiativeRepository) {
        this.initiativeRepository = initiativeRepository;
    }
    //Не трогать!
    @Override
    public void attachView(InitiativeContract.View view) {
        super.attachView(view);
    }
    //Сэйв очков
    public void savePoints(float points){
        initiativeRepository.saveSumm(points);
    }
    //Загрузка очков
    public float getPoints(){
        return initiativeRepository.getPoints();
    }
    //Получение переменной для формулы
    public float getBaseCoast(){
        return initiativeRepository.getBaseCoast();
    }
    //Сэйв переменной для формулы
    public void saveBaseCoast(float baseCoastPlus){
        initiativeRepository.setBaseCoast(baseCoastPlus);
    }

}
