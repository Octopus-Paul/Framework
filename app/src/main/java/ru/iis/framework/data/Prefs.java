package ru.iis.framework.data;

import static ru.iis.framework.utils.Constants.BUYING;
import static ru.iis.framework.utils.Constants.KNOWLEDGES_BUYED;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;

public class Prefs {

    private final SharedPreferences sp;
    //Инициализация
    public Prefs(Context context) {
        sp = PreferenceManager.getDefaultSharedPreferences(context);
    }
    //Сэйв стрингов
    public void put(String name, String value) {
        sp.edit().putString(name, value).apply();
    }
    //Сэйв флоат
    public void put(String name, float value) {
        sp.edit().putFloat(name, value).apply();
    }
    //Загрузка стринга
    public String getString(String name) {
        return sp.getString(name, null);
    }
    //Загрузка флоат
    public float getFloat(String name){
        return sp.getFloat(name,0.2f);
    }
    //Сэйв массива
    public void put(boolean[] list){
        Gson gson = new Gson();
        String json = gson.toJson(list);
        put(BUYING, json);
    }
    //Загрузка массива
    public boolean[] getBooleans(){
        boolean[] list = new Gson().fromJson(getString(BUYING), boolean[].class);
        if (list != null)
            return list;
        else
            return KNOWLEDGES_BUYED;
    }
}
