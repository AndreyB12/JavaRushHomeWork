package com.javarush.test.level04.lesson04.task10;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String res ="";
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int[] a=new int[3];
        for (int i = 0; i <3; i++)
        {
            a[i]=Integer.parseInt(reader.readLine());
        }
        if (a[0]==a[1]&&a[0]==a[2]){
            res=a[0]+" "+a[0]+" "+a[0];
        }else{
            if (a[0]==a[1]||a[0]==a[2]) res=a[0]+" "+a[0];
            if (a[1]==a[2]) res=a[1]+" "+a[1];
        }
        System.out.println(res);

    }
}