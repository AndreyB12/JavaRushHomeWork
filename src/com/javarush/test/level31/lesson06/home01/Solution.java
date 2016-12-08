package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        File newFile = new File(args[0]);

        String zipFile = args[1];

        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
        Map<ZipEntry, byte[]> entryList = new HashMap<>();
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null)
        {
            if (!entry.isDirectory())
            {
                ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int i;
                while ((i = zis.read(bytes)) > 0)
                {
                    byteOS.write(bytes, 0, i);
                }
                entryList.put(entry, byteOS.toByteArray());
                byteOS.close();
            }
        }
        zis.close();

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));

        boolean contains = false;
        for (Map.Entry<ZipEntry, byte[]> entr : entryList.entrySet())
        {
            String name = entr.getKey().getName().split("/")[entr.getKey().getName().split("/").length - 1];
            if (name.equalsIgnoreCase(newFile.getName()))
            {
                ZipEntry newZipEntry = new ZipEntry("new/" + newFile.getName());
                newZipEntry.setSize(newFile.length());
                zos.putNextEntry(newZipEntry);
                Files.copy(newFile.toPath(), zos);
                zos.closeEntry();
                contains = true;
            } else
            {
                zos.putNextEntry(entr.getKey());
                if (entr.getValue() != null) zos.write(entr.getValue());
                zos.closeEntry();
            }
        }

   /*     if (!contains)
        {

            ZipEntry newZipEntry = new ZipEntry("new/" + newFile.getName());
            newZipEntry.setSize(newFile.length());
            zos.putNextEntry(newZipEntry);
            Files.copy(newFile.toPath(), zos);
            zos.closeEntry();
        }*/

        zos.close();
    }
}
