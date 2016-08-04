package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("F1", "N1");
        map.put("F2", "N1");
        map.put("F3", "N2");
        map.put("F4", "N1");
        map.put("F5", "N1");
        map.put("F6", "N1");
        map.put("F7", "N2");
        map.put("F8", "N3");
        map.put("F9", "N3");
        map.put("F10", "N3");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int c = 0;
        for (String mapName : map.values())
        {
            if (mapName.toLowerCase().equals(name.toLowerCase())) c++;
        }
        return c;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int c = 0;
        for (String lName : map.keySet())
        {
            if(lName.toLowerCase().equals(lastName.toLowerCase())) c++;
        }
        return c;
    }
}
