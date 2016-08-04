package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by butkoav on 26.05.2016.
 */
public class Singleton
{
    private static Singleton singleton = null;

    private Singleton()
    {
    }

    public static Singleton getInstance()
    {
        if (singleton == null)
        {
            singleton = new Singleton();
        }
        return singleton;
    }
}
