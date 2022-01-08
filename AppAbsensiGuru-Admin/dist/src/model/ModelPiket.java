/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Anjar
 */
public class ModelPiket {
    private String kode;
   private String nip_absen;
   private String nama;
   private String masuk;
   private String keluar;
      private String cari_tanggal;
   private String jadwal1;
   private String jadwal2;
   private String jadwal3;
   private String jadwal4;
   private String jadwal5;
   private String jadwal6;
   private String jadwal7;
   private String jadwal8;
   private Date tanggal;
   private String kelas;

    public String getNip_absen() {
        return nip_absen;
    }

    public void setNip_absen(String nip_absen) {
        this.nip_absen = nip_absen;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJadwal1() {
        return jadwal1;
    }

    public void setJadwal1(String jadwal1) {
        this.jadwal1 = jadwal1;
    }

    public String getJadwal2() {
        return jadwal2;
    }

    public void setJadwal2(String jadwal2) {
        this.jadwal2 = jadwal2;
    }

    public String getJadwal3() {
        return jadwal3;
    }

    public void setJadwal3(String jadwal3) {
        this.jadwal3 = jadwal3;
    }

    public String getJadwal4() {
        return jadwal4;
    }

    public void setJadwal4(String jadwal4) {
        this.jadwal4 = jadwal4;
    }

    public String getJadwal5() {
        return jadwal5;
    }

    public void setJadwal5(String jadwal5) {
        this.jadwal5 = jadwal5;
    }

    public String getJadwal6() {
        return jadwal6;
    }

    public void setJadwal6(String jadwal6) {
        this.jadwal6 = jadwal6;
    }

    public String getJadwal7() {
        return jadwal7;
    }

    public void setJadwal7(String jadwal7) {
        this.jadwal7 = jadwal7;
    }

    public String getJadwal8() {
        return jadwal8;
    }

    public void setJadwal8(String jadwal8) {
        this.jadwal8 = jadwal8;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getCari_tanggal() {
        return cari_tanggal;
    }

    public void setCari_tanggal(String cari_tanggal) {
        this.cari_tanggal = cari_tanggal;
    }

    public String getMasuk() {
        return masuk;
    }

    public void setMasuk(String masuk) {
        this.masuk = masuk;
    }

    public String getKeluar() {
        return keluar;
    }

    public void setKeluar(String keluar) {
        this.keluar = keluar;
    }
}
