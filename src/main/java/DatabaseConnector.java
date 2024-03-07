import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnector {

    static final String uurl = "jdbc:sqlite:employee_db.db";
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(uurl);
    }
}
