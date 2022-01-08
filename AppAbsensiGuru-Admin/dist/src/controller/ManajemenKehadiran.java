/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ModelKehadiran;

/**
 *
 * @author ASUS
 */
public class ManajemenKehadiran {
   
    
     public boolean cek_guru(ModelKehadiran guru) throws SQLException {
        
        String cek = "SELECT * from tbguru where nip = ?";
        PreparedStatement pst = KoneksiDB.getKoneksi().prepareStatement(cek);
        pst.setString(1, guru.getNip_h());
        ResultSet rs;
        rs = pst.executeQuery();
        
        if(rs.next()){
            return true;
        }
        return false;
        
    }
    
        public void masuk(String nip) throws SQLException {
        
            
        String hadir = "INSERT INTO tbkehadiran VALUES( ?, CURDATE(), CURTIME(), 0)";
        PreparedStatement pst = KoneksiDB.getKoneksi().prepareStatement(hadir);
        pst.setString(1, nip);
        pst.executeUpdate();     
        
    }
        
        public void keluar(String nip) throws SQLException {
        
        String cek = "UPDATE tbkehadiran SET jam_keluar=CURTIME() WHERE nip=? AND tanggal=CURDATE()";
        PreparedStatement pst = KoneksiDB.getKoneksi().prepareStatement(cek);
        pst.setString(1, nip);       
        pst.executeUpdate();       
        
    }

        
    
}

    

