package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by butkoav on 03.11.2016.
 */
public class Cook extends Observable implements Runnable
{
    private final String name;
    private LinkedBlockingQueue<Order> queue;
    private boolean interrupt = false;

    public Cook(String name)
    {
        this.name = name;
    }

    public void startCookingOrder(Order order)
    {
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %smin", order, order.getTotalCookingTime()));
        try
        {
            Thread.sleep(order.getTotalCookingTime() * 10);
        }
        catch (InterruptedException e)
        {
            interrupt = true;
        }
        StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), this.name, order.getTotalCookingTime() * 60, order.getDishes()));
        setChanged();
        notifyObservers(order);
    }

    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public void run()
    {

        try
        {
            while (true)
            {
                Order order = queue.poll();
                if (interrupt && order == null) return;
                if (order != null) this.startCookingOrder(order);
                Thread.currentThread().sleep(10);
            }
        }
        catch (InterruptedException e)
        {
            interrupt = true;
        }

    }


    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }
}
