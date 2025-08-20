/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConnection;

import java.sql.*;

public class Connector {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String db = "jdbc:mysql://localhost/db_easyCF";
    private String user = "root";
    private String password = "";
    private Connection conn = null;
    private Statement state = null;
    private ResultSet rs = null;

    //Constructor
    public Connector() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(db, user, password);
            state = conn.createStatement();
            System.out.println("Database Connected");
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }
    }

    //Execute untuk INSERT, UPDATE, DELETE
    public boolean executeUpdate(String query1) {
        try {
            state.executeUpdate(query1);
            return true;
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }
    
    public Connection getConnection(){
        return this.conn;
    }

    //Execute untuk SELECT
    public ResultSet executeQuery(String query) {
        try {
            rs = state.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return rs;
    }
}
