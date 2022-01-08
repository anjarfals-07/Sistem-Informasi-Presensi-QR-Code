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
//import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.ModelGuru;


/**
 *
 * @author ASUS
 */
public class ManajemenGuru {
    PreparedStatement pst;
    ResultSet rs;
    String sql;
    Statement st;
    public void loadDataGuru(DefaultTableModel namatabel, String modf) throws SQLException{  
        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
        
        if(modf == null){
           sql = "SELECT * FROM tbguru as p, tbjabatan as j "
                    + "where p.jabatan = j.kode_jabatan";
           }else{
            sql = "SELECT * FROM tbguru as p, tbjabatan as j "
                    + "where p.jabatan = j.kode_jabatan or "
                    + "p.nama is like '%?%'";
            
            pst.setString(1, modf.toString());
            
        }
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        
        rs = pst.executeQuery(sql);
            
            while(rs.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[8];
                o[0] = rs.getString("nip_absen");
                o[1] = rs.getString("nip");
                o[2] = rs.getString("nama");
                o[3] = rs.getString("nama_jabatan");
                  o[4] = rs.getString("tugas");
                    o[5] = rs.getString("tlp");
                o[6] = rs.getString("foto");
                o[7] = rs.getString("file");
 
                namatabel.addRow(o);
            }
            rs.close();
            pst.close();
        

    }
     public boolean cekGuru(ModelGuru modg) throws SQLException {
        sql = "SELECT * from tbguru where nip_absen = ?";
                pst = KoneksiDB.getKoneksi().prepareStatement(sql);
                pst.setString(1, modg.getNip_absen());
                rs = pst.executeQuery();

                if(rs.next()){
                   return true;
                }
                else {
            return false;
        }
}
     public void updateGuru(ModelGuru modg) throws SQLException {
        
        sql = "UPDATE tbguru SET nip=?, nama = ?, jabatan = ?, tugas = ?,tlp = ?,foto=?,file=?,id_admin=? WHERE nip_absen=?";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(1, modg.getNip());
        pst.setString(2, modg.getNama());
        pst.setString(3, modg.getJabatan());
        pst.setString(4, modg.getTugas());
        pst.setString(5, modg.getTlp());
        pst.setString(6, modg.getFoto());
        pst.setString(9, modg.getNip_absen());
        pst.setString(8, modg.getId_admin());
        pst.setString(7, modg.getFile());

        pst.executeUpdate();
        pst.close();
    
    }
    public void tambahGuru(ModelGuru modg) throws SQLException {
        sql = "INSERT INTO tbguru values(?, ?, ?, ?, ?, ?, ?, ?,?)";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        
        pst.setString(1, modg.getNip_absen());
        pst.setString(2, modg.getNip());
        pst.setString(3, modg.getNama());
        pst.setString(4, modg.getJabatan());
        pst.setString(5, modg.getTugas());
        pst.setString(6, modg.getTlp());
        pst.setString(7, modg.getFoto());
        pst.setString(8, modg.getFile());
        pst.setString(9, modg.getId_admin());

        pst.executeUpdate();
        pst.close();
        
    }
    public void hapusGuru(ModelGuru modg) throws SQLException {
    
        sql = "DELETE FROM tbguru WHERE nip_absen=? ";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(1, modg.getNip_absen());
        
        pst.executeUpdate();
        pst.close();
    
    }

  public ResultSet caridata(DefaultTableModel dtm, String cari) {
        try {
            String sql = "SELECT * FROM tbguru WHERE nip LIKE '%"+cari+"%' OR nama LIKE '%"+cari+"%' OR jabatan LIKE '%"+cari+"%'";
          pst = KoneksiDB.getKoneksi().prepareStatement(sql);
          rs = pst.executeQuery();
            Object [] data = new Object[5];
                while(rs.next()) {
                data[0] = rs.getString("nip_absen");
                data[1] = rs.getString("nip");
                data[2] = rs.getString("nama");
                data[3] = rs.getString("nama_jabatan");
                data[4] = rs.getString("foto");
         //       data[5] = rs.getString("id_jam");
                dtm.addRow(data);
                
             }
        } catch (SQLException ex) {
            Logger.getLogger(ManajemenGuru.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
         
        
        
      }
}
     

