package com.javarush.test.level18.lesson08.task04;

import java.io.*;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {
    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException
    {
        super(fileName);
        if(!fileName.substring(fileName.length()-4,fileName.length()).equals(".txt")){
            throw new UnsupportedFileNameException();
        }
    }

    public TxtInputStream(File file) throws FileNotFoundException, UnsupportedFileNameException
    {
        super(file);
        if(!file.getName().substring(file.getName().length()-4,file.getName().length()).equals(".txt")){
            throw new UnsupportedFileNameException();
        }

    }

    private TxtInputStream(FileDescriptor fdObj)
    {
        super(fdObj);
    }
}

