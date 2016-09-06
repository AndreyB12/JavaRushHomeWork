package com.javarush.test.level21.lesson05.task03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution
*/
public class Solution
{
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public static void main(String... args) throws ParseException
    {
        Date date = new SimpleDateFormat("dd/MM/YYYY").parse("12/07/1983");
        Solution sol1 = new Solution(123, "test", 123.123, date, null);
        Solution sol2 = new Solution(123, "test", 123.123, date, sol1);
        Solution sol3 = new Solution(123, "test", 123.123, date, sol1);
        Set<Solution> set = new HashSet<>();
        set.add(sol2);

        System.out.println(sol2.hashCode());
        System.out.println(sol3.hashCode());
        System.out.println(sol2.equals(sol3));
        System.out.println(set.contains(sol3));
    }


    public Solution(int anInt, String string, double aDouble, Date date, Solution solution)
    {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date != null) return false;
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution != null) return false;
        if (string != null ? !string.equals(solution1.string) : solution1.string != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (string != null ? string.hashCode() : 0);
        return result;
    }
}
