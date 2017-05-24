package upload;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SitesHandler extends DBConnection {
    private static PreparedStatement ps;

    public SitesHandler() {
        super();
        connect();
    }

    public static int selectId(String siteName) throws SQLException {
        ps = conn.prepareStatement("select id from sites where Name = ?");
        ps.setString(1, siteName);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
}
}
