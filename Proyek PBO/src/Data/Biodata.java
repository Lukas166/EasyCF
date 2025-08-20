/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import dbConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Biodata extends Users {
    private int biodata_id;
    private String email;
    private String nama;
    private double limit_pengeluaran;
    
    public Biodata(){
        this.biodata_id = 0;
        this.email = "";
        this.nama = "";
        this.limit_pengeluaran = 0;
    }
    
    public Biodata(int biodata_id, String email, String nama, int limit_pengeluaran){
        this.biodata_id = biodata_id;
        this.email = email;
        this.nama = nama;
        this.limit_pengeluaran = limit_pengeluaran;
    }
    
    public void setBiodataID(int biodata_id){
        this.biodata_id = biodata_id;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void setLimitPengeluaran(double limit_pengeluaran){
        this.limit_pengeluaran = limit_pengeluaran;
    }
    
    public int getBiodataID(){
        return this.biodata_id;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public double getLimitPengeluaran(){
        return this.limit_pengeluaran;
    }
    
    public double getTotalPengeluaran(double uangKeluar){
        this.limit_pengeluaran += uangKeluar;
        return this.limit_pengeluaran;
    }
    
    @Override
    public void deleteUser() {
        String query1 = "DELETE FROM Pengeluaran WHERE username=?";
        String query2 = "DELETE FROM Users WHERE USERNAME=?";
        String query3 = "DELETE FROM Biodata WHERE biodata_id=?";
        Connector connect = new Connector();
        Connection conn = connect.getConnection();

        try {
            // Use prepared statements to prevent SQL injection
            PreparedStatement pstmt1 = conn.prepareStatement(query1);
            pstmt1.setString(1, this.username);
            pstmt1.executeUpdate();

            PreparedStatement pstmt2 = conn.prepareStatement(query2);
            pstmt2.setString(1, this.username);
            pstmt2.executeUpdate();
            
            PreparedStatement pstmt3 = conn.prepareStatement(query3);
            pstmt2.setInt(1, this.biodata_id);
            pstmt2.executeUpdate();

            // Close the prepared statements
            pstmt1.close();
            pstmt2.close();

        } catch (SQLException ex) {
            // Proper error logging
            System.err.println("Error deleting user: " + ex.getMessage());
        } finally {
            // Ensure connection is closed
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error closing connection: " + ex.getMessage());
            }
        }
    }
    
    
}
