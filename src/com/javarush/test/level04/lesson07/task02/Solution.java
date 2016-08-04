package com.javarush.test.level04.lesson07.task02;

/* Строка - описание
Ввести с клавиатуры целое число в диапазоне 1 - 999. Вывести его строку-описание следующего вида:
«четное однозначное число» - если число четное и имеет одну цифру,
«нечетное однозначное число» - если число нечетное и имеет одну цифру,
«четное двузначное число» - если число четное и имеет две цифры,
«нечетное двузначное число» - если число нечетное и имеет две цифры,
«четное трехзначное число» - если число четное и имеет три цифры,
«нечетное трехзначное число» - если число нечетное и имеет три цифры.
Если введенное число не попадает в диапазон 1 - 999, в таком случае ничего не выводить на экран.
Пример для числа 100:
четное трехзначное число
Пример для числа 51:
нечетное двузначное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        getDescription(x);

    }

    static void getDescription(int a)
    {
        if (a<1||a>999) return;
        String desc = "";
        if (a % 2 == 0) desc += "четное ";
        else desc += "нечетное ";

        switch ((int) Math.log10(Math.abs(a)) + 1)
        {
            case 1:
                desc += "однозначное ";
                break;
            case 2:
                desc += "двузначное ";
                break;
            case 3:
                desc += "трехзначное ";
                break;
        }

        desc += "число";
        System.out.println(desc);
    }
}
