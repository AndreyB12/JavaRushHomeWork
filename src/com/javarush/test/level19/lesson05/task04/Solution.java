package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(reader.readLine());
        FileWriter fw = new FileWriter(reader.readLine());
        reader.close();
        char[] crs = new char[256];
        int count;
        String line = "";
        while (fr.ready())
        {
            count = fr.read(crs);
            line = String.valueOf(crs).replaceAll("\\.", "!");
            fw.write(line.toCharArray(), 0, count);
        }
        fr.close();
        fw.close();
    }
}
