package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution
{
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args)
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fr = new BufferedReader(new FileReader(reader.readLine())))
        {
            List<String> firsts = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            while (fr.ready())
            {
                sb.append(fr.readLine().toLowerCase());
                sb.append(" ");
            }
            String[] words = sb.toString().split(" ");

            for (int i = 0; i < words.length; i++)
            {
                String first = words[i];
                for (int j = i; j < words.length; j++)
                {
                    String second = words[j];
                    if (!first.equals("") && first.equals(new StringBuilder(second).reverse().toString()))
                    {
                        if (!firsts.contains((first.compareTo(second) < 0) ? first : second))
                        {
                            Pair pair = new Pair();
                            pair.first = (first.compareTo(second) < 0) ? first : second;
                            pair.second = (first.compareTo(second) < 0) ? second : first;
                            firsts.add((first.compareTo(second) < 0) ? first : second);
                            result.add(pair);
                        }
                    }
                }
            }
            for (Pair pair : result) System.out.println(pair);
        }
        catch (Exception e)
        {
        }
    }

    public static class Pair
    {
        String first;
        String second;

        @Override
        public String toString()
        {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
