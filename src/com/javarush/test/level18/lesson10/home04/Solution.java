package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1Name = reader.readLine();
        FileInputStream f2 = new FileInputStream(reader.readLine());
        reader.close();

        FileInputStream f1in = new FileInputStream(f1Name);
        byte[] f1Content = new byte[f1in.available()];
        f1in.read(f1Content);
        f1in.close();

        FileOutputStream f1out = new FileOutputStream(f1Name);
        byte[] f2Content = new byte[f2.available()];
        f2.read(f2Content);
        f2.close();

        f1out.write(f2Content);
        f1out.write(f1Content);
        f1out.close();
    }
}
