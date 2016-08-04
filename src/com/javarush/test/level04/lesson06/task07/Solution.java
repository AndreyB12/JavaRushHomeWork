package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] a = new int[3];
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <a.length; i++)
        {
            a[i]=Integer.parseInt(reader.readLine());
        }
            System.out.println(getIndex(a)+1);
    }
    static int getIndex(int[] a){
        if (a[0]==a[1])    return 2;
        if (a[0]==a[2]) return 1;
        return 0;

    }
}
