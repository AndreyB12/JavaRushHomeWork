package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by butkoav on 19.11.2016.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancies = new ArrayList<>();
        Document document;
        int p = 0;
        try
        {
            while (true)
            {
                document = getDocument("Киев", p++);
                Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.size() == 0) break;
                for (Element element : elements)
                {
                    Vacancy vacancy = new Vacancy();
                    //get title and url
                    Element title = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    vacancy.setTitle(title.text());
                    vacancy.setUrl(title.attr("href"));


                    //get city
                    Element city = element.select("[data-qa=vacancy-serp__vacancy-address]").first();
                    vacancy.setCity(city.text());
                    //get company
                    Element company = element.select("[data-qa=vacancy-serp__vacancy-employer]").first();
                    vacancy.setCompanyName(company.text());

                    //get salary
                    Element salary = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    if (salary != null) vacancy.setSalary(salary.attr("content"));
                    else vacancy.setSalary("");
                    //get site
                    vacancy.setSiteName("http://hh.ua/");
                    vacancies.add(vacancy);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, searchString, page);
      //  url = "http://javarush.ru/testdata/big28data.html";
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36";
        String referrer = "";
        Document document = Jsoup.connect(url).userAgent(userAgent).referrer(referrer).get();
        return document;
    }
}
