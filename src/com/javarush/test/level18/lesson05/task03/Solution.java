package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream f1 = new FileInputStream(reader.readLine());
        FileOutputStream f2 = new FileOutputStream(reader.readLine());
        FileOutputStream f3 = new FileOutputStream(reader.readLine());
        reader.close();
        byte[] p1 = new byte[(int) Math.ceil((double)f1.available()/2)];
        byte[] p2 = new byte[f1.available()-p1.length];
        f1.read(p1);
        f1.read(p2);
        f2.write(p1);
        f3.write(p2);

        f1.close();
        f2.close();
        f3.close();
    }
}
