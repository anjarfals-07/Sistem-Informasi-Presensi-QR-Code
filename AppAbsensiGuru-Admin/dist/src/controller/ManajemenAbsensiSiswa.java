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
import model.ModelAbsenSiswa;

/**
 *
 * @author Anjar
 */
public class ManajemenAbsensiSiswa {
    
 PreparedStatement pst;
    ResultSet rs;
    String sql;
    public void loadDataAbsensiSiswa(DefaultTableModel namatabel) throws SQLException{
        
        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
    
        sql = "SELECT * FROM tbabsensi_siswa ORDER BY no_absen ASC";
        
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        rs = pst.executeQuery(sql);
            
            while(rs.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[27];
                o[0] = rs.getString("no_absen");
                o[1] = rs.getString("nis");
                o[2] = rs.getString("nama");
                o[3] = rs.getString("kelas");
                o[4] = rs.getString("semester");
                o[5] = rs.getString("tahun_ajaran");
                o[6] = rs.getString("matapelajaran");
                o[7] = rs.getString("pertemuan_1");
                o[8] = rs.getString("pertemuan_2");
                o[9] = rs.getString("pertemuan_3");
                o[10] = rs.getString("pertemuan_4");
                o[11] = rs.getString("pertemuan_5");
                o[12] = rs.getString("pertemuan_6");
                o[13] = rs.getString("pertemuan_7");
                o[14] = rs.getString("pertemuan_8");
                o[15] = rs.getString("pertemuan_9");
                o[16] = rs.getString("pertemuan_10");
                o[17] = rs.getString("pertemuan_11");
                o[18] = rs.getString("pertemuan_12");
                o[19] = rs.getString("pertemuan_13");
                o[20] = rs.getString("pertemuan_14");
                o[21] = rs.getString("pertemuan_15");
                o[22] = rs.getString("pertemuan_16");
                o[23] = rs.getString("total_hadir");
                o[24] = rs.getString("total_sakit");
                o[25] = rs.getString("total_izin");
                o[26] = rs.getString("total_alpha");
        
 
                namatabel.addRow(o);
            }
            rs.close();
            pst.close();

     }
    
     public void tambahAbsenSiswa(ModelAbsenSiswa moda) throws SQLException {
        sql = "INSERT INTO tbabsensi_siswa (nis,nama,kelas,semester,tahun_ajaran,matapelajaran,pertemuan_1,pertemuan_2,"
                + "pertemuan_3,pertemuan_4,pertemuan_5,pertemuan_6,pertemuan_7,pertemuan_8,pertemuan_9,pertemuan_10,"
                + "pertemuan_11,pertemuan_12,pertemuan_13,pertemuan_14,pertemuan_15,pertemuan_16,total_hadir,total_sakit,"
                + "total_izin,total_alpha)VALUES( ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
      //  pst.setString(1, moda.getNo());
        pst.setString(1, moda.getNis());
        pst.setString(2, moda.getNama_siswa());
        pst.setString(3, moda.getKelas());
        pst.setString(4, moda.getSemester());
        pst.setString(5, moda.getTahun_ajaran());
        pst.setString(6, moda.getMatapelajaran());
        pst.setString(7, moda.getPer1());
        pst.setString(8, moda.getPer2());
        pst.setString(9, moda.getPer3());
        pst.setString(10, moda.getPer4());
        pst.setString(11, moda.getPer5());
        pst.setString(12, moda.getPer6());
        pst.setString(13, moda.getPer7());
        pst.setString(14, moda.getPer8());
        pst.setString(15, moda.getPer9());
        pst.setString(16, moda.getPer10());
        pst.setString(17, moda.getPer11());
        pst.setString(18, moda.getPer12());
        pst.setString(19, moda.getPer13());
        pst.setString(20, moda.getPer14());
        pst.setString(21, moda.getPer15());
        pst.setString(22, moda.getPer16());
        pst.setString(23, moda.getTtl_hadir());
        pst.setString(24, moda.getTtl_sakit());
        pst.setString(25, moda.getTtl_izin());
        pst.setString(26, moda.getTtl_alpha());

        pst.executeUpdate();
        pst.close();

    }
       public void ubahAbsenSiswa(ModelAbsenSiswa moda) throws SQLException {
        
        sql = "UPDATE tbabsensi_siswa SET nis=?, nama = ?, kelas = ?, semester=?, tahun_ajaran=?, matapelajaran=?, pertemuan_1=?,"
                + "pertemuan_2=?, pertemuan_3=?,pertemuan_4=?, pertemuan_5=?, pertemuan_6=?, pertemuan_7=?, pertemuan_8=?,"
                + "pertemuan_9=?, pertemuan_10=?, pertemuan_11=?, pertemuan_12=?, pertemuan_13=?,pertemuan_14=?, pertemuan_15=?,"
                + "pertemuan_16=?, total_hadir=?, total_sakit=?,total_izin=?, total_alpha=? WHERE no_absen=?";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setString(27, moda.getNo());
        pst.setString(1, moda.getNis());
        pst.setString(2, moda.getNama_siswa());
        pst.setString(3, moda.getKelas());
        pst.setString(4, moda.getSemester());
        pst.setString(5, moda.getTahun_ajaran());
        pst.setString(6, moda.getMatapelajaran());
        pst.setString(7, moda.getPer1());
        pst.setString(8, moda.getPer2());
        pst.setString(9, moda.getPer3());
        pst.setString(10, moda.getPer4());
        pst.setString(11, moda.getPer5());
        pst.setString(12, moda.getPer6());
        pst.setString(13, moda.getPer7());
        pst.setString(14, moda.getPer8());
        pst.setString(15, moda.getPer9());
        pst.setString(16, moda.getPer10());
        pst.setString(17, moda.getPer11());
        pst.setString(18, moda.getPer12());
        pst.setString(19, moda.getPer13());
        pst.setString(20, moda.getPer14());
        pst.setString(21, moda.getPer15());
        pst.setString(22, moda.getPer16());
        pst.setString(23, moda.getTtl_hadir());
        pst.setString(24, moda.getTtl_sakit());
        pst.setString(25, moda.getTtl_izin());
        pst.setString(26, moda.getTtl_alpha());
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
    
     public boolean cekDuplikasiSiswa(ModelAbsenSiswa moda) throws SQLException {
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
            Logger.getLogger(ManajemenAbsensiSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
      }

         
}
      