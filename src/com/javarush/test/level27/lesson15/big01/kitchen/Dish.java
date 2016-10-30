package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by butkoav on 31.10.2016.
 */
public enum Dish
{
    Fish, Steak, Soup, Juice, Water;

    public static String allDishesToString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Dish.values().length - 1; i++)
        {
            sb.append(Dish.values()[i]);
            sb.append(", ");
        }
        sb.append(Dish.values()[Dish.values().length - 1]);

        return sb.toString();
    }
}
