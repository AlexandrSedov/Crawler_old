package Parse;

import download.Downloader;
import upload.KeywordsHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public String getSitemapURL(String robotsUrl) throws IOException {
        String robots = Downloader.getPage(robotsUrl);
        Pattern pattern = Pattern.compile(".*Sitemap:");
        Matcher matcher = pattern.matcher(robots);
        matcher.find();
        String url = robots.substring(matcher.end()+1).split(" ")[0];
        return url;
    }

    public ArrayList<String> getURLs(String sitemapUrl) throws IOException {
        String sitemap = Downloader.getPage(sitemapUrl);
        if ( sitemap.isEmpty() | sitemap == null ) throw new IOException("sitemap is empty");
        ArrayList<String> urls = new ArrayList<>();

        Pattern pattern = Pattern.compile("(https?:\\/\\/)?([\\w\\.]+)\\.([a-z]{2,6}\\.?)(\\/[\\w\\.]*)*\\/?");
        Matcher matcher = pattern.matcher(sitemap);
        while (matcher.find())
            urls.add(sitemap.substring(matcher.start(), matcher.end()));

        return urls;
    }

    public int countPageRank(String pageURL, int personId) throws IOException, SQLException {
        String page = Downloader.getPage(pageURL);
        KeywordsHandler kwh = new KeywordsHandler();
        int rank = 0;
        ArrayList<String> keywords = new ArrayList<>();
        keywords.addAll(kwh.getKeywords(personId));
        for (String s : keywords) {
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(page);
            while (matcher.find())
                rank++;
        }
        return rank;
    }
}
