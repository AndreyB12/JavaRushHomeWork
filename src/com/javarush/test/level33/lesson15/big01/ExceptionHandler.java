package com.javarush.test.level33.lesson15.big01;

/**
 * Created by butkoav on 15.01.2017.
 */
public class ExceptionHandler
{
    public static void log(Exception e)
    {
        Helper.printMessage(e.getMessage());
    }
}
