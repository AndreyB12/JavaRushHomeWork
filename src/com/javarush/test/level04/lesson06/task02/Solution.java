package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[4];
        for (int i = 0; i <4; i++)
        {
            a[i]=sc.nextInt();
        }

        System.out.println(Max(a));
    }
    static int Max(int[] a){
        int m = a[0];
        for (int i = 0; i <a.length ; i++)
        {
            if(a[i]>m) m=a[i];
        }
        return m;
    }
}
