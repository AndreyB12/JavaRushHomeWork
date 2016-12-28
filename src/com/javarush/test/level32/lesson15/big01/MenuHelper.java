package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by butkoav on 29.12.2016.
 */
public class MenuHelper
{
    /**
     * 7.1.	Реализуй в MenuHelper статический метод JMenuItem addMenuItem(JMenu parent, String
     * text, ActionListener actionListener). Он должен:
     * 7.1.1.	Создавать новый пункт меню JMenuItem, используя text.
     * 7.1.2.	Устанавливать этому пункту слушателя действий с помощью метода addActionListener().
     * 7.1.3.	Добавлять в parent созданный пункт меню.
     * 7.1.4.	Возвращать созданный пункт меню.
     *
     * @param parent         - меню в которое мы добавляем пункт
     * @param text           - текст добавляемого пункта
     * @param actionListener - слушатель действий добавляемого пункта меню
     * @return
     */
    public static JMenuItem addMenuItem(JMenu parent, String
            text, ActionListener actionListener)
    {
        JMenuItem jMenuItem = new JMenuItem();
        jMenuItem.addActionListener(actionListener);
        parent.add(jMenuItem);
        return jMenuItem;
    }
}
