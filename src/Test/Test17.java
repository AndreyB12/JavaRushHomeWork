package Test;


import com.javarush.test.level29.lesson15.big01.human.Human;
import com.javarush.test.level29.lesson15.big01.human.Soldier;
import com.javarush.test.level29.lesson15.big01.human.Teacher;


/**
 * Created by butkoav on 05.06.2016.
 */
public class Test17
{
    public static void main(String[] args) throws Exception
    {
        Human teacher = new Teacher("Andry",33,45);
        teacher.printData();

    }

}
