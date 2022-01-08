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
public class ModelAbsensi {
    private String kode;
    private String tahun;
    private String nip;
    private Date tanggal;
    private String absen;
    private String keterangan;
    private Date tgl_mulai;
    private Date tgl_selesai;
    private String total;
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

    public String getAbsen() {
        return absen;
    }

    public void setAbsen(String absen) {
        this.absen = absen;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getTgl_mulai() {
        return tgl_mulai;
    }

    public void setTgl_mulai(Date tgl_mulai) {
        this.tgl_mulai = tgl_mulai;
    }

    public Date getTgl_selesai() {
        return tgl_selesai;
    }

    public void setTgl_selesai(Date tgl_selesai) {
        this.tgl_selesai = tgl_selesai;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }
    
    
}
