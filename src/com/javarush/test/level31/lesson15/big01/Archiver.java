package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Created by butkoav on 11.12.2016.
 * * Задание 1.
 * 5.	Создай класс Archiver и добавь в него метод main.
 * 6.	В методе main:
 * 6.1 Запроси пользователя ввести полный путь архива с клавиатуры. Не забудь, что имя тоже
 * входит в состав полного пути.
 * 6.2 Создай объект класса ZipFileManager, передав в него имя файла архива. Разберись, как из
 * String получить Path. Подсказка: изучи метод get() класса Paths.
 * 6.3 Запроси пользователя ввести путь к файлу, который будем архивировать. Не путай это с
 * файлом архива, который мы уже ввели. На этот раз нам нужен файл, который мы будем
 * сжимать, а не в котором хранить сжатые данные.
 * 6.4 Вызови метод createZip у объекта ZipFileManager, передав в него путь для архивации.
 */
public class Archiver
{
    public static void main(String... args)
    {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));)
        {
            System.out.println("Absolute path to archive:");
            String archivePath = reader.readLine();
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(archivePath));

            System.out.println("Absolute path to file to be archived:");
            String archivedFilePath = reader.readLine();
            zipFileManager.createZip(Paths.get(archivedFilePath));

            new ExitCommand().execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
