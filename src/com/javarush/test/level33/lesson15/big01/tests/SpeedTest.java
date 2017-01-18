package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by butkoav on 18.01.2017.
 */
public class SpeedTest
{
   public long getTimeForGettingIds(Shortener shortener, Set<String>
            strings, Set<Long> ids)
    {
        long st = new Date().getTime();

        for (String str : strings)
        {
            ids.add(shortener.getId(str));
        }
        return new Date().getTime() - st;
    }

   public long getTimeForGettingStrings(Shortener shortener,
                                  Set<Long> ids, Set<String> strings)
    {
        long st = new Date().getTime();
        for (Long key : ids)
        {
            strings.add(shortener.getString(key));
        }
        return new Date().getTime() - st;
    }

    @Test
    public void testHashMapStorage()
    {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        Set<String> newStrings1 = new HashSet<>();
        Set<String> newStrings2 = new HashSet<>();
        for (int i = 0; i < 10000; i++)
        {
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();

        long t1 = getTimeForGettingIds(shortener1, origStrings, ids1);
        long t2 = getTimeForGettingIds(shortener2, origStrings, ids2);
     //   System.out.println(t1);
     //   System.out.println(t2);

        Assert.assertTrue(t1 > t2);

        t1 = getTimeForGettingStrings(shortener1, ids1, newStrings1);
        t2 = getTimeForGettingStrings(shortener2, ids2, newStrings2);
        Assert.assertEquals(t1, t2, 5.0);

   //    System.out.println(t1);
     //   System.out.println(t2);
    }
}
