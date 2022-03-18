package ru.iis.framework.utils;

import ru.iis.framework.R;

public class Constants {

    //Network осталось от шаблона архитектуры, но убирать жутко лень. Можете заняться этим
    public static final String NETWORK_BASE_URL = "https://test.ru/";
    public static final long NETWORK_TIMEOUT_SEC = 10;

    //айдишники айтемов. Используется в mainActivity
    public static final int MENU_OFF = -1;
    public static final int MENU_CLICKER = R.id.clickerMenuItem;
    public static final int MENU_INITIATIVE = R.id.initiativeMenuItem;
    public static final int MENU_KNOWLEDGE = R.id.knowledgeMenuItem;

    //Знания-название
    public static final String[] KNOWLEDGES_NAME={"Сходить в\nбиблиотеку","Поучаствовать в\nолимпиаде","Подготовиться к\nконтрольной","Посетить\nконференцию","Подготовить\nпроект","Сходить на\nпрактику",
                                                    "Работа над\nдипломом","Стать\nбакалавром","Стать\nмагистром","Стать\nаспирантом","Защитить\nкандидатскую","Защитить\nдокторскую","Стать\nзав. кафедрой",
                                                        "Стать\nдир. Института","Стать\nпроректором","Стать\nректором"}; //16
    //Знания-цена
    public static final long[] KNOWLEDGES_BASE= new long[]{15, 100, 500, 3000, 10000, 40000, 100000, 350000, 1000000, 3000000,5000000,10000000,15000000,25000000,35000000,50000000};
    //Знания-баф формулы
    public static final float[] KNOWLEDGES_ADD= new float[]{0.1f,0.3f,0.4f,1,5,25,70,250,750,2300,4500,10000,15000,27000,40000,75000};
    //Знания-дэф значения. Используется до первого сейва, что бы не ловить null
    public static final boolean[] KNOWLEDGES_BUYED=new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
    //Знания-айдишники иконок
    public static final int[] KNOWLEDGES_ICONS=new int[]{R.drawable.ic_library,R.drawable.ic_sport,R.drawable.ic_cup,R.drawable.ic_meeting,R.drawable.ic_project,R.drawable.ic_practic,
                                                        R.drawable.ic_diplom,R.drawable.ic_bachelor,R.drawable.ic_magistr,R.drawable.ic_aspirant,R.drawable.ic_rector,R.drawable.ic_doc,
                                                        R.drawable.ic_zav,R.drawable.ic_dec,R.drawable.ic_prorec,R.drawable.ic_rector1};

    //Инициативы-текст
    public static final String[] INITIATIVES_NAME={"Помочь\nстудсовету","Сходить в\nНЕОН","Посетить\nярморку","Сходить в\nКВН"};
    //Инициативы-цена
    public static final int[] INITIATIVES_BASE= new int[]{10,100,1000,10000};
    //Инициативы-баф формулы
    public static final float[] INITIATIVES_ADD= new float[]{0.1f,0.5f,1,3};
    //Инициативы-айдишники иконок
    public static final int[] INITIATIVES_ICONS=new int[]{R.drawable.ic_stud,R.drawable.ic_neon,R.drawable.ic_cup,R.drawable.ic_kvn};

    //Название сэйвов
    public static final String POINTS_COUNT="ru.iis.clicker.points";
    public static final String BASE_COAST ="ru.iis.clicker.base.cost";
    public static final String MULTIPLIER="ru.iis.clicker.multiplier";
    public static final String SPEED="ru.iis.clicker.multiplier";
    public static final String BUYING="ru.iis.clicker.buying";

}