package upload;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonHandler extends DBConnection {
    private static PreparedStatement ps;

    public PersonHandler() {
        super();
        connect();
    }

    public static int selectId(String personName) throws SQLException {
        ps = conn.prepareStatement("select ID from persons where Name = ?");
        ps.setString(1, personName);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public static String selectName(int id) throws SQLException {
        ps = conn.prepareStatement("select Name from persons where id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getString(1);
    }
}
