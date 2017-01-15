package com.javarush.test.level33.lesson15.big01;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by butkoav on 15.01.2017.
 */
public class Solution
{
    public static Set<Long> getIds(Shortener shortener, Set<String> strings)
    {
        Set<Long> result = new HashSet<>();
        if (strings != null)
            for (String string : strings)
            {
                result.add(shortener.getId(string));
            }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
    {
        Set<String> result = new HashSet<>();
        if (keys != null)
            for (Long key : keys)
            {
                result.add(shortener.getString(key));
            }
        return result;
    }
}
