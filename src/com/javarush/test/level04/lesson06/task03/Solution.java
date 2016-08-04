package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[3];
        for (int i = 0; i <3; i++)
        {
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        for (int i = 2; i>=0; i--)
        {
            System.out.println(a[i]);
        }
    }
}
