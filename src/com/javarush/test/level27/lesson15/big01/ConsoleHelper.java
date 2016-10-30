package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by butkoav on 31.10.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> list = new ArrayList<>();
        String string;
        do
        {
            writeMessage("Make an order:");
            writeMessage(Dish.allDishesToString());
            string = readString();
            try
            {
                list.add(Dish.values()[Integer.parseInt(string) - 1]);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        while (!string.toLowerCase().equals("exit"));
        return list;
    }
}
