package ru.iis.framework.ui.clicker;

import javax.inject.Inject;

import ru.iis.framework.data.repository.AuthRepository;
import ru.iis.framework.data.repository.ClickerRepository;
import ru.iis.framework.data.repository.TestRepository;
import ru.iis.framework.ui.base.BasePresenter;
import ru.iis.framework.ui.test.TestContract;

public class ClickerPresenter extends BasePresenter<ClickerContract.View> implements ClickerContract.Presenter {

    public ClickerRepository clickerRepository;

    @Inject
    public ClickerPresenter(ClickerRepository clickerRepository) {
        this.clickerRepository = clickerRepository;
    }

    @Override
    public void attachView(ClickerContract.View view) {
        super.attachView(view);
    }

    public void afkPlus(float baseCost){
        getView().changeCount(clickerRepository.afkPlus(baseCost));
    }

    public void savePoints(float points){
        clickerRepository.saveSumm(points);
    }

    public float getPoints(){
        return clickerRepository.getPoints();
    }

    public float getBaseCoast(){
        return clickerRepository.getBaseCoast();
    }

    public void clickPlus(float baseCoast){
        getView().changeCount(clickerRepository.clickPlus(baseCoast));
    }

}
