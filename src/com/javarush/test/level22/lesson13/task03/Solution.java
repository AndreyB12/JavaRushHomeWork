package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution
{
    public static void main(String...args)
    {
        System.out.println(String.format("%s - %b","+380501234567",checkTelNumber("+380501234567")));
        System.out.println(String.format("%s - %b","0501234567",checkTelNumber("0501234567")));
        System.out.println(String.format("%s - %b","+38(050)1234567",checkTelNumber("+38(050)1234567")));
        System.out.println(String.format("%s - %b","(050)1234567",checkTelNumber("(050)1234567")));
        System.out.println(String.format("%s - %b","+38050123-45--67",checkTelNumber("+38050123-45--67")));
        System.out.println(String.format("%s - %b","050123-4567",checkTelNumber("050123-4567")));

        System.out.println(String.format("%s - %b","+38)050(1234567",checkTelNumber("+38)050(1234567")));
        System.out.println(String.format("%s - %b","+38(050)1-23-45-6-7",checkTelNumber("+38(050)1-23-45-6-7")));
        System.out.println(String.format("%s - %b","050ххх4567",checkTelNumber("050ххх4567")));
        System.out.println(String.format("%s - %b","0501(234)560",checkTelNumber("0501(234)560")));
        System.out.println(String.format("%s - %b","(0)501234567",checkTelNumber("(0)501234567")));

    }
    public static boolean checkTelNumber(String telNumber)
    {
       return telNumber.matches("(?=(^\\+([^\\d]*\\d){12}$)|(^([^\\d]*[\\d]){10}$))(^\\+?((\\d*\\(\\d{3}\\))|(\\d*))(([\\d]+-?){2})\\d+$)");
    }
}
