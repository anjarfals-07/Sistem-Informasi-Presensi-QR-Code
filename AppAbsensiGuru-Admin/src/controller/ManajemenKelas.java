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
import model.ModelKelas;


/**
 *
 * @author Anjar
 */
public class ManajemenKelas {
     PreparedStatement pst;
    ResultSet rs;
    String sql;
    
     public void loadDataKelas(DefaultTableModel namatabel) throws SQLException{ 
        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
        
           sql = "SELECT * FROM tbkelas";
           
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        rs = pst.executeQuery(sql);
           
            while(rs.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[2];
                o[0] = rs.getString("kode");
                o[1] = rs.getString("nama_kelas");
              
                namatabel.addRow(o);
            }
            rs.close();
            pst.close();

     }
    
    public boolean cekKelas(ModelKelas moda) throws SQLException {
        sql = "SELECT * from tbkelas where kode = ?";
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
    
    public boolean cekDuplikasi(ModelKelas moda) throws SQLException {
        sql = "SELECT * from tbkelas where kode = ?";
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
    
   
    public void ubahKelas(ModelKelas moda) throws SQLException {
        
        sql = "UPDATE tbkelas SET nama_kelas=? WHERE kode=?";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(1, moda.getNama_kelas());
        pst.setString(2, moda.getKode());

        pst.executeUpdate();
        pst.close();
    
    }
    
     public void tambahKelas(ModelKelas moda) throws SQLException {
        sql = "INSERT INTO tbkelas(nama_kelas)  VALUES(?)";
       
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
       // pst.setString(1, moda.getKode());
        pst.setString(1, moda.getNama_kelas());
        
        pst.executeUpdate();
        pst.close();
        
        
    }
   
}
