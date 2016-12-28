package com.javarush.test.level32.lesson08.home01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by butkoav on 25.12.2016.
 */
public class CustomInvocationHandler implements InvocationHandler
{
    private SomeInterfaceWithMethods someInterfaceWithMethods;

    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethods)
    {
        this.someInterfaceWithMethods = someInterfaceWithMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println(String.format("%s in", method.getName()));
        Object result = method.invoke(someInterfaceWithMethods, args);
        System.out.println(String.format("%s out", method.getName()));
        return result;
    }
}
