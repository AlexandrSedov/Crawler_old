package upload;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection implements Connection {
    public static java.sql.Connection conn = null;
    private static Statement stmt = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/gbrains";

    static final String USER = "root";
    static final String PASS = "123456";

    public DBConnection() { connect(); }

    @Override
    public void connect() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
