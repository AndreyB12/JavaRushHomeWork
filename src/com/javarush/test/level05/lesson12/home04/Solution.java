package com.javarush.test.level05.lesson12.home04;

import java.util.Date;
/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

public class Solution
{
    public static void main(String[] args)
    {
        Date date = new Date();
        String str = String.format("%td %<tm %<tY", date);
        System.out.println(str);
    }
}
