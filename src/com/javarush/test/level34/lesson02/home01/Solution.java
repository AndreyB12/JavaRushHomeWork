package com.javarush.test.level34.lesson02.home01;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
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
    private Map<String, BigDecimal> exprsValues = new HashMap<>();

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

        s = "cos(3 + 19*3)";
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


    private BigDecimal getBDValue(String text)
    {
        if (text.matches("a\\d++")) return exprsValues.get(text);

        BigDecimal bd = new BigDecimal(text);
        bd.setScale(10,BigDecimal.ROUND_HALF_UP);
        return bd;
    }

    private double getDoubleValue(String text)
    {
        if (text.matches("a\\d++")) return exprsValues.get(text).doubleValue();
        return Double.valueOf(text);
    }

    public void recursion(final String expression, int countOperation)
    {
       // System.out.println(expression);
       // System.out.println(exprsValues);

        //вывод результата
        Pattern pattern = Pattern.compile("a\\d+|\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(expression);

        if (matcher.matches())
        {

            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            df.setMinimumFractionDigits(0);
            df.setGroupingSize(0);
            BigDecimal result = getBDValue(expression);
            result.setScale(2, BigDecimal.ROUND_HALF_UP);
            System.out.println(df.format(result.doubleValue()).replace(",", ".") + " " + countOperation);
            exprsValues.clear();
        }

        //Ищем операции изменения знака
        pattern = Pattern.compile("(^|.*?\\()-(\\d+(\\.\\d+)?|((a\\d+)))(.?).*?");
        matcher = pattern.matcher(expression);
        while (matcher.find())
        {
            String alias = "a" + (exprsValues.size() + 1);
            String nextOperand = matcher.group(6);
            if (!nextOperand.matches("[\\*\\/\\^]"))
            {
                String operand1 = matcher.group(2);
                BigDecimal o1 = getBDValue(operand1);
                exprsValues.put(alias, o1.negate());
                recursion(expression.substring(0, matcher.start(2) - 1) + alias + expression.substring(matcher.end(2)), ++countOperation); // .replaceFirst(Pattern.quote("-" + operand1), alias), ++countOperation);
                return;
            }
        }
        // sinus
        pattern = Pattern.compile(".*?sin\\((\\d+(\\.\\d+)?|a\\d+)\\).*?");
        matcher = pattern.matcher(expression);
        if (matcher.matches())
        {
            String alias = "a" + (exprsValues.size() + 1);
            double x = getDoubleValue(matcher.group(1));
            exprsValues.put(alias, new BigDecimal(Math.sin(Math.toRadians(x))));
            recursion(expression.replaceFirst(Pattern.quote("sin(" + matcher.group(1) + ")"), alias), ++countOperation);
            return;
        }
        // cosinus
        pattern = Pattern.compile(".*?cos\\((\\d+(\\.\\d+)?|a\\d+)\\).*?");
        matcher = pattern.matcher(expression);
        if (matcher.matches())
        {
            String alias = "a" + (exprsValues.size() + 1);
            double x = getDoubleValue(matcher.group(1));
            exprsValues.put(alias, new BigDecimal(Math.cos(Math.toRadians(x))));
            recursion(expression.replaceFirst(Pattern.quote("cos(" + matcher.group(1) + ")"), alias), ++countOperation);
            return;
        }
        // tangens
        pattern = Pattern.compile(".*?tan\\((\\d+(\\.\\d+)?|a\\d+)\\).*?");
        matcher = pattern.matcher(expression);
        if (matcher.matches())
        {
            String alias = "a" + (exprsValues.size() + 1);
            double x = getDoubleValue(matcher.group(1));
            exprsValues.put(alias, new BigDecimal(Math.tan(Math.toRadians(x))));
            recursion(expression.replaceFirst(Pattern.quote("tan(" + matcher.group(1) + ")"), alias), ++countOperation);
            return;
        }

        //убираем скобки
        pattern = Pattern.compile(".*?\\((\\d+(\\.\\d+)?|a\\d+)\\).*?");
        matcher = pattern.matcher(expression);
        while (matcher.find())
        {
            String operand1 = matcher.group(1);
            recursion(expression.substring(0, matcher.start(1) - 1) + operand1 + expression.substring(matcher.end(1) + 1), countOperation);
            return;
        }

        //Ищем операции умножения
        pattern = Pattern.compile(".*?((\\d+(\\.\\d+)?|(a\\d+))\\*(\\d+(\\.\\d+)?|(a\\d+))).*?");
        matcher = pattern.matcher(expression);
        if (matcher.matches())
        {
            String alias = "a" + (exprsValues.size() + 1);
            String operand1 = matcher.group(2);
            String operand2 = matcher.group(5);
            BigDecimal o1 = getBDValue(operand1);
            BigDecimal o2 = getBDValue(operand2);
            exprsValues.put(alias, o1.multiply(o2));
            recursion(expression.replaceFirst(Pattern.quote(matcher.group(1)), alias), ++countOperation);
            return;
        }

        //Ищем операции деления
        pattern = Pattern.compile(".*?((\\d+(\\.\\d+)?|(a\\d+))/(\\d+(\\.\\d+)?|(a\\d+))).*?");
        matcher = pattern.matcher(expression);
        if (matcher.matches())
        {
            String alias = "a" + (exprsValues.size() + 1);
            String operand1 = matcher.group(2);
            String operand2 = matcher.group(5);
            BigDecimal o1 = getBDValue(operand1);
            BigDecimal o2 = getBDValue(operand2);
            exprsValues.put(alias, o1.divide(o2, 10, RoundingMode.HALF_UP));
            recursion(expression.replaceFirst(Pattern.quote(matcher.group(1)), alias), ++countOperation);
            return;
        }
        //Ищем операции возведения в степень
        pattern = Pattern.compile(".*?((\\d+(\\.\\d+)?|(a\\d+))\\^(\\d+(\\.\\d+)?|(a\\d+))).*?");
        matcher = pattern.matcher(expression);
        if (matcher.matches())
        {
            String alias = "a" + (exprsValues.size() + 1);
            String operand1 = matcher.group(2);
            String operand2 = matcher.group(5);
            double o1 = getDoubleValue(operand1);
            double o2 = getDoubleValue(operand2);
            exprsValues.put(alias, new BigDecimal(Math.pow(o1, o2)));
            recursion(expression.replaceFirst(Pattern.quote(matcher.group(1)), alias), ++countOperation);
            return;
        }
        //Ищем операции вычитания
        pattern = Pattern.compile(".*?((\\d+(\\.\\d+)?|(a\\d+))\\-(\\d+(\\.\\d+)?|(a\\d+)))(.?).*?");
        matcher = pattern.matcher(expression);
        while (matcher.find())
        {
            String alias = "a" + (exprsValues.size() + 1);
            String operand1 = matcher.group(2);
            String operand2 = matcher.group(5);
            String nextAction = matcher.group(8);
            if (nextAction.matches("[\\+\\-\\)]?"))
            {
                BigDecimal o1 = getBDValue(operand1);
                BigDecimal o2 = getBDValue(operand2);
                exprsValues.put(alias, o1.add(o2.negate()));
                recursion(expression.substring(0, matcher.start(1)) + alias +
                        expression.substring(matcher.end(1)), ++countOperation);
                // expression.replaceFirst(Pattern.quote(matcher.group(1)), alias), ++countOperation);
                return;
            }
        }

        //Ищем операции сложения
        pattern = Pattern.compile(".*?((\\d+(\\.\\d+)?|(a\\d+))\\+(\\d+(\\.\\d+)?|(a\\d+)))(.?).*?");
        matcher = pattern.matcher(expression);
        while (matcher.find())
        {
            String alias = "a" + (exprsValues.size() + 1);
            String operand1 = matcher.group(2);
            String operand2 = matcher.group(5);
            String nextAction = matcher.group(8);
            if (nextAction.matches("[\\+\\-\\)]?"))
            {
                BigDecimal o1 = getBDValue(operand1);
                BigDecimal o2 = getBDValue(operand2);
                exprsValues.put(alias, o1.add(o2));
                recursion(expression.substring(0, matcher.start(1)) + alias +
                        expression.substring(matcher.end(1)), ++countOperation);
                // expression.replaceFirst(Pattern.quote(matcher.group(1)), alias), ++countOperation);
                return;
            }
        }


    }

    public Solution()
    {
        //don't delete
    }
}
