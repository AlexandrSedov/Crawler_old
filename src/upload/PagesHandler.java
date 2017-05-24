package upload;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PagesHandler extends DBConnection {
    private static PreparedStatement ps;

    public PagesHandler() {
        super();
        connect();
    }

    public static int selectId(String url) throws SQLException {
        ps = conn.prepareStatement("select ID from pages where Url = ?");
        ps.setString(1, url);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public static ArrayList<String> selectUrls(int siteId) throws SQLException {
        ArrayList<String> urls = new ArrayList<>();
        ps = conn.prepareStatement("select url from pages where siteId = ?");
        ps.setInt(1, siteId);
        ResultSet rs = ps.executeQuery();
        while ( rs.next() ) {
            urls.add(rs.getString(1));
        }
        return urls;
    }

    public void insert(String url, String siteName) throws SQLException {
        ps = conn.prepareStatement("INSERT INTO pages VALUES (null, ?, ?, null, ?);");
        ps.setString(1, url);
        ps.setString(2, getCurrentDate());
        ps.setInt(3, SitesHandler.selectId(siteName));
        ps.executeUpdate();
    }

    public void changeLastScanDate(String pageUrl) throws SQLException {
        ps = conn.prepareStatement("update pages set LastScanDate = ? where Url = ?;");
        ps.setString(1, getCurrentDate());
        ps.setString(2, pageUrl);
        ps.executeUpdate();
    }

    private static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("YY.MM.dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
