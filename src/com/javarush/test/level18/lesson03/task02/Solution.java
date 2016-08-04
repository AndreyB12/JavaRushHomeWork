package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        int bte, minBte = -1;

        while ((bte = fis.read()) >= 0)
        {
            if (minBte==-1|| minBte > bte) minBte = bte;
        }
        reader.close();
        fis.close();
        System.out.println(minBte);
    }
}
