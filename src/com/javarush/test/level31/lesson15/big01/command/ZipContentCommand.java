package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.FileProperties;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;

/**
 * Created by butkoav on 12.12.2016.
 */
public class ZipContentCommand extends ZipCommand
{
    /**
     * Задание 14.
     * <p>
     * Все готово, чтобы реализовать метод execute() класса ZipContentCommand:
     * 1.	Выведи сообщение "Просмотр содержимого архива."
     * 2.	Создай объект класса ZipFileManager с помощью метода getZipFileManager()
     * 3.	Выведи сообщение "Содержимое архива:"
     * 4.	Получи список файлов архива с помощью метода getFilesList()
     * 5.	Выведи свойства каждого файла в консоль. Тут нам и пригодится ранее реализованный метод
     * toString() класса FileProperties
     * 6.	Выведи сообщение "Содержимое архива прочитано."
     *
     * @throws Exception
     */
    @Override
    public void execute() throws Exception
    {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");
        for (FileProperties fileProps : zipFileManager.getFilesList())
        {
            ConsoleHelper.writeMessage(fileProps.toString());
        }
    }
}
