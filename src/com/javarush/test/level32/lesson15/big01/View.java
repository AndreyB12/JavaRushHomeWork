package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by butkoav on 28.12.2016.
 */
public class View extends JFrame implements ActionListener
{
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }


    /**
     * 19.1.	Получи из события команду с помощью метода getActionCommand(). Это будет
     * обычная строка. По этой строке ты можешь понять какой пункт меню создал данное
     * событие.
     * 19.2.	Если это команда "Новый", вызови у контроллера метод createNewDocument(). В этом
     * пункте и далее, если необходимого метода в контроллере еще нет - создай заглушки.
     * 19.3.	Если это команда "Открыть", вызови метод openDocument().
     * 19.4.	Если "Сохранить", то вызови saveDocument().
     * 19.5.	Если "Сохранить как..." - saveDocumentAs().
     * 19.6.	Если "Выход" - exit().
     * 19.7.	Если "О программе", то вызови метод showAbout() у представления.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        switch (command)
        {
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;
        }
    }



    public Controller getController()
    {
        return controller;
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void init()
    {
        initGui();
        FrameListener frameListener = new FrameListener(this);
        this.addWindowListener(frameListener);
        this.setVisible(true);
    }

    public void initGui()
    {
        initMenuBar();
        initEditor();
        pack();
    }
    public void initButtonPanel()
    {}
    public void initMenuBar()
    {
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);

        getContentPane().add(jMenuBar, BorderLayout.NORTH);

    }

    public void initEditor()
    {
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPaneHTML = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", jScrollPaneHTML);

        JScrollPane jScrollPaneTxt = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", jScrollPaneTxt);

        tabbedPane.setPreferredSize(new Dimension(800, 500));

        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void exit()
    {
        this.controller.exit();
    }

    public void selectedTabChanged()
    {
        switch (tabbedPane.getSelectedIndex())
        {
            case 0:
                controller.setPlainText(plainTextPane.getText());
                break;
            case 1:
                plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();

    }

    public boolean isHtmlTabSelected()
    {
        return tabbedPane.getSelectedIndex() == 0 ? true : false;
    }

    public boolean canUndo()
    {
        return undoManager.canUndo();
    }

    public boolean canRedo()
    {
        return undoManager.canRedo();
    }

    public void undo()
    {
        try
        {
            undoManager.undo();
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public void redo()
    {
        try
        {
            undoManager.redo();
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener()
    {
        return undoListener;
    }

    public void resetUndo()
    {
        undoManager.discardAllEdits();
    }

    public void selectHtmlTab()
    {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update()
    {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout()
    {
        JOptionPane.showMessageDialog(getContentPane(), "HTML Editor. ButkoAV.", "HTML Editor.", JOptionPane.INFORMATION_MESSAGE);
    }
}
