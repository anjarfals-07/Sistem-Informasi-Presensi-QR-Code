/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.ManajemenDashbord;
import controller.SubmitHadir;
import controller.SubmitPresensi;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DecimalFormat;
//import java.text.DateFormat;
//import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
//import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import koneksi.konek;
import model.Hadir;

/**
 *
 * @author ASUS
 */
public class AbsensiGuru1 extends javax.swing.JFrame {

    /**
     * Creates new form AbsensiGuru
     */
    DefaultTableModel tabeldasbor;
  
    public void loadTblDashboard() throws SQLException{
       ManajemenDashbord mdtl = new ManajemenDashbord();
        mdtl.loadData(tabeldasbor);
        
       // mdtl.loadDataDasborSiang(tabeldasbor);
         try {
            int guru = mdtl.getTotalGuru();
            Dasbor_jumlah_guru.setText(String.valueOf(guru));
            int kehadiran = mdtl.getJumlahGuru();      
            Dasbor_persentase_kehadiran.setText(String.valueOf((kehadiran))+" Data");
            
             
        } catch (SQLException ex) {
            Logger.getLogger(AbsensiGuru1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   // DefaultTableModel tabeldasbors;
    public void loadTblDashboards() throws SQLException{
        
         
//       ManajemenDashbord mdt = new ManajemenDashbord();
//        mdt.loadDataDasborSiang(tabeldasbor);
//        try {
//           
//           int guru_siang = mdt.getTotalGuru();
//            Dasbor_jumlah_guru.setText(String.valueOf(guru_siang));
//            int kehadiransiang = mdt.getJumlahGuruSiang();           
//            Dasbor_persentase_kehadiran_siang.setText(String.valueOf((kehadiransiang))+" Data");
//                
//        } catch (SQLException ex) {
//            Logger.getLogger(AbsensiGuru.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//     public void loadTblDashboardTelat() throws SQLException{
//       ManajemenDashbord mdt = new ManajemenDashbord();
//        mdt.loadDataDasborTelat(tabeldasbor);
//        try {  
//           int guru_telat = mdt.getTotalGuru();
//            Dasbor_jumlah_guru.setText(String.valueOf(guru_telat));
//            int kehadirantelat = mdt.getJumlahGuruTelat();       
//            Dasbor_persentase_kehadiran_telat.setText(String.valueOf((kehadirantelat))+" Data");
//                
//        } catch (SQLException ex) {
//            Logger.getLogger(AbsensiGuru.class.getName()).log(Level.SEVERE, null, ex);
//        }

//   
    }
   
    private List<Hadir> ambil   = new ArrayList<Hadir>(); 
    public AbsensiGuru1() throws SQLException  {
        initComponents();
        
      
    
        
            ImageIcon icon = new ImageIcon("src/images/LOGO7.png");
        setIconImage(icon.getImage());
        tabeldasbor = new DefaultTableModel();
        
        //menambahkan TableModel ke Tabel
        tbdasbor.setModel(tabeldasbor);        
    
        tabeldasbor.addColumn("TANGGAL");
        tabeldasbor.addColumn("NIP");
        tabeldasbor.addColumn("NAMA GURU");
        tabeldasbor.addColumn("JABATAN");
        tabeldasbor.addColumn("ABSEN MASUK");
        tabeldasbor.addColumn("ABSEN KELUAR");
        
           //+++++++++Agar memulai aplikasi berada di tengah layar
    
        Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = new Dimension ( 1100, 700 );
        this.setBounds ( ss.width / 2 - frameSize.width / 2, 
                  ss.height / 2 - frameSize.height / 2,
                  frameSize.width, frameSize.height );
                  
        
        //Informasi hari, tanggal
                 
          label_tanggal.setText(new SimpleDateFormat("dd / MMMM / YYYY").format(new java.util.Date()));
          txtNip.requestFocus();
         label_tanggal1.setText(new SimpleDateFormat("dd / MMMM / YYYY").format(new java.util.Date()));
          txtNip1.requestFocus();
          
           label_tanggal3.setText(new SimpleDateFormat("YYYY/MM/dd").format(new java.util.Date()));
        
        jam();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        label_error_message = new javax.swing.JLabel();
        label_jamkerja = new javax.swing.JLabel();
        tampil_jam = new javax.swing.JLabel();
        txtNip = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        foto_guru = new javax.swing.JLabel();
        label_NipGuru = new javax.swing.JLabel();
        label_NamaGuru = new javax.swing.JLabel();
        label_JabatanGuru = new javax.swing.JLabel();
        lbtugas = new javax.swing.JLabel();
        label_tanggal = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lbversi = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtid_jam = new javax.swing.JLabel();
        mainPanel2 = new javax.swing.JPanel();
        label_error_message1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        label_jamkerja1 = new javax.swing.JLabel();
        tampil_jam1 = new javax.swing.JLabel();
        txtNip1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        foto_guru1 = new javax.swing.JLabel();
        label_NipGuru1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        label_NamaGuru1 = new javax.swing.JLabel();
        label_JabatanGuru1 = new javax.swing.JLabel();
        lbtugas1 = new javax.swing.JLabel();
        label_tanggal1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jPanel7 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        p_laporan_guru = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbdasbor = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        Dasbor_persentase_kehadiran = new javax.swing.JLabel();
        Dasbor_jumlah_guru = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        label_tanggal3 = new javax.swing.JLabel();
        label_jam3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new java.awt.CardLayout());

        mainPanel.setBackground(new java.awt.Color(102, 204, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_error_message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_error_message.setText("silahkan");
        mainPanel.add(label_error_message, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 310, -1));

        label_jamkerja.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        label_jamkerja.setForeground(new java.awt.Color(255, 255, 255));
        label_jamkerja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_jamkerja.setText("Jam Masuk");
        label_jamkerja.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.add(label_jamkerja, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 250, 20));

        tampil_jam.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        tampil_jam.setText("03 : 00 :00");
        mainPanel.add(tampil_jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 120, -1));

        txtNip.setFont(new java.awt.Font("Lucida Gr", 0, 24)); // NOI18N
        txtNip.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNip.setToolTipText("");
        txtNip.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNip.setInheritsPopupMenu(true);
        txtNip.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNipFocusGained(evt);
            }
        });
        txtNip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNipActionPerformed(evt);
            }
        });
        txtNip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNipKeyReleased(evt);
            }
        });
        mainPanel.add(txtNip, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 290, 50));

        jLabel1.setFont(new java.awt.Font("Lucida G", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Masukan NIP"));
        mainPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 310, 80));

        foto_guru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto_guru.setToolTipText("");
        foto_guru.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.add(foto_guru, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 250, 220));

        label_NipGuru.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        label_NipGuru.setForeground(new java.awt.Color(255, 255, 255));
        label_NipGuru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_NipGuru.setText("Nip");
        label_NipGuru.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.add(label_NipGuru, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 250, 20));

        label_NamaGuru.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        label_NamaGuru.setForeground(new java.awt.Color(255, 255, 255));
        label_NamaGuru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_NamaGuru.setText("Nama Guru");
        label_NamaGuru.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.add(label_NamaGuru, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 250, 20));

        label_JabatanGuru.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        label_JabatanGuru.setForeground(new java.awt.Color(255, 255, 255));
        label_JabatanGuru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_JabatanGuru.setText("Jabatan");
        label_JabatanGuru.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.add(label_JabatanGuru, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 250, 20));

        lbtugas.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbtugas.setForeground(new java.awt.Color(255, 255, 255));
        lbtugas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtugas.setText("Tugas Tambahan");
        lbtugas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.add(lbtugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 250, 20));

        label_tanggal.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        label_tanggal.setText("Sabtu 10 Januari 2014");
        mainPanel.add(label_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 240, 30));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel25.setText("Absensi Masuk");
        mainPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        jTextArea1.setBackground(new java.awt.Color(102, 204, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("1. Pastikan waktu keluar dan masuk anda\nsesuai jadwal yang ditentukan\n2. Arahkan Pointer ke Nip Yang Akan di Scan\n3. Dekatkan barcode Kartu Tanda Guru anda\nke scanner ( Jika memakai Scanner )\n4. Tunggu sampai NIP terbaca dan tertulis\ninformasi tentang anda di layar\n5. Anda Berhasil Melakukan Absen");
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tata Cara Presensi Guru "));
        jScrollPane1.setViewportView(jTextArea1);

        mainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 300, 190));

        jLabel2.setBackground(new java.awt.Color(102, 204, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Created By Team KKP");
        jLabel2.setOpaque(true);
        mainPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 230, 200, -1));

        jScrollPane2.setBackground(new java.awt.Color(102, 204, 255));
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "S6I", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jTextArea2.setBackground(new java.awt.Color(102, 204, 255));
        jTextArea2.setColumns(4);
        jTextArea2.setRows(5);
        jTextArea2.setTabSize(3);
        jTextArea2.setText("1. Arief Abdul Karim \n2. Kiki Aristiani\n3. Maulana Sakti\n4. Muhammad Anjar\n5. Nurul Hady\n6. Rangga Heryanto\n7. Rizky Maulana\n8. Sugi Asep");
        jTextArea2.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea2);

        mainPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 270, 200, 190));

        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 290, 390));

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setOpaque(true);
        mainPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 330, 410));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LOGO7.jpg"))); // NOI18N
        jLabel27.setText("jLabel27");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 190, 210));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/full-time.png"))); // NOI18N
        mainPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/date.png"))); // NOI18N
        mainPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        lbversi.setFont(new java.awt.Font("Lucida G", 3, 12)); // NOI18N
        lbversi.setForeground(new java.awt.Color(255, 255, 255));
        lbversi.setText("Absensi Guru V .1 .0");
        mainPanel.add(lbversi, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 120, 20));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("F1 : ABSEN MASUK");
        jPanel2.add(jLabel5);

        jToolBar1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel35.setText("F2 : ABSEN KELUAR");
        jPanel3.add(jLabel35);

        jToolBar1.add(jPanel3);

        jPanel5.setBackground(new java.awt.Color(102, 204, 255));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel37.setText("F4 : DATA ABSENSI");
        jPanel5.add(jLabel37);

        jToolBar1.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(102, 204, 255));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel38.setText("F5 : EXIT PROGRAM");
        jPanel6.add(jLabel38);

        jToolBar1.add(jPanel6);

        mainPanel.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 580, 600, 30));

        txtid_jam.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtid_jam.setForeground(new java.awt.Color(255, 255, 255));
        txtid_jam.setText("1");
        mainPanel.add(txtid_jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 10, 20));

        jPanel1.add(mainPanel, "card2");

        mainPanel2.setBackground(new java.awt.Color(102, 204, 255));
        mainPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_error_message1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_error_message1.setText("silahkan");
        mainPanel2.add(label_error_message1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 310, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 2, 14)); // NOI18N
        jLabel8.setText("Absensi Guru Ver.1");
        mainPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 120, -1));

        label_jamkerja1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        label_jamkerja1.setForeground(new java.awt.Color(255, 255, 255));
        label_jamkerja1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_jamkerja1.setText("Jam Keluar");
        label_jamkerja1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel2.add(label_jamkerja1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 270, 20));

        tampil_jam1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        tampil_jam1.setText("03 : 00 :00");
        mainPanel2.add(tampil_jam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 120, -1));

        txtNip1.setFont(new java.awt.Font("Lucida Gr", 0, 24)); // NOI18N
        txtNip1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNip1.setToolTipText("");
        txtNip1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNip1.setInheritsPopupMenu(true);
        txtNip1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNip1ActionPerformed(evt);
            }
        });
        txtNip1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNip1KeyReleased(evt);
            }
        });
        mainPanel2.add(txtNip1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 290, 50));

        jLabel9.setFont(new java.awt.Font("Lucida G", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Masukan NIP"));
        mainPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 310, 80));

        foto_guru1.setBackground(new java.awt.Color(102, 204, 255));
        foto_guru1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto_guru1.setText("Foto");
        foto_guru1.setToolTipText("");
        foto_guru1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel2.add(foto_guru1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 270, 230));

        label_NipGuru1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        label_NipGuru1.setForeground(new java.awt.Color(255, 255, 255));
        label_NipGuru1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_NipGuru1.setText("Nip ");
        label_NipGuru1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel2.add(label_NipGuru1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 270, 20));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Absensi Keluar");
        mainPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));

        label_NamaGuru1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        label_NamaGuru1.setForeground(new java.awt.Color(255, 255, 255));
        label_NamaGuru1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_NamaGuru1.setText("Nama Guru");
        label_NamaGuru1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel2.add(label_NamaGuru1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 270, 20));

        label_JabatanGuru1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        label_JabatanGuru1.setForeground(new java.awt.Color(255, 255, 255));
        label_JabatanGuru1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_JabatanGuru1.setText("Jabatan");
        label_JabatanGuru1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel2.add(label_JabatanGuru1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 270, 20));

        lbtugas1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbtugas1.setForeground(new java.awt.Color(255, 255, 255));
        lbtugas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtugas1.setText("Tugas Tambahan");
        lbtugas1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel2.add(lbtugas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 270, 20));

        label_tanggal1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        label_tanggal1.setText("Sabtu 10 Januari 2014");
        mainPanel2.add(label_tanggal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 240, 30));

        jTextArea3.setBackground(new java.awt.Color(102, 204, 255));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setText("1. Pastikan waktu keluar dan masuk anda\n    sesuai jadwal yang ditentukan\n2. Arahkan Pointer ke Nip Yang Akan di Scan\n3. Dekatkan barcode Kartu Tanda Guru anda\n     ke scanner ( Jika memakai Scanner )\n4. Tunggu sampai NIP terbaca dan tertulis\n     informasi tentang anda di layar\n5. Anda Berhasil Melakukan Absen");
        jTextArea3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tata Cara Presensi Guru "));
        jScrollPane3.setViewportView(jTextArea3);

        mainPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 290, 200));

        jLabel10.setBackground(new java.awt.Color(102, 204, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Created By Team KKP");
        jLabel10.setOpaque(true);
        mainPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 250, 190, -1));

        jScrollPane4.setBackground(new java.awt.Color(102, 204, 255));
        jScrollPane4.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "S6I", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jTextArea4.setBackground(new java.awt.Color(102, 204, 255));
        jTextArea4.setColumns(4);
        jTextArea4.setRows(5);
        jTextArea4.setTabSize(3);
        jTextArea4.setText("1. Arief Abdul Karim\n2. Kiki Aristiani\n3. Maulana Sakti\n4. Muhammad Anjar\n5. Nurul Hady\n6. Rangga Heryanto\n7. Rizky Maulana\n8. Sugi Asep");
        jTextArea4.setWrapStyleWord(true);
        jScrollPane4.setViewportView(jTextArea4);

        mainPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 290, 190, 190));

        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 290, 400));

        jLabel13.setBackground(new java.awt.Color(0, 102, 102));
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel13.setOpaque(true);
        mainPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 310, 420));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LOGO7.jpg"))); // NOI18N
        jLabel28.setText("jLabel27");
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, 190, 210));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/full-time.png"))); // NOI18N
        mainPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/date.png"))); // NOI18N
        mainPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setRollover(true);

        jPanel7.setBackground(new java.awt.Color(102, 204, 255));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel39.setText("F1 : ABSEN MASUK");
        jPanel7.add(jLabel39);

        jToolBar2.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(102, 204, 255));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel40.setText("F2 : ABSEN KELUAR");
        jPanel8.add(jLabel40);

        jToolBar2.add(jPanel8);

        jPanel10.setBackground(new java.awt.Color(102, 204, 255));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel42.setText("F4 : DATA ABSENSI");
        jPanel10.add(jLabel42);

        jToolBar2.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(102, 204, 255));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel43.setText("F5 : EXIT PROGRAM");
        jPanel11.add(jLabel43);

        jToolBar2.add(jPanel11);

        mainPanel2.add(jToolBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 580, 590, 30));

        jPanel1.add(mainPanel2, "card2");

        p_laporan_guru.setBackground(new java.awt.Color(102, 204, 255));
        p_laporan_guru.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        p_laporan_guru.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbdasbor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbdasbor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdasborMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbdasbor);

        p_laporan_guru.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 700, 380));

        jLabel15.setBackground(new java.awt.Color(204, 204, 0));
        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Data Presensi ");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel15.setOpaque(true);
        p_laporan_guru.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, 270, 30));

        Dasbor_persentase_kehadiran.setBackground(new java.awt.Color(255, 102, 102));
        Dasbor_persentase_kehadiran.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        Dasbor_persentase_kehadiran.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Dasbor_persentase_kehadiran.setText("-");
        Dasbor_persentase_kehadiran.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Dasbor_persentase_kehadiran.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Dasbor_persentase_kehadiran.setOpaque(true);
        p_laporan_guru.add(Dasbor_persentase_kehadiran, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 270, -1));

        Dasbor_jumlah_guru.setBackground(new java.awt.Color(255, 102, 102));
        Dasbor_jumlah_guru.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        Dasbor_jumlah_guru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Dasbor_jumlah_guru.setText("-");
        Dasbor_jumlah_guru.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Dasbor_jumlah_guru.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Dasbor_jumlah_guru.setOpaque(true);
        p_laporan_guru.add(Dasbor_jumlah_guru, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 360, 270, -1));

        jLabel64.setBackground(new java.awt.Color(51, 255, 51));
        jLabel64.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Jumlah Presensi");
        jLabel64.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel64.setOpaque(true);
        p_laporan_guru.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 270, 20));

        jLabel65.setBackground(new java.awt.Color(204, 204, 0));
        jLabel65.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Jumlah Guru");
        jLabel65.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel65.setOpaque(true);
        p_laporan_guru.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 270, 30));

        jLabel66.setBackground(new java.awt.Color(102, 204, 255));
        jLabel66.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel66.setOpaque(true);
        p_laporan_guru.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, 290, 380));

        jLabel83.setText("logo smk");
        p_laporan_guru.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 270, 190));

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton8.setText("Cek Data Hari Ini");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        p_laporan_guru.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 150, 30));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel18.setText("DATA ABSENSI");
        p_laporan_guru.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        label_tanggal3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        label_tanggal3.setText("tgl");
        label_tanggal3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                label_tanggal3FocusGained(evt);
            }
        });
        p_laporan_guru.add(label_tanggal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 180, 30));

        label_jam3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        label_jam3.setText("lbl jam");
        p_laporan_guru.add(label_jam3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 180, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/full-time.png"))); // NOI18N
        p_laporan_guru.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/date.png"))); // NOI18N
        p_laporan_guru.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 56, -1, 20));

        jPanel1.add(p_laporan_guru, "card2");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenuBar1.setPreferredSize(new java.awt.Dimension(283, 40));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-menu-25.png"))); // NOI18N
        jMenu1.setText("MENU ABSENSI");
        jMenu1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-sunrise-25.png"))); // NOI18N
        jMenuItem1.setText("ABSENSI MASUK");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-sun-25.png"))); // NOI18N
        jMenuItem2.setText("ABSENSI KELUAR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/graphic-design.png"))); // NOI18N
        jMenu2.setText("DATA ABSEN");
        jMenu2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-attendance-25.png"))); // NOI18N
        jMenuItem3.setText("DATA ABSEN GURU");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-exit-sign-16.png"))); // NOI18N
        jMenu3.setText("KELUAR APLIKASI");
        jMenu3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        jMenuItem4.setText("Keluar Aplikasi");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNipActionPerformed

    private void txtNipKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNipKeyReleased
        // TODO add your handling code here:
      
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String nip;
           String id_jam;
            boolean status_guru, status_hadir;
            nip = txtNip.getText();
            id_jam= txtid_jam.getText();
            Hadir guru = new Hadir();

            guru.setNip(nip);
            guru.setId_Jam(id_jam);
            if(!"".equals(nip)){
                SubmitPresensi kehadiran = new SubmitPresensi();
                try{
                    //cek apakah pegawai ada di tabel pegawai
                    status_guru = kehadiran.cek_guru(guru);
                    if(status_guru == true){
                        //cek dia harusnya masuk jam berapa
                        Date jam = new Date();

                        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                       String jam_sekarang = format.format(jam.getTime());

                        ambil = kehadiran.ambil(guru);
                       
                        String data[] = new String[6];
                        for(Hadir h : ambil){
                            data[0] = h.getNip_guru();
                            data[1] = h.getNama();
                            data[2] = h.getJabatan();
                            data[3] = h.getId_Jam();
                            data[4] = h.getFoto();
                            data[5] = h.getTugas();
                           
                        }
                     
                        Time waktu[] = new Time[1];
                        for(Hadir h : ambil){
                            waktu[0] = h.getMasukStart();
                          
                        }

                        Time longjam = Time.valueOf(jam_sekarang);

                        long lj = longjam.getTime();
                        long mm = waktu[0].getTime();
                        

                        //cek apakah pegawai tsb sudah absen masuk atau belum
                        status_hadir = kehadiran.cek_kehadiran(guru);
                        if(status_hadir == true){
                            if(mm < lj ){
                                kehadiran.masuk(guru.getNip());
                                label_NipGuru.setText(data[0]);
                                label_NamaGuru.setText(data[1]);
                                label_JabatanGuru.setText(data[2]);
                                foto_guru.setIcon((new javax.swing.ImageIcon("C:/Users/ASUS/Documents/NetBeansProjects/kkp_foto/"+data[4])));
                               // foto_guru.setIcon(new javax.swing.ImageIcon("../kkp_foto/"+data[3]));
                                foto_guru.setText("");
                                lbtugas.setText(data[5]);
                                
                                label_error_message.setText("Masuk Berhasil");
                                label_jamkerja.setText("In : " +jam_sekarang);
//                               
                                txtNip.setText("");
                                txtNip.requestFocus();

                            }
                            else{

                                label_error_message.setText("Anda tidak diperkenankan");
                            }
                        }
                    }
                       
                     
                }catch(SQLException ex){
                    label_error_message.setText("Kesalahan Database");
                }
            }
            else
            {
                label_error_message.setText("Masukan NIP");
            }
           
            txtNip.requestFocus();
             txtNip.setText("");
        }


    }//GEN-LAST:event_txtNipKeyReleased

    private void txtNip1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNip1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNip1ActionPerformed

    private void txtNip1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNip1KeyReleased
        // TODO add your handling code here:
          if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
         String nip1;
           String id_jam1;
            boolean status_guru, status_hadir;
            nip1 = txtNip1.getText();
            id_jam1= txtid_jam.getText();
            Hadir guru = new Hadir();

            guru.setNip(nip1);
            guru.setId_Jam(id_jam1);
            if(!"".equals(nip1)){
                SubmitPresensi kehadiran = new SubmitPresensi();
                try{
                    //cek apakah pegawai ada di tabel pegawai
                    status_guru = kehadiran.cek_guru(guru);
                    if(status_guru == true){
                        //cek dia harusnya masuk jam berapa
                        Date jam = new Date();

                        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                       String jam_sekarang = format.format(jam.getTime());

                        ambil = kehadiran.ambil(guru);

                        String data[] = new String[6];
                        for(Hadir h : ambil){
                            data[0] = h.getNip_guru();
                            data[1] = h.getNama();
                            data[2] = h.getJabatan();
                            data[3] = h.getId_Jam();
                            data[4] = h.getFoto();
                            data[5] = h.getTugas();
                        }
                        Time waktu[] = new Time[1];
                        for(Hadir h : ambil){
                            waktu[0] = h.getMasukStart();
                          
                        }

                        Time longjam = Time.valueOf(jam_sekarang);

                        long lj = longjam.getTime();
                        long mm = waktu[0].getTime();
                        

                        //cek apakah pegawai tsb sudah absen masuk atau belum
                        
                        status_hadir = kehadiran.cek_Keluar(guru);
                        
                         if(status_hadir == false) {

                            if(mm < lj ){
                                kehadiran.keluar(guru.getNip());
                               
                                label_NipGuru1.setText(data[0]);
                                label_NamaGuru1.setText(data[1]);
                                label_JabatanGuru1.setText(data[2]);
                                foto_guru1.setIcon((new javax.swing.ImageIcon("C:/Users/ASUS/Documents/NetBeansProjects/kkp_foto/"+data[4])));
                               // foto_guru.setIcon(new javax.swing.ImageIcon("../kkp_foto/"+data[3]));
                                foto_guru1.setText("");
                                 lbtugas1.setText(data[5]);
                               
                                label_error_message1.setText("Keluar berhasil");
                                label_jamkerja1.setText("Out : "+jam_sekarang);
                                txtNip1.setText("");
                                txtNip1.requestFocus();
                            }
                            
                            else {
                         label_error_message1.setText("Silahkan Absen Masuk Dahulu");
                        }
                       }
                    }
                   
                  

                }catch(SQLException ex){
                    label_error_message1.setText("Kesalahan Database");
                }
            }
            else
            {
                label_error_message1.setText("Masukan NIP");
            }
            txtNip1.requestFocus();
            txtNip1.setText("");
        }
    }//GEN-LAST:event_txtNip1KeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         mainPanel.setVisible(true);
         mainPanel2.setVisible(false);
    
          p_laporan_guru.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
         mainPanel2.setVisible(true);
   
         mainPanel.setVisible(false);
       
           p_laporan_guru.setVisible(false);
      
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void tbdasborMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdasborMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbdasborMouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
   
         mainPanel.setVisible(false);
          mainPanel2.setVisible(false);
        
           p_laporan_guru.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
      //  JOptionPane.showMessageDialog(null,"Keluar Aplikasi","Pesan",JOptionPane.YES_NO_OPTION);
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void label_tanggal3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_label_tanggal3FocusGained
        // TODO add your handling code here:
        TableRowSorter<TableModel>sorter= new TableRowSorter<TableModel>(((DefaultTableModel)tbdasbor.getModel()));    
        sorter.setRowFilter(RowFilter.regexFilter(label_jam3.getText()));
        tbdasbor.setRowSorter(sorter);
    }//GEN-LAST:event_label_tanggal3FocusGained

    private void txtNipFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNipFocusGained
        // TODO add your handling code here:
 
    }//GEN-LAST:event_txtNipFocusGained

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try {
            loadTblDashboard();
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(AbsensiGuru1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AbsensiGuru1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbsensiGuru1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbsensiGuru1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbsensiGuru1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AbsensiGuru1().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AbsensiGuru1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dasbor_jumlah_guru;
    private javax.swing.JLabel Dasbor_persentase_kehadiran;
    private javax.swing.JLabel foto_guru;
    private javax.swing.JLabel foto_guru1;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel label_JabatanGuru;
    private javax.swing.JLabel label_JabatanGuru1;
    private javax.swing.JLabel label_NamaGuru;
    private javax.swing.JLabel label_NamaGuru1;
    private javax.swing.JLabel label_NipGuru;
    private javax.swing.JLabel label_NipGuru1;
    private javax.swing.JLabel label_error_message;
    private javax.swing.JLabel label_error_message1;
    private javax.swing.JLabel label_jam3;
    private javax.swing.JLabel label_jamkerja;
    private javax.swing.JLabel label_jamkerja1;
    private javax.swing.JLabel label_tanggal;
    private javax.swing.JLabel label_tanggal1;
    private javax.swing.JLabel label_tanggal3;
    private javax.swing.JLabel lbtugas;
    private javax.swing.JLabel lbtugas1;
    private javax.swing.JLabel lbversi;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainPanel2;
    private javax.swing.JPanel p_laporan_guru;
    private javax.swing.JLabel tampil_jam;
    private javax.swing.JLabel tampil_jam1;
    private javax.swing.JTable tbdasbor;
    private javax.swing.JTextField txtNip;
    private javax.swing.JTextField txtNip1;
    private javax.swing.JLabel txtid_jam;
    // End of variables declaration//GEN-END:variables
private void jam() {
     Timer tt = new Timer();
     tt.scheduleAtFixedRate(new TimerTask() {
         
         @Override
         public void run() {
             tampil_jam.setText(new SimpleDateFormat("HH:mm:ss").format(new java.util.Date()));
             tampil_jam1.setText(new SimpleDateFormat("HH:mm:ss").format(new java.util.Date()));
            
            //  tampil_jam3.setText(new SimpleDateFormat("HH:mm:ss").format(new java.util.Date()));
             label_jam3.setText(new SimpleDateFormat("HH:mm:ss").format(new java.util.Date()));
                        
             
         }
     }, 0, 1000);
 }

 
}
