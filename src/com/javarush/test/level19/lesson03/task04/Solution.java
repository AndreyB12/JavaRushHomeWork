package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner
    {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException, ParseException
        {
            String[] line = scanner.nextLine().split(" ");
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date date = df.parse(String.format("%s/%s/%s",line[3],line[4],line[5]));

            return new Person(line[1],line[2],line[0],date);
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
