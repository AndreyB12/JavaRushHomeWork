package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

/**
 * Created by butkoav on 31.10.2016.
 */
public class Restaurant
{
    public static void main(String... args)
    {
            Tablet tblt5 = new Tablet(5);
            Cook cookAndry = new Cook("Andry");
            Waitor waitor = new Waitor();
            cookAndry.addObserver(waitor);
            tblt5.addObserver(cookAndry);
            tblt5.createOrder();
    }
}
