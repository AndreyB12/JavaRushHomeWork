package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by butkoav on 20.11.2016.
 */
public class HtmlView implements View
{
    private Controller controller;
    private final String filePath;

    {
        filePath = "./src/" + this.getClass().getPackage().getName().toString().replaceAll("\\.", "/") + "/vacancies.html";
    }

    @Override
    public void update(List<Vacancy> vacancies)
    {

        String docHtml = null;
        try
        {
            docHtml = getUpdatedFileContent(vacancies);
            updateFile(docHtml);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod()
    {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException
    {
        Document document;
        document = getDocument();
        Element originalTmpl = document.getElementsByClass("template").first();
        Element vacancyTmpl = originalTmpl.clone();
        vacancyTmpl.removeAttr("style");
        vacancyTmpl.removeClass("template");

        for (Element elm : document.getElementsByClass("vacancy").not(".template"))
        {
            elm.remove();
        }

        for (Vacancy vacancy : vacancies)
        {
            Element vacancyElement = vacancyTmpl.clone();
            vacancyElement.getElementsByClass("city").first().text(vacancy.getCity());
            vacancyElement.getElementsByTag("a").first().text(vacancy.getTitle());
            vacancyElement.getElementsByTag("a").first().attr("href", vacancy.getUrl());
            vacancyElement.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
            vacancyElement.getElementsByClass("salary").first().text(vacancy.getSalary());

            originalTmpl.before(vacancyElement);
        }
        return document.html();

    }

    private void updateFile(String fileText) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(filePath);
        fos.write(fileText.getBytes("UTF-8"));
        fos.close();
    }

    protected Document getDocument() throws IOException
    {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
