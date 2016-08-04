package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{

    static String file;

    public static void main(String[] args)
    {

        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
            //  BufferedReader fr = new BufferedReader(new FileReader("e:\\test.html"));
            reader.close();

            String tag = args[0];

            StringBuffer sb = new StringBuffer();
            char[] buff = new char[20];
            int count = 0;
            while (fr.ready())
            {
                count = fr.read(buff);
                sb.append(buff, 0, count);
            }
            fr.close();

            file = sb.toString();
            getTags(tag, 1);


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    static void getTags(String tag, int strStart)
    {
        String patternString = "<tag.*?>";
        patternString = patternString.replaceAll("tag", tag);
        Pattern pattern = Pattern.compile(patternString, Pattern.DOTALL);
        Matcher mch = pattern.matcher(file.substring(strStart));
        int start;
        int end;
        while (mch.find())
        {
            start = mch.start();
            end = getTagEnd(tag, mch.end() + strStart);
            System.out.println(file.substring(start + 1, end));
        }
    }

    static int getTagEnd(String tag, int start)
    {
        int count = 1;
        String patternString = "<\\w+.*?>|</\\w+>";
        patternString = patternString.replaceAll("tag", tag);
        Pattern pattern = Pattern.compile(patternString);
        Matcher mch = pattern.matcher(file.substring(start));
        while (mch.find())
        {
            if (mch.group().matches("<\\w+.*?>"))
            {
                count++;
            } else
            {
                count--;
            }
            if (count == 0)
            {
                break;
            }
        }
        return mch.end() + start;
    }
}
