package Test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by butkoav on 08.06.2016.
 */
public class FileCopyTest
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fin = new FileInputStream("e:\\Sicario (2015) BDRip [UKR] [Hurtom].avi");
        FileOutputStream fout = new FileOutputStream("e:\\copy.avi");
        byte[] bytes = new byte[1024];
        int count =0;
        int lastWrite =0;
        while(fin.available()>0)
        {
            count=fin.read(bytes);
            fout.write(bytes,0,count);
        }
        fin.close();
        fout.close();


    }
}
