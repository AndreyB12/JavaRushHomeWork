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
    private Tablet tablet;
    private List<Dish> dishes;


    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString()
    {
       if(dishes.isEmpty()) return "";
        return String.format("Your order: %s of %s", dishes, tablet).toString();
    }
}
