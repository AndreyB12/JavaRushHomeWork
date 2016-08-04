package com.javarush.test.level08.lesson08.task05;


import java.util.Collections;
import java.util.HashMap;

import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
   /*public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();
        for (HashMap.Entry<String, String> entr : map.entrySet())
        {
            System.out.println(entr.getKey() + " - " + entr.getValue());
        }
        removeTheFirstNameDuplicates(map);
        for (HashMap.Entry<String, String> entr : map.entrySet())
        {
            System.out.println(entr.getKey() + " - " + entr.getValue());
        }
    }*/

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("F1", "N1");
        map.put("F2", "N2");
        map.put("F3", "N1");
        map.put("F4", "N4");
        map.put("F5", "N1");
        map.put("F6", "N5");
        map.put("F7", "N2");
        map.put("F8", "N1");
        map.put("F9", "N5");
        map.put("F10", "N7");
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> nmap = new HashMap<String, String>(map);
        for (String name:nmap.values()             )
        {
            if(Collections.frequency(nmap.values(),name)>1) removeItemFromMapByValue(map,name);
        }



    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
