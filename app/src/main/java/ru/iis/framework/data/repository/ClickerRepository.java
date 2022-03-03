package ru.iis.framework.data.repository;

import static ru.iis.framework.utils.Constants.BASE_COAST;
import static ru.iis.framework.utils.Constants.MULTIPLIER;
import static ru.iis.framework.utils.Constants.POINTS_COUNT;
import static ru.iis.framework.utils.Constants.SPEED;

import ru.iis.framework.data.Prefs;

public class ClickerRepository {
    private final Prefs prefs;

    public ClickerRepository(Prefs prefs){
        this.prefs = prefs;
    }

    public float afkPlus(float baseCoast){
        return baseCoast*prefs.getFloat(MULTIPLIER);
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

    public float clickPlus(float baseCoast){
        return (float) (baseCoast*(Math.pow( 1.15,prefs.getFloat(SPEED))));
    }
}
