package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat f2 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);

        Date date = null;
        try
        {
            date = format.parse(reader.readLine());
            System.out.println(f2.format(date).toUpperCase() );
        }
        catch (Exception e)
        {
            System.out.println("Wrong date format.");
        }



    }
}
