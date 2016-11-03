package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

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
        ConsoleHelper.writeMessage("Start cooking - " + order);
    }
}
