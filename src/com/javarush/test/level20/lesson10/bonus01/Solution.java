package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution
{
    public static void main(String... args)
    {

        int m = 3;
        int s = 370;
        int summ = 0;
        int d = 10;


        int[] rslt = getNumbers(200000000);

        for (int i = 0; i < rslt.length; i++)
        {

            System.out.println(rslt[i]);
        }

    }

    public static int[] getNumbers(int N)
    {
        ArrayList<Integer> rslt = new ArrayList<>();
        for (int i = 1; i <= N; i++)
        {
            if (checkNumber(i))
            {
                rslt.add(i);
            }
        }
        int[] result = new int[rslt.size()];
        for (int i = 0; i < rslt.size(); i++)
        {
            result[i] = rslt.get(i);
        }
        return result;
    }

    private static boolean checkNumber(int n)
    {
        int m = String.valueOf(n).length();
        int s = n;
        int summ=0;
        for (int i = 0; i < m; i++)
        {
            int s1 = 1;
            int dgt = s % 10;
            for (int j = 0; j < m; j++)
            {
                s1 *= dgt;
            }
            s = s / 10;
            summ += s1;
        }
        boolean result = false;
        result = (summ == n) ? true : false;
        return result;
    }
}
