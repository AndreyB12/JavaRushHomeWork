package com.javarush.test.level26.lesson02.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution
{
    public static Integer[] sort(Integer[] array)
    {
        Arrays.sort(array);
        final double mediana = (array.length % 2 == 0) ? (array[array.length / 2 - 1] + array[(array.length) / 2]) / 2 : (array[array.length / 2]);
        ArrayList<Integer> intArray = new ArrayList<>();
        for (Integer i : array)
        {
            intArray.add(i);
        }
        Collections.sort(intArray, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                int result = Math.abs(o1 - (int) mediana) - Math.abs(o2 - (int) mediana);
                return (result == 0) ? Integer.compare(o1, o2) : result;
            }

        });
        return intArray.toArray(array);
    }

    public static void main(String... args)
    {
        Integer[] array = new Integer[]{3, 4, 7, 6, 5, 2, 1, 11, 5, 48, 49, 56, 92, 94};
        array = sort(array);
        for (int i = 0; i < array.length; i++)
        {

            System.out.print(array[i]);
            System.out.print(", ");
        }
    }
}
