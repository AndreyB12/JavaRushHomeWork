package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * Created by butkoav on 31.12.2016.
 */
public class ToolBarHelper
{
    public static JButton addButton(JToolBar parent, String text, ActionListener listener)
    {
        JButton jButton = new JButton(text);
        jButton.addActionListener(listener);
        parent.add(jButton, BorderLayout.WEST);
        return jButton;
    }

    public static JButton addButton(JToolBar parent,String name, String toolTipText, String iconName, ActionListener listener)
    {
        URL imgUrl = null;
        try
        {
            imgUrl = ToolBarHelper.class.getResource("icons/" + iconName);
            ImageIcon icon = new ImageIcon(imgUrl);
            JButton jButton = new JButton(icon);
            jButton.setName(name);
            jButton.setToolTipText(toolTipText);
            jButton.addActionListener(listener);
            parent.add(jButton);
            return jButton;
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
        return null;
    }
}
