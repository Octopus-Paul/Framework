package ru.iis.framework.data.repository;

import static ru.iis.framework.utils.Constants.BASE_COAST;
import static ru.iis.framework.utils.Constants.POINTS_COUNT;

import ru.iis.framework.data.Prefs;

public class InitiativeRepository {
    private final Prefs prefs;

    public InitiativeRepository(Prefs prefs){
        this.prefs = prefs;
    }

    public void saveSumm(float points){
        prefs.put(POINTS_COUNT,points);
    }

    public float getPoints(){
        return prefs.getFloat(POINTS_COUNT);
    }

    public float getBaseCoast(){
        return prefs.getFloat(BASE_COAST);
    }

    public void setBaseCoast(float baseCoastPlus){
        prefs.put(BASE_COAST,getBaseCoast()+baseCoastPlus);
    }
}
