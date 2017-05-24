package download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Downloader {
    public static String getPage(String pageUrl) throws IOException {
        URL url = new URL(pageUrl);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
        int responseCode = httpURLConnection.getResponseCode();
        switch (responseCode) {
            case HttpURLConnection.HTTP_OK:
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String line = "";
                while((line = reader.readLine()) != null)
                    builder.append(line);
                return builder.toString();
            default:
                throw new IOException("Couldn't connect to server: error " + responseCode);
        }
    }
}
