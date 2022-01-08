/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.ModelGuru;
import model.ModelSiswa;

/**
 *
 * @author Anjar
 */
public class ManajemenSiswa {
    PreparedStatement pst;
    ResultSet rs;
    String sql;
    Statement st;
   public void loadDataSiswa(DefaultTableModel namatabel) throws SQLException{ 
        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
        
           sql = "SELECT * FROM tbsiswa";
           
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        rs = pst.executeQuery(sql);
           
            while(rs.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[8];
                o[0] = rs.getString("kode");
                o[1] = rs.getString("nis");
                o[2] = rs.getString("nama_siswa");
                o[3] = rs.getString("kelas");
                o[4] = rs.getString("jenis_kelamin");
                o[5] = rs.getString("no_tlp");
                o[6] = rs.getString("file_foto");
                o[7] = rs.getString("foto_siswa");
                namatabel.addRow(o);
            }
            rs.close();
            pst.close();

     }
    
    public boolean cekSiswa(ModelSiswa moda) throws SQLException {
        sql = "SELECT * from tbsiswa where kode = ?";
                 pst = KoneksiDB.getKoneksi().prepareStatement(sql);
                pst.setString(1, moda.getKode());
                rs = pst.executeQuery();

                if(rs.next()){
                   return true;
                }
                else {
            return false;
        }
}
    
    public boolean cekDuplikasi(ModelSiswa moda) throws SQLException {
        sql = "SELECT * from tbsiswa where kode = ?";
                pst = KoneksiDB.getKoneksi().prepareStatement(sql);
                pst.setString(1, moda.getKode());
               // pst.setDate(2,new java.sql.Date( moda.getTanggal().getTime()));
                rs = pst.executeQuery();

                if(rs.next()){
                   return true;
                }
                else {
            return false;
        }
}
    
   
    public void ubahSiswa(ModelSiswa moda) throws SQLException {
        
        sql = "UPDATE tbsiswa SET nis=?, nama_siswa=?, kelas=?, jenis_kelamin=?,no_tlp=?,file_foto=?,foto_siswa=? WHERE kode=?";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(1, moda.getNis());
        pst.setString(2, moda.getNama_siswa());
        pst.setString(3, moda.getKelas());
        pst.setString(4, moda.getJenis_kelamin());
        pst.setString(5, moda.getTlp());
        pst.setString(6, moda.getFile_foto());
        pst.setString(7, moda.getFoto_siswa());
        pst.setString(8, moda.getKode());

        pst.executeUpdate();
        pst.close();
    
    }
    
     public void tambahSiswa(ModelSiswa moda) throws SQLException {
        sql = "INSERT INTO tbsiswa(kode,nis,nama_siswa,kelas,jenis_kelamin,no_tlp,file_foto,foto_siswa)VALUES(?,?,?,?,?,?,?,?)";
       
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
       // pst.setString(1, moda.getKode());
        pst.setString(1, moda.getKode());
        pst.setString(2, moda.getNis());
        pst.setString(3, moda.getNama_siswa());
        pst.setString(4, moda.getKelas());
        pst.setString(5, moda.getJenis_kelamin());
        pst.setString(6, moda.getTlp());
        pst.setString(7, moda.getFile_foto());
        pst.setString(8, moda.getFoto_siswa());
        pst.executeUpdate();
        pst.close();
        
        
    }
     
      public void hapusSiswa(ModelSiswa modg) throws SQLException {
    
        sql = "DELETE FROM tbsiswa WHERE kode=? ";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(1, modg.getKode());
        
        pst.executeUpdate();
        pst.close();
    
    }

     
        public int autonumbersiswaOtkp1(ModelSiswa moda) {
        
//        PreparedStatement statement = null;
         int nomor=0;
        try{
              sql = "SELECT ifnull(max(convert(right(kode,2),signed integer)),0) as kode_siswa,"
            + "ifnull(length(max(convert(right(kode,2),signed integer))),0)as panjang "
            + "from tbsiswa ";
             pst = KoneksiDB.getKoneksi().prepareStatement(sql);
//             pst.setString(1, moda.getKode());
             rs = pst.executeQuery();
//            statement = connection.prepareStatement(COUNTERDATANG);
//            ResultSet rs = statement.executeQuery();
            if(rs.next())             
                nomor=rs.getInt("kode_siswa")+1;          
            
        }catch (Exception e) {
            e.printStackTrace();
        }   
        return nomor;
    }
        
        
         public List<ModelSiswa> isicombokelas() {
      PreparedStatement statement;
        List<ModelSiswa> list = null;
      try {
           list = new ArrayList();
              sql =  "SELECT * FROM tbkelas order by nama_kelas";
           pst = KoneksiDB.getKoneksi().prepareStatement(sql);
            rs = pst.executeQuery();             
           while (rs.next()) {
               ModelSiswa b = new ModelSiswa();  
               b.setKelas(rs.getString("nama_kelas"));
               list.add(b);
            }

       } catch (Exception e) {
          e.printStackTrace();
       }
       return list;
  }
        
         //manggil data supplier lewat combo costumer
    public List<ModelSiswa> getnamakelas(String nama) {
      //  PreparedStatement statement;
        List<ModelSiswa> list = null;
        try {
            list = new ArrayList();
            sql = "SELECT * FROM tbkelas where nama_kelas=?";
            pst = KoneksiDB.getKoneksi().prepareStatement(sql);
            
            pst.setString(1, nama);
            rs = pst.executeQuery();   
           
            while (rs.next()) {                         
                ModelSiswa b = new ModelSiswa();             
                b.setKelas(rs.getString("nama_kelas"));
               
                list.add(b);            
            } 

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }  
    
}
