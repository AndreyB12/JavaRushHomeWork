package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution
{
    public static String getPartOfString(String string) throws TooShortStringException
    {
        try
        {
            int s = string.indexOf('\t');
            int e = string.indexOf('\t', s + 1);
            return string.substring(s+1, e);
        }
        catch (Exception e)
        {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception
    {
    }

    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
       // System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
