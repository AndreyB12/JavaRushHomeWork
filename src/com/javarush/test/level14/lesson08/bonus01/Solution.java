package com.javarush.test.level14.lesson08.bonus01;

import java.io.IOException;
import java.rmi.server.ServerNotActiveException;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        exceptions.add(new IOException());
        exceptions.add(new RuntimeException());
        exceptions.add(new ServerNotActiveException());
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new IllegalMonitorStateException());
        exceptions.add(new IllegalStateException());
        exceptions.add(new IllegalThreadStateException());
        exceptions.add(new IndexOutOfBoundsException());
        exceptions.add(new NegativeArraySizeException());


    }
}
