package ru.iis.framework.data.repository;

import static ru.iis.framework.utils.Constants.BASE_COAST;
import static ru.iis.framework.utils.Constants.POINTS_COUNT;

import ru.iis.framework.data.Prefs;

public class InitiativeRepository {
    private final Prefs prefs;
    //Инициализация
    public InitiativeRepository(Prefs prefs){
        this.prefs = prefs;
    }
    //Сэйв очков (Кроме смерти активити - лучше передавать очки в бандлах, но мне лень)
    public void saveSumm(float points){
        prefs.put(POINTS_COUNT,points);
    }
    //Загрузить из памяти очков(Но лучше бандлами, снова)
    public float getPoints(){
        return prefs.getFloat(POINTS_COUNT);
    }
    //Загрузка части формулы, для сэйва
    public float getBaseCoast(){
        return prefs.getFloat(BASE_COAST);
    }
    //Сэйв переменной формулы
    public void setBaseCoast(float baseCoastPlus){
        prefs.put(BASE_COAST,getBaseCoast()+baseCoastPlus);
    }
}
