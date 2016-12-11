package com.javarush.test.level31.lesson15.big01;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by butkoav on 10.12.2016.
 * * Задание 1.
 * 1.	Создай класс менеджер ZipFileManager
 * 2.	Добавь в класс приватную переменную Path zipFile. В ней мы будем хранить полный путь к архиву,
 * с которым будем работать.
 * 3.	Добавь конструктор ZipFileManager(Path zipFile). Проинициализируй поле класса zipFile.
 * 4.	Объяви публичный метод createZip(Path source) throws Exception, пока с пустой реализацией.
 * Path source – это путь к чему-то, что мы будем архивировать.
 * <p>
 * *﻿Задание 2.
 * 1.	Создай новый поток архива ZipOutputStream используя перемнную класса zipFile, с помощью метода
 * newOutputStream класса Files.
 * 2.	Создай новый элемент архива ZipEntry. В конструктор ZipEntry передай строку, содержащую имя новой записи.
 * Имя нужно получить из полного пути source, взять только имя файла и сконвертировать его в String.
 * 3.	Добавь в поток архива созданный элемент архива.
 * 4.	Перепиши данные из файла, который архивируем в поток архива. Для этого:
 * 4.1. создай поток InputStream для добавляемого файла source, используя метод newInputStream класса Files
 * 4.2. сделай цикл, который будет читать данные из InputStream (созданного в п.4.1), пока они там есть и записывать
 * их в ZipOutputStream (созданный в п.1)
 * 4.3. закрой InputStream, сделай это с помощью try-with-resources
 * 5.	Закрой элемент архива у потока архива
 * 6.	Закрой поток архива, сделай это также с помощью try-with-resources
 * 7.	Запусти программу и проверь, что файл архивируется
 */
public class ZipFileManager
{
    private Path zipFile;

    public ZipFileManager(Path zipFile)
    {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception
    {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
             InputStream inputStream = Files.newInputStream(source))
        {
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(zipEntry);
            int count;
            byte[] bytes = new byte[1024];
            while ((count = inputStream.read(bytes)) > 0)
            {
                zipOutputStream.write(bytes, 0, count);
            }
            zipOutputStream.closeEntry();
        }
    }
}
