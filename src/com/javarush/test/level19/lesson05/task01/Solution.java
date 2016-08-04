package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fr = new FileInputStream(reader.readLine());
        FileOutputStream fw = new FileOutputStream(reader.readLine());
        reader.close();
        long i = 1;
        while (fr.available() > 0)
        {
            if (i % 2 == 0 && i > 0)
            {
                fw.write(fr.read());
            } else fr.skip(1);
            i++;
        }
        fr.close();
        fw.close();
    }
}
