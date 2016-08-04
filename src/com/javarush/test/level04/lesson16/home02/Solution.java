package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a[] = new int[3];
        for (int i = 0; i < 3; i++)
        {
            a[i]=Integer.parseInt(reader.readLine() );
        }
        Arrays.sort(a);
        System.out.println(a[1]);
    }
}
