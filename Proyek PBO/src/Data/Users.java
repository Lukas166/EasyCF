/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import dbConnection.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author ASUS
 */
public class Users {
    protected String username;
    protected String password;
    protected Encrypt encrypt;
    protected Pengeluaran[] pengeluaran;
            
    public static Users currentUser;
    
    public Users(){
        this.encrypt = new Encrypt();
        this.username = "";
        this.password = "";
    }
    
    public Users(String username, String password){
        this.username = username;
        this.password = encrypt.encode(password);
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = encrypt.encode(password);
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return encrypt.decode(this.password);
    }
    
    public Pengeluaran[] getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(Pengeluaran[] pengeluaran) {
        this.pengeluaran = pengeluaran;
    }
    
    public void getDataPengeluaran(){
            String query = "SELECT * FROM PENGELUARAN WHERE USERNAME='" + this.username + "'";

            Connector conn = new Connector();

        try {
            ResultSet rs = conn.executeQuery(query);
            
            List<Pengeluaran> pengeluaranList = new ArrayList<>();
            
            while (rs.next()){
                Pengeluaran p = new Pengeluaran();
                p.setJudul(rs.getString("judul"));
                p.setDeskripsi(rs.getString("deskripsi"));
                p.setTipePengeluaran(rs.getString("tipe_pengeluaran"));
                p.setUangKeluar(rs.getLong("uang_keluar"));
                p.setTanggal(rs.getString("tanggal"));
                
                pengeluaranList.add(p);
            }
            
            pengeluaran = new Pengeluaran[pengeluaranList.size()];
            pengeluaranList.toArray(pengeluaran);
            
            for (Pengeluaran p : pengeluaran) {
                System.out.println(p.getJudul() + " " + p.getUangKeluar());
            }
        } catch (SQLException ex) {
            
        }   
    }
    
    public long getDataPengeluaranPerMinggu(String tanggalAwal, String tanggalAkhir) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long total = 0;

        try {
            Date startDate = dateFormat.parse(tanggalAwal);
            Date endDate = dateFormat.parse(tanggalAkhir);
            
            System.out.println(startDate);
            System.out.println(endDate);

            for (Pengeluaran p : pengeluaran) {
                try {
                    // Parsing tanggal pengeluaran
                    Date tanggalPengeluaran = dateFormat.parse(p.getTanggal());
                    System.out.println("tgl: " + tanggalPengeluaran);

                    // Memeriksa apakah tanggal pengeluaran berada di dalam rentang yang ditentukan
                    if (!tanggalPengeluaran.before(startDate) && !tanggalPengeluaran.after(endDate)) {
                        total += p.getUangKeluar(); // Mengakses getter untuk mendapatkan nilai uang keluar
                    }
                } catch (ParseException ex) {
                    
                }
            }

            // Mengembalikan total pengeluaran dalam rentang tanggal
            return total;

        } catch (ParseException ex) {
            
        }

        // Mengembalikan nilai 0 jika terjadi kesalahan
        return 0;
    }
    
    public long getDataPengeluaranPerBulan(int month, int year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        long total = 0;
        getDataPengeluaran();

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);

        System.out.println(startDate);
        System.out.println(endDate);

        for (Pengeluaran p : pengeluaran) {
            try {
                // Parse the expense date
                LocalDate tanggalPengeluaran = LocalDate.parse(p.getTanggal(), formatter);

                if (!tanggalPengeluaran.isBefore(startDate) && !tanggalPengeluaran.isAfter(endDate)) {
                    total += p.getUangKeluar();
                }
            } catch (DateTimeParseException ex) {
                System.err.println("Error parsing date: " + p.getTanggal());
            }
        }

        return total;
    }
    
    public long[] getDataPerTanggal(int month, int year){
        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();
        getDataPengeluaran();
        long data[] = {getDataPengeluaranPerMinggu(year + "-" + month + "-01", year + "-" + month + "-08")
                        ,getDataPengeluaranPerMinggu(year + "-" + month + "-09", year + "-" + month + "-16")
                        ,getDataPengeluaranPerMinggu(year + "-" + month + "-17", year + "-" + month + "-23")
                        ,getDataPengeluaranPerMinggu(year + "-" + month + "-24", year + "-" + month + "-" + daysInMonth)};
        System.out.println(data[0]);
        System.out.println(data[1]);
        System.out.println(data[2]);
        System.out.println(data[3]);
        return data;
    }

    public void deleteUser() {}
}