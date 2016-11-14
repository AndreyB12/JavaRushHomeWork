package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.Locale;


/**
 * Created by butkoav on 31.10.2016.
 */
public class Restaurant
{
    public static void main(String... args)
    {
        Locale.setDefault(Locale.ENGLISH);

        Tablet tblt5 = new Tablet(5);
        Cook cookAndry = new Cook("BAndry");
        Waitor waitor = new Waitor();
        cookAndry.addObserver(waitor);
        tblt5.addObserver(cookAndry);
        tblt5.createOrder();

        StatisticEventManager.getInstance().register(cookAndry);
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
