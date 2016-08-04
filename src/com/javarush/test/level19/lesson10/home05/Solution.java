package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> words = new ArrayList<>();
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        FileWriter fw = new FileWriter(args[1]);
        while (fr.ready())
        {
            Collections.addAll(words, fr.readLine().split(" "));
        }
        fr.close();

        for (String word : words)
        {
            if(word.matches(".*\\d.*"))
            {
                fw.write(word.toCharArray());
                fw.write(" ");
            }
        }

        fw.close();
    }
}
