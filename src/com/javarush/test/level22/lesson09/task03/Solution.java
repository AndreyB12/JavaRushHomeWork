package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

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

        StringBuilder result = getLine();
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        StringBuilder result = new StringBuilder();



        return result;
    }
}
