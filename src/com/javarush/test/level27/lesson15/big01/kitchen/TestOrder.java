package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by butkoav on 14.11.2016.
 */
public class TestOrder extends Order
{
    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException
    {
        dishes = new ArrayList<>();
        int k = 1 + (int) (Math.random() * 3);
        for (int i = 0; i < k; i++)
        {
            dishes.add(Dish.values()[(int) (Math.random() * Dish.values().length)]);
        }

    }
}
