package ru.alternation.examples.youtube.parser_html_1;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=-l8Ji17d65Y
public class Test {
    public static void main(String[] args) throws IOException {
        List<ru.alternation.examples.youtube.parser_html_1.Article> articleList = new ArrayList<>();

        Document doc = Jsoup.connect("http://4pda.ru").get();

        Elements h1Elemetns = doc.getElementsByAttributeValue("class", "list-post-title");

        for (Element h1Element: h1Elemetns) {
//        h1Elemetns.forEach(h1Element -> {
            Element aElement = h1Element.child(0);
            String url = aElement.attr("href");
            String title = aElement.child(0).text();

            articleList.add(new ru.alternation.examples.youtube.parser_html_1.Article(url, title));
        }
//        );

        articleList.forEach(System.out::println);
    }
}

class Article {
    private String url;
    private String name;

    public Article(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Article{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}