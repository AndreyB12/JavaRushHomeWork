package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String fileName = reader.readLine();
            FileOutputStream fos = new FileOutputStream(fileName);
           // writeToFile(fos,fileName);
            String currentLine;

            do{
                currentLine = reader.readLine();
                writeToFile(fos, currentLine);
            } while (!(currentLine).toLowerCase().equals("exit"));



            reader.close();
            fos.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void writeToFile(FileOutputStream fos, String s)
    {
        try
        {

            for (char c : s.toCharArray())
            {
                fos.write(c);
            }
            fos.write('\n');

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}

