package ru.iis.framework.data.repository;

import static ru.iis.framework.utils.Constants.BASE_COAST;
import static ru.iis.framework.utils.Constants.MULTIPLIER;
import static ru.iis.framework.utils.Constants.POINTS_COUNT;
import static ru.iis.framework.utils.Constants.SPEED;

import ru.iis.framework.data.Prefs;

public class ClickerRepository {
    private final Prefs prefs;
    //Инициализация
    public ClickerRepository(Prefs prefs){
        this.prefs = prefs;
    }
    //Формула пассивного дохода
    public float afkPlus(float baseCoast){
        return baseCoast*prefs.getFloat(MULTIPLIER);
    }
    //Сэйв очков (Кроме смерти активити - лучше передавать очки в бандлах, но мне лень)
    public void saveSumm(float points){
        prefs.put(POINTS_COUNT,points);
    }
    //Загрузить из памяти очки
    public float getPoints(){
        return prefs.getFloat(POINTS_COUNT);
    }
    //Загрузка части формулы
    public float getBaseCoast(){
        return prefs.getFloat(BASE_COAST);
    }
    //Формула увелечения очков за клик
    public float clickPlus(float baseCoast){
        return (float) (baseCoast*(Math.pow( 1.15,prefs.getFloat(SPEED))));
    }
}
