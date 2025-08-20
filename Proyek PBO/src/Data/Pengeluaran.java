/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author ASUS
 */

public class Pengeluaran {
    private String judul;
    private String deskripsi;
    private String tipePengeluaran;
    private long uangKeluar;
    private String tanggal;

    // Constructor
    public Pengeluaran(String judul, String deskripsi, String tipePengeluaran, long uangKeluar, String tanggal) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.tipePengeluaran = tipePengeluaran;
        this.uangKeluar = uangKeluar;
        this.tanggal = tanggal;
    }

    public Pengeluaran() {
        this.judul = "";
        this.deskripsi = "";
        this.tipePengeluaran = "";
        this.uangKeluar = 0;
        this.tanggal = "";
    }

    //setter dan getter
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    public void setTipePengeluaran(String tipePengeluaran) {
        this.tipePengeluaran = tipePengeluaran;
    }

    public void setUangKeluar(long uangKeluar) {
        this.uangKeluar = uangKeluar;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getTipePengeluaran() {
        return tipePengeluaran;
    }

    public long getUangKeluar() {
        return uangKeluar;
    }


    public String getTanggal() {
        return tanggal;
    }
    
    

}

