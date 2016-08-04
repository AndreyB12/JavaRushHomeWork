package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f1 = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        FileWriter f2 = new FileWriter(reader.readLine());
        reader.close();

        String[] str = f1.readLine().split(" ");
        f1.close();
        for (int i = 0; i < str.length-1; i++)
        {
            f2.write(String.valueOf(Math.round(Double.parseDouble(str[i]))));
            f2.write(" ");
        }
        f2.write(String.valueOf(Math.round(Double.parseDouble(str[str.length-1]))));
        f2.close();

    }
}
