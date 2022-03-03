package ru.iis.framework.utils;

import ru.iis.framework.R;

public class Constants {

    //Network
    public static final String NETWORK_BASE_URL = "https://test.ru/";
    public static final long NETWORK_TIMEOUT_SEC = 10;

    public static final int MENU_OFF = -1;
    public static final int MENU_CLICKER = R.id.clickerMenuItem;
    public static final int MENU_INITIATIVE = R.id.initiativeMenuItem;
    public static final int MENU_KNOWLEDGE = R.id.knowledgeMenuItem;

    public static final String[] KNOWLEDGES_NAME={"Сходить в\nбиблиотеку","Поучаствовать в\nолимпиаде","Подготовиться к\nконтрольной","Посетить\nконференцию","Подготовить\nпроект","Сходить на\nпрактику",
                                                    "Работа над\nдипломом","Стать\nбакалавром","Стать\nмагистром","Стать\nасперантом","Стать\nректором"};
    public static final long[] KNOWLEDGES_BASE= new long[]{15, 100, 500, 3000, 10000, 40000, 200000, 1666666, 123456789, 3999999999L,75000000000L};
    public static final float[] KNOWLEDGES_ADD= new float[]{0.1f,0.5f,4,10,40,100,400,6666,98765,999999,10000000};
    public static final boolean[] KNOWLEDGES_BUYED=new boolean[]{false,false,false,false,false,false,false,false,false,false,false};
    public static final int[] KNOWLEDGES_ICONS=new int[]{R.drawable.ic_library,R.drawable.ic_sport,R.drawable.ic_cup,R.drawable.ic_meeting,R.drawable.ic_project,R.drawable.ic_practic,
                                                        R.drawable.ic_diplom,R.drawable.ic_bachelor,R.drawable.ic_magistr,R.drawable.ic_aspirant,R.drawable.ic_rector};

    public static final String[] INITIATIVES_NAME={"Помочь\nстудсовету","Сходить в\nНЕОН","Посетить\nярморку","Сходить в\nКВН"};
    public static final int[] INITIATIVES_BASE= new int[]{10,100,1000,10000};
    public static final float[] INITIATIVES_ADD= new float[]{0.5f,1,5,25};
    public static final int[] INITIATIVES_ICONS=new int[]{R.drawable.ic_stud,R.drawable.ic_neon,R.drawable.ic_cup,R.drawable.ic_kvn};

    public static final String POINTS_COUNT="ru.iis.clicker.points";
    public static final String BASE_COAST ="ru.iis.clicker.base.cost";
    public static final String MULTIPLIER="ru.iis.clicker.multiplier";
    public static final String SPEED="ru.iis.clicker.multiplier";
    public static final String BUYING="ru.iis.clicker.buying";

}