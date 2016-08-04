package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream f1 = new FileOutputStream(reader.readLine());
        FileInputStream f2 = new FileInputStream(reader.readLine());
        FileInputStream f3 = new FileInputStream(reader.readLine());

        reader.close();
        byte[] f2Content = new byte[f2.available()];
        byte[] f3Content = new byte[f3.available()];
        f2.read(f2Content);
        f3.read(f3Content);
        f2.close();
        f3.close();

        f1.write(f2Content);
        f1.write(f3Content);
        f1.close();



    }
}
