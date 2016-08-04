package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    private static String newFileName = "";
    private static int maxIndx = 0;
    private static final String PREFIX = ".part";

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String currFileName;
        while (!(currFileName = reader.readLine()).equals("end"))
        {
            getFileIndex(currFileName);
        }
        reader.close();

        FileOutputStream fos = new FileOutputStream(newFileName);
        for (int i = 1; i <= maxIndx; i++)
        {
            FileInputStream fis = new FileInputStream(newFileName + PREFIX + i);
            byte[] bt = new byte[fis.available()];
            fis.read(bt);
            fis.close();
            fos.write(bt);
        }
        fos.close();
    }

    private static int getFileIndex(String fileName)
    {
        int indx = Integer.parseInt(fileName.substring(fileName.indexOf(PREFIX, fileName.length() - 9) + 5));
        if (indx > maxIndx) maxIndx = indx;
        if (indx == 1)
        {
            newFileName = fileName.substring(0, fileName.length() - PREFIX.length() - Integer.toString(indx).length());
        }
        return indx;
    }
}
