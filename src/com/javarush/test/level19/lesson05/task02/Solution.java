package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(reader.readLine());
        reader.close();
        int count = 0;
        String word = "";
        char cr;
        while (fr.ready())
        {
            cr = (char) fr.read();
            if (Character.isLetter(cr))
            {
                word = word + cr;
            } else
            {
                if (word.toLowerCase().equals("world")) count++;
                word = "";
            }
        }
        fr.close();
        System.out.println(count);
    }
}
