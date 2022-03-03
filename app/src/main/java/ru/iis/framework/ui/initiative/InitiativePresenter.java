package ru.iis.framework.ui.initiative;

import javax.inject.Inject;

import ru.iis.framework.data.repository.ClickerRepository;
import ru.iis.framework.data.repository.InitiativeRepository;
import ru.iis.framework.ui.base.BasePresenter;
import ru.iis.framework.ui.clicker.ClickerContract;

public class InitiativePresenter extends BasePresenter<InitiativeContract.View> implements InitiativeContract.Presenter {

    public InitiativeRepository initiativeRepository;

    @Inject
    public InitiativePresenter(InitiativeRepository initiativeRepository) {
        this.initiativeRepository = initiativeRepository;
    }

    @Override
    public void attachView(InitiativeContract.View view) {
        super.attachView(view);
    }

    public void savePoints(float points){
        initiativeRepository.saveSumm(points);
    }

    public float getPoints(){
        return initiativeRepository.getPoints();
    }

    public float getBaseCoast(){
        return initiativeRepository.getBaseCoast();
    }

    public void saveBaseCoast(float baseCoastPlus){
        initiativeRepository.setBaseCoast(baseCoastPlus);
    }

}
