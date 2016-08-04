package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] result = new ArrayList[2];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = new ArrayList<String>();
        }
        result[0].add("l1_1");
        result[0].add("l1_2");
        result[0].add("l1_3");
        result[1].add("l2_1");
        result[1].add("l2_2");

        return result;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}