/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class KoneksiDB {
    private static Connection koneksi;
    
    public static Connection getKoneksi(){
        //cek apakak koneksi null
        if(koneksi == null){
            
            try {
                String url;
                url = "jdbc:mysql://localhost:3306/presensi_guru";
                String user = "root";
                String password = "";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                
                koneksi = DriverManager.getConnection(url,user,password);
            } catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Eror Membuat Koneksi"+ex);
            }
        }
        
        return koneksi;
                
    }

    static Object getConnection() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
