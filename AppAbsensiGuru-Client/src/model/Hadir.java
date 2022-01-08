/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;

/**
 *
 * @author ASUS
 */
public class Hadir {
        private String tugas;
    private String nip;
    private String Nama;
    private String Jabatan;
    private String Foto;
    private String id_Jam;
     private String jam_start;
    private Time MasukStart;
    private Time KerjaStart;
    private Time KerjaEnd;
    private Time KeluarEnd;
    private String keterangan;
    private String nip_guru;

 
    
    public Hadir(){
        
    }

    

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getJabatan() {
        return Jabatan;
    }

    public void setJabatan(String Jabatan) {
        this.Jabatan = Jabatan;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public String getId_Jam() {
        return id_Jam;
    }

    public void setId_Jam(String id_Jam) {
        this.id_Jam = id_Jam;
    }

    public Time getMasukStart() {
        return MasukStart;
    }

    public void setMasukStart(Time MasukStart) {
        this.MasukStart = MasukStart;
    }

    public Time getKerjaStart() {
        return KerjaStart;
    }

    public void setKerjaStart(Time KerjaStart) {
        this.KerjaStart = KerjaStart;
    }

    public Time getKerjaEnd() {
        return KerjaEnd;
    }

    public void setKerjaEnd(Time KerjaEnd) {
        this.KerjaEnd = KerjaEnd;
    }

    public Time getKeluarEnd() {
        return KeluarEnd;
    }

    public void setKeluarEnd(Time KeluarEnd) {
        this.KeluarEnd = KeluarEnd;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNip_guru() {
        return nip_guru;
    }

    public void setNip_guru(String nip_guru) {
        this.nip_guru = nip_guru;
    }

    public String getTugas() {
        return tugas;
    }

    public void setTugas(String tugas) {
        this.tugas = tugas;
    }

    public String getJam_start() {
        return jam_start;
    }

    public void setJam_start(String jam_start) {
        this.jam_start = jam_start;
    }

 
    
    
}
