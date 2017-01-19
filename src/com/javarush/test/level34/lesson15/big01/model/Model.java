package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

/**
 * Created by butkoav on 19.01.2017.
 */
public class Model
{
    public static int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

}
