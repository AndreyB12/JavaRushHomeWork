package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] i = new int[20];
        int maximum;
        int minimum;
        for (int j = 0; j < 20; j++)
        {
            i[j] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(i);
        maximum = i[i.length - 1];
        minimum = i[0];
        System.out.println(maximum);
        System.out.println(minimum);
    }
}
