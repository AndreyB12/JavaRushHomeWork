package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        ArrayList<Integer> evens = new ArrayList<>();

        fileName = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fileName));
        String currStr = reader.readLine();

        while (currStr != null)
        {
            int i = Integer.parseInt(currStr);
            if (Integer.parseInt(currStr) % 2 == 0) evens.add(i);
            currStr = reader.readLine();
        }
        reader.close();
        Collections.sort(evens);

        for (int i = 0; i < evens.size(); i++)
        {
            System.out.println(evens.get(i));
        }

    }
}
