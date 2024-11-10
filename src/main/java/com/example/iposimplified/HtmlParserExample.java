package com.example.iposimplified;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

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
                HashMap<String, String> details = new HashMap<String, String>();
                details.put("link", table[i].child(0).child(0).attr("href"));
                details.put("name", table[i].child(0).child(0).text());
                details.put("gmp", table[i].child(1).text() );
                details.put("issue_type", table[i].child(6).text());

                Document ipo = Jsoup.connect(details.get("link")).get();
                Element[] ipo_details = ipo.getElementsByClass("wp-block-table is-style-stripes has-medium-font-size").first().child(0).child(0).children().toArray(new Element[0]);
                for(int j=1; j<ipo_details.length; j++) {
                    details.put(ipo_details[j].child(0).text(), ipo_details[j].child(1).text());
                }
                Element[] ipo_dates = ipo.getElementsByClass("wp-block-table is-style-stripes has-medium-font-size").toArray(new Element[0])[2].child(0).child(0).children().toArray(new Element[0]);
                for(int j=1; j<ipo_dates.length; j++) {
                    details.put(ipo_dates[j].child(0).text(), ipo_dates[j].child(1).text());
                }

                System.out.println("#############################################################################");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
