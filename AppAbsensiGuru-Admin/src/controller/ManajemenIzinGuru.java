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
import model.ModelIzin;

/**
 *
 * @author ASUS
 */
public class ManajemenIzinGuru {
    
    PreparedStatement pst;
    ResultSet rs;
    String sql;
    

    
      public void loadDataIzin(DefaultTableModel namatabel) throws SQLException{ 
        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
    
                sql = "SELECT tbizin.kode, tbizin.tanggal, tbizin.nip, tbguru.nama, tbguru.jabatan,tbizin.ket_absen,tbizin.tahun,tbguru.foto,tbguru.file\n" +
"                FROM tbizin INNER JOIN tbguru where tbizin.nip=tbguru.nip\n" +
"                ORDER BY tbizin.kode asc";
     
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        rs = pst.executeQuery(sql);
           
            while(rs.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[9];
                o[0] = rs.getString("kode");
                o[1] = rs.getDate("tanggal");
                o[2] = rs.getString("nip");
                o[3] = rs.getString("nama");
                o[4] = rs.getString("jabatan");
                o[5] = rs.getString("ket_absen");
                o[6] = rs.getString("tahun");
                o[7] = rs.getString("foto");
                o[8] = rs.getString("file");
                namatabel.addRow(o);
            }
            rs.close();
            pst.close();

     }
    
    public boolean cekGuru(ModelIzin moda) throws SQLException {
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
    
    public boolean cekDuplikasi(ModelIzin moda) throws SQLException {
        sql = "SELECT * from tbabsen where kode = ?";
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
    
   
    public void ubahIzin(ModelIzin moda) throws SQLException {
        
        sql = "UPDATE tbabsen SET nip = ?, ket_izin=?,  tanggal = ?,id_admin=?, tahun=? WHERE kode=?";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(1, moda.getNip());  
        pst.setString(2, moda.getKet_absen());
        pst.setDate(3, new java.sql.Date(moda.getTanggal().getTime()));
        pst.setString(4, moda.getId_adm());
        pst.setString(5, moda.getTahun());
        pst.setString(6, moda.getKode());

        pst.executeUpdate();
        pst.close();
    
    }
    
     public void tambahIzin(ModelIzin moda) throws SQLException {
        sql = "INSERT INTO tbizin(nip,ket_absen,tanggal,id_admin,tahun)  VALUES( ?, ?, ?, ?, ?)";
       
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
       // pst.setString(1, moda.getKode());
        pst.setString(1, moda.getNip());
                pst.setString(2, moda.getKet_absen());
        pst.setDate(3, new java.sql.Date(moda.getTanggal().getTime()));

        pst.setString(4, moda.getId_adm());
        pst.setString(5, moda.getTahun());
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
