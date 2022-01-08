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
import javax.swing.table.DefaultTableModel;
import model.ModelPiket;

/**
 *
 * @author Anjar
 */
public class ManajemenPiketGuru {
    PreparedStatement pst;
    ResultSet rs;
    String sql;
    
     public void loadDataPiket(DefaultTableModel namatabel) throws SQLException{ 
        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
        
//           sql = "SELECT tbpiket.kode,tbpiket.tanggal, tbpiket.kode_absen, tbpiket.nama, tbpiket.jam_1,tbpiket.jam_2,tbpiket.jam_3,tbpiket.jam_4,tbpiket.jam_5,tbpiket.jam_6,tbpiket.jam_7,tbpiket.jam_8" +
//              "FROM tbpiket where tbpiket.tanggal=curdate()\n" +
////               "FROM tbpiket \n" +
//               "ORDER BY tbpiket.kode asc";
        sql = "SELECT * FROM tbpiket where tanggal=curdate()";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        rs = pst.executeQuery(sql);
           
            while(rs.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[14];
                o[0] = rs.getString("kode");
                o[1] = rs.getDate("tanggal");
                o[2] = rs.getString("kode_absen");
                o[3] = rs.getString("nama");
                o[4] = rs.getString("jam_1");
                o[5] = rs.getString("jam_2");
                o[6] = rs.getString("jam_3");
                o[7] = rs.getString("jam_4");
                o[8] = rs.getString("jam_5");
                o[9] = rs.getString("jam_6");
                o[10] = rs.getString("jam_7");
                o[11] = rs.getString("jam_8");
                o[12] = rs.getString("jam_masuk");
                o[13] = rs.getString("jam_keluar");
                namatabel.addRow(o);
            }
            rs.close();
            pst.close();

     }
     
      public void loadAllPiket(DefaultTableModel namatabel) throws SQLException{ 
        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
        
//           sql = "SELECT tbpiket.kode,tbpiket.tanggal, tbpiket.kode_absen, tbpiket.nama, tbpiket.jam_1,tbpiket.jam_2,tbpiket.jam_3,tbpiket.jam_4,tbpiket.jam_5,tbpiket.jam_6,tbpiket.jam_7,tbpiket.jam_8" +
//              "FROM tbpiket where tbpiket.tanggal=curdate()\n" +
////               "FROM tbpiket \n" +
//               "ORDER BY tbpiket.kode asc";
        sql = "SELECT * FROM tbpiket";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        rs = pst.executeQuery(sql);
           
            while(rs.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[14];
                o[0] = rs.getString("kode");
                o[1] = rs.getDate("tanggal");
                o[2] = rs.getString("kode_absen");
                o[3] = rs.getString("nama");
                o[4] = rs.getString("jam_1");
                o[5] = rs.getString("jam_2");
                o[6] = rs.getString("jam_3");
                o[7] = rs.getString("jam_4");
                o[8] = rs.getString("jam_5");
                o[9] = rs.getString("jam_6");
                o[10] = rs.getString("jam_7");
                o[11] = rs.getString("jam_8");
                o[12] = rs.getString("jam_masuk");
                o[13] = rs.getString("jam_keluar");
                namatabel.addRow(o);
            }
            rs.close();
            pst.close();

     }
    
 
    
    public boolean cekPiket(ModelPiket moda) throws SQLException {
        sql = "SELECT * from tbguru where nip_absen = ?";
                pst = KoneksiDB.getKoneksi().prepareStatement(sql);
                pst.setString(1, moda.getNip_absen());
                rs = pst.executeQuery();

                if(rs.next()){
                   return true;
                }
                else {
            return false;
        }
    }
                
                
    
    public boolean cekDuplikasi(ModelPiket moda) throws SQLException {
        sql = "SELECT * from tbpiket where kode = ?";
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
    
   
    public void ubahPiket(ModelPiket moda) throws SQLException {
        
        sql = "UPDATE tbpiket SET kode_absen = ?, nama=?,  jam_1 = ?,jam_2=?, jam_3=?,jam_4=?,jam_5=?,jam_6=?,jam_7=?,jam_8=?,tanggal=?,jam_masuk=?,jam_keluar=? WHERE kode=?";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(1, moda.getNip_absen());  
        pst.setString(2, moda.getNama());
        pst.setString(3, moda.getJadwal1());
        pst.setString(4, moda.getJadwal2());
        pst.setString(5, moda.getJadwal3());
        pst.setString(6, moda.getJadwal4());
        pst.setString(7, moda.getJadwal5());
        pst.setString(8, moda.getJadwal6());
        pst.setString(9, moda.getJadwal7());
        pst.setString(10, moda.getJadwal8());
        pst.setDate(11, new java.sql.Date(moda.getTanggal().getTime()));
        pst.setString(12, moda.getMasuk());
        pst.setString(13, moda.getKeluar());
        pst.setString(14, moda.getKode());

        pst.executeUpdate();
        pst.close();
    
    }
    
     public void tambahPiket(ModelPiket moda) throws SQLException {
        sql = "INSERT INTO tbpiket(kode_absen,nama,jam_1,jam_2,jam_3,jam_4,jam_5,jam_6,jam_7,jam_8,tanggal,jam_masuk,jam_keluar)  VALUES( ?, ?,?, ?, ?, ?, ?,?,?,?,?,?,?)";
       
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
       // pst.setString(1, moda.getKode());
        pst.setString(1, moda.getNip_absen());
        pst.setString(2, moda.getNama());
        pst.setString(3, moda.getJadwal1());
        pst.setString(4, moda.getJadwal2());
        pst.setString(5, moda.getJadwal3());
        pst.setString(6, moda.getJadwal4());
        pst.setString(7, moda.getJadwal5());
        pst.setString(8, moda.getJadwal6());
        pst.setString(9, moda.getJadwal7());
        pst.setString(10, moda.getJadwal8());
        pst.setDate(11, new java.sql.Date(moda.getTanggal().getTime()));
         pst.setString(12, moda.getMasuk());
          pst.setString(13, moda.getKeluar());

        pst.executeUpdate();
        pst.close();
        
        
    }
     
        
         public List<ModelPiket> isicombokelas() {
//        PreparedStatement statement;
        List<ModelPiket> list = null;
        try {
            list = new ArrayList();
              sql =  "SELECT * FROM tbkelas order by nama_kelas";
            pst = KoneksiDB.getKoneksi().prepareStatement(sql);
             rs = pst.executeQuery();             
            while (rs.next()) {
                ModelPiket b = new ModelPiket();  
                b.setKelas(rs.getString("nama_kelas"));
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
        
         //manggil data supplier lewat combo costumer
    public List<ModelPiket> getnamakelas(String nama) {
      //  PreparedStatement statement;
        List<ModelPiket> list = null;
        try {
            list = new ArrayList();
            sql = "SELECT * FROM tbkelas where nama_kelas=?";
            pst = KoneksiDB.getKoneksi().prepareStatement(sql);
            
            pst.setString(1, nama);
            rs = pst.executeQuery();   
           
            while (rs.next()) {                         
                ModelPiket b = new ModelPiket();             
                b.setKelas(rs.getString("nama_kelas"));
               
                list.add(b);            
            } 

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }  
    
    
      public List<ModelPiket> isicombotanggal() {
//        PreparedStatement statement;
        List<ModelPiket> list = null;
        try {
            list = new ArrayList();
              sql =  "SELECT * FROM tbpiket order by tanggal";
            pst = KoneksiDB.getKoneksi().prepareStatement(sql);
             rs = pst.executeQuery();             
            while (rs.next()) {
                ModelPiket b = new ModelPiket();  
                b.setCari_tanggal(rs.getString("tanggal"));
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
      public List<ModelPiket> gettanggal(String nama) {
      //  PreparedStatement statement;
        List<ModelPiket> list = null;
        try {
            list = new ArrayList();
            sql = "SELECT * FROM tbpiket where tanggal=?";
            pst = KoneksiDB.getKoneksi().prepareStatement(sql);
            
            pst.setString(1, nama);
            rs = pst.executeQuery();   
           
            while (rs.next()) {                         
                ModelPiket b = new ModelPiket();             
                b.setCari_tanggal(rs.getString("tanggal"));
               
                list.add(b);            
            } 

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }  
    
   
}
