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
import koneksi.konek;

/**
 *
 * @author ASUS
 */
public class ManajemenDashbord {
    
 PreparedStatement pst;
    ResultSet rs;
    String sql;
     public void loadData(DefaultTableModel namatabel) throws SQLException {

        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
            
        sql =   "SELECT tbkehadiran.tanggal,tbguru.nip, tbguru.nama, tbjabatan.nama_jabatan, tbkehadiran.jam_masuk, tbkehadiran.jam_keluar\n" +
                "FROM tbguru\n" +
                "INNER JOIN tbjabatan ON tbguru.jabatan = tbjabatan.kode_jabatan\n" +
                "INNER JOIN tbkehadiran ON tbguru.nip_absen = tbkehadiran.nip\n" +
                   "WHERE tbkehadiran.tanggal = CURDATE()\n" +
                "GROUP BY tbguru.nip_absen\n" +
                "ORDER BY tbkehadiran.tanggal DESC";
        pst = konek.getKoneksi().prepareStatement(sql);
        
        rs = pst.executeQuery(sql);
            
            while(rs.next()){
                //lakukan penelusuran baris
                Object[] o = new Object[6];
               
                o[0] = rs.getDate("tanggal");
                 o[1] = rs.getString("nip");
                o[2] = rs.getString("nama");
                o[3] = rs.getString("nama_jabatan");
                o[4] = rs.getTime("jam_masuk");
                o[5] = rs.getTime("jam_keluar");
 
                namatabel.addRow(o);
            }
            rs.close();
            pst.close();

     } 
//    public void loadDataDasbor(DefaultTableModel namatabel) throws SQLException{
//
//        namatabel.getDataVector().removeAllElements();
//        namatabel.fireTableDataChanged();
//            
//        sql =   "SELECT tbkehadiran.id_jam, tbkehadiran.tanggal,tbguru.nip, tbguru.nama, tbjabatan.nama_jabatan, tbkehadiran.jam_masuk, tbkehadiran.jam_keluar\n" +
//                "FROM tbguru\n" +
//                "INNER JOIN tbjabatan ON tbguru.jabatan = tbjabatan.kode_jabatan\n" +
//                "INNER JOIN tbkehadiran ON tbguru.nip_absen = tbkehadiran.nip\n" +
//                "WHERE tbkehadiran.id_jam = 'Pagi'\n" +
//                "GROUP BY tbguru.nip_absen\n" +
//                "ORDER BY tbkehadiran.tanggal DESC";
//        pst = konek.getKoneksi().prepareStatement(sql);
//        
//        rs = pst.executeQuery(sql);
//            
//            while(rs.next()){
//                //lakukan penelusuran baris
//                Object[] o = new Object[7];
//                 o[0] = rs.getString("id_jam");
//                o[1] = rs.getDate("tanggal");
//                 o[2] = rs.getString("nip");
//                o[3] = rs.getString("nama");
//                o[4] = rs.getString("nama_jabatan");
//                o[5] = rs.getTime("jam_masuk");
//                o[6] = rs.getTime("jam_keluar");
// 
//                namatabel.addRow(o);
//            }
//            rs.close();
//            pst.close();
//
//     } 
//    
//    public void loadDataDasborSiang(DefaultTableModel namatabel) throws SQLException{
//
//        namatabel.getDataVector().removeAllElements();
//        namatabel.fireTableDataChanged();
//            
//        sql =   "SELECT tbkehadiran.id_jam, tbkehadiran.tanggal,tbguru.nip, tbguru.nama, tbjabatan.nama_jabatan, tbkehadiran.jam_masuk, tbkehadiran.jam_keluar\n" +
//                "FROM tbguru\n" +
//                "INNER JOIN tbjabatan ON tbguru.jabatan = tbjabatan.kode_jabatan\n" +
//                "INNER JOIN tbkehadiran ON tbguru.nip_absen = tbkehadiran.nip\n" +
//                "WHERE tbkehadiran.id_jam = 'Siang'\n" +
//                "GROUP BY tbguru.nip_absen\n" +
//                "ORDER BY tbkehadiran.tanggal DESC";
//        pst = konek.getKoneksi().prepareStatement(sql);
//        
//        rs = pst.executeQuery(sql);
//            
//            while(rs.next()){
//                //lakukan penelusuran baris
//                Object[] o = new Object[7];
//                 o[0] = rs.getString("id_jam");
//                o[1] = rs.getDate("tanggal");
//                 o[2] = rs.getString("nip");
//                o[3] = rs.getString("nama");
//                o[4] = rs.getString("nama_jabatan");
//                o[5] = rs.getTime("jam_masuk");
//                o[6] = rs.getTime("jam_keluar");
// 
//                namatabel.addRow(o);
//            }
//            rs.close();
//            pst.close();
//
//     } 
//    
//     public void loadDataDasborTelat(DefaultTableModel namatabel) throws SQLException{
//
//        namatabel.getDataVector().removeAllElements();
//        namatabel.fireTableDataChanged();
//            
//        sql =   "SELECT tbkehadiran.id_jam, tbkehadiran.tanggal,tbguru.nip, tbguru.nama, tbjabatan.nama_jabatan, tbkehadiran.jam_masuk, tbkehadiran.jam_keluar\n" +
//                "FROM tbguru\n" +
//                "INNER JOIN tbjabatan ON tbguru.jabatan = tbjabatan.kode_jabatan\n" +
//                "INNER JOIN tbkehadiran ON tbguru.nip_absen = tbkehadiran.nip\n" +
//                "WHERE tbkehadiran.id_jam = 'Telat'\n" +
//                "GROUP BY tbguru.nip_absen\n" +
//                "ORDER BY tbkehadiran.tanggal DESC";
//        pst = konek.getKoneksi().prepareStatement(sql);
//        
//        rs = pst.executeQuery(sql);
//            
//            while(rs.next()){
//                //lakukan penelusuran baris
//                Object[] o = new Object[7];
//                 o[0] = rs.getString("id_jam");
//                o[1] = rs.getDate("tanggal");
//                 o[2] = rs.getString("nip");
//                o[3] = rs.getString("nama");
//                o[4] = rs.getString("nama_jabatan");
//                o[5] = rs.getTime("jam_masuk");
//                o[6] = rs.getTime("jam_keluar");
// 
//                namatabel.addRow(o);
//            }
//            rs.close();
//            pst.close();
//
//     } 
     public int getJumlahGuru() throws SQLException{
        sql = "SELECT Count(*) as jumlah_guru from tbkehadiran where tanggal=CURDATE()";
        
         pst = konek.getKoneksi().prepareStatement(sql);
        rs = pst.executeQuery(sql);
        
        int jumlah_guru;
            while(rs.next()){
                jumlah_guru = rs.getInt("jumlah_guru");
                return jumlah_guru;
            }
            return 0;
    }
    
//    public int getJumlahGuru() throws SQLException{
//        sql = "SELECT Count(*) as jumlah_guru_pagi from tbkehadiran where id_jam='Pagi' ";//
//        
//         pst = konek.getKoneksi().prepareStatement(sql);
//        rs = pst.executeQuery(sql);
//        
//        int jumlah_pagi;
//            while(rs.next()){
//                jumlah_pagi = rs.getInt("jumlah_guru_pagi");
//                return jumlah_pagi;
//            }
//            return 0;
//    }
//    
//    public int getJumlahGuruSiang() throws SQLException{
//        sql = "SELECT Count(*) as jumlah_guru_siang from tbkehadiran where id_jam='Siang'";
//        
//         pst = konek.getKoneksi().prepareStatement(sql);
//        rs = pst.executeQuery(sql);
//        
//        int jumlah_siang;
//            while(rs.next()){
//                jumlah_siang = rs.getInt("jumlah_guru_siang");
//                return jumlah_siang;
//            }
//            return 0;
//    }
//    
//      public int getJumlahGuruTelat() throws SQLException{
//        sql = "SELECT Count(*) as jumlah_guru_telat from tbkehadiran where id_jam='Telat'";
//        
//         pst = konek.getKoneksi().prepareStatement(sql);
//        rs = pst.executeQuery(sql);
//        
//        int jumlah_telat;
//            while(rs.next()){
//                jumlah_telat = rs.getInt("jumlah_guru_telat");
//                return jumlah_telat;
//            }
//            return 0;
//    }
      
     public int getTotalGuru() throws SQLException{
        sql = "SELECT count(*) as total_guru from tbguru;";
         pst = konek.getKoneksi().prepareStatement(sql);
        rs = pst.executeQuery(sql);
        
        int jumlah_hadir;
            while(rs.next()){
                jumlah_hadir = rs.getInt("total_guru");
                return jumlah_hadir;
            }
            return 0;
    }
    
//    public int getTotalHadirSiang() throws SQLException{
//        sql = "SELECT count(*) as total_hadir_siang from tbkehadiran where id_jam = 'Siang';";
//         pst = konek.getKoneksi().prepareStatement(sql);
//        rs = pst.executeQuery(sql);
//        
//        int jumlah_hadir;
//            while(rs.next()){
//                jumlah_hadir = rs.getInt("total_hadir_siang");
//                return jumlah_hadir;
//            }
//            return 0;
//    }
    public int getTotalHari() throws SQLException{
        sql = "SELECT tanggal as tanggal_kerja "
                + "from tbkehadiran"
                + "group by tanggal;";
         pst = konek.getKoneksi().prepareStatement(sql);
        rs = pst.executeQuery(sql);
        
        int jumlah_hari = 0;
            while(rs.next()){
                jumlah_hari +=1;                   
            }
            return jumlah_hari; 
    }
    
//    public int getTotalHariSiang() throws SQLException{
//        sql = "SELECT tanggal as tanggal_kerja "
//                + "from tbkehadiran where id_jam = 'Siang'"
//                + "group by tanggal;";
//       pst = konek.getKoneksi().prepareStatement(sql);
//        rs = pst.executeQuery(sql);
//        
//        int jumlah_hari = 0;
//            while(rs.next()){
//                jumlah_hari +=1;                   
//            }
//            return jumlah_hari; 
//    }
}
    
