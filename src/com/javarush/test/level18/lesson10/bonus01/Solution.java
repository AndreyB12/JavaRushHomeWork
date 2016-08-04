package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;


public class Solution
{
    public static void main(String[] args) throws Throwable
    {
        FileInputStream fis = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[2]);

        switch (args[0])
        {
            case "-e":
                copyData( fis, fos,1);
                break;

            case "-d":
                copyData(fis, fos,0);
                break;
            default:
                return;
        }
        fis.close();
        fos.close();
    }

    private static void copyData(InputStream is, OutputStream os, int mode) throws IOException
    {
        byte[] in = new byte[256];
        int count = 0;
        while ((count = is.read(in)) != -1)
        {
            byte[] res =(mode == 1)? encryptData(in) : decryptData(in);
            os.write(res,0,count);
        }
    }


    private static byte[] encryptData(byte[] in)
    {
        byte[] result = new byte[in.length];
        for (int i = 0; i < in.length; i++)
        {
            result[i] = (byte) (in[i] - 128);
        }

        return result;
    }

    private static byte[] decryptData(byte[] in)
    {
        byte[] result = new byte[in.length];
        for (int i = 0; i < in.length; i++)
        {
            result[i] = (byte) (in[i] + 128);
        }

        return result;
    }

}
