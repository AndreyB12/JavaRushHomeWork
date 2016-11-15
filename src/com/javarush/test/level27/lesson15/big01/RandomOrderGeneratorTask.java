package com.javarush.test.level27.lesson15.big01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by butkoav on 14.11.2016.
 */
public class RandomOrderGeneratorTask implements Runnable
{
    private List<Tablet> tablets = new ArrayList<>();
    private final int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval)
    {
        this.tablets = tablets;
        this.interval = interval;
    }


    @Override
    public void run()
    {
        Tablet tablet;
        while (true)
        {
                int numb = (int) Math.round(Math.random() * (tablets.size() - 1));
                tablet = tablets.get(numb);
                tablet.createTestOrder();
            try
            {
                Thread.currentThread().sleep(interval);
            }
            catch (InterruptedException e)
            {
                break;
            }

        }
    }
}
