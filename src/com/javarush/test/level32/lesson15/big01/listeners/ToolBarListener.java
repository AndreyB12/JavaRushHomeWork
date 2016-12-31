package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by butkoav on 31.12.2016.
 */
public class ToolBarListener implements ActionListener
{
    private View view;

    public ToolBarListener(View view)
    {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (((JButton) e.getSource()).getName())
        {
            case "btnOpen":
                view.getController().openDocument();
                break;
            case "btnNew":
                view.getController().createNewDocument();
                break;
            case "btnSave":
                view.getController().saveDocument();
                break;
            case "btnSaveAs":
                view.getController().saveDocumentAs();
                break;
            case "btnAddImage":
                view.addImage();
                break;
        }
    }
}
