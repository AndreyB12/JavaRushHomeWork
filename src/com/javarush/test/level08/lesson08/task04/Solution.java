package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone0", new Date("JUNE 1 1980"));
        map.put("tallone1", new Date("JUL 1 1980"));
        map.put("Sallone2", new Date("JUNE 1 1980"));
        map.put("Stllone3", new Date("JUNE 1 1980"));
        map.put("Stallone4", new Date("JUNE 1 1980"));
        map.put("Staone5", new Date("JUNE 1 1980"));
        map.put("Stall6", new Date("JUNE 1 1980"));
        map.put("Staloe7", new Date("DEC 1 1985"));
        map.put("Stane8", new Date("JAN 1 1980"));
        map.put("Stallo9", new Date("JUNE 1 1980"));


        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Date date = it.next().getValue();
            int m = date.getMonth();
            if (m == 5 || m == 6 || m == 7)
            {
                it.remove();
            }
        }

    }
}
