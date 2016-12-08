package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution
{
    public static void main(String[] args)
    {
        try
        {
            String resultFileName = args[0];
            List<String> sourceList = new ArrayList<>();
            for (int i = 1; i < args.length; i++)
            {
                sourceList.add(args[i]);
            }
            Collections.sort(sourceList);
            List<InputStream> inputStreams = new ArrayList<>();
            for (String file : sourceList)
            {
                inputStreams.add(new FileInputStream(file));
            }
            ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(inputStreams)));
            FileOutputStream fileOutputStream = new FileOutputStream(resultFileName);
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            byte[] buffer = new byte[1024];
            int i;
            if (zipEntry != null)
            {
                while ((i = zipInputStream.read(buffer)) > 0)
                {
                    fileOutputStream.write(buffer,0,i);
                }
            }
            zipInputStream.close();
            fileOutputStream.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
