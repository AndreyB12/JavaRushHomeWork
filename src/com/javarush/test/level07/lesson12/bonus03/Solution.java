package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
// TODO Add try-catch
            String s;
            do
            {
                s = reader.readLine();
            }
            while (!tryParseInt(s, array[i]));
            array[i] = Integer.parseInt(s);

        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static boolean tryParseInt(String str, Integer i)
    {
        try
        {
            i = Integer.parseInt(str);
            return true;
        }
        catch (Throwable t)
        {
            return false;
        }
    }

    public static void sort(int[] array)
    {
        int tmp;
        // Arrays.sort(array);
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length; j++)
            {
                if (array[i] > array[j])
                {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
