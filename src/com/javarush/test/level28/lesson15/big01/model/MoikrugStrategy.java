package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by butkoav on 22.11.2016.
 */
public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancies = new ArrayList<>();
        Document document;
        int p = 1;
        try
        {
            while (true)
            {
                document = getDocument(searchString, p++);
                Elements elements = document.getElementsByClass("job");
                if (elements.size() == 0) break;
                for (Element element : elements)
                {
                    Vacancy vacancy = new Vacancy();
                    //get title and url
                    Element title = element.getElementsByClass("title").first();
                    vacancy.setTitle(title.getElementsByTag("a").first().text());
                    vacancy.setUrl(title.getElementsByTag("a").first().attr("href"));


                    //get city
                    Element city = element.getElementsByClass("location").first();
                    if (city != null) vacancy.setCity(city.getElementsByTag("a").first().text());
                    else vacancy.setCity("");

                    //get company
                    Element company = element.getElementsByClass("company_name").first();
                    vacancy.setCompanyName(company.getElementsByTag("a").first().text());

                    //get salary
                    Element salary = element.getElementsByClass("salary").first();
                    if (salary != null)
                    {
                        String salaryTxt = "";
                        for (Element slr : salary.children())
                        {
                            salaryTxt += slr.text();
                        }
                        vacancy.setSalary(salaryTxt);
                    } else vacancy.setSalary("");


                    //get site
                    vacancy.setSiteName("https://moikrug.ru");
                    vacancies.add(vacancy);
                }
             //   break;
            }
        }
        catch (IOException e)
        {
        }
        return vacancies;

    }


    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, page, URLEncoder.encode(searchString, "UTF-8"));
       // url = "http://javarush.ru/testdata/big28data2.html";
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36";
        String referrer = "http://javarush.ru/";
        Connection connection = Jsoup.connect(url).userAgent(userAgent).referrer(referrer);
        Document document = connection.get();
        return document;
    }
}
