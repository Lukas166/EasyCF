//package dbConnection;
//
//import java.sql.*;
//
//class Connector {
//    private String driver = "com.mysql.cj.jdbc.Driver";
//    private String db = "jdbc:mysql://localhost/db_easyCF";
//    private String user = "root";
//    private String password = "";
//    private Connection conn = null;
//    private Statement state = null;
//    private ResultSet rs = null;
//
//    // Constructor
//    public Connector() {
//        try {
//            Class.forName(driver);
//            System.out.println("Driver OK");
//        } catch (Exception e) {
//            System.out.println("Driver Error: " + e.getMessage());
//        }
//
//        try {
//            conn = DriverManager.getConnection(db, user, password);
//            state = conn.createStatement();
//            System.out.println("Database Connected");
//        } catch (Exception e) {
//            System.out.println("Connection Error: " + e.getMessage());
//        }
//    }
//
//    public void query(String stringQuery) {
//        try {
//            state.executeUpdate(stringQuery);
//            System.out.println("Query Executed: " + stringQuery);
//        } catch (Exception e) {
//            System.out.println("Query Error: " + e.getMessage());
//        }
//    }
//
//    public ResultSet getData(String SQLString) {
//        try {
//            rs = state.executeQuery(SQLString);
//        } catch (Exception e) {
//            System.out.println("Query Error: " + e.getMessage());
//        }
//        return rs;
//    }
//}
//
//public class Test {
//    public static void main(String args[]) {
//        Connector conn = new Connector();
//
//        // Insert data ke tabel biodata
//        String insertBiodataQuery = "INSERT INTO biodata (biodata_id, nama, email, limit_pengeluaran) VALUES "
//                + "(1, 'John Doe', 'johndoe@example.com', 5000);";
//        conn.query(insertBiodataQuery);
//
//        // Insert data ke tabel users dengan FK ke biodata
//        String insertUsersQuery = "INSERT INTO users (username, password, biodata_id) VALUES "
//                + "('johndoe', 'password123', 1);";
//        conn.query(insertUsersQuery);
//
//        System.out.println("Data inserted into biodata and users tables.");
//    }
//}
