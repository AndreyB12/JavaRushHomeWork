package com.javarush.test.level34.lesson08.bonus01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V>
{
    private Map<K, V> cache = new WeakHashMap<K, V>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception
    {
        V obj;
        if (cache.containsKey(key))
            obj = cache.get(key);
        else
        {
            Constructor<V> constructor = clazz.getConstructor(key.getClass());
            obj = constructor.newInstance(key);
            put(obj);
        }
        return obj;
    }

    public boolean put(V obj)
    {
        //TODO add your code here
        try
        {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            K key = (K) method.invoke(obj);
            cache.put(key, obj);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public int size()
    {
        return cache.size();
    }
}
