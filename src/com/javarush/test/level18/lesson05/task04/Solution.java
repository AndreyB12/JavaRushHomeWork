package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.nio.channels.FileChannel;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream f1 = new FileInputStream("e:\\test.txt");
        FileOutputStream f2 = new FileOutputStream("e:\\test23.txt");

        reader.close();

        FileChannel fc = f1.getChannel();
        fc.position(f1.available() - 1);

        int bt;
        char cr;
        while (true)
        {
            bt = f1.read();
            cr=(char)bt;
            System.out.println(cr);
            f2.write(bt);
            if(!(fc.position() - 2 < 0)) fc.position(fc.position() - 2);
            else break;
        }

        f1.close();
        f2.close();
    }
}
