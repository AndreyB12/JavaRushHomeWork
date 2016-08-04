package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit"))
        {
            new ReadThread(fileName).start();
        }

    }

    public static class ReadThread extends Thread
    {
        private String fileName;

        public ReadThread(String fileName)
        {
            super();
            this.fileName = fileName;
        }

        @Override
        public void run()
        {
            try
            {
                FileInputStream fis = new FileInputStream(this.fileName);
                int[] bytesCount = new int[256];

                while (fis.available() > 0)
                {
                    bytesCount[fis.read()]++;
                }
                fis.close();
                int maxCount = 0;
                int maxByte = 0;
                for (int i = 0; i < bytesCount.length; i++)
                {
                    if (maxCount < bytesCount[i]) {
                        maxCount = bytesCount[i];
                        maxByte = i;
                    }
                }
                synchronized (resultMap){
                    resultMap.put(fileName,maxByte);
                }

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
