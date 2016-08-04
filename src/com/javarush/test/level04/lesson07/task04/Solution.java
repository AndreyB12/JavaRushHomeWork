package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int pc = 0, nc = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[3];
        for (int i = 0; i < 3; i++)
        {
            a[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] > 0) pc++;
            if (a[i] < 0) nc++;
        }
        System.out.println(String.format("количество отрицательных чисел: %s", nc));
        System.out.println(String.format("количество положительных чисел: %s", pc));

    }
}
