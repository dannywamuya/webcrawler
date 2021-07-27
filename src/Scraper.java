/*
* Simple web scraper based on jsoup that grabs urls from DOM content and saves to a file
*
* author -      Danny Wamuya
* date   -      27.07.2021
* lib    -      jsoup-1.14.1.jar
*
* */

import java.io.FileWriter;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {
    public static void main(String[] args) {
        String url = "https://github.com/";
        try {
            getUrls(url);
        } catch (Exception e) {
            System.err.println("Error : getUrls\n");
            System.out.println(e.getMessage());
        }
    }

    private static void getUrls(String url) throws Exception {

        FileWriter fWriter = new FileWriter("/Users/Danny/github.txt");

        Connection con = Jsoup.connect(url);
        Document doc = con.get();
        Elements ls = doc.select("a[href]");

        for (Element l : ls) {
            fWriter.write(l.absUrl("href") + "\n");
            System.out.println(l.absUrl("href"));
        }
        fWriter.close();
    }
}
