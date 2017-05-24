package upload;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonPageRankHandler extends DBConnection {
    private static PreparedStatement ps;

    public PersonPageRankHandler() {
        super();
        connect();
    }

    public void insert(String personName, String pageUrl, int rank) throws SQLException {
            ps = conn.prepareStatement("INSERT INTO personpagerank VALUES (?, ?, ?);");
            ps.setInt(1, PersonHandler.selectId(personName));
            ps.setInt(2, PagesHandler.selectId(pageUrl));
            ps.setInt(3, rank);
            ps.executeUpdate();
    }
}
