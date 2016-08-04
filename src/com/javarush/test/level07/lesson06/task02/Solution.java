package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        String[] listM = new String[5];
        int maxlenth = 0;
        ArrayList<Integer> maxID = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++)
        {
            list.add(reader.readLine());
        }
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).length() > maxlenth)
            {
                maxID.clear();
                maxID.add(i);
                maxlenth=list.get(i).length();
            }else  if (list.get(i).length() == maxlenth)
                    maxID.add(i);
        }
        for (int i = 0; i < maxID.size(); i++)
        {
            System.out.println(list.get(maxID.get(i)));
        }
    }
}
