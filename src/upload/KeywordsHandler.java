package upload;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KeywordsHandler extends DBConnection {
    private static PreparedStatement ps;

    public KeywordsHandler() {
        super();
        connect();
    }

    public static ArrayList<String> selectKeywords(int personId) throws SQLException {
        ArrayList<String> keywords = new ArrayList<>();
        ps = conn.prepareStatement("select Name from keywords where personID = ?");
        ps.setInt(1, personId);
        ResultSet rs = ps.executeQuery();
        while ( rs.next() ) {
            keywords.add(rs.getString(1));
        }
        return keywords;
    }
}
