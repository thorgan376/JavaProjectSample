import java.sql.*;

public class Database {
    public static String HOST_NAME = "localhost";
    public static Integer PORT = 3306;
    public static String DB_NAME = "db_test";
    public static String DB_USER_NAME = "root";
    public static String DB_PASSWORD = "123456";
    private static Database instance = null;
    private Database() {};
    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlConnection = String.format("jdbc:mysql://%s:%d/%s",HOST_NAME, PORT, DB_NAME);
            return DriverManager.getConnection(urlConnection,DB_USER_NAME,DB_PASSWORD);
        }catch (Exception exception) {
            System.out.println("Error connect DB"+exception.toString());
            return null;
        }
    }
}