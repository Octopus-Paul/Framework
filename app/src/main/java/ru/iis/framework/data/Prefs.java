package ru.iis.framework.data;

import static ru.iis.framework.utils.Constants.BUYING;
import static ru.iis.framework.utils.Constants.KNOWLEDGES_BUYED;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Prefs {

    private final SharedPreferences sp;

    public Prefs(Context context) {
        sp = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void put(String name, String value) {
        sp.edit().putString(name, value).apply();
    }

    public void put(String name, float value) {
        sp.edit().putFloat(name, value).apply();
    }

    public void put(String name, Boolean value) {
        sp.edit().putBoolean(name, value).apply();
    }

    public void put(String name, long value) {
        sp.edit().putLong(name, value).apply();
    }

    public String getString(String name) {
        return sp.getString(name, null);
    }

    public long getLong(String name){
        return sp.getLong(name, 1);
    }

    public float getFloat(String name){
        return sp.getFloat(name,0.2f);
    }

    public boolean getBoolean(String name) {
        return sp.getBoolean(name, false);
    }

    public void put(boolean[] list){
        Gson gson = new Gson();
        String json = gson.toJson(list);
        put(BUYING, json);
    }

    public boolean[] getBooleans(){
        boolean[] list = new Gson().fromJson(getString(BUYING), boolean[].class);
        if (list != null)
            return list;
        else
            return KNOWLEDGES_BUYED;
    }
}
