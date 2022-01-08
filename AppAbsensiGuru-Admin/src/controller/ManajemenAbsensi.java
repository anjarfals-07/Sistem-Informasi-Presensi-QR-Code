/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.ModelAbsensi;

/**
 *
 * @author ASUS
 */
public class ManajemenAbsensi {
    
    PreparedStatement pst;
    ResultSet rs;
    String sql;
    
     public void loadDataAbsen(DefaultTableModel namatabel) throws SQLException{ 
        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
    
        sql = "SELECT tbabsen.kode, tbabsen.tanggal, tbabsen.nip, tbguru.nama, tbguru.jabatan,tbabsen.tanggal_mulai,tbabsen.tanggal_selesai,tbabsen.hari, tbabsen.keterangan,tbabsen.tahun,tbguru.foto,tbguru.file\n" +
"                FROM tbabsen INNER JOIN tbguru where tbabsen.nip=tbguru.nip\n" +
"                ORDER BY tbabsen.kode asc";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        rs = pst.executeQuery(sql);
           
            while(rs.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[12];
                o[0] = rs.getString("kode");
                o[1] = rs.getDate("tanggal");
                o[2] = rs.getString("nip");
                o[3] = rs.getString("nama");
                o[4] = rs.getString("jabatan");
//                o[5] = rs.getString("izin");
                o[5] = rs.getDate("tanggal_mulai");
                o[6] = rs.getDate("tanggal_selesai");
                o[7] = rs.getString("hari");
                o[8] = rs.getString("keterangan");
                 o[9] = rs.getString("tahun");
                o[10] = rs.getString("foto");
              o[11] = rs.getString("file");
                namatabel.addRow(o);
            }
            rs.close();
            pst.close();

     }
    
   
    
     
    
    public boolean cekGuru(ModelAbsensi moda) throws SQLException {
        sql = "SELECT * from tbguru where nip = ?";
                pst = KoneksiDB.getKoneksi().prepareStatement(sql);
                pst.setString(1, moda.getNip());
                rs = pst.executeQuery();

                if(rs.next()){
                   return true;
                }
                else {
            return false;
        }
}
    
    public boolean cekDuplikasi(ModelAbsensi moda) throws SQLException {
        sql = "SELECT * from tbizin where kode = ?";
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
    
     public void ubahAbsen(ModelAbsensi moda) throws SQLException {
        
        sql = "UPDATE tbabsen SET nip = ?,  tanggal = ?,tanggal_mulai=?,tanggal_selesai=?,hari=?, keterangan=?, id_admin=?, tahun=? WHERE kode=?";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(1, moda.getNip());
       
        pst.setDate(2, new java.sql.Date(moda.getTanggal().getTime()));
        pst.setDate(3, new java.sql.Date(moda.getTgl_mulai().getTime()));
        pst.setDate(4, new java.sql.Date(moda.getTgl_selesai().getTime()));
        pst.setString(5, moda.getTotal());
        pst.setString(6, moda.getKeterangan());
        pst.setString(7, moda.getId_adm());
         pst.setString(8, moda.getTahun());
         pst.setString(9, moda.getKode());

        pst.executeUpdate();
        pst.close();
    
    }
    public void tambahAbsen(ModelAbsensi moda) throws SQLException {
        sql = "INSERT INTO tbabsen(nip,tanggal,tanggal_mulai,tanggal_selesai,hari,keterangan,id_admin,tahun)  VALUES( ?, ?, ?, ?, ?, ?, ?, ?)";
       
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
       // pst.setString(1, moda.getKode());
        pst.setString(1, moda.getNip());
//        pst.setString(2, moda.getAbsen());
        pst.setDate(2, new java.sql.Date(moda.getTanggal().getTime()));
        pst.setDate(3, new java.sql.Date(moda.getTgl_mulai().getTime()));
        pst.setDate(4, new java.sql.Date(moda.getTgl_selesai().getTime()));
        pst.setString(5, moda.getTotal());
        pst.setString(6, moda.getKeterangan());
        pst.setString(7, moda.getId_adm());
        pst.setString(8, moda.getTahun());
        pst.executeUpdate();
        pst.close();
        
        
    }
    
    /*public void hapusGuru(ModelAbsensi moda) throws SQLException {
    
        sql = "DELETE FROM tbabsen where kode=?";
        String resetno="ALTER TABLE tbabsen DROP `kode`;";
        String consecutivenumber="ALTER TABLE tbabsen ADD `kode` INT(11) NOT NULL AUTO_INCREMENT FIRST ,ADD KEY(`kode`);";
              
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
          pst = KoneksiDB.getKoneksi().prepareStatement(resetno);
            pst = KoneksiDB.getKoneksi().prepareStatement(consecutivenumber);
            pst.setString(1, moda.getKode());

        pst.executeUpdate();
        pst.close();
    }*/
    
    
    
    
}
