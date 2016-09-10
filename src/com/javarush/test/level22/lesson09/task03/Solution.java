package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String[] words = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fr = new BufferedReader(new FileReader(reader.readLine())))
        {
            StringBuilder sb = new StringBuilder();
            while (fr.ready())
            {
                sb.append(fr.readLine());
                if (fr.ready()) sb.append(" ");
            }
            words = sb.toString().split(" ");
          }
        catch (Exception e)
        {
            throw e;
        }
        if (words == null) return;

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        Arrays.sort(words);
        List<String> line = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++)
        {
            line.add(words[i]);
            if (findNext(words[i], words, line))
            {
                break;
            } else line.remove(line.size() - 1);
        }

        for (String word : line)
        {
            if (result.length() > 0) result.append(" ");
            result.append(word);
        }

        return result;
    }

    private static boolean findNext(String word, String[] words, List<String> line)
    {
        if (line.size() == words.length) return true;
        for (String w : words)
        {
            if (w.toLowerCase().charAt(0) == word.toLowerCase().charAt(word.length() - 1) && !line.contains(w))
            {
                line.add(w);
                if (findNext(w, words, line)) return true;
                else line.remove(line.size() - 1);
            }
        }
        return false;
    }
}
