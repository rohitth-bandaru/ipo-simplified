package com.example.iposimplified;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HtmlParserExample {
    public static void main(String[] args) {
        try {
            // Load and parse the HTML file
            Document doc = Jsoup.connect("https://ipowatch.in/ipo-grey-market-premium-latest-ipo-gmp/").get();
            Element[] table = doc.getElementsByClass("wp-block-table is-style-regular has-medium-font-size").first().child(0).child(0).children().toArray(new Element[0]);
            for(int i=1; i<table.length; i++) {
                String link = table[i].child(0).child(0).attr("href");
                System.out.println("link : " + link);
                System.out.println("name : " + table[i].child(0).child(0).text());
                System.out.println("dates : " + table[i].child(0).child(2).text());
                System.out.println("ipo gmp : "+ table[i].child(1).text());
                System.out.println("per share price : " + table[i].child(2).text());
                System.out.println("issue type : " + table[i].child(6).text());
                System.out.println("#############################################################################");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
