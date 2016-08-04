package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int c=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[3];
        for (int i = 0; i <3; i++)
        {
            a[i]=Integer.parseInt(reader.readLine() );
        }
        for (int i = 0; i <a.length ; i++)
        {
            if (a[i]>0) c++;
        }
        System.out.println(c);
    }
}
