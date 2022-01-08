/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.ModelSiswa;


/**
 *
 * @author ASUS
 */
public class ManajemenAbsenSiswa {
  PreparedStatement pst;
    ResultSet rs;
    String sql;
    public void loadDataAbsenSiswa(DefaultTableModel namatabel) throws SQLException{
        
        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
    
        sql = "SELECT * FROM tbabsen_siswa ORDER BY no_absen ASC";
        
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        rs = pst.executeQuery(sql);
            
            while(rs.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[8];
                o[0] = rs.getString("no_absen");
                o[1] = rs.getString("nis");
                o[2] = rs.getString("nama");
                o[3] = rs.getString("kelas");
                o[4] = rs.getString("sakit");
                o[5] = rs.getString("izin");
                o[6] = rs.getString("alpha");
                o[7] = rs.getDate("tanggal");
           
 
                namatabel.addRow(o);
            }
            rs.close();
            pst.close();

     }
    
     public void tambahAbsenSiswa(ModelSiswa moda) throws SQLException {
        sql = "INSERT INTO tbabsen_siswa (nis,nama,kelas,sakit,izin,alpha,tanggal,id_admin)VALUES( ?, ?, ?, ?,?,?,?,?)";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
      //  pst.setString(1, moda.getNo());
        pst.setString(1, moda.getNis());
        pst.setString(2, moda.getNama_siswa());
        pst.setString(3, moda.getKelas());
        pst.setString(4, moda.getSakit());
        pst.setString(5, moda.getIzin());
        pst.setString(6, moda.getAlpha());
        pst.setString(8, moda.getId_admin());
        pst.setDate(7, new java.sql.Date(moda.getTanggal().getTime()));

        pst.executeUpdate();
        pst.close();

    }
       public void ubahAbsenSiswa(ModelSiswa moda) throws SQLException {
        
        sql = "UPDATE tbabsen_siswa SET nis=?, nama = ?, kelas = ?, sakit=?, izin=?, alpha=?, tanggal=?,id_admin=? WHERE no_absen=?";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(9, moda.getNo());
        pst.setString(1, moda.getNis());
        pst.setString(2, moda.getNama_siswa());
        pst.setString(3, moda.getKelas());
        pst.setString(4, moda.getSakit());
        pst.setString(5, moda.getIzin());
        pst.setString(6, moda.getAlpha());
        pst.setDate(7, new java.sql.Date(moda.getTanggal().getTime()));
        pst.setString(8, moda.getId_admin());
        pst.executeUpdate();
        pst.close();
    
    }
       
  /*  public void hapusSiswa(ModelSiswa moda) throws SQLException {
    
        sql = "DELETE FROM tbabsen_siswa where no_absen=?";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(1, moda.getNo());

        pst.executeUpdate();
        pst.close();
    } */    
    
     public boolean cekDuplikasiSiswa(ModelSiswa moda) throws SQLException {
        sql = "SELECT * from tbabsen_siswa where no_absen=? ";
                pst = KoneksiDB.getKoneksi().prepareStatement(sql);
                pst.setString(1, moda.getNo());
              //  pst.setDate(2,new java.sql.Date( moda.getTanggal().getTime()));
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
            String sql = "SELECT * FROM tbabsen_siswa WHERE nis LIKE '%"+cari+"%' OR nama LIKE '%"+cari+"%' OR kelas LIKE '%"+cari+"%'";
          pst = KoneksiDB.getKoneksi().prepareStatement(sql);
          rs = pst.executeQuery();
            Object [] data = new Object[7];
                while(rs.next()) {
               // data[0] = rs.getString(1);
                data[0] = rs.getString("nis");
                data[1] = rs.getString("nama");
                data[2] = rs.getString("kelas");
                data[3] = rs.getString("sakit");
                data[4] = rs.getString("izin");
                data[5] = rs.getString("alpha");
                data[6] = rs.getDate("tanggal");
                dtm.addRow(data);
                
             }
        } catch (SQLException ex) {
            Logger.getLogger(ManajemenAbsenSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
      }

         
}
      
