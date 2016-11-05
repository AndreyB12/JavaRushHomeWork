package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by butkoav on 31.10.2016.
 */
public class Order
{
    private List<Dish> dishes;
    private Tablet tablet;
    private int totalCookingTime;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
        for (Dish dish : dishes)
        {
            totalCookingTime += dish.getDuration();
        }
    }

    public int getTotalCookingTime()
    {
        return totalCookingTime;
    }

    public boolean isEmpty()
    {
        return dishes.isEmpty();
    }

    @Override
    public String toString()
    {
        return dishes.isEmpty() ? "" : String.format("Your order: %s of %s", dishes, tablet);
    }
}
