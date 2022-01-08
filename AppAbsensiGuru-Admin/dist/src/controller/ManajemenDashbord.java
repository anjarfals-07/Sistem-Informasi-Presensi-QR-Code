/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import Renderer.TableCellRenderer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import model.ModelAbsensi;
//import model.ModelGuru;
import model.ModelKehadiran;


/**
 *
 * @author ASUS
 */
public class ManajemenDashbord {
 PreparedStatement pst;
    ResultSet rs;
    String sql;
    
       public void loaadData(DefaultTableModel namatabel) throws SQLException {

        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
            
        sql =  "SELECT tbkehadiran.tanggal,tbguru.nip, tbguru.nama, tbjabatan.nama_jabatan, tbkehadiran.jam_masuk, tbkehadiran.jam_keluar\n" +
                "FROM tbguru\n" +
                "INNER JOIN tbjabatan ON tbguru.jabatan = tbjabatan.kode_jabatan\n" +
                "INNER JOIN tbkehadiran ON tbguru.nip_absen = tbkehadiran.nip\n"+
                "ORDER BY tbkehadiran.id_jam ASC\n";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        
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
       
        public void JumlahData(DefaultTableModel namatabel) throws SQLException {

        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
            
        sql =   "SELECT tbkehadiran.tanggal,tbguru.nip, tbguru.nama, tbjabatan.nama_jabatan, tbkehadiran.jam_masuk, tbkehadiran.jam_keluar\n" +
                "FROM tbguru\n" +
                "INNER JOIN tbjabatan ON tbguru.jabatan = tbjabatan.kode_jabatan\n" +
                "INNER JOIN tbkehadiran ON tbguru.nip_absen = tbkehadiran.nip\n" +
                "GROUP BY tbguru.nip_absen\n" +
                "ORDER BY tbkehadiran.tanggal DESC";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        
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
        
    public void loadDataDasbor(DefaultTableModel namatabel) throws SQLException{

        namatabel.getDataVector().removeAllElements();
        namatabel.fireTableDataChanged();
            
       sql =   "SELECT tbkehadiran.tanggal,tbguru.nip, tbguru.nama, tbjabatan.nama_jabatan, tbkehadiran.jam_masuk, tbkehadiran.jam_keluar\n" +
                "FROM tbguru\n" +
                "INNER JOIN tbjabatan ON tbguru.jabatan = tbjabatan.kode_jabatan\n" +
                "INNER JOIN tbkehadiran ON tbguru.nip_absen = tbkehadiran.nip\n" +
                 "WHERE tbkehadiran.tanggal = CURDATE()\n" +
                "GROUP BY tbguru.nip_absen\n" +
                "ORDER BY tbkehadiran.tanggal DESC";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        
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
    
   
 
    
    public int getJumlahGuru() throws SQLException{
        sql = "SELECT Count(*) as jumlah_guru_pagi from tbkehadiran where tanggal=CURDATE()";
        
         pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        rs = pst.executeQuery(sql);
        
        int jumlah_pagi;
            while(rs.next()){
                jumlah_pagi = rs.getInt("jumlah_guru_pagi");
                return jumlah_pagi;
            }
            return 0;
    }
   
    
     public int getTotalGuru() throws SQLException{
        sql = "SELECT count(*) as total_guru from tbguru;";
         pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        rs = pst.executeQuery(sql);
        
        int jumlah_hadir;
            while(rs.next()){
                jumlah_hadir = rs.getInt("total_guru");
                return jumlah_hadir;
            }
            return 0;
    }
    
  
    public int getTotalHari() throws SQLException{
        sql = "SELECT tanggal as tanggal_kerja "
                + "from tbkehadiran where tanggal = CURDATE()"
                + "group by tanggal;";
         pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        rs = pst.executeQuery(sql);
        
        int jumlah_hari = 0;
            while(rs.next()){
                jumlah_hari +=1;                   
            }
            return jumlah_hari; 
    }
    
   
      public void hapusAbsensi(ModelKehadiran modg) throws SQLException {
    
        sql = "DELETE FROM tbkehadiran WHERE tanggal=? ";
        pst = KoneksiDB.getKoneksi().prepareStatement(sql);
        pst.setDate(1, java.sql.Date.valueOf(modg.getTgl()));
       
        pst.executeUpdate();
        pst.close();
    
    }
}
    
