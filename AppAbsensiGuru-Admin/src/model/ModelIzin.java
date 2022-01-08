/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class ModelIzin {
    private String kode;
    private String tahun;
    private String nip;
    private Date tanggal;
    private String ket_absen;
    
    public String getId_adm() {
        return id_adm;
    }

    public void setId_adm(String id_adm) {
        this.id_adm = id_adm;
    }
    String id_adm;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }


    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getKet_absen() {
        return ket_absen;
    }

    public void setKet_absen(String ket_absen) {
        this.ket_absen = ket_absen;
    }
    
    
}
