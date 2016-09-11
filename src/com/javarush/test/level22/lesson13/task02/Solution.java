package com.javarush.test.level22.lesson13.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution
{
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException
    {
        String fileW1251 = args[0];
        String fileUTF8 = args[1];

        try (FileInputStream fr = new FileInputStream(fileW1251);
             FileOutputStream fw = new FileOutputStream(fileUTF8))
        {
            Charset w1251 = Charset.forName("windows-1251");
            Charset utf8 = Charset.forName("UTF8");
            byte[] buffer = new byte[fr.available()];

            fr.read(buffer);
            {
                String string = new String(buffer, utf8);
                buffer = string.getBytes(w1251);
                fw.write(buffer);
            }

        }
        catch (Exception e)
        {

        }

    }
}
