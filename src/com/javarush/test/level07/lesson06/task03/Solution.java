package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> minID = new ArrayList<Integer>();
        int min;
        for (int i = 0; i < 5; i++)
        {
            list.add(reader.readLine());
        }
        min = list.get(0).length();

        for (int i = 0; i < 5; i++)
        {
            if (list.get(i).length()<min)
            {
                minID.clear();
                minID.add(i);
                min= list.get(i).length();
            }
            else if (list.get(i).length()==min) minID.add(i);
        }

        for (int i = 0; i < minID.size(); i++)
        {
            System.out.println(list.get(minID.get(i)));
        }



    }
}
