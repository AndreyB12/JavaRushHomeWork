package com.javarush.test.level03.lesson08.task05;

/* Чистая любовь
Ввести с клавиатуры три имени, вывести на экран надпись:
name1 + name2 + name3 = Чистая любовь, да-да!
Пример: Вася + Ева + Анжелика = Чистая любовь, да-да!
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String[] names = new String[3];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // int years = Integer.parseInt(reader.readLine());
        for(int i=0;i<3;i++){
            names[i] = reader.readLine();
        }
        System.out.println(String.format("%s + %s + %s = Чистая любовь, да-да!", names));

    }
}