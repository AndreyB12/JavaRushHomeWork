package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] x=new int[5];
/*        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());*/
        for (int i = 0; i <x.length  ; i++)
        {
            x[i]=Integer.parseInt(reader.readLine());
        }
        int minimum = min(x);

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b)
    {
        return a < b ? a : b;
    }
    public static int min(int[] a)
    {
        Arrays.sort(a);
        return a[0];
    }

}
