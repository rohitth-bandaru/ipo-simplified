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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
