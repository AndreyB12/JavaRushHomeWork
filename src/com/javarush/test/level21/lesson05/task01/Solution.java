package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution
{
    private final String first, last;

    public Solution(String first, String last)
    {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution = (Solution) o;
        boolean result = false;
        result = (first == null) ? (solution.first == null) : ((solution.first == null) ? false : (first.equals(solution.first)));
        result = result && (last == null) ? (solution.last == null) : ((solution.last == null) ? false : (last.equals(solution.last)));

        return result;
    }

    @Override
    public int hashCode()
    {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args)
    {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        s.add(new Solution(null, null));
        s.add(new Solution(null, "Duck"));

        System.out.println(s.contains(new Solution("Donald", "Duck")));
        System.out.println(s.contains(new Solution(null, null)));
        System.out.println(s.contains(new Solution(null, "Duck")));
    }
}
