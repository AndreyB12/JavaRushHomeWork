package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by butkoav on 07.01.2017.
 */
@XmlRootElement
@XmlType(name = "shop")
public class Shop
{
    @XmlElementWrapper(name = "goods")
    public List<String> names;

    public int count;
    public double profit;

    public List<String> secretData;

    public Shop()
    {
    }
}
