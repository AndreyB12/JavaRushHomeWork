package Test;

import com.javarush.test.level33.lesson10.bonus01.Solution;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by butkoav on 08.01.2017.
 */
@XmlRootElement
public class TestClass
{
    public String name;

    public List<String> second = new ArrayList<>();

    public TestClass()
    {

    }

    public TestClass(String name)
    {
        this.name = name;
    }

    public static void main(String... args)
    {
        TestClass testClass = new TestClass("test class name");
        testClass.second.add("<second>");
        testClass.second.add("\"");
        testClass.second.add("dsfgdg");
        testClass.second.add("'");
        try
        {
            System.out.println(Solution.toXmlWithComment(testClass, "second", "some comment"));
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

}
