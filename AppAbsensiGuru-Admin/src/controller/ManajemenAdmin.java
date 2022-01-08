/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.ModelAdmin;


/**
 *
 * @author ASUS
 */
public class ManajemenAdmin {
 PreparedStatement pst;
    ResultSet rs;
    String sql;
    
    public void loadDataAdmin(DefaultTableModel namatabel) throws SQLException{
        
        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
    
        sql = "SELECT * FROM admin";
        
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
    
        rs = pst.executeQuery(sql);
            
            while(rs.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[4];
              //  o[0] = rs.getString(1);
                o[0] = rs.getString("id_admin");
                o[1] = rs.getString("nama_admin");
                o[2] = rs.getString("username");
                o[3] = rs.getString("password");
               
 
                namatabel.addRow(o);
            }
            rs.close();
            pst.close();

     }
    
     public void loadDataDetailAdmin(DefaultTableModel namatabel) throws SQLException{
        
        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
    
        sql = "SELECT * FROM admin";
        
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
    
        rs = pst.executeQuery(sql);
            
            while(rs.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[4];
              //  o[0] = rs.getString(1);
                o[0] = rs.getString("id_admin");
                o[1] = rs.getString("nama_admin");
                o[2] = rs.getString("username");
                o[3] = rs.getString("password");
               
 
                namatabel.addRow(o);
            }
            rs.close();
            pst.close();

     }
    
     public void tambahAdmin(ModelAdmin moda) throws SQLException {
        sql = "INSERT INTO admin VALUES(?, ?, ?, ?)";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(1, moda.getId_admin());
        pst.setString(2, moda.getNama_admin());
        pst.setString(3, moda.getUsername());
        pst.setString(4, moda.getPassword());
       
        pst.executeUpdate();
        pst.close();

    }
       public void ubahAdmin(ModelAdmin moda) throws SQLException {
        
        sql = "UPDATE admin SET nama_admin = ?, username = ?, password=? WHERE id_admin=?";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(1, moda.getNama_admin());
        pst.setString(2, moda.getUsername());
        pst.setString(3, moda.getPassword());
        pst.setString(4, moda.getId_admin());
    
        pst.executeUpdate();
        pst.close();
    
    }
       
    public void hapusAdmin(ModelAdmin moda) throws SQLException {
    
        sql = "DELETE FROM admin where id_admin=?";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(1, moda.getId_admin());

        pst.executeUpdate();
        pst.close();
    }     
    
     public boolean cekDuplikasiAdmin(ModelAdmin moda) throws SQLException {
        sql = "SELECT * from admin where id_admin = ?";
                pst = KoneksiDB.getKoneksi().prepareStatement(sql);
                pst.setString(1, moda.getId_admin());
              //  pst.setString(2, moda.getUsername());
                rs = pst.executeQuery();

                if(rs.next()){
                   return true;
                }
                else {
            return false;
        }
     }        
      public ResultSet caridata(DefaultTableModel dtm, String cari) {
        try {
            String sql = "SELECT * FROM admin WHERE id_admin LIKE '%"+cari+"%' OR nama_admin LIKE '%"+cari+"%' OR username LIKE '%"+cari+"%'";
          pst = KoneksiDB.getKoneksi().prepareStatement(sql);
          rs = pst.executeQuery();
            Object [] o = new Object[3];
                while(rs.next()) {
                o[0] = rs.getString("id_admin");
                o[1] = rs.getString("nama_admin");
                o[2] = rs.getString("username");
                o[3] = rs.getString("password");
               
                dtm.addRow(o);
                
             }
        } catch (SQLException ex) {
            Logger.getLogger(ManajemenAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
      }

       public void ubahPassword(ModelAdmin moda) throws SQLException {
        
        sql = "UPDATE admin SET username = ?, password=? WHERE nama_admin=?";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(3, moda.getNama_admin());
        pst.setString(1, moda.getUsername());
        pst.setString(2, moda.getPassword());
       // pst.setString(4, moda.getId_admin());
    
        pst.executeUpdate();
        pst.close();
    
    }
       
            public boolean cekDuplikasi(ModelAdmin moda) throws SQLException {
        sql = "SELECT * from admin where nama_admin = ? ";
                pst = KoneksiDB.getKoneksi().prepareStatement(sql);
                pst.setString(1, moda.getNama_admin());
              //  pst.setString(2, moda.getUsername());
                rs = pst.executeQuery();

                if(rs.next()){
                   return true;
                }
                else {
            return false;
        }
     }
         
}
      
