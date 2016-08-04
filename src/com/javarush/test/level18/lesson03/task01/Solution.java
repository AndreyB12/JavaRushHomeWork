package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        List<Integer> bytes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fr = new FileReader(reader.readLine());
        while (fr.ready())
        {
            bytes.add(fr.read());
        }
        reader.close();
        fr.close();
        Collections.sort(bytes);
        System.out.println(bytes.get(bytes.size()-1));
    }
}
