package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution
{
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            allLines = readFile(reader.readLine());
            forRemoveLines = readFile(reader.readLine());
            Solution solution = new Solution();
            solution.joinData();
            System.out.println(allLines.toString());
        }
        catch (CorruptedDataException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private static List<String> readFile(String filePath) throws IOException
    {
        List<String> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while (!((line = reader.readLine()) == null))
        {
            list.add(line);
        }
        reader.close();
        return list;
    }

    public void joinData() throws CorruptedDataException
    {
        /*boolean flag = true;
        for (String line : forRemoveLines)
        {
            if (!allLines.contains(line))
            {
                flag = false;
                break;
            }
        }
        if (flag)*/
        if(allLines.containsAll(forRemoveLines))
        {
            /*for (String line : forRemoveLines)
            {
                while (allLines.contains(line))
                {
                    allLines.remove(line);
                }
            }*/
            allLines.removeAll(forRemoveLines);
        } else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
