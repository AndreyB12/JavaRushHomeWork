package com.javarush.test.level04.lesson04.task06;

/* День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название «понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше или меньше 7 – вывести «такого дня недели не существует».
Пример для номера 5:
пятница
Пример для номера 10:
такого дня недели не существует
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());

/*        if (a>7||a<1) {
            System.out.println("такого дня недели не существует");
            return;
        }*/
        switch (a) {
            case 1: System.out.println("понедельник");
                break;
            case 2: System.out.println("вторник");
                break;
            case 3: System.out.println("среда");
                break;
            case 4: System.out.println("четверг");
                break;
            case 5: System.out.println("пятница");
                break;
            case 6: System.out.println("суббота");
                break;
            case 7: System.out.println("воскресенье");
                break;
            default : System.out.println("такого дня недели не существует");
    }
    }

}