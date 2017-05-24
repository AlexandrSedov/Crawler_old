package Parse;

import download.Downloader;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public String getSitemapURL(String robotsUrl) throws IOException {
        String robots = Downloader.getPage(robotsUrl);
        Pattern pattern = Pattern.compile(".*Sitemap:");
        Matcher matcher = pattern.matcher(robots);
        matcher.find();
        String URL = robots.substring(matcher.end()+1).split(" ")[0];
        return URL;
    }

    public String getURLs(String sitemapUrl) throws IOException {
        String sitemap = Downloader.getPage(sitemapUrl);

        return sitemap;
    }
}
