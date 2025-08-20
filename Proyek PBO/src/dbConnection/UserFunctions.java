    /*
    * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
    * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
    */

    package dbConnection;

    import Data.*;
    import java.sql.*;
    import javax.swing.JOptionPane;
    import java.util.regex.Pattern;
    import ui.dashboard;

    public class UserFunctions {

        public boolean registerUser(String username, String password, String email) {
                if (username.length() < 4 || username.length() > 30 || username.equals("  Enter Username")){
                    JOptionPane.showMessageDialog(null, "Username harus lebih dari 3.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            
            String emailRegex = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
            if (!Pattern.matches(emailRegex, email)){
                JOptionPane.showMessageDialog(null, "Email tidak valid.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            if (password.length() < 8 || password.equals("  Enter Password")) {
                JOptionPane.showMessageDialog(null, "Password harus lebih dari 7 karakter.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            Connector conn = new Connector();
            Encrypt encrypt = new Encrypt();

            try {
                String checkUsernameQuery = "SELECT username FROM users WHERE username = '" + username + "'";
                ResultSet checkUsernameRs = conn.executeQuery(checkUsernameQuery);
                if (checkUsernameRs.next()){
                    JOptionPane.showMessageDialog(null, "Username sudah terdaftar.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                
                String checkEmailQuery = "SELECT email FROM biodata WHERE email = '" + email + "'";
                ResultSet checkRs = conn.executeQuery(checkEmailQuery);
                if (checkRs.next()) {
                    JOptionPane.showMessageDialog(null, "Email sudah terdaftar. Gunakan email lain.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                
                String encodedPassword = encrypt.encode(password);
                String query1 = "INSERT INTO biodata (nama, email, limit_pengeluaran) VALUES ('" + username + "', '" + email + "', 0)";
                
                if (conn.executeUpdate(query1)) {
                    String query2 = "INSERT INTO users (username, password, biodata_id) " +
                                    "VALUES ('" + username + "', '" + encodedPassword + "', " +
                                    "(SELECT MAX(biodata_id) FROM biodata))";

                    if (conn.executeUpdate(query2)) {
                        String fetchBiodataQuery = "SELECT MAX(biodata_id) AS biodata_id FROM biodata";
                        ResultSet rs = conn.executeQuery(fetchBiodataQuery);
                        if (rs.next()) {
                            return true;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal memasukkan data ke tabel users.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal memasukkan data ke tabel biodata.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            return false;
        }

        public boolean loginUser(String username, String password) {
            if (username.length() < 4 || username.length() > 30) {
                JOptionPane.showMessageDialog(null, "Username harus lebih dari 3 karakter.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (password.length() < 8) {
                JOptionPane.showMessageDialog(null, "Password harus lebih dari 7 karakter.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        
            Connector conn = new Connector();
            Encrypt encrypt = new Encrypt();
        
            try {
                String encodedPassword = encrypt.encode(password);
               
                String query = "SELECT u.username, u.password, b.biodata_id, b.nama, b.email, b.limit_pengeluaran " +
                              "FROM users u " +
                              "LEFT JOIN biodata b ON u.username = b.nama " +
                              "WHERE u.username = '" + username + "' AND u.password = '" + encodedPassword + "'";
                
                ResultSet rs = conn.executeQuery(query);
        
                if (rs.next()) {
                    Users user = new Biodata();
                    Biodata biodata = (Biodata) user;

                    biodata.setUsername(username);
                    biodata.setPassword(password);
                    
                    biodata.setBiodataID(rs.getInt("biodata_id"));
                    biodata.setNama(rs.getString("nama"));
                    biodata.setEmail(rs.getString("email"));
                    biodata.setLimitPengeluaran(rs.getDouble("limit_pengeluaran"));

                    Users.currentUser = biodata;
            
                    dashboard db = new dashboard();
                    db.setUser(biodata);
                    db.setVisible(true);
                    db.setSize(335, 545);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Username atau password tidak valid.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        
            return false;
        }
    }
