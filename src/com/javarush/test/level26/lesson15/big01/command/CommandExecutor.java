package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by butkoav on 19.10.2016.
 */
public final class CommandExecutor
{
    private static Map<Operation, Command> commands;

    static
    {
        commands = new HashMap<>();
        commands.put(Operation.DEPOSIT, new DepositCommand());
        commands.put(Operation.INFO, new InfoCommand());
        commands.put(Operation.WITHDRAW, new WithdrawCommand());
        commands.put(Operation.EXIT, new ExitCommand());
    }

    public static final void execute(Operation operation)
    {
        commands.get(operation).execute();
    }

    private CommandExecutor()
    {
    }
}
