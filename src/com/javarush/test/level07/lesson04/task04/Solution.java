package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a1 = new int[10];
        for (int i = 0; i < a1.length; i++)
        {
            a1[i] = Integer.parseInt(reader.readLine());
        }
        int tr;
        for (int i = 0; i < (int) (a1.length / 2); i++)
        {
            tr = a1[i];
            a1[i] = a1[a1.length - 1 - i];
            a1[a1.length - 1 - i] = tr;
        }
        for (int i = 0; i < a1.length; i++)
        {
            System.out.println(a1[i]);
        }
    }
}
