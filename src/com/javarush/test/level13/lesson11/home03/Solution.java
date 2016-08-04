package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            String fileName = reader.readLine();
            reader.close();

            FileInputStream fis = new FileInputStream(fileName);

            int bt;
            while ((bt = fis.read())!=-1)
            {
                System.out.print((char)bt);
            }
            fis.close();

/*            reader = new BufferedReader(new FileReader(fileName));
            String currentLine;


            while ((currentLine = reader.readLine()) != null)
            {
                System.out.println(currentLine);
            }*/
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
    }
}
