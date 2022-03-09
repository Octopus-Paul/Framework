package ru.iis.framework.data.repository;

import ru.iis.framework.data.Prefs;

public class TestRepository {

    private final Prefs prefs;
    //Остаток от шаблона архитектуры
    public TestRepository(Prefs prefs){
        this.prefs = prefs;
    }
}
