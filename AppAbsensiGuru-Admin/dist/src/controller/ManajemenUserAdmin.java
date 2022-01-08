/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import SessionLogin.UserID;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ModelLogin;

/**
 *
 * @author ASUS
 */
public class ManajemenUserAdmin {
    
    public boolean cekLogin(ModelLogin usr) throws SQLException {
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
        PreparedStatement pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(1, usr.getUsername());
        pst.setString(2, usr.getPassword());
        ResultSet rs;
        rs = pst.executeQuery();
        if (rs.next()) { 
            UserID.setUserLogin(rs.getString("id_admin"));
            UserID.setNamaLogin(rs.getString("nama_admin"));
            return true;
        }
        return false;
    }
 
}
