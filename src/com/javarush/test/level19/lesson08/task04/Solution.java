package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {

        PrintStream cnslStream = System.out;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outStream);
        System.setOut(printStream);
        testString.printSomething();
        String s1 = outStream.toString();
        String[] strs = s1.split(" ");
        int a = Integer.valueOf(strs[0]);
        int b = Integer.valueOf(strs[2]);
        int c = 0;
        switch (strs[1])
        {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
        }

        System.setOut(cnslStream);
        System.out.println(s1 + c);

    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("3 + 6 = ");
        }
    }
}

