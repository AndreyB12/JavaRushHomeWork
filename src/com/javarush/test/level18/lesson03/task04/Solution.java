package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        Map<Integer, Integer> byteMap = new HashMap<>();

        while (fis.available() > 0)
        {
            int bt = fis.read();
            if (byteMap.containsKey(bt)) byteMap.put(bt, byteMap.get(bt) + 1);
            else byteMap.put(bt, 1);
        }
        reader.close();
        fis.close();
        int minCount = 0;
        ArrayList<Integer> minBytes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entr : byteMap.entrySet())
        {
            if (entr.getValue() < minCount || minCount ==0)
            {
                minCount = entr.getValue();
                minBytes.clear();
                minBytes.add(entr.getKey());
            } else if (entr.getValue() == minCount)
            {
                minBytes.add(entr.getKey());
            }
        }
        for (int i = 0; i < minBytes.size(); i++)
        {

        }

        System.out.println(minBytes.toString().substring(1, minBytes.toString().length() - 1).replaceAll(", ", " "));

    }
}
