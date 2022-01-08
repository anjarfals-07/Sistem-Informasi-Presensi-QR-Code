/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import koneksi.konek;
import model.Hadir;

/**
 *
 * @author Anjar
 */
public class SubmitPresensi {
     Hadir h = new Hadir();
    
    public boolean cek_guru(Hadir guru) throws SQLException {
        
        String cek = "SELECT * from tbguru where nip_absen = ?";
        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
        pst.setString(1, guru.getNip());
        ResultSet rs;
        rs = pst.executeQuery();
        
        if(rs.next()){
            return true;
        }

        return false;
    }
    
     public boolean cek_jamMasuk(Hadir guru) throws SQLException {
        
        String cek = "SELECT * from tbguru where nip_absen=?";
        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
        pst.setString(1, guru.getNip());
        ResultSet rs;
        rs = pst.executeQuery();
        
        if(rs.next()){
            return false;
        }
        return true;

    }
     
   
//     public boolean cek_jamKeluar(Hadir guru) throws SQLException {
//        
//        String cek = "SELECT * from tbguru where nip_absen=?";
//        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
//        pst.setString(1, guru.getNip());
//        ResultSet rs;
//        rs = pst.executeQuery();
//        
//        if(rs.next()){
//            return false;
//        }
//        return true;
//
//    }
        
   // KEHADIRAN PAGI 
   public boolean cek_kehadiran(Hadir guru) throws SQLException {
        
        String cek = "SELECT * from tbkehadiran where nip=? and tanggal=curdate()";//and tanggal=curdate()
        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
        pst.setString(1, guru.getNip());
 
        ResultSet rs;
        rs = pst.executeQuery();
        
        if(rs.next()){
            JOptionPane.showMessageDialog(null, "Anda Sudah Melakukan Absensi, Silahkan Cek Kembali..!");
            return false;
        }
        
        return true;

    } 
   public boolean cek_Keluar(Hadir guru) throws SQLException {
        
        String cek = "SELECT * from tbkehadiran where nip=? and tanggal=curdate()";//and tanggal=curdate()
        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
        pst.setString(1, guru.getNip());
 
        ResultSet rs;
        rs = pst.executeQuery();
        
        if(rs.next()){
            
            return false;
        }
        
        return true;

    } 
   
   // MASUK ALL PAGI SIANG TELAT
   public void masuk(String nip) throws SQLException {
                   
        String hadir = "INSERT INTO tbkehadiran(nip, tanggal, jam_masuk, jam_keluar,id_jam) VALUES( ?, CURDATE(), CURTIME(), ? ,?)";
        PreparedStatement pst = konek.getKoneksi().prepareStatement(hadir);
        pst.setString(1, nip);
        pst.setTime(2, h.getMasukStart());
        pst.setString(3, h.getId_Jam());
    
        pst.executeUpdate();     
        
    }
     //KELUAR PAGI   
    public void keluar(String nip) throws SQLException {
        
        String cek = "UPDATE tbkehadiran SET jam_keluar=CURTIME() WHERE nip=? and id_jam='1' and tanggal=curdate()";
        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
        pst.setString(1, nip);       
        pst.executeUpdate();       
        
    }
    
    public List<Hadir>ambil(Hadir guru) throws SQLException {
        
  
    String cek ="SELECT tbguru.nip_absen,tbguru.nip, tbguru.nama, tbjabatan.nama_jabatan,  "
                + "tbguru.file,tbguru.tugas,tbjam_hadir.jam_masuk_mulai, tbjam_hadir.id_jam FROM tbguru, tbjabatan, "
                + "tbjam_hadir WHERE tbguru.nip_absen=? AND tbjam_hadir.id_jam ='1' and tbguru.jabatan = tbjabatan.kode_jabatan "
                + "group by nip_absen";
        //
        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
        pst.setString(1, guru.getNip());
        ResultSet rs;
        rs = pst.executeQuery();
        List<Hadir> list = new ArrayList<>();
        if(rs.next()){
            h.setNip_guru(rs.getString("nip"));
            h.setNama(rs.getString("nama"));
            //h.setFoto(rs.getString("foto"));
             h.setFoto(rs.getString("file"));
            h.setId_Jam(rs.getString("id_jam"));
            h.setJabatan(rs.getString("nama_jabatan"));
            h.setTugas(rs.getString("tugas"));
            h.setMasukStart(rs.getTime("jam_masuk_mulai"));
            list.add(h);
        }        
        return list;
    }
    
      
     
//     //KEHADIRAN SIANG
//      public boolean cek_kehadiranSIANG(Hadir guru) throws SQLException {
//        
//        String cek = "SELECT * from tbkehadiran where nip=? AND id_jam=? and tanggal=curdate()";//and tanggal=curdate()
//        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
//        pst.setString(1, guru.getNip());
//       pst.setString(2, guru.getId_Jam());
//        ResultSet rs;
//        rs = pst.executeQuery();
//        
//        if(rs.next()){
//            return false;
//        }
//        return true;
//
//    }
//   
//       public void keluarsiang(String nip) throws SQLException {
//        
//        String cek = "UPDATE tbkehadiran SET jam_keluar=CURTIME() WHERE nip=?  AND id_jam='Siang' and tanggal=curdate()";
//        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
//        pst.setString(1, nip);       
//        pst.executeUpdate();       
//        
//    }
//      
//     public List<Hadir>ambilsiang(Hadir guru) throws SQLException {
//
//        String cek ="SELECT tbguru.nip_absen,tbguru.nip, tbguru.nama, tbjabatan.nama_jabatan,  "
//                + "tbjam_hadir.jam_mengajar, tbjam_hadir.jam_mengajar_selesai, tbguru.foto, "
//                + "tbjam_hadir.jam_masuk_mulai, tbjam_hadir.jam_keluar, tbjam_hadir.id_jam FROM tbguru, tbjabatan, "
//                + "tbjam_hadir WHERE tbguru.nip_absen=? AND tbjam_hadir.id_jam ='Siang' and tbguru.jabatan = tbjabatan.kode_jabatan "
//                + "group by nip_absen";
//        //
//        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
//        pst.setString(1, guru.getNip());
//        ResultSet rs;
//        rs = pst.executeQuery();
//        List<Hadir> list = new ArrayList<>();
//        if(rs.next()){
//            h.setNip_guru(rs.getString("nip"));
//            h.setNama(rs.getString("nama"));
//            h.setFoto(rs.getString("foto"));
//            h.setId_Jam(rs.getString("id_jam"));
//            h.setJabatan(rs.getString("nama_jabatan"));
//            h.setMasukStart(rs.getTime("jam_masuk_mulai"));
//            h.setKerjaStart(rs.getTime("jam_mengajar"));
//            h.setKerjaEnd(rs.getTime("jam_mengajar_selesai"));
//            h.setKeluarEnd(rs.getTime("jam_keluar"));
//            list.add(h);
//        }        
//        return list;
//    }
//     
//     // TEST TELAT
//      public boolean cek_kehadiranTELAT(Hadir guru) throws SQLException {
//        
//        String cek = "SELECT * from tbkehadiran where nip=? AND id_jam=? and tanggal=curdate()";//and tanggal=curdate()
//        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
//        pst.setString(1, guru.getNip());
//       pst.setString(2, guru.getId_Jam());
//        ResultSet rs;
//        rs = pst.executeQuery();
//        
//        if(rs.next()){
//            return false;
//        }
//        return true;
//
//    }
//   
//       public void keluartelat(String nip) throws SQLException {
//        
//        String cek = "UPDATE tbkehadiran SET jam_keluar=CURTIME() WHERE nip=?  AND id_jam='Telat' and tanggal=curdate()";
//        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
//        pst.setString(1, nip);       
//        pst.executeUpdate();       
//        
//    }
//     
//     
//          public List<Hadir>ambiltelat(Hadir guru) throws SQLException {
//        
//  
//        String cek ="SELECT tbguru.nip_absen,tbguru.nip, tbguru.nama, tbjabatan.nama_jabatan,  "
//                + "tbjam_hadir.jam_mengajar, tbjam_hadir.jam_mengajar_selesai, tbguru.foto, "
//                + "tbjam_hadir.jam_masuk_mulai, tbjam_hadir.jam_keluar, tbjam_hadir.id_jam FROM tbguru, tbjabatan, "
//                + "tbjam_hadir WHERE tbguru.nip_absen=? AND tbjam_hadir.id_jam ='Telat' and tbguru.jabatan = tbjabatan.kode_jabatan "
//                + "group by nip_absen";
//        //
//        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
//        pst.setString(1, guru.getNip());
//        ResultSet rs;
//        rs = pst.executeQuery();
//        List<Hadir> list = new ArrayList<>();
//        if(rs.next()){
//            h.setNip_guru(rs.getString("nip"));
//            h.setNama(rs.getString("nama"));
//            h.setFoto(rs.getString("foto"));
//            h.setId_Jam(rs.getString("id_jam"));
//            h.setJabatan(rs.getString("nama_jabatan"));
//            h.setMasukStart(rs.getTime("jam_masuk_mulai"));
//            h.setKerjaStart(rs.getTime("jam_mengajar"));
//            h.setKerjaEnd(rs.getTime("jam_mengajar_selesai"));
//            h.setKeluarEnd(rs.getTime("jam_keluar"));
//            list.add(h);
//        }        
//        return list;
//    }
}
