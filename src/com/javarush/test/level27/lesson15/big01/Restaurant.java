package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Created by butkoav on 31.10.2016.
 */
public class Restaurant
{
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> QUEUE = new LinkedBlockingQueue<>();

    public static void main(String... args)
    {
        Locale.setDefault(Locale.ENGLISH);

        List<Tablet> tabletList = new ArrayList<>();

        Cook cookAndrii = new Cook("Andrii");
        cookAndrii.setQueue(QUEUE);
        Thread threadAndrii = new Thread(cookAndrii);
        threadAndrii.start();


        Cook cookAmigo = new Cook("Amigo");
        cookAmigo.setQueue(QUEUE);
        Thread threadAmigo = new Thread(cookAmigo);
        threadAmigo.start();

        Waitor waitor = new Waitor();
        cookAndrii.addObserver(waitor);
        cookAmigo.addObserver(waitor);

        for (int i = 0; i < 5; i++)
        {
            tabletList.add(new Tablet(i + 1));
            tabletList.get(tabletList.size() - 1).setQueue(QUEUE);
        }

        Thread taskGenerator = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        taskGenerator.start();
        try
        {
            Thread.sleep(1000);
            taskGenerator.interrupt();
            taskGenerator.join();
        }
        catch (InterruptedException e)
        {
        }
        threadAmigo.interrupt();
        threadAndrii.interrupt();

        try
        {
            threadAmigo.join();
            threadAndrii.join();
        }
        catch (InterruptedException e)
        {
        }

  /*      DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();*/
    }
}
