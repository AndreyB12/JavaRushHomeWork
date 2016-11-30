package com.javarush.test.level31.lesson02.home01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution
{

    static List<File> files = new ArrayList<>();
    static File resultFile;
    public static void main(String[] args) throws IOException
    {

        File root = new File(args[0]);
        resultFile = new File(args[1]);

        processFiles(root);
        Collections.sort(files, new Comparator<File>()
        {
            @Override
            public int compare(File o1, File o2)
            {
                return o1.getName().compareTo(o2.getName());
            }
        });
        File newOutputFile = new File(resultFile.getParent() + "/allFilesContent.txt");
        resultFile.renameTo(newOutputFile);

        try (FileOutputStream os = new FileOutputStream(newOutputFile))
        {
            for (File file : files)
            {
                byte[] b = new byte[50];
                int i;
                FileInputStream is = new FileInputStream(file);
                i = is.read(b);
                os.write(b, 0, i);
                os.write(10);
            }
        }
        catch (Exception e)
        {
        }
    }

    public static void processFiles(File root)
    {
        for (File file : root.listFiles())
        {
            if (file.isDirectory())
            {
                processFiles(file);
                if (file.listFiles().length == 0) file.delete();
            } else if (!file.getAbsolutePath().equalsIgnoreCase(resultFile.getAbsolutePath()))
            {
                if (file.length() > 50) file.delete();
                else files.add(file);
            }
        }
    }
}
