package ru.iis.framework.data.repository;

import static ru.iis.framework.utils.Constants.BASE_COAST;
import static ru.iis.framework.utils.Constants.BUYING;
import static ru.iis.framework.utils.Constants.POINTS_COUNT;
import static ru.iis.framework.utils.Constants.SPEED;

import ru.iis.framework.data.Prefs;

public class KnowledgeRepository {
    private final Prefs prefs;

    public KnowledgeRepository(Prefs prefs){
        this.prefs = prefs;
    }

    public void saveSumm(float points){
        prefs.put(POINTS_COUNT,points);
    }

    public float getPoints(){
        return prefs.getFloat(POINTS_COUNT);
    }

    public float getSpeed(){
        return prefs.getFloat(SPEED);
    }

    public void setSpeed(float newSpeed){
        prefs.put(SPEED,newSpeed);
    }

    public void setKnowledges(boolean[] buyed){
        prefs.put(buyed);
    }

    public boolean[] getKnowledges(){
        return prefs.getBooleans();
    }
}
