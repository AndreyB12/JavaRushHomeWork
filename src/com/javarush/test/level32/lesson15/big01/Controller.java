package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by butkoav on 28.12.2016.
 */
public class Controller
{
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view)
    {
        this.view = view;
    }

    public static void main(String... args)
    {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);

        view.init();
        controller.init();

    }

    public void init()
    {
        createNewDocument();
    }

    public HTMLDocument getDocument()
    {
        return document;
    }

    public void resetDocument()
    {
        if (document != null)
        {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text)
    {
        resetDocument();
        StringReader sr = new StringReader(text);
        try
        {
            new HTMLEditorKit().read(sr, document, 0);
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText()
    {
        StringWriter sw = new StringWriter();
        try
        {
            new HTMLEditorKit().write(sw, document, 0, document.getLength());
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
        return sw.toString();
    }

    /**
     * 22.1.	Переключать представление на html вкладку.
     * 22.2.	Создавать новый объект для выбора файла JFileChooser.
     * 22.3.	Устанавливать ему в качестве фильтра объект HTMLFileFilter.
     * 22.4.	Показывать диалоговое окно "Save File" для выбора файла.
     * 22.5.	Если пользователь подтвердит выбор файла:
     * 22.5.1.	Сохранять выбранный файл в поле currentFile.
     * 22.5.2.	Устанавливать имя файла в качестве заголовка окна представления.
     * 22.5.3.	Создавать FileWriter на базе currentFile.
     * 22.5.4.	Переписывать данные из документа document в объекта FileWriter-а аналогично тому,
     * как мы это делали в методе getPlainText().
     * 22.6.	Метод не должен кидать исключения.
     */
    public void saveDocumentAs()
    {
        try
        {
            view.selectHtmlTab();
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileFilter(new HTMLFileFilter());
            int returnVal = jFileChooser.showSaveDialog(view);

            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                currentFile = jFileChooser.getSelectedFile();
                view.setTitle(currentFile.getName());

                FileWriter fw = new FileWriter(currentFile);
                new HTMLEditorKit().write(fw, document, 0, document.getLength());
                fw.close();
            }

        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public void saveDocument()
    {
        if (currentFile == null) saveDocumentAs();
        else
        {
            view.selectHtmlTab();
            try
            {
                FileWriter fw = new FileWriter(currentFile);
                new HTMLEditorKit().write(fw, document, 0, document.getLength());
                fw.close();
            }
            catch (Exception e)
            {
                ExceptionHandler.log(e);
            }
        }
    }

    /**
     * 23.2.	Пришло время реализовать метод openDocument(). Метод должен работать
     * аналогично методу saveDocumentAs(), в той части, которая отвечает за выбор файла.
     * Подсказка: Обрати внимание на имя метода для показа диалогового окна.
     * Когда файл выбран, необходимо:
     * 23.2.1.	Установить новое значение currentFile.
     * 23.2.2.	Сбросить документ.
     * 23.2.3.	Установить имя файла в заголовок у представления.
     * 23.2.4.	Создать FileReader, используя currentFile.
     * 23.2.5.	Вычитать данные из FileReader-а в документ document с помощью объекта класса
     * HTMLEditorKit.
     * 23.2.6.	Сбросить правки (вызвать метод resetUndo представления).
     * 23.2.7.	Если возникнут исключения - залогируй их и не пробрасывай наружу.
     * Проверь работу пунктов меню Сохранить и Открыть.
     */
    public void openDocument()
    {
        try
        {
            view.selectHtmlTab();
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileFilter(new HTMLFileFilter());
            int returnVal = jFileChooser.showOpenDialog(view);

            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                currentFile = jFileChooser.getSelectedFile();
                resetDocument();
                view.setTitle(currentFile.getName());

                FileReader fr = new FileReader(currentFile);
                new HTMLEditorKit().read(fr,document,0);
                fr.close();
                view.resetUndo();
            }
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }


    /**
     * 20.1.	Реализуй метод создания нового документа createNewDocument() в контроллере. Он
     * должен:
     * 20.1.1.	Выбирать html вкладку у представления.
     * 20.1.2.	Сбрасывать текущий документ.
     * 20.1.3.	Устанавливать новый заголовок окна, например: "HTML редактор". Воспользуйся
     * методом setTitle(), который унаследован в нашем представлении.
     * 20.1.4.	Сбрасывать правки в Undo менеджере. Используй метод resetUndo представления.
     * 20.1.5. Обнулить переменную currentFile.
     * 20.2.	Реализуй метод инициализации init() контроллера. Он должен просто вызывать метод
     * создания нового документа.
     */
    public void createNewDocument()
    {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void exit()
    {
        System.exit(0);
    }
}
