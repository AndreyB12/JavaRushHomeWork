package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by butkoav on 02.12.2016.
 * Задание 19.
 * <p>
 * Сегодня будем реализовывать класс BotSocketThread, вернее переопределять некоторые
 * его методы, весь основной функционал он уже унаследовал от SocketThread.
 * 19.1.	Переопредели метод clientMainLoop():
 * 19.1.1.	С помощью метода sendTextMessage() отправь сообщение с текстом
 * "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды."
 * 19.1.2.	Вызови реализацию clientMainLoop() родительского класса.
 * 19.2.	Переопредели метод processIncomingMessage(String message). Он должен
 * следующим образом обрабатывать входящие сообщения:
 * 19.2.1.	Вывести в консоль текст полученного сообщения message.
 * 19.2.2.	Получить из message имя отправителя и текст сообщения. Они разделены ": ".
 * 19.2.3.	Отправить ответ в зависимости от текста принятого сообщения. Если текст
 * сообщения:
 * "дата" – отправить сообщение содержащее текущую дату в формате "d.MM.YYYY";
 * "день" – в формате"d";
 * "месяц" - "MMMM";
 * "год" - "YYYY";
 * "время" - "H:mm:ss";
 * "час" - "H";
 * "минуты" - "m";
 * "секунды" - "s".
 * Указанный выше формат используй для создания объекта SimpleDateFormat. Для
 * получения текущей даты необходимо использовать класс Calendar и метод
 * getTime().
 * Ответ должен содержать имя клиента, который прислал запрос и ожидает ответ,
 * например, если Боб отправил запрос "время", мы должны отправить ответ
 * "Информация для Боб: 12:30:47".
 * Наш бот готов. Запусти сервер, запусти бота, обычного клиента и убедись, что все работает правильно.
 * Помни, что message бывают разных типов и не всегда содержат ":"
 * <p>
 * **************************************************************************************
 * <p>
 * Задание 18.
 * <p>
 * Иногда бывают моменты, что не находится достойного собеседника. Не общаться же с
 * самим собой :). Давай напишем бота, который будет представлять собой клиента, который
 * автоматически будет отвечать на некоторые команды. Проще всего реализовать бота,
 * который сможет отправлять текущее время или дату, когда его кто-то об этом попросит. С
 * него и начнем:
 * 18.1.	Создай новый класс BotClient в пакете client. Он должен быть унаследован от
 * Client.
 * 18.2.	В классе BotClient создай внутренний класс BotSocketThread унаследованный от
 * SocketThread. Класс BotSocketThread должен быть публичным.
 * 18.3.	Переопредели методы:
 * 18.3.1.	getSocketThread(). Он должен создавать и возвращать объект класса
 * BotSocketThread.
 * 18.3.2.	shouldSentTextFromConsole(). Он должен всегда возвращать false. Мы не хотим,
 * чтобы бот отправлял текст введенный в консоль.
 * 18.3.3.	getUserName(), метод должен генерировать новое имя бота, например:
 * date_bot_XX, где XX – любое число от 0 до 99. Этот метод должен возвращать
 * каждый раз новое значение, на случай, если на сервере захотят
 * зарегистрироваться несколько ботов, у них должны быть разные имена.
 * 18.4.	Добавь метод main. Он должен создавать новый объект BotClient и вызывать у
 * него метод run().
 * <p>
 * **************************************************************************************
 **/

public class BotClient extends Client
{
    public static void main(String... args)
    {
        new BotClient().run();
    }

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {
        return String.format("date_bot_%d", (int) (Math.random() * 99));
    }

    public class BotSocketThread extends SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
            String[] messageParts = message.split(": ");
            String senderName = "";
            String messageText = "";
            if (messageParts.length > 0) senderName = messageParts[0];
            if (senderName.equalsIgnoreCase(getName())) return;
            if (messageParts.length > 1) messageText = messageParts[1];
            String format = "";
            switch (messageText.toLowerCase())
            {
                case "дата":
                    format = "d.MM.YYYY";
                    break;
                case "день":
                    format = "d";
                    break;
                case "месяц":
                    format = "MMMM";
                    break;
                case "год":
                    format = "YYYY";
                    break;
                case "время":
                    format = "H:mm:ss";
                    break;
                case "час":
                    format = "H";
                    break;
                case "минуты":
                    format = "m";
                    break;
                case "секунды":
                    format = "s";
                    break;
            }

            if (!format.isEmpty())
            {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sendTextMessage(String.format("Информация для %s: %s", senderName, sdf.format(calendar.getTime())));
            }
        }
    }
}
