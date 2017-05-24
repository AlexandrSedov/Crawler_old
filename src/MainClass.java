import Parse.Parser;
import upload.KeywordsHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
//        String url = "https://www.ria.ru/robots.txt";
//        Parser parser = new Parser();
//        String URL = null;
//        ArrayList<String> urls = new ArrayList<>();
//        try {
//            URL = parser.getSitemapURL(url);
//            URL = parser.getURLs(URL);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(URL.toString());
        KeywordsHandler kh = new KeywordsHandler();
        try {
            System.out.println(kh.selectKeywords(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
