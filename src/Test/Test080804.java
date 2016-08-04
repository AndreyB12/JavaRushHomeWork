package Test;

import java.util.Date;
import java.util.HashMap;
import static com.javarush.test.level08.lesson08.task04.Solution.*;


/**
 * Created by butkoav on 03.05.2016.
 */
public class Test080804
{
    public static void main(String[] args)
    {
        HashMap<String,Date> map = createMap();
        removeAllSummerPeople(map);

        for (HashMap.Entry<String,Date> entr :map.entrySet()             )
        {
            String lName = entr.getKey();
            System.out.println(lName);
        }
    }
}
