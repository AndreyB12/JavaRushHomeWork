package com.javarush.test.level34.lesson02.home01;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Рекурсия для мат.выражения
На вход подается строка - математическое выражение.
Выражение включает целые и дробные числа, скобки (), пробелы, знак отрицания -, возведение в степень ^, sin(x), cos(x), tan(x)
Для sin(x), cos(x), tan(x) выражение внутри скобок считать градусами, например, cos(3 + 19*3)=0.5
Степень задается так: a^(1+3) и так a^4, что эквивалентно a*a*a*a.
С помощью рекурсии вычислить выражение и количество математических операций. Вывести через пробел результат в консоль.
Результат выводить с точностью до двух знаков, для 0.33333 вывести 0.33, использовать стандартный принцип округления.
Не создавайте статические переменные и поля класса.
Не пишите косвенную рекурсию.
Пример, состоящий из операций sin * - + * +:
sin(2*(-5+1.5*4)+28)
Результат:
0.5 6
*/
public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        String s = "sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output 0.5 6 actually ");
        solution.recursion(s, 0);

        s = "tan(45)";
        System.out.print(s + " expected output 1 1 actually ");
        solution.recursion(s, 0);

        s = "0.305";
        System.out.print(s + " expected output 0.3 0 actually ");
        solution.recursion(s, 0);

        s = "0.3051";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recursion(s, 0);

        s = "1+(1+(1+1)*(1+1))*(1+1)+1";
        System.out.print(s + " expected output 12 8 actually ");
        solution.recursion(s, 0);

        s = "tan(44+sin(89-cos(180)^2))";
        System.out.print(s + " expected output 1 6 actually ");
        solution.recursion(s, 0);

        s = "-2+(-2+(-2)-2*(2+2))";
        System.out.print(s + " expected output -14 8 actually ");
        solution.recursion(s, 0);

        s = "sin(80+(2+(1+1))*(1+1)+2)";
        System.out.print(s + " expected output 1 7 actually ");
        solution.recursion(s, 0);

        s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
        System.out.print(s + " expected output 6 11 actually ");
        solution.recursion(s, 0);

        s = "2^10+2^(5+5)";
        System.out.print(s + " expected output 2048 4 actually ");
        solution.recursion(s, 0);

        s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
        System.out.print(s + " expected output 72.96 8 actually ");
        solution.recursion(s, 0);

        s = "0.000025+0.000012";
        System.out.print(s + " expected output 0 1 actually ");
        solution.recursion(s, 0);

        s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
        System.out.print(s + " expected output -3 16 actually ");
        solution.recursion(s, 0);

        s = "cos(3+19*3)";
        System.out.print(s + " expected output 0.5 3 actually ");
        solution.recursion(s, 0);

        s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
        System.out.print(s + " expected output 8302231.36 14 actually ");
        solution.recursion(s, 0);

        s = "(-1 + (-2))";
        System.out.print(s + " expected output -3 3 actually ");
        solution.recursion(s, 0);

        s = "-sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output -0.5 7 actually ");
        solution.recursion(s, 0);

        s = "sin(100)-sin(100)";
        System.out.print(s + " expected output 0 3 actually ");
        solution.recursion(s, 0);
    }


    private double getDblValue(String text)
    {
        return text == null ? 0 : Double.valueOf(text.replace("(", "").replace(")", ""));
    }

    public void recursion(final String expression, int countOperation)
    {
        String express = expression.replace(" ","");
        //    System.out.println(express);

        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.ENGLISH);
        dfs.setDecimalSeparator('.');
        dfs.setGroupingSeparator(' ');
        DecimalFormat df = new DecimalFormat();
        df.setDecimalFormatSymbols(dfs);
        df.setMaximumFractionDigits(5);
        df.setMinimumFractionDigits(0);
        df.setGroupingSize(0);

        //вывод результата
        Pattern pattern = Pattern.compile("\\-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(express);

        if (matcher.matches())
        {
            double result = Double.valueOf(express);
            df.setMaximumFractionDigits(2);
            System.out.println(df.format(result) + " " + countOperation);
            return;
        }

        //считаем операции
        if (countOperation == 0)
        {
            pattern = Pattern.compile("([\\+\\-\\*\\/\\^]|sin|cos|tan)");
            matcher = pattern.matcher(express);
            while (matcher.find()) countOperation++;
        }


        // sinus
        pattern = Pattern.compile(".*?(sin\\((\\-?\\d+(\\.\\d+)?)\\)).*?");
        matcher = pattern.matcher(express);
        if (matcher.matches())
        {
            double x = getDblValue(matcher.group(2));
            double rs = Math.sin(Math.toRadians(x));
            recursion(express.replaceFirst(Pattern.quote(matcher.group(1)), df.format(rs)), countOperation);
            return;
        }
        // cosinus
        pattern = Pattern.compile(".*?(cos\\((\\-?\\d+(\\.\\d+)?)\\)).*?");
        matcher = pattern.matcher(express);
        if (matcher.matches())
        {
            double x = getDblValue(matcher.group(2));
            double rs = Math.cos(Math.toRadians(x));
            recursion(express.replaceFirst(Pattern.quote(matcher.group(1)), df.format(rs)), countOperation);
            return;
        }
        // tangens
        pattern = Pattern.compile(".*?(tan\\((\\-?\\d+(\\.\\d+)?)\\)).*?");
        matcher = pattern.matcher(express);
        if (matcher.matches())
        {
            double x = getDblValue(matcher.group(2));
            double rs = Math.tan(Math.toRadians(x));
            recursion(express.replaceFirst(Pattern.quote(matcher.group(1)), df.format(rs)), countOperation);
            return;
        }


        //Ищем операции умножения
        pattern = Pattern.compile(".*?((\\d+(\\.\\d+)?)\\*(\\-?\\d+(\\.\\d+)?)).*?");
        matcher = pattern.matcher(express);
        if (matcher.matches())
        {
            String operand1 = matcher.group(2);
            String operand2 = matcher.group(4);
            double o1 = getDblValue(operand1);
            double o2 = getDblValue(operand2);
            double rs = o1 * o2;
            recursion(express.replaceFirst(Pattern.quote(matcher.group(1)), df.format(rs)), countOperation);
            return;
        }

        //Ищем операции деления
        pattern = Pattern.compile(".*?((\\d+(\\.\\d+)?)\\/(\\-?\\d+(\\.\\d+)?)).*?");
        matcher = pattern.matcher(express);
        if (matcher.matches())
        {
            String operand1 = matcher.group(2);
            String operand2 = matcher.group(4);
            double o1 = getDblValue(operand1);
            double o2 = getDblValue(operand2);
            double rs = o1 / o2;
            recursion(express.replaceFirst(Pattern.quote(matcher.group(1)), df.format(rs)), countOperation);
            return;
        }
        //Ищем операции возведения в степень
        pattern = Pattern.compile(".*?((\\d+(\\.\\d+)?|\\(\\-?\\d+(\\.\\d+)?\\))\\^(\\-?\\d+(\\.\\d+)?|\\(\\-?\\d+(\\.\\d+)?\\))).*?");
        matcher = pattern.matcher(express);
        if (matcher.matches())
        {
            String operand1 = matcher.group(2);
            String operand2 = matcher.group(5);
            double o1 = getDblValue(operand1);
            double o2 = getDblValue(operand2);
            double rs = Math.pow(o1, o2);
            recursion(express.replaceFirst(Pattern.quote(matcher.group(1)), df.format(rs)), countOperation);
            return;
        }
        //Ищем операции вычитания
        pattern = Pattern.compile(".*?((\\-?\\d+(\\.\\d+)?|\\(\\-?\\d+(\\.\\d+)?\\))\\-(\\-?\\d+(\\.\\d+)?|\\(\\-?\\d+(\\.\\d+)?\\)))(.?).*?");
        matcher = pattern.matcher(express);
        while (matcher.find())
        {
            String operand1 = matcher.group(2);
            String operand2 = matcher.group(5);
            String nextAction = matcher.group(8);
            if (nextAction.matches("[\\+\\-\\)]?"))
            {
                double o1 = getDblValue(operand1);
                double o2 = getDblValue(operand2);
                double rs = o1 - o2;
                recursion(express.substring(0, matcher.start(1)) + df.format(rs) +
                        express.substring(matcher.end(1)), countOperation);
                return;
            }
        }
        //убираем скобки
        pattern = Pattern.compile(".*?((\\-?)\\((\\-?\\d+(\\.\\d+)?)\\)).*?");
        matcher = pattern.matcher(express);
        if (matcher.find())
        {
            String operand1 = matcher.group(3);
            String min = matcher.group(2);
            double m = min.matches("-") ? -1 : 1;
            double rs = getDblValue(operand1) * m;

            recursion(express.substring(0, matcher.start(1)) + df.format(rs) + express.substring(matcher.end(1)), countOperation);
            return;
        }

        //Ищем операции сложения
        pattern = Pattern.compile(".*?((\\-?\\d+(\\.\\d+)?)\\+(\\-?\\d+(\\.\\d+)?))(.?).*?");
        matcher = pattern.matcher(express);
        while (matcher.find())
        {
            String operand1 = matcher.group(2);
            String operand2 = matcher.group(4);
            String nextAction = matcher.group(6);
            if (nextAction.matches("[\\+\\-\\)]?"))
            {
                double o1 = getDblValue(operand1);
                double o2 = getDblValue(operand2);
                double rs = o1 + o2;
                recursion(express.substring(0, matcher.start(1)) + df.format(rs) +
                        express.substring(matcher.end(1)), countOperation);
                return;
            }
        }


    }

    public Solution()
    {
        //don't delete
    }
}
