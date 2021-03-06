package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by butkoav on 03.11.2016.
 */
public class Cook extends Observable implements Observer
{
    private final String name;

    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public void update(Observable o, Object order)
    {
        if (order instanceof Order)
        {
            Order order_ = (Order) order;
            ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %smin", order, order_.getTotalCookingTime()));
            StatisticManager.getInstance().register(new CookedOrderEventDataRow(o.toString(), this.name, order_.getTotalCookingTime() * 60, order_.getDishes()));
            setChanged();
            notifyObservers(order);
        }
    }
}
