package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by butkoav on 15.01.2017.
 */
public class Solution
{
    /**
     * 6.2.	Добавь в класс Solution реализации вспомогательных статических методов:
     * 6.2.1.	Set<Long> getIds(Shortener shortener, Set<String> strings). Этот метод должен
     * для переданного множества строк возвращать множество
     * идентификаторов. Идентификатор для каждой отдельной строки нужно
     * получить, используя  shortener.
     *
     * @param shortener
     * @param strings
     * @return
     */
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

    /**
     * 6.2.2.	Set<String> getStrings(Shortener shortener, Set<Long> keys). Метод будет
     * возвращать множество строк, которое соответствует переданному
     * множеству идентификаторов.
     * При реальном использовании Shortener, задача получить из множества строк
     * множество идентификаторов и наоборот скорее всего не встретится, это нужно
     * исключительно для тестирования.
     *
     * @param shortener Shortener instance
     * @param keys      set of keys
     * @return set of values
     */
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

    /**
     * 6.2.3.	testStrategy(StorageStrategy strategy, long elementsNumber). Метод будет
     * тестировать работу переданной стратегии на определенном количестве
     * элементов elementsNumber. Реализация метода должна:
     * 6.2.3.1.	Выводить имя класса стратегии. Имя не должно включать имя пакета.
     * 6.2.3.2.	Генерировать тестовое множество строк, используя Helper и заданное
     * количество элементов elementsNumber.
     * 6.2.3.3.	Создавать объект типа Shortener, используя переданную стратегию.
     * 6.2.3.4.	Замерять и выводить время необходимое для отработки метода getIds
     * для заданной стратегии и заданного множества элементов. Время
     * вывести в миллисекундах. При замере времени работы метода можно
     * пренебречь переключением процессора на другие потоки, временем,
     * которое тратится на сам вызов, возврат значений и вызов методов
     * получения времени (даты). Замер времени произведи с
     * использованием объектов типа Date.
     * 6.2.3.5.	Замерять и выводить время необходимое для отработки метода
     * getStrings для заданной стратегии и полученного в предыдущем пункте
     * множества идентификаторов.
     * 6.2.3.6.	Сравнивать одинаковое ли содержимое множества строк, которое было
     * сгенерировано и множества, которое было возвращено методом
     * getStrings. Если множества одинаковы, то выведи "Тест пройден.",
     * иначе "Тест не пройден.".
     *
     * @param strategy
     * @param elementsNumber
     */
    public static void testStrategy(StorageStrategy strategy, long elementsNumber)
    {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++)
        {
            strings.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date startTime = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date endTime = new Date();
        long ms = endTime.getTime() - startTime.getTime();
        // Helper.printMessage(String.format("getIds takes %s milliseconds.", ms));
        Helper.printMessage(String.format("%s", ms));

        startTime = new Date();
        Set<String> newStrings = getStrings(shortener, ids);
        endTime = new Date();
        ms = endTime.getTime() - startTime.getTime();
        //   Helper.printMessage(String.format("getStrings takes %s milliseconds.", ms));
        Helper.printMessage(String.format("%s", ms));

        if (strings.equals(newStrings)) Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
    }

    private static void secondTest(StorageStrategy strategy)
    {
        Shortener shortener = new Shortener(strategy);
        String string1 = "Some string 1";
        String string2 = "Some string 2";
        String string3 = "Some string 3";
        String string4 = "Some string 3";

        Helper.printMessage(shortener.getId(string1).toString());
        Helper.printMessage(shortener.getId(string2).toString());
        Helper.printMessage(shortener.getId(string3).toString());
        Helper.printMessage(shortener.getId(string4).toString());

    }

    public static void main(String... args)
    {
    //    testStrategy(new HashMapStorageStrategy(), 10000);
    //    testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    //    testStrategy(new OurHashMapStorageStrategy(), 10000);
      //      testStrategy(new FileStorageStrategy(), 1000);
      //  secondTest(new HashMapStorageStrategy());
     //   secondTest(new OurHashMapStorageStrategy());
   //     secondTest(new OurHashBiMapStorageStrategy());
    //    secondTest(new HashBiMapStorageStrategy());
        secondTest(new DualHashBidiMapStorageStrategy());
    //   secondTest(new FileStorageStrategy());

    }
}
