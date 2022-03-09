package ru.iis.framework.data.repository;

import static ru.iis.framework.utils.Constants.BASE_COAST;
import static ru.iis.framework.utils.Constants.BUYING;
import static ru.iis.framework.utils.Constants.POINTS_COUNT;
import static ru.iis.framework.utils.Constants.SPEED;

import ru.iis.framework.data.Prefs;

public class KnowledgeRepository {
    private final Prefs prefs;
    //Инициализация
    public KnowledgeRepository(Prefs prefs){
        this.prefs = prefs;
    }
    //Сэйв очков (Кроме смерти активити - лучше передавать очки в бандлах, но мне лень)
    public void saveSumm(float points){
        prefs.put(POINTS_COUNT,points);
    }
    //Загрузка части формулы, для сэйва
    public float getPoints(){
        return prefs.getFloat(POINTS_COUNT);
    }
    //Получение переменной формулы
    public float getSpeed(){
        return prefs.getFloat(SPEED);
    }
    //Сэйв переменной формулы
    public void setSpeed(float newSpeed){
        prefs.put(SPEED,newSpeed);
    }
    //Сэйв списка купленного
    public void setKnowledges(boolean[] buyed){
        prefs.put(buyed);
    }
    //Загрузка списка купленного
    public boolean[] getKnowledges(){
        return prefs.getBooleans();
    }
}
