package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader fr2 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String ln1, ln2, ln1nxt, ln2nxt;
        List<String> file1 = new ArrayList<>();
        List<String> file2 = new ArrayList<>();


        while (fr1.ready())
        {
            file1.add(fr1.readLine());
        }
        while (fr2.ready())
        {
            file2.add(fr2.readLine());
        }
        fr1.close();
        fr2.close();
        int i = 0, j = 0;
        while (true)
        {
            ln1 = (i < file1.size()) ? file1.get(i) : "";
            ln2 = (j < file2.size()) ? file2.get(j) : "";
            ln1nxt = (i + 1 < file1.size()) ? file1.get(i + 1) : "";
            ln2nxt = (j + 1 < file2.size()) ? file2.get(j + 1) : "";

            if (ln1.equals(ln2))
            {
                lines.add(new LineItem(Type.SAME, ln1));
                i++;
                j++;
            } else if (ln1.equals(ln2nxt))
            {
                lines.add(new LineItem(Type.ADDED, ln2));
                j++;
            } else if (ln1nxt.equals(ln2))
            {
                lines.add(new LineItem(Type.REMOVED, ln1));
                i++;
            }
            if (i >= file1.size() & j >= file2.size()) break;
        }
    }


    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}
