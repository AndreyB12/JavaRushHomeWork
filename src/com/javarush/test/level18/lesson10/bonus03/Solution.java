package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        RandomAccessFile ras = new RandomAccessFile(fileName, "rw");
        long pos = 0;
        switch (args[0])
        {
            case "-u":
                updateLine(ras, args[1], args[2], args[3], args[4]);
                break;
            case "-d":
                deleteLine(ras, args[1]);
                break;
            default:
                return;
        }

        ras.close();
    }

    private static long findID(RandomAccessFile ras, String id) throws IOException
    {
        long position = 0;
        String line;
        ras.seek(0);
        while ((line = ras.readLine()) != null)
        {
            if (line.substring(0, 8).trim().equals(id)) return position;
            position = ras.getFilePointer();
        }
        return -1;
    }

    private static void updateLine(RandomAccessFile ras, String id, String productName, String price, String quantity) throws IOException
    {
        long pos = findID(ras, id);
        if (pos >= 0)
        {
            byte[] buffer = new byte[256];
            int count = 0;

            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%-8s", id));
            sb.append(String.format("%-30s", productName));
            sb.append(String.format("%-8s", price));
            sb.append(String.format("%-4s", quantity));
            sb.append('\n');

            ras.seek(pos);
            ras.readLine();
            long nxtpos = ras.getFilePointer();
            count = ras.read(buffer);
            nxtpos = ras.getFilePointer();
            ras.seek(pos);
            ras.write(sb.toString().getBytes());
            pos=ras.getFilePointer();
            if (count > 0)
            {
                ras.write(buffer, 0, count);

                pos = ras.getFilePointer();
                do
                {
                    ras.seek(nxtpos);
                    count = ras.read(buffer);
                    nxtpos = ras.getFilePointer();
                    ras.seek(pos);
                    if (count > 0) ras.write(buffer, 0, count);
                    pos = ras.getFilePointer();
                }
                while (count == buffer.length);
            }


            ras.setLength(pos);
        }

    }

    private static void deleteLine(RandomAccessFile ras, String id) throws IOException
    {
        byte[] buffer = new byte[256];
        int count = 0;
        long pos = findID(ras, id);
        if (pos >= 0)
        {
            ras.seek(pos);
            ras.readLine();
            long nxtpos = ras.getFilePointer();

            do
            {
                ras.seek(nxtpos);
                count = ras.read(buffer);
                nxtpos = ras.getFilePointer();
                ras.seek(pos);
                if (count > 0) ras.write(buffer, 0, count);
                pos = ras.getFilePointer();
            }
            while (count == buffer.length);

            ras.setLength(pos);
        }
    }
}
