package ru.iis.framework.ui.knowledge;

import javax.inject.Inject;

import ru.iis.framework.data.repository.InitiativeRepository;
import ru.iis.framework.data.repository.KnowledgeRepository;
import ru.iis.framework.ui.base.BasePresenter;
import ru.iis.framework.ui.initiative.InitiativeContract;

public class KnowledgePresenter extends BasePresenter<KnowledgeContract.View> implements KnowledgeContract.Presenter {

    public KnowledgeRepository knowledgeRepository;

    @Inject
    public KnowledgePresenter(KnowledgeRepository knowledgeRepository) {
        this.knowledgeRepository = knowledgeRepository;
    }

    @Override
    public void attachView(KnowledgeContract.View view) {
        super.attachView(view);
    }

    public float getSpeed(){
        return knowledgeRepository.getSpeed();
    }
    public void setSpeed(float speed){
        knowledgeRepository.setSpeed(speed);
    }

    public void setKnowledges(boolean[] buyed){
        knowledgeRepository.setKnowledges(buyed);
    }

    public boolean[] getKnowledges(){
        return knowledgeRepository.getKnowledges();
    }

    public void savePoints(float points){
        knowledgeRepository.saveSumm(points);
    }

    public float getPoints(){
        return knowledgeRepository.getPoints();
    }
}
