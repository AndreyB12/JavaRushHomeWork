package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
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
        int maxCount = 0;
        ArrayList<Integer> maxBytes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entr : byteMap.entrySet())
        {
            if (entr.getValue() > maxCount)
            {
                maxCount = entr.getValue();
                maxBytes.clear();
                maxBytes.add(entr.getKey());
            } else if (entr.getValue() == maxCount)
            {
                maxBytes.add(entr.getKey());
            }
        }

        System.out.println(maxBytes.toString().substring(1,maxBytes.toString().length()-1).replaceAll(", "," "));

    }
}
