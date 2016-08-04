package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        int maxID = 0;
        maxID=Integer.parseInt(readLastLine(fileName).substring(0,8).trim());


        if(args[0].equals("-c"))
        {
            FileWriter fw = new FileWriter(fileName,true);
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%-8s", Integer.toString(maxID+1)));
            sb.append(String.format("%-30s", args[1]));
            sb.append(String.format("%-8s", args[2]));
            sb.append(String.format("%-4s", args[3]));
            fw.write(String.format("%n"));
            fw.write(sb.toString());
            fw.close();
        }
    }

    private static String readLastLine(String fileName) throws IOException
    {
        String line = "";
        int bte;
        RandomAccessFile ras = new RandomAccessFile(fileName, "r");
        long pos = ras.length();
        ras.seek(pos - 1);

        while (true)
        {
            ras.seek(pos-1);
            if ((bte = ras.read()) == 10 && (line = ras.readLine()) != null)
            {
                break;
            }
            pos--;
        }
        ras.close();
        return line;
    }
}
