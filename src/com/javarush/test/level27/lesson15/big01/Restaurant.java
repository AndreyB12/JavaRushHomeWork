package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;

/**
 * Created by butkoav on 31.10.2016.
 */
public class Restaurant
{
    public static void main(String... args)
    {
        Tablet tblt5  = new Tablet(5);
        tblt5.addObserver(new Cook("Andry"));
        tblt5.createOrder();
    }
}
