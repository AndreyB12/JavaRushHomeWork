package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by butkoav on 19.10.2016.
 */
class ExitCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
      //  if (ConsoleHelper.askAreYouSure()) throw new InterruptOperationException();
    }

    ExitCommand()
    {
    }
}
