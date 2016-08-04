package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution
{
    public Solution()
    {
    }
    public Solution(int i, int b)
    {
    }
    public Solution(int i,int k, int j)
    {
    }

    protected Solution(int i)
    {
    }
    protected Solution(Integer i)
    {
    }
    protected Solution(Double i)
    {
    }

     Solution(short i)
    {
    }
     Solution(Number i)
    {
    }
     Solution(float i)
    {
    }

    private Solution(double d){}

    private Solution (float f,double d){}
    private Solution (String s,float f){}

}

