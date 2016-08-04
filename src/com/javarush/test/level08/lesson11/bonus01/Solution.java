package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> months = getMonthNames();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String monthName = reader.readLine();
        if (months.contains(monthName.toLowerCase()))
            System.out.println(monthName + " is " + (months.indexOf(monthName.toLowerCase()) + 1) + " month");

    }

    public static ArrayList<String> getMonthNames()
    {
        ArrayList<String> months = new ArrayList<>();
        months.add("january");
        months.add("february");
        months.add("march");
        months.add("april");
        months.add("may");
        months.add("june");
        months.add("jule");
        months.add("august");
        months.add("september");
        months.add("october");
        months.add("november");
        months.add("december");
        return months;
    }

}
