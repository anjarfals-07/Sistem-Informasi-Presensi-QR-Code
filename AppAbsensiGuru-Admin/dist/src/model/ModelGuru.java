/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class ModelGuru {
    private String nip_absen;
    private String nip;
    private String nama;
    private String jabatan;
    private String foto;
    private String file;
    private String tampung_jabatan;
    private String shift;
    private String id_admin;
    private String tugas;
    private String tlp;

    public ModelGuru(){
        
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


    public String getShift() {
        return shift;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getTampung_jabatan() {
        return tampung_jabatan;
    }

    public void setTampung_jabatan(String tampung_jabatan) {
        this.tampung_jabatan = tampung_jabatan;
    }

    public String getNip_absen() {
        return nip_absen;
    }

    public void setNip_absen(String nip_absen) {
        this.nip_absen = nip_absen;
    }

    public String getId_admin() {
        return id_admin;
    }

    public void setId_admin(String id_admin) {
        this.id_admin = id_admin;
    }

    public String getTugas() {
        return tugas;
    }

    public void setTugas(String tugas) {
        this.tugas = tugas;
    }

    public String getTlp() {
        return tlp;
    }

    public void setTlp(String tlp) {
        this.tlp = tlp;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
   
    
}
