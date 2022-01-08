/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Renderer.TableCellRenderer;
import SessionLogin.UserID;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import controller.KoneksiDB;
import controller.ManajemenDashbord;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.*;


/**
 *
 * @author User
 */
public class MenuUtama extends javax.swing.JFrame implements Runnable  {
    
    /**
     * Creates new form MenuUtama
     */

     private Connection conn = new KoneksiDB().getKoneksi();
     //variabel text gerak
     Thread t;
        boolean kanan=true;
        boolean kiri=false;
        boolean jalan=true;
        int x,y;
        int a,b;
        
     //Tabel Kehadiran Pagi
     DefaultTableModel tabeldasbor;
    public void loadTblDashboard() throws SQLException{
       ManajemenDashbord mdtl = new ManajemenDashbord();
        mdtl.loadDataDasbor(tabeldasbor);
          // panggil method tgl agar menampilkan data dgn tgl terupdate
//        tgl();
     
        try {
            int guru = mdtl.getTotalGuru();
            Dasbor_jumlah_guru.setText(String.valueOf(guru));
            int hadir = mdtl.getJumlahGuru();
            int hari = mdtl.getTotalHari();
            double persentase = hadir / hari;
            double persentase2 = persentase / guru;
            double persentase3 = persentase2 * 100;
            DecimalFormat df = new DecimalFormat("####");        
            Dasbor_persentase_kehadiran.setText(String.valueOf((hadir))+" Data");
            Dasbor_persentase_kehadiran1.setText(String.valueOf(df.format(persentase3))+" %");
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
   
    public MenuUtama() {
        initComponents();
        ImageIcon icon = new ImageIcon("src/icon/admin.png");
        setIconImage(icon.getImage());
        
        // Agar Tabel Kehadiran Auto Update Tanggal Sehingga hanya muncul pdata pada tanggal tersebut
       txtcaritglhadir.setText(new SimpleDateFormat("dd-MMMM-yyyy").format(new java.util.Date()));

       // menampilkan form di tengah layar
        this.setLocationRelativeTo(null);
          jPanel9.setVisible(false);
          jPanel9.setEnabled(false);
          
         panel_master.setVisible(false);
         panel_master.setEnabled(false);
         panel_laporan.setVisible(false);
         panel_laporan.setEnabled(false);
         jScrollPane1.setVisible(false);
         jScrollPane1.setEnabled(false);
         jScrollPane3.setVisible(false);
         jScrollPane3.setEnabled(false);
         
         
             //Membuat TableModel Dasbor
        tabeldasbor = new DefaultTableModel();
        //menambahkan TableModel ke Tabel
        tbdasbor.setModel(tabeldasbor);  
        tabeldasbor.addColumn("TANGGAL");
        tabeldasbor.addColumn("NIP");
        tabeldasbor.addColumn("NAMA GURU");
        tabeldasbor.addColumn("JABATAN");
        tabeldasbor.addColumn("ABSEN MASUK");
        tabeldasbor.addColumn("ABSEN KELUAR");
        tbdasbor.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer());
        dasbortengah();
        headerdasbor();
       
         String KD = UserID.getUserLogin();
        lblkodeadm.setText(KD);
        lb_id_admin.setText(KD);
        
        String NM = UserID.getNamaLogin();
        lblnamaadm.setText(NM);
        
        lblnamaadm3.setText(NM);
        lb_nama_admin.setText(NM);
        
       
        //pemanggilan text bergerak kekanan dan kira
        x = textgerak.getX();
        y= textgerak.getY();
        t= new Thread(this);
        t.start();//pemanggilan text gerak
        
        
    }

     //text gerak
      @Override
    public void run() {
        getjam(); 
      while(true){
          if(jalan){
              if(x >= pgerak.getWidth()-130){
                  kiri=true;
                  kanan=false;
                
              }
               if(kiri){
                   x --;
                   textgerak.setLocation(x,y); 
              }
               if(x<=5){
                   kanan=true;
                   kiri=false;
              }
               if(kanan){
                   x++;
                   textgerak.setLocation(x,y);
              } 

       } try {
         Thread.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE,null,ex);
        }
     // repaint();
 
      }
    }
    
    public void getBackgroundColor(){
        Color c= jColorChooser1.showDialog(null,"Background Color", jDesktopPane1.getBackground());
        jDesktopPane1.setBackground(c);
        p_laporan_guru.setBackground(c);
        txtcaritglhadir.setBackground(c);
               
    }
   
   
    public void getBackgroundColorSide(){
        Color d= jColorChooser1.showDialog(null,"Panel Side",getBackground());
        panel_side.setBackground(d);
     //   Color e= jColorChooser1.showDialog(null, "Panel Menu",jPanel9.getBackground());
        jPanel9.setBackground(d);
        jPanel8.setBackground(d);
        panel_master.setBackground(d);
        pnldata.setBackground(d);
        pnldataabsen.setBackground(d);
        panel_laporan.setBackground(d);
        pnl_setting.setBackground(d);
        pnl_laporan.setBackground(d);
        pnel_top.setBackground(d);
       
    }
    public void getBackgroundTextColor(){
         Color d= jColorChooser1.showDialog(null,"Title Text Color ",getForeground());
        jLabel36.setForeground(d);
        jLabel37.setForeground(d);
        lb_id_admin.setForeground(d);
         lb_nama_admin.setForeground(d);
          lbl_tgl.setForeground(d);
           lbl_jam.setForeground(d);
           lbversi.setForeground(d);
    }
   
    public void getjam(){
       ActionListener taskPerformer = new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent evt) {
               SimpleDateFormat tgl = new SimpleDateFormat("EEEE-dd-MMM-YYYY");
               String no1_jam="";
               String no1_menit="";
               String no1_detik="";
               Date dt= new Date();
               int nilai_jam   =   dt.getHours();
               int nilai_menit =   dt.getMinutes();
               int nilai_detik =   dt.getSeconds();
               if(nilai_jam<=9){
                   no1_jam="0";
               }
               if(nilai_menit<=9){
                   no1_menit="0";
               }
               if(nilai_detik<=9){
                   no1_detik="0";
               }
               String jam = no1_jam + Integer.toString(nilai_jam);
               String menit = no1_menit + Integer.toString(nilai_menit);
               String detik = no1_detik + Integer.toString(nilai_detik);
               lbl_jam.setText("  " + jam+ " : " +menit+ " : " +detik+ "  ");
               lbl_tgl.setText(tgl.format(dt));
           }
       };
       new javax.swing.Timer(1000, taskPerformer).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jColorChooser1 = new javax.swing.JColorChooser();
        panel_side = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lb_id_admin = new javax.swing.JLabel();
        lb_nama_admin = new javax.swing.JLabel();
        lbl_tgl = new javax.swing.JLabel();
        lbl_jam = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pabsen = new javax.swing.JPanel();
        lbabsen = new javax.swing.JLabel();
        lbabsen1 = new javax.swing.JLabel();
        phome = new javax.swing.JPanel();
        lbhome = new javax.swing.JLabel();
        lbhome1 = new javax.swing.JLabel();
        pdata = new javax.swing.JPanel();
        lbdata = new javax.swing.JLabel();
        lbdata1 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        lbseting = new javax.swing.JLabel();
        lbseting1 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        lblaporan = new javax.swing.JLabel();
        lblaporan1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_laporan = new javax.swing.JPanel();
        pnl_laporan = new javax.swing.JPanel();
        b_printkartuall = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        b_printkehdiran = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        b_printizin = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        b_printketerangan = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        b_printizin1 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        b_printkartuall1 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        pnl_setting = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panel_master = new javax.swing.JPanel();
        pnldataabsen = new javax.swing.JPanel();
        babsengr = new javax.swing.JPanel();
        lbabsengr = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        babsensw = new javax.swing.JPanel();
        lbabsensw = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        babsengr1 = new javax.swing.JPanel();
        lbabsengr1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        babsensw1 = new javax.swing.JPanel();
        lbabsensw1 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        pnldata = new javax.swing.JPanel();
        badmin = new javax.swing.JPanel();
        lbadmin = new javax.swing.JLabel();
        bguru = new javax.swing.JPanel();
        lbguru = new javax.swing.JLabel();
        bguru1 = new javax.swing.JPanel();
        lbguru1 = new javax.swing.JLabel();
        pnlhome = new javax.swing.JPanel();
        badmin1 = new javax.swing.JPanel();
        lbadmin1 = new javax.swing.JLabel();
        badmin2 = new javax.swing.JPanel();
        lbadmin2 = new javax.swing.JLabel();
        pnel_top = new javax.swing.JPanel();
        lbversi = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        p_home = new javax.swing.JPanel();
        p_laporan_guru = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdasbor = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        Dasbor_persentase_kehadiran = new javax.swing.JLabel();
        Dasbor_jumlah_guru = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        Dasbor_persentase_kehadiran1 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblkodeadm = new javax.swing.JLabel();
        lblnamaadm = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        pgerak = new javax.swing.JPanel();
        textgerak = new javax.swing.JPanel();
        hh = new javax.swing.JLabel();
        textgerak1 = new javax.swing.JLabel();
        textgerak2 = new javax.swing.JLabel();
        lblnamaadm3 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtcaritglhadir = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jLabel110 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icon/admin.png")).getImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_side.setBackground(new java.awt.Color(0, 0, 102));
        panel_side.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel_side.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(0, 0, 102));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_id_admin.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_id_admin.setForeground(new java.awt.Color(255, 255, 255));
        lb_id_admin.setText("ID ADMIN");

        lb_nama_admin.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_nama_admin.setForeground(new java.awt.Color(255, 255, 255));
        lb_nama_admin.setText("NAMA ADMIN");

        lbl_tgl.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_tgl.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tgl.setText("TANGGAL");

        lbl_jam.setBackground(new java.awt.Color(255, 255, 255));
        lbl_jam.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_jam.setForeground(new java.awt.Color(255, 255, 255));
        lbl_jam.setText("JAM");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/full-time.png"))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/date.png"))); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customers.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_nama_admin)
                    .addComponent(lb_id_admin))
                .addGap(0, 49, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lb_id_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_nama_admin))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_jam)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_side.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 260, 100));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel10MousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-exit-sign-16.png"))); // NOI18N
        jLabel10.setText("Exit");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, 30));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel11MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel11MousePressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-color-wheel-25.png"))); // NOI18N
        jLabel11.setText("Warna 1");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel12MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel12MousePressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-about-16.png"))); // NOI18N
        jLabel12.setText("About");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 240, 30));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel13MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel13MousePressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        jLabel13.setText("  Logout");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 240, 30));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel14MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel14MousePressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/database.png"))); // NOI18N
        jLabel14.setText("Backup Dan Restore Database");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 240, 30));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel16MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel16MousePressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-color-wheel-25.png"))); // NOI18N
        jLabel17.setText("Warna 2");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 80, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/p_add.png"))); // NOI18N
        jLabel21.setText(" Music");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 120, 30));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel18MousePressed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-color-wheel-25.png"))); // NOI18N
        jLabel39.setText("Warna 1");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-color-wheel-25.png"))); // NOI18N
        jLabel38.setText("Title Text");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 80, 30));

        panel_side.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 40, 260, 180));

        jPanel15.setBackground(new java.awt.Color(0, 0, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-menu-25.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel16MousePressed(evt);
            }
        });
        jPanel15.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 40));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-menu-25.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });
        jPanel15.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 40));

        panel_side.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 60, 40));

        pabsen.setBackground(new java.awt.Color(255, 255, 255));
        pabsen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pabsen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pabsenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pabsenMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pabsenMousePressed(evt);
            }
        });
        pabsen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbabsen.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbabsen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-attendance-25.png"))); // NOI18N
        lbabsen.setText("Absen");
        lbabsen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbabsenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbabsenMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbabsenMousePressed(evt);
            }
        });
        pabsen.add(lbabsen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        lbabsen1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbabsen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-attendance-25.png"))); // NOI18N
        lbabsen1.setText("Absen");
        lbabsen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbabsen1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbabsen1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbabsen1MousePressed(evt);
            }
        });
        pabsen.add(lbabsen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        panel_side.add(pabsen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 80, 30));

        phome.setBackground(new java.awt.Color(255, 255, 255));
        phome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        phome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phomeMousePressed(evt);
            }
        });
        phome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbhome.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-dashboard-25.png"))); // NOI18N
        lbhome.setText("Home");
        lbhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbhomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbhomeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbhomeMousePressed(evt);
            }
        });
        phome.add(lbhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        lbhome1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbhome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-dashboard-25.png"))); // NOI18N
        lbhome1.setText("Home");
        lbhome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbhome1MousePressed(evt);
            }
        });
        phome.add(lbhome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        panel_side.add(phome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 90, -1));

        pdata.setBackground(new java.awt.Color(255, 255, 255));
        pdata.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pdataMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pdataMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pdataMousePressed(evt);
            }
        });
        pdata.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbdata.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbdata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-file-25.png"))); // NOI18N
        lbdata.setText("Data");
        lbdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbdataMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbdataMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbdataMousePressed(evt);
            }
        });
        pdata.add(lbdata, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        lbdata1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbdata1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-file-25.png"))); // NOI18N
        lbdata1.setText("Data");
        lbdata1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbdata1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbdata1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbdata1MousePressed(evt);
            }
        });
        pdata.add(lbdata1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        panel_side.add(pdata, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 90, 30));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel21MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel21MousePressed(evt);
            }
        });
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbseting.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbseting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbseting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-services-25.png"))); // NOI18N
        lbseting.setText("Setting Jam");
        lbseting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbsetingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbsetingMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbsetingMousePressed(evt);
            }
        });
        jPanel21.add(lbseting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        lbseting1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbseting1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbseting1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-services-25.png"))); // NOI18N
        lbseting1.setText("Setting Jam");
        lbseting1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbseting1MousePressed(evt);
            }
        });
        jPanel21.add(lbseting1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        panel_side.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 130, -1));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel22MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel22MousePressed(evt);
            }
        });
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblaporan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblaporan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/archives.png"))); // NOI18N
        lblaporan.setText("Laporan");
        lblaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblaporanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblaporanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblaporanMousePressed(evt);
            }
        });
        jPanel22.add(lblaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        lblaporan1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblaporan1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblaporan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/archives.png"))); // NOI18N
        lblaporan1.setText("Laporan");
        lblaporan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblaporan1MousePressed(evt);
            }
        });
        jPanel22.add(lblaporan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        panel_side.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 130, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panel_laporan.setLayout(new java.awt.CardLayout());

        pnl_laporan.setBackground(new java.awt.Color(255, 255, 255));
        pnl_laporan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b_printkartuall.setBackground(new java.awt.Color(255, 255, 255));
        b_printkartuall.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b_printkartuall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_printkartuallMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_printkartuallMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b_printkartuallMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-user-menu-male-25.png"))); // NOI18N
        jLabel2.setText("Cetak Kartu Guru");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-print-file-25.png"))); // NOI18N

        javax.swing.GroupLayout b_printkartuallLayout = new javax.swing.GroupLayout(b_printkartuall);
        b_printkartuall.setLayout(b_printkartuallLayout);
        b_printkartuallLayout.setHorizontalGroup(
            b_printkartuallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b_printkartuallLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(91, 91, 91))
        );
        b_printkartuallLayout.setVerticalGroup(
            b_printkartuallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_laporan.add(b_printkartuall, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 219, -1));

        b_printkehdiran.setBackground(new java.awt.Color(255, 255, 255));
        b_printkehdiran.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b_printkehdiran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_printkehdiranMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_printkehdiranMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b_printkehdiranMousePressed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/administrative-docs.png"))); // NOI18N
        jLabel23.setText("Cetak Data Presensi");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-print-file-25.png"))); // NOI18N

        javax.swing.GroupLayout b_printkehdiranLayout = new javax.swing.GroupLayout(b_printkehdiran);
        b_printkehdiran.setLayout(b_printkehdiranLayout);
        b_printkehdiranLayout.setHorizontalGroup(
            b_printkehdiranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(b_printkehdiranLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        b_printkehdiranLayout.setVerticalGroup(
            b_printkehdiranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        pnl_laporan.add(b_printkehdiran, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 219, 40));

        b_printizin.setBackground(new java.awt.Color(255, 255, 255));
        b_printizin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b_printizin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_printizinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_printizinMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b_printizinMousePressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-attendance-25.png"))); // NOI18N
        jLabel25.setText("Cetak Data Cuti Guru");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-print-file-25.png"))); // NOI18N

        javax.swing.GroupLayout b_printizinLayout = new javax.swing.GroupLayout(b_printizin);
        b_printizin.setLayout(b_printizinLayout);
        b_printizinLayout.setHorizontalGroup(
            b_printizinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b_printizinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        b_printizinLayout.setVerticalGroup(
            b_printizinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_laporan.add(b_printizin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 219, -1));

        b_printketerangan.setBackground(new java.awt.Color(255, 255, 255));
        b_printketerangan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b_printketerangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_printketeranganMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_printketeranganMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b_printketeranganMousePressed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-attendance-25.png"))); // NOI18N
        jLabel24.setText("Cetak Absen Siswa");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-print-file-25.png"))); // NOI18N

        javax.swing.GroupLayout b_printketeranganLayout = new javax.swing.GroupLayout(b_printketerangan);
        b_printketerangan.setLayout(b_printketeranganLayout);
        b_printketeranganLayout.setHorizontalGroup(
            b_printketeranganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b_printketeranganLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        b_printketeranganLayout.setVerticalGroup(
            b_printketeranganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_laporan.add(b_printketerangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 219, 40));

        b_printizin1.setBackground(new java.awt.Color(255, 255, 255));
        b_printizin1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b_printizin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_printizin1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_printizin1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b_printizin1MousePressed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-attendance-25.png"))); // NOI18N
        jLabel42.setText("Cetak Data Izin Guru");

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-print-file-25.png"))); // NOI18N

        javax.swing.GroupLayout b_printizin1Layout = new javax.swing.GroupLayout(b_printizin1);
        b_printizin1.setLayout(b_printizin1Layout);
        b_printizin1Layout.setHorizontalGroup(
            b_printizin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b_printizin1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        b_printizin1Layout.setVerticalGroup(
            b_printizin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(b_printizin1Layout.createSequentialGroup()
                .addComponent(jLabel43)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        pnl_laporan.add(b_printizin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 219, -1));

        b_printkartuall1.setBackground(new java.awt.Color(255, 255, 255));
        b_printkartuall1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b_printkartuall1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_printkartuall1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_printkartuall1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b_printkartuall1MousePressed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-user-menu-male-25.png"))); // NOI18N
        jLabel44.setText("Cetak Form Piket Guru");

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-print-file-25.png"))); // NOI18N

        javax.swing.GroupLayout b_printkartuall1Layout = new javax.swing.GroupLayout(b_printkartuall1);
        b_printkartuall1.setLayout(b_printkartuall1Layout);
        b_printkartuall1Layout.setHorizontalGroup(
            b_printkartuall1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, b_printkartuall1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel44)
                .addGap(91, 91, 91))
        );
        b_printkartuall1Layout.setVerticalGroup(
            b_printkartuall1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_laporan.add(b_printkartuall1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 219, 40));

        panel_laporan.add(pnl_laporan, "card2");

        pnl_setting.setBackground(new java.awt.Color(255, 255, 255));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel31MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel31MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel31MousePressed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-time-25.png"))); // NOI18N
        jLabel26.setText("Setting Jam Hadir");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-settings-25.png"))); // NOI18N

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout pnl_settingLayout = new javax.swing.GroupLayout(pnl_setting);
        pnl_setting.setLayout(pnl_settingLayout);
        pnl_settingLayout.setHorizontalGroup(
            pnl_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_settingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_settingLayout.setVerticalGroup(
            pnl_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_settingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        panel_laporan.add(pnl_setting, "card3");

        jScrollPane1.setViewportView(panel_laporan);

        panel_side.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 260, 140));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/microsoft-logo-24.png"))); // NOI18N
        panel_side.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/graphic-design.png"))); // NOI18N
        panel_side.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/apple-logo-24.png"))); // NOI18N
        panel_side.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/facebook-logo-24.png"))); // NOI18N
        panel_side.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/google-logo-24.png"))); // NOI18N
        panel_side.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        panel_master.setBackground(new java.awt.Color(204, 204, 204));
        panel_master.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        panel_master.setLayout(new java.awt.CardLayout());

        pnldataabsen.setBackground(new java.awt.Color(255, 255, 255));
        pnldataabsen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnldataabsen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        babsengr.setBackground(new java.awt.Color(255, 255, 255));
        babsengr.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        babsengr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                babsengrMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                babsengrMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                babsengrMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                babsengrMousePressed(evt);
            }
        });
        babsengr.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbabsengr.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbabsengr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-teacher-25.png"))); // NOI18N
        lbabsengr.setText("Cuti Guru");
        babsengr.add(lbabsengr, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 2, 140, 36));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-attendance-25.png"))); // NOI18N
        babsengr.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, 30));

        pnldataabsen.add(babsengr, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 40));

        babsensw.setBackground(new java.awt.Color(255, 255, 255));
        babsensw.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        babsensw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                babsenswMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                babsenswMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                babsenswMousePressed(evt);
            }
        });
        babsensw.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbabsensw.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbabsensw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-student-male-25.png"))); // NOI18N
        lbabsensw.setText("Absen Siswa");
        babsensw.add(lbabsensw, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 2, 104, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-attendance-25.png"))); // NOI18N
        babsensw.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, 30));

        pnldataabsen.add(babsensw, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 220, 40));

        babsengr1.setBackground(new java.awt.Color(255, 255, 255));
        babsengr1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        babsengr1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                babsengr1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                babsengr1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                babsengr1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                babsengr1MousePressed(evt);
            }
        });
        babsengr1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbabsengr1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbabsengr1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-teacher-25.png"))); // NOI18N
        lbabsengr1.setText("Izin Guru");
        babsengr1.add(lbabsengr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 2, 140, 36));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-attendance-25.png"))); // NOI18N
        babsengr1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, 30));

        pnldataabsen.add(babsengr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 220, 40));

        babsensw1.setBackground(new java.awt.Color(255, 255, 255));
        babsensw1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        babsensw1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                babsensw1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                babsensw1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                babsensw1MousePressed(evt);
            }
        });
        babsensw1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbabsensw1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbabsensw1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/date.png"))); // NOI18N
        lbabsensw1.setText(" Jadwal Piket Guru");
        babsensw1.add(lbabsensw1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 2, 140, 30));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-attendance-25.png"))); // NOI18N
        babsensw1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, 30));

        pnldataabsen.add(babsensw1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 220, 40));

        panel_master.add(pnldataabsen, "card3");

        pnldata.setBackground(new java.awt.Color(255, 255, 255));
        pnldata.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnldata.setPreferredSize(new java.awt.Dimension(230, 317));
        pnldata.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        badmin.setBackground(new java.awt.Color(255, 255, 255));
        badmin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        badmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                badminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                badminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                badminMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                badminMousePressed(evt);
            }
        });

        lbadmin.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbadmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customers.png"))); // NOI18N
        lbadmin.setText(" Data Admin");

        javax.swing.GroupLayout badminLayout = new javax.swing.GroupLayout(badmin);
        badmin.setLayout(badminLayout);
        badminLayout.setHorizontalGroup(
            badminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(badminLayout.createSequentialGroup()
                .addComponent(lbadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 107, Short.MAX_VALUE))
        );
        badminLayout.setVerticalGroup(
            badminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbadmin, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        pnldata.add(badmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 40));

        bguru.setBackground(new java.awt.Color(255, 255, 255));
        bguru.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bguru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bguruMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bguruMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bguruMousePressed(evt);
            }
        });

        lbguru.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbguru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-teacher-25.png"))); // NOI18N
        lbguru.setText("Data Guru");

        javax.swing.GroupLayout bguruLayout = new javax.swing.GroupLayout(bguru);
        bguru.setLayout(bguruLayout);
        bguruLayout.setHorizontalGroup(
            bguruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bguruLayout.createSequentialGroup()
                .addComponent(lbguru, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 119, Short.MAX_VALUE))
        );
        bguruLayout.setVerticalGroup(
            bguruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbguru, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        pnldata.add(bguru, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 220, 40));

        bguru1.setBackground(new java.awt.Color(255, 255, 255));
        bguru1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bguru1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bguru1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bguru1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bguru1MousePressed(evt);
            }
        });

        lbguru1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbguru1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-teacher-25.png"))); // NOI18N
        lbguru1.setText("Data Siswa");

        javax.swing.GroupLayout bguru1Layout = new javax.swing.GroupLayout(bguru1);
        bguru1.setLayout(bguru1Layout);
        bguru1Layout.setHorizontalGroup(
            bguru1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bguru1Layout.createSequentialGroup()
                .addComponent(lbguru1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 119, Short.MAX_VALUE))
        );
        bguru1Layout.setVerticalGroup(
            bguru1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbguru1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        pnldata.add(bguru1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 220, 40));

        panel_master.add(pnldata, "card2");

        pnlhome.setBackground(new java.awt.Color(255, 255, 255));

        badmin1.setBackground(new java.awt.Color(255, 255, 255));
        badmin1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        badmin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                badmin1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                badmin1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                badmin1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                badmin1MousePressed(evt);
            }
        });

        lbadmin1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbadmin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-increase-35.png"))); // NOI18N
        lbadmin1.setText("Data Kehadiran Guru");

        javax.swing.GroupLayout badmin1Layout = new javax.swing.GroupLayout(badmin1);
        badmin1.setLayout(badmin1Layout);
        badmin1Layout.setHorizontalGroup(
            badmin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(badmin1Layout.createSequentialGroup()
                .addComponent(lbadmin1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
        );
        badmin1Layout.setVerticalGroup(
            badmin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbadmin1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        badmin2.setBackground(new java.awt.Color(255, 255, 255));
        badmin2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        badmin2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                badmin2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                badmin2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                badmin2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                badmin2MousePressed(evt);
            }
        });

        lbadmin2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbadmin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-student-male-25.png"))); // NOI18N
        lbadmin2.setText("Data Kelas Siswa");

        javax.swing.GroupLayout badmin2Layout = new javax.swing.GroupLayout(badmin2);
        badmin2.setLayout(badmin2Layout);
        badmin2Layout.setHorizontalGroup(
            badmin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(badmin2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbadmin2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        badmin2Layout.setVerticalGroup(
            badmin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbadmin2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlhomeLayout = new javax.swing.GroupLayout(pnlhome);
        pnlhome.setLayout(pnlhomeLayout);
        pnlhomeLayout.setHorizontalGroup(
            pnlhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlhomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(badmin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(badmin2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlhomeLayout.setVerticalGroup(
            pnlhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlhomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(badmin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(badmin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        panel_master.add(pnlhome, "card4");

        jScrollPane3.setViewportView(panel_master);

        panel_side.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 260, 160));

        getContentPane().add(panel_side, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 710));

        pnel_top.setBackground(new java.awt.Color(0, 0, 102));
        pnel_top.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnel_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbversi.setFont(new java.awt.Font("Lucida G", 3, 12)); // NOI18N
        lbversi.setForeground(new java.awt.Color(255, 255, 255));
        lbversi.setText(" Dashboard V .1 .0");
        pnel_top.add(lbversi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 120, 20));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Smk PGRI 28 Jakarta Timur");
        pnel_top.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1030, -1));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Sistem Informasi  Kehadiran Guru");
        pnel_top.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1030, -1));

        getContentPane().add(pnel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 1040, 110));

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setEnabled(false);

        p_laporan_guru.setBackground(new java.awt.Color(255, 255, 255));
        p_laporan_guru.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jScrollPane2FocusGained(evt);
            }
        });

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
        tbdasbor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbdasborPropertyChange(evt);
            }
        });
        tbdasbor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbdasborKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbdasbor);

        p_laporan_guru.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 700, 370));

        jLabel22.setBackground(new java.awt.Color(204, 204, 0));
        jLabel22.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("DATA PRESENSI");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel22.setOpaque(true);
        p_laporan_guru.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, 260, 30));

        Dasbor_persentase_kehadiran.setBackground(new java.awt.Color(255, 102, 102));
        Dasbor_persentase_kehadiran.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        Dasbor_persentase_kehadiran.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Dasbor_persentase_kehadiran.setText("-");
        Dasbor_persentase_kehadiran.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Dasbor_persentase_kehadiran.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Dasbor_persentase_kehadiran.setOpaque(true);
        p_laporan_guru.add(Dasbor_persentase_kehadiran, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 130, -1));

        Dasbor_jumlah_guru.setBackground(new java.awt.Color(255, 102, 102));
        Dasbor_jumlah_guru.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        Dasbor_jumlah_guru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Dasbor_jumlah_guru.setText("-");
        Dasbor_jumlah_guru.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Dasbor_jumlah_guru.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Dasbor_jumlah_guru.setOpaque(true);
        p_laporan_guru.add(Dasbor_jumlah_guru, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 290, 260, -1));

        jLabel63.setBackground(new java.awt.Color(51, 255, 51));
        jLabel63.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Persentase");
        jLabel63.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel63.setOpaque(true);
        p_laporan_guru.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 210, 130, 20));

        jLabel64.setBackground(new java.awt.Color(51, 255, 51));
        jLabel64.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Jumlah Presensi");
        jLabel64.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel64.setOpaque(true);
        p_laporan_guru.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, 130, 20));

        Dasbor_persentase_kehadiran1.setBackground(new java.awt.Color(153, 255, 255));
        Dasbor_persentase_kehadiran1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        Dasbor_persentase_kehadiran1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Dasbor_persentase_kehadiran1.setText("-");
        Dasbor_persentase_kehadiran1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Dasbor_persentase_kehadiran1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Dasbor_persentase_kehadiran1.setOpaque(true);
        p_laporan_guru.add(Dasbor_persentase_kehadiran1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 230, 130, -1));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Kode Admin");
        jLabel53.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        p_laporan_guru.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 490, 130, 20));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Nama Admin");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        p_laporan_guru.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 490, 130, 20));

        lblkodeadm.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        lblkodeadm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblkodeadm.setText("kode");
        lblkodeadm.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        p_laporan_guru.add(lblkodeadm, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, 130, 20));

        lblnamaadm.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        lblnamaadm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnamaadm.setText("nama");
        lblnamaadm.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        p_laporan_guru.add(lblnamaadm, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 510, 130, 20));

        jLabel108.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customers.png"))); // NOI18N
        jLabel108.setText("Admin Login");
        jLabel108.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        p_laporan_guru.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, 260, 20));

        jLabel109.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/20180716093058.png"))); // NOI18N
        jLabel109.setText("Logo");
        p_laporan_guru.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 160, 150));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel28.setOpaque(true);
        p_laporan_guru.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, 260, 210));

        jLabel65.setBackground(new java.awt.Color(204, 204, 0));
        jLabel65.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("JUMLAH DATA GURU");
        jLabel65.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel65.setOpaque(true);
        p_laporan_guru.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, 260, 30));

        jLabel66.setBackground(new java.awt.Color(255, 255, 255));
        jLabel66.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel66.setOpaque(true);
        p_laporan_guru.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 280, 370));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-microsoft-excel-25.png"))); // NOI18N
        jButton7.setText("Export ( Excel 2003 )");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        p_laporan_guru.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 170, 30));

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/issue.png"))); // NOI18N
        jButton8.setText("Cek Absensi");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        p_laporan_guru.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 140, 30));

        pgerak.setBackground(new java.awt.Color(0, 0, 0));
        pgerak.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textgerak.setBackground(new java.awt.Color(0, 0, 0));
        textgerak.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        textgerak.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hh.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        hh.setForeground(new java.awt.Color(255, 255, 255));
        hh.setText("Selamat Datang ..! ");
        textgerak.add(hh, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 0, 140, -1));

        textgerak1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        textgerak1.setForeground(new java.awt.Color(255, 255, 255));
        textgerak1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textgerak1.setText("Di Aplikasi Manajemen Absensi ..!");
        textgerak.add(textgerak1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 270, -1));

        textgerak2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        textgerak2.setForeground(new java.awt.Color(255, 255, 255));
        textgerak2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textgerak2.setText(">>>>>>>>> Pgri 28 Jkt <<<<<<<<<");
        textgerak.add(textgerak2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 290, 20));

        lblnamaadm3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblnamaadm3.setForeground(new java.awt.Color(255, 255, 255));
        lblnamaadm3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnamaadm3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customers.png"))); // NOI18N
        lblnamaadm3.setText(" -");
        textgerak.add(lblnamaadm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 270, 20));

        javax.swing.GroupLayout pgerakLayout = new javax.swing.GroupLayout(pgerak);
        pgerak.setLayout(pgerakLayout);
        pgerakLayout.setHorizontalGroup(
            pgerakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pgerakLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(textgerak, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(677, Short.MAX_VALUE))
        );
        pgerakLayout.setVerticalGroup(
            pgerakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pgerakLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textgerak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        p_laporan_guru.add(pgerak, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 990, 110));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel29.setText("www.unindra.ac.id");
        p_laporan_guru.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 580, -1, 20));

        txtcaritglhadir.setEditable(false);
        txtcaritglhadir.setBackground(new java.awt.Color(255, 255, 255));
        txtcaritglhadir.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtcaritglhadir.setBorder(null);
        txtcaritglhadir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcaritglhadirFocusGained(evt);
            }
        });
        txtcaritglhadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaritglhadirActionPerformed(evt);
            }
        });
        txtcaritglhadir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcaritglhadirKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcaritglhadirKeyReleased(evt);
            }
        });
        p_laporan_guru.add(txtcaritglhadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, 160, 30));

        jButton13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-trash-25.png"))); // NOI18N
        jButton13.setText("Hapus Data ");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton13MousePressed(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        p_laporan_guru.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 550, 160, 40));

        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-pay-date-48.png"))); // NOI18N
        p_laporan_guru.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, -1, 50));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/unindra.png"))); // NOI18N
        p_laporan_guru.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 550, 40, 40));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel40.setText("Develop By Team KKP Unindra 2021  ");
        p_laporan_guru.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, -1, -1));

        javax.swing.GroupLayout p_homeLayout = new javax.swing.GroupLayout(p_home);
        p_home.setLayout(p_homeLayout);
        p_homeLayout.setHorizontalGroup(
            p_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
            .addGroup(p_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(p_laporan_guru, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE))
        );
        p_homeLayout.setVerticalGroup(
            p_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
            .addGroup(p_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p_homeLayout.createSequentialGroup()
                    .addComponent(p_laporan_guru, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jDesktopPane1.setLayer(p_home, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(p_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 1040, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        // TODO add your handling code here:
        jLabel10.setForeground(Color.white);
        jPanel10.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        // TODO add your handling code here:
       jLabel10.setForeground(Color.black);
        jPanel10.setBackground(new Color(255,255,255));
        
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jPanel10MousePressed

    private void jPanel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseEntered
        // TODO add your handling code here:
         jLabel14.setForeground(Color.white);
        jPanel14.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_jPanel14MouseEntered

    private void jPanel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseExited
        // TODO add your handling code here:
       jLabel14.setForeground(Color.black);
        jPanel14.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jPanel14MouseExited

    private void jPanel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseEntered
        // TODO add your handling code here:
        jLabel13.setForeground(Color.white);
        jPanel13.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_jPanel13MouseEntered

    private void jPanel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseExited
        // TODO add your handling code here:
        jLabel13.setForeground(Color.black);
        jPanel13.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jPanel13MouseExited

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
        // TODO add your handling code here:
        jLabel12.setForeground(Color.white);
        jPanel12.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_jPanel12MouseEntered

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
        // TODO add your handling code here:
        jLabel12.setForeground(Color.black);
        jPanel12.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jPanel12MouseExited

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        // TODO add your handling code here:
        jLabel11.setForeground(Color.white);
        jPanel11.setBackground(new Color(255,102,0));

    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        // TODO add your handling code here:
      jLabel11.setForeground(Color.black);
        jPanel11.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jPanel11MouseExited

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        // TODO add your handling code here:
        jPanel15.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        // TODO add your handling code here:
      jPanel15.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MousePressed
        // TODO add your handling code here:
        ImageIcon AS =  new ImageIcon(getClass().getResource("/icon/icons8-scroll-up-25.png"));
        jLabel15.setIcon(AS);
        jLabel15.setVisible(true);
        jLabel15.setEnabled(true);
        jLabel16.setVisible(false);
         jLabel16.setEnabled(false);
         jPanel9.setVisible(true);
          jPanel9.setEnabled(true);
    }//GEN-LAST:event_jLabel16MousePressed

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
         jLabel16.setVisible(true);
        jLabel16.setEnabled(true);
        jLabel15.setVisible(false);
        jLabel15.setEnabled(false);
       
        jPanel9.setVisible(false);
        jPanel9.setEnabled(false);
    }//GEN-LAST:event_jLabel15MousePressed

    private void pdataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdataMouseEntered
        // TODO add your handling code here:
       
    }//GEN-LAST:event_pdataMouseEntered

    private void pdataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdataMouseExited
        // TODO add your handling code here:
         
    }//GEN-LAST:event_pdataMouseExited

    private void pabsenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pabsenMouseEntered
        // TODO add your handling code here:
         
    }//GEN-LAST:event_pabsenMouseEntered

    private void pabsenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pabsenMouseExited
        // TODO add your handling code here:
      
    }//GEN-LAST:event_pabsenMouseExited

    private void pdataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdataMousePressed
        // TODO add your handling code here:
 
    }//GEN-LAST:event_pdataMousePressed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jLabel16MouseClicked

    private void pabsenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pabsenMousePressed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_pabsenMousePressed

    private void lbdataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbdataMouseEntered
        // TODO add your handling code here:
            pdata.setBackground(new Color(255,102,0));
            
    }//GEN-LAST:event_lbdataMouseEntered

    private void lbdataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbdataMousePressed
        // TODO add your handling code here:
        ImageIcon AS =  new ImageIcon(getClass().getResource("/icon/icons8-scroll-up-25.png"));
        lbdata1.setIcon(AS);
        lbdata1.setVisible(true);
        lbdata1.setEnabled(true);
        lbdata.setVisible(false);
        lbdata.setEnabled(false);
         jScrollPane3.setVisible(true);
        jScrollPane3.setEnabled(true);
        panel_master.setVisible(true);
        panel_master.setEnabled(true);
        pnldata.setVisible(true);
        pnldata.setEnabled(true);
         pnldataabsen.setVisible(false);
        pnldataabsen.setEnabled(false);
        pnlhome.setVisible(false);
        pnlhome.setEnabled(false);
         ImageIcon AB =  new ImageIcon(getClass().getResource("/icon/icons8-attendance-25.png"));
        lbabsen1.setIcon(AB);
        ImageIcon AC =  new ImageIcon(getClass().getResource("/icon/icons8-dashboard-25.png"));
        lbhome1.setIcon(AC);
       // icons8-dashboard-25.png
    }//GEN-LAST:event_lbdataMousePressed

    private void lbdata1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbdata1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbdata1MouseEntered

    private void lbdata1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbdata1MousePressed
        // TODO add your handling code here:
        lbdata1.setVisible(false);
        lbdata1.setEnabled(false);
        lbdata.setVisible(true);
        lbdata.setEnabled(true);
        pnldataabsen.setVisible(false);
        pnldataabsen.setEnabled(false);
         jScrollPane3.setVisible(false);
        jScrollPane3.setEnabled(false);
        pnldata.setVisible(false);
        pnldata.setEnabled(false);
        pnlhome.setVisible(false);
        pnlhome.setEnabled(false);
        panel_master.setVisible(false);
        panel_master.setEnabled(false);
    }//GEN-LAST:event_lbdata1MousePressed

    private void lbdataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbdataMouseExited
        // TODO add your handling code here:
          pdata.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_lbdataMouseExited

    private void lbdata1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbdata1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbdata1MouseExited

    private void lbabsenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbabsenMouseEntered
        // TODO add your handling code here:
         pabsen.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_lbabsenMouseEntered

    private void lbabsenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbabsenMouseExited
        // TODO add your handling code here:
           pabsen.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_lbabsenMouseExited

    private void lbabsen1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbabsen1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbabsen1MouseEntered

    private void lbabsen1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbabsen1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbabsen1MouseExited

    private void lbabsenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbabsenMousePressed
        // TODO add your handling code here:
          ImageIcon AS =  new ImageIcon(getClass().getResource("/icon/icons8-scroll-up-25.png"));
        lbabsen1.setIcon(AS);
        lbabsen1.setVisible(true);
        lbabsen1.setEnabled(true);
        lbabsen.setVisible(false);
        lbabsen.setEnabled(false);
         jScrollPane3.setVisible(true);
        jScrollPane3.setEnabled(true);
        panel_master.setVisible(true);
        panel_master.setEnabled(true);
        pnldataabsen.setVisible(true);
        pnldataabsen.setEnabled(true);
         pnldata.setVisible(false);
        pnldata.setEnabled(false);
         pnlhome.setVisible(false);
        pnlhome.setEnabled(false);
        ImageIcon AC =  new ImageIcon(getClass().getResource("/icon/icons8-dashboard-25.png"));
        lbhome1.setIcon(AC);
       ImageIcon AB =  new ImageIcon(getClass().getResource("/icon/icons8-file-25.png"));
        lbdata1.setIcon(AB);
    }//GEN-LAST:event_lbabsenMousePressed

    private void lbabsen1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbabsen1MousePressed
        // TODO add your handling code here:
        
        lbabsen1.setVisible(false);
        lbabsen1.setEnabled(false);
        lbabsen.setVisible(true);
        lbabsen.setEnabled(true);
        pnldataabsen.setVisible(false);
        pnldataabsen.setEnabled(false);
        panel_master.setVisible(false);
        panel_master.setEnabled(false);
         jScrollPane3.setVisible(false);
        jScrollPane3.setEnabled(false);
         pnldata.setVisible(false);
        pnldata.setEnabled(false);
    }//GEN-LAST:event_lbabsen1MousePressed

    private void badminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badminMouseEntered
        // TODO add your handling code here:
         lbadmin.setForeground(Color.white);
        badmin.setBackground(new Color(255,102,0));

    }//GEN-LAST:event_badminMouseEntered

    private void badminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badminMouseExited
        // TODO add your handling code here:
        lbadmin.setForeground(Color.black);
        badmin.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_badminMouseExited

    private void bguruMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bguruMouseEntered
        // TODO add your handling code here:
        lbguru.setForeground(Color.white);
        bguru.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_bguruMouseEntered

    private void bguruMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bguruMouseExited
        // TODO add your handling code here:
       lbguru.setForeground(Color.black);
        bguru.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_bguruMouseExited

    private void babsengrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_babsengrMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_babsengrMouseClicked

    private void babsengrMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_babsengrMouseEntered
        // TODO add your handling code here:
          lbabsengr.setForeground(Color.white);
        babsengr.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_babsengrMouseEntered

    private void babsengrMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_babsengrMouseExited
        // TODO add your handling code here:
        lbabsengr.setForeground(Color.black);
        babsengr.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_babsengrMouseExited

    private void babsenswMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_babsenswMouseEntered
        // TODO add your handling code here:
        lbabsensw.setForeground(Color.white);
        babsensw.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_babsenswMouseEntered

    private void babsenswMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_babsenswMouseExited
        // TODO add your handling code here:
         lbabsensw.setForeground(Color.black);
        babsensw.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_babsenswMouseExited

    private void jPanel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseEntered
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jPanel22MouseEntered

    private void jPanel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel22MouseExited

    private void jPanel22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel22MousePressed

    private void jPanel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseEntered
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jPanel21MouseEntered

    private void jPanel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MousePressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jPanel21MousePressed

    private void jPanel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseExited
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jPanel21MouseExited

    private void lblaporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaporanMouseEntered
        // TODO add your handling code here:
       //lblaporan.setForeground(Color.white);
        jPanel22.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_lblaporanMouseEntered

    private void lblaporanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaporanMouseExited
        // TODO add your handling code here:
            jPanel22.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_lblaporanMouseExited

    private void lblaporanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaporanMousePressed
        // TODO add your handling code here:
         ImageIcon AS =  new ImageIcon(getClass().getResource("/icon/icons8-scroll-up-25.png"));
        lblaporan1.setIcon(AS);
        lblaporan1.setVisible(true);
        lblaporan1.setEnabled(true);
        lblaporan.setVisible(false);
        lblaporan.setEnabled(false);
        panel_laporan.setVisible(true);
        panel_laporan.setEnabled(true);
        jScrollPane1.setVisible(true);
        jScrollPane1.setEnabled(true);
        pnl_laporan.setVisible(true);
        pnl_laporan.setEnabled(true);
         pnl_setting.setVisible(false);
        pnl_setting.setEnabled(false);
           
         ImageIcon AB =  new ImageIcon(getClass().getResource("/icon/icons8-services-25.png"));
        lbseting1.setIcon(AB);
    }//GEN-LAST:event_lblaporanMousePressed

    private void lblaporan1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaporan1MousePressed
        // TODO add your handling code here:
       lblaporan1.setVisible(false);
        lblaporan1.setEnabled(false);
        lblaporan.setVisible(true);
        lblaporan.setEnabled(true);
      panel_laporan.setVisible(false);
        panel_laporan.setEnabled(false);
        jScrollPane1.setVisible(false);
        jScrollPane1.setEnabled(false);
        pnl_laporan.setVisible(false);
        pnl_laporan.setEnabled(false);
         pnl_setting.setVisible(false);
        pnl_setting.setEnabled(false);
    }//GEN-LAST:event_lblaporan1MousePressed

    private void lbsetingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbsetingMouseEntered
        // TODO add your handling code here:
        jPanel21.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_lbsetingMouseEntered

    private void lbsetingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbsetingMouseExited
        // TODO add your handling code here:
         jPanel21.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_lbsetingMouseExited

    private void lbsetingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbsetingMousePressed
        // TODO add your handling code here:
        ImageIcon AS =  new ImageIcon(getClass().getResource("/icon/icons8-scroll-up-25.png"));
        lbseting1.setIcon(AS);
        lbseting1.setVisible(true);
        lbseting1.setEnabled(true);
        lbseting.setVisible(false);
        lbseting.setEnabled(false);
        panel_laporan.setVisible(true);
        panel_laporan.setEnabled(true);
        jScrollPane1.setVisible(true);
        jScrollPane1.setEnabled(true);
        pnl_laporan.setVisible(false);
        pnl_laporan.setEnabled(false);
         pnl_setting.setVisible(true);
        pnl_setting.setEnabled(true);
           
         ImageIcon AB =  new ImageIcon(getClass().getResource("/icon/archives.png"));
        lblaporan1.setIcon(AB);
    }//GEN-LAST:event_lbsetingMousePressed

    private void lbseting1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbseting1MousePressed
        // TODO add your handling code here:
          lbseting1.setVisible(false);
        lbseting1.setEnabled(false);
        lbseting.setVisible(true);
        lbseting.setEnabled(true);
      panel_laporan.setVisible(false);
        panel_laporan.setEnabled(false);
        jScrollPane1.setVisible(false);
        jScrollPane1.setEnabled(false);
        pnl_laporan.setVisible(false);
        pnl_laporan.setEnabled(false);
         pnl_setting.setVisible(false);
        pnl_setting.setEnabled(false);
    }//GEN-LAST:event_lbseting1MousePressed

    private void jPanel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MousePressed
        // TODO add your handling code here:
        getBackgroundColor();
    }//GEN-LAST:event_jPanel11MousePressed

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        // TODO add your handling code here:
         jLabel17.setForeground(Color.white);
        jPanel16.setBackground(new Color(255,102,0));

    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseExited
        // TODO add your handling code here:
        jLabel17.setForeground(Color.black);
        jPanel16.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jPanel16MouseExited

    private void jPanel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MousePressed
        // TODO add your handling code here:
        getBackgroundColorSide();
    }//GEN-LAST:event_jPanel16MousePressed

    private void b_printkartuallMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printkartuallMouseEntered
        // TODO add your handling code here:
        jLabel2.setForeground(Color.white);
        b_printkartuall.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_b_printkartuallMouseEntered

    private void b_printkartuallMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printkartuallMouseExited
        // TODO add your handling code here:
          jLabel2.setForeground(Color.black);
        b_printkartuall.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_b_printkartuallMouseExited

    private void b_printkehdiranMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printkehdiranMouseEntered
        // TODO add your handling code here:
          jLabel23.setForeground(Color.white);
        b_printkehdiran.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_b_printkehdiranMouseEntered

    private void b_printkehdiranMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printkehdiranMouseExited
        // TODO add your handling code here:
          jLabel23.setForeground(Color.black);
        b_printkehdiran.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_b_printkehdiranMouseExited

    private void b_printketeranganMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printketeranganMouseEntered
        // TODO add your handling code here:
          jLabel24.setForeground(Color.white);
        b_printketerangan.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_b_printketeranganMouseEntered

    private void b_printketeranganMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printketeranganMouseExited
        // TODO add your handling code here:
          jLabel24.setForeground(Color.black);
        b_printketerangan.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_b_printketeranganMouseExited

    private void b_printizinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printizinMouseEntered
        // TODO add your handling code here:
          jLabel25.setForeground(Color.white);
        b_printizin.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_b_printizinMouseEntered

    private void b_printizinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printizinMouseExited
        // TODO add your handling code here:
         jLabel25.setForeground(Color.black);
        b_printizin.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_b_printizinMouseExited

    private void jPanel31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel31MouseEntered
        // TODO add your handling code here:
        jLabel26.setForeground(Color.white);
       jPanel31.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_jPanel31MouseEntered

    private void jPanel31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel31MouseExited
        // TODO add your handling code here:
        jLabel26.setForeground(Color.black);
        jPanel31.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jPanel31MouseExited

    private void badminMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badminMousePressed
     
        
    }//GEN-LAST:event_badminMousePressed

    private void bguruMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bguruMousePressed
        // TODO add your handling code here:
           try {
            // TODO add your handling code here:
            FormGuru f= new FormGuru();
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(f);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
        
            f.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bguruMousePressed

    private void badminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badminMouseClicked
      
        try {
            FormAdmin f= new FormAdmin();
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(f);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            f.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
    }//GEN-LAST:event_badminMouseClicked

    private void babsengrMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_babsengrMousePressed
        // TODO add your handling code here:
          try {
            FormAbsenGuru f= new FormAbsenGuru();
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(f);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            f.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_babsengrMousePressed

    private void babsenswMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_babsenswMousePressed
        // TODO add your handling code here:
        try {
          FormAbsenSiswa f= new FormAbsenSiswa();
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(f);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            f.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_babsenswMousePressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
         jLabel21.setForeground(Color.white);
        jPanel1.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        // TODO add your handling code here:
         jLabel21.setForeground(Color.black);
        jPanel1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jPanel1MouseExited

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
      Utama m = new Utama();
    
            m.setVisible(true);
    }//GEN-LAST:event_jPanel1MousePressed

    private void tbdasborMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdasborMouseClicked
        // TODO add your handling code here:
        //tbdasbor.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer());
    }//GEN-LAST:event_tbdasborMouseClicked

    private void tbdasborPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbdasborPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_tbdasborPropertyChange

    private void tbdasborKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbdasborKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_tbdasborKeyPressed

    private void jScrollPane2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScrollPane2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2FocusGained

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try {
            loadTblDashboard();
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
 
    

    }//GEN-LAST:event_jButton13ActionPerformed

    private void txtcaritglhadirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcaritglhadirKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcaritglhadirKeyReleased

    private void txtcaritglhadirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcaritglhadirKeyPressed
        // TODO add your handling code here:\   
    }//GEN-LAST:event_txtcaritglhadirKeyPressed

    private void txtcaritglhadirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcaritglhadirFocusGained
        // TODO add your handling code here:
    
    }//GEN-LAST:event_txtcaritglhadirFocusGained

    private void txtcaritglhadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaritglhadirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcaritglhadirActionPerformed

    private void badmin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badmin1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_badmin1MouseClicked

    private void badmin1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badmin1MouseEntered
        // TODO add your handling code here:
         lbadmin1.setForeground(Color.white);
        badmin1.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_badmin1MouseEntered

    private void badmin1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badmin1MouseExited
        // TODO add your handling code here:
        lbadmin1.setForeground(Color.black);
        badmin1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_badmin1MouseExited

    private void badmin1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badmin1MousePressed
        // TODO add your handling code here:
 
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(p_laporan_guru);
            p_laporan_guru.setVisible(true);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
    }//GEN-LAST:event_badmin1MousePressed

    private void lbhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbhomeMouseEntered
        // TODO add your handling code here:
         phome.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_lbhomeMouseEntered

    private void lbhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbhomeMouseExited
        // TODO add your handling code here:
         phome.setBackground(new Color(255,255,255));
         
    }//GEN-LAST:event_lbhomeMouseExited

    private void lbhomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbhomeMousePressed
        // TODO add your handling code here:
         ImageIcon AS =  new ImageIcon(getClass().getResource("/icon/icons8-scroll-up-25.png"));
        lbhome1.setIcon(AS);
        lbhome1.setVisible(true);
        lbdata1.setEnabled(true);
        lbhome.setVisible(false);
        lbhome.setEnabled(false);
        jScrollPane3.setVisible(true);
        jScrollPane3.setEnabled(true);
        panel_master.setVisible(true);
        panel_master.setEnabled(true);
        pnldata.setVisible(false);
        pnldata.setEnabled(false);
         pnldataabsen.setVisible(false);
        pnldataabsen.setEnabled(false);
        pnlhome.setVisible(true);
        pnlhome.setEnabled(true);
         ImageIcon AB =  new ImageIcon(getClass().getResource("/icon/icons8-attendance-25.png"));
        lbabsen1.setIcon(AB);
        ImageIcon AC =  new ImageIcon(getClass().getResource("/icon/icons8-file-25.png"));
        lbdata1.setIcon(AC);
    }//GEN-LAST:event_lbhomeMousePressed

    private void lbhome1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbhome1MousePressed
        // TODO add your handling code here:
        lbhome1.setVisible(false);
        lbhome1.setEnabled(false);
        lbhome.setVisible(true);
        lbhome.setEnabled(true);
        pnldataabsen.setVisible(false);
        pnldataabsen.setEnabled(false);
        jScrollPane3.setVisible(false);
        jScrollPane3.setEnabled(false);

        pnldata.setVisible(false);
        pnldata.setEnabled(false);
        pnlhome.setVisible(false);
        pnlhome.setEnabled(false);
        panel_master.setVisible(false);
        panel_master.setEnabled(false);
    }//GEN-LAST:event_lbhome1MousePressed

    private void jPanel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MousePressed
        // TODO add your handling code here:
            BackupRestore f= new BackupRestore();
            f.setVisible(true);
       
    }//GEN-LAST:event_jPanel14MousePressed

    private void jPanel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseEntered

    private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseExited

    private void jPanel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MousePressed

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // TODO add your handling code here:
         jLabel38.setForeground(Color.white);
        jPanel2.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        // TODO add your handling code here:
        jLabel38.setForeground(Color.black);
        jPanel2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        getBackgroundTextColor();
    }//GEN-LAST:event_jPanel2MousePressed

    private void b_printkartuallMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printkartuallMousePressed
        CetakKartuSemua c = new CetakKartuSemua();
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(c);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
        
            c.setVisible(true);
        
    }//GEN-LAST:event_b_printkartuallMousePressed

    private void b_printkehdiranMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printkehdiranMousePressed
        // TODO add your handling code here:
         CetakKehadiranGuru c = new CetakKehadiranGuru();
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(c);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
        
            c.setVisible(true);
    }//GEN-LAST:event_b_printkehdiranMousePressed

    private void b_printketeranganMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printketeranganMousePressed
        // TODO add your handling code here:
         CetakAbsenSiswa c = new CetakAbsenSiswa();
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(c);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
        
            c.setVisible(true);
    }//GEN-LAST:event_b_printketeranganMousePressed

    private void b_printizinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printizinMousePressed
        // TODO add your handling code here:
           CetakIzinGuru c = new CetakIzinGuru();
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(c);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
        
            c.setVisible(true);
    }//GEN-LAST:event_b_printizinMousePressed

    private void jPanel31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel31MousePressed
         try {
             // TODO add your handling code here:
             FormSettingJam c = new FormSettingJam();
             jDesktopPane1.removeAll();
             jDesktopPane1.repaint();
             jDesktopPane1.revalidate();
             jDesktopPane1.add(c);
             jDesktopPane1.repaint();
             jDesktopPane1.revalidate();
             
             c.setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jPanel31MousePressed

    private void jButton13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MousePressed
         try {
             // TODO add your handling code here:
             FormSettingJam c = new FormSettingJam();
             jDesktopPane1.removeAll();
             jDesktopPane1.repaint();
             jDesktopPane1.revalidate();
             jDesktopPane1.add(c);
             jDesktopPane1.repaint();
             jDesktopPane1.revalidate();
             
             c.setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton13MousePressed

    private void jPanel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MousePressed
        // TODO add your handling code here:
             About a = new About();
             jDesktopPane1.removeAll();
             jDesktopPane1.repaint();
             jDesktopPane1.revalidate();
             jDesktopPane1.add(a);
             jDesktopPane1.repaint();
             jDesktopPane1.revalidate();
             
             a.setVisible(true);
    }//GEN-LAST:event_jPanel12MousePressed

    private void jPanel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MousePressed
        // TODO add your handling code here:
        Login lo = new Login();
        this.dispose();
        lo.setVisible(true);
        lo.show();
    }//GEN-LAST:event_jPanel13MousePressed

    private void babsengr1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_babsengr1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_babsengr1MouseClicked

    private void babsengr1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_babsengr1MouseEntered
        // TODO add your handling code here:
         lbabsengr1.setForeground(Color.white);
        babsengr1.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_babsengr1MouseEntered

    private void babsengr1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_babsengr1MouseExited
        // TODO add your handling code here:
        lbabsengr1.setForeground(Color.black);
        babsengr1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_babsengr1MouseExited

    private void babsengr1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_babsengr1MousePressed
        // TODO add your handling code here:
         try {
            FormIzinGuru f= new FormIzinGuru();
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(f);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            f.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_babsengr1MousePressed

    private void b_printizin1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printizin1MouseEntered
        // TODO add your handling code here:
                jLabel42.setForeground(Color.white);
        b_printizin1.setBackground(new Color(255,102,0));

    }//GEN-LAST:event_b_printizin1MouseEntered

    private void b_printizin1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printizin1MouseExited
        // TODO add your handling code here:
           jLabel42.setForeground(Color.black);
        b_printizin1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_b_printizin1MouseExited

    private void b_printizin1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printizin1MousePressed
        // TODO add your handling code here:
         CetakKeteranganIzin c = new CetakKeteranganIzin();
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(c);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
        
            c.setVisible(true);
    }//GEN-LAST:event_b_printizin1MousePressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int option = fc.showSaveDialog(MenuUtama.this);
        if (option== JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getName();
            String path = fc.getSelectedFile().getParentFile().getPath();
            int len = filename.length();
            String ext="";
            String file = "";
            if (len > 4) {
                ext = filename.substring(len-4, len);

            }
            if (ext.equals(".xls")) {
                file = path + "\\" + filename+ "";

            }else{
                file = path + "\\" + filename+ ".xls";
            }
            toExcel(tbdasbor, new File(file));
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void bguru1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bguru1MouseEntered
        // TODO add your handling code here:
        lbguru1.setForeground(Color.white);
        bguru1.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_bguru1MouseEntered

    private void bguru1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bguru1MouseExited
        // TODO add your handling code here:
        lbguru1.setForeground(Color.black);
        bguru1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_bguru1MouseExited

    private void bguru1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bguru1MousePressed
        // TODO add your handling code here:
             try {
            // TODO add your handling code here:
            FormSiswa f= new FormSiswa();
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(f);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
        
            f.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bguru1MousePressed

    private void badmin2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badmin2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_badmin2MouseClicked

    private void badmin2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badmin2MouseEntered
        // TODO add your handling code here:
         lbadmin2.setForeground(Color.white);
        badmin2.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_badmin2MouseEntered

    private void badmin2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badmin2MouseExited
        // TODO add your handling code here:
         lbadmin2.setForeground(Color.black);
        badmin2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_badmin2MouseExited

    private void badmin2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_badmin2MousePressed
        // TODO add your handling code here:
         try {
          FormKelas f= new FormKelas();
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(f);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            f.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_badmin2MousePressed

    private void babsensw1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_babsensw1MouseEntered
        // TODO add your handling code here:
        lbabsensw1.setForeground(Color.white);
        babsensw1.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_babsensw1MouseEntered

    private void babsensw1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_babsensw1MouseExited
        // TODO add your handling code here:
        lbabsensw1.setForeground(Color.black);
        babsensw1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_babsensw1MouseExited

    private void babsensw1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_babsensw1MousePressed
        // TODO add your handling code here:
            try {
          FormPiketGuru f= new FormPiketGuru();
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(f);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            f.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_babsensw1MousePressed

    private void b_printkartuall1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printkartuall1MouseEntered
        // TODO add your handling code here:
        jLabel44.setForeground(Color.white);
        b_printkartuall1.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_b_printkartuall1MouseEntered

    private void b_printkartuall1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printkartuall1MouseExited
        // TODO add your handling code here:
           jLabel44.setForeground(Color.black);
        b_printkartuall1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_b_printkartuall1MouseExited

    private void b_printkartuall1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_printkartuall1MousePressed
        // TODO add your handling code here:
         CetakDataPiket c = new CetakDataPiket();
            jDesktopPane1.removeAll();
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
            jDesktopPane1.add(c);
            jDesktopPane1.repaint();
            jDesktopPane1.revalidate();
        
            c.setVisible(true);
    }//GEN-LAST:event_b_printkartuall1MousePressed

    private void phomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phomeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phomeMousePressed

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
           UIManager.setLookAndFeel(new McWinLookAndFeel());
                 //"com.jtattoo.plaf.hifi.HiFiLookAndFeel " com.jtattoo.plaf.mcwin.McWinLookAndFeel
      
      } catch (Exception ex) {
            ex.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dasbor_jumlah_guru;
    private javax.swing.JLabel Dasbor_persentase_kehadiran;
    private javax.swing.JLabel Dasbor_persentase_kehadiran1;
    private javax.swing.JPanel b_printizin;
    private javax.swing.JPanel b_printizin1;
    private javax.swing.JPanel b_printkartuall;
    private javax.swing.JPanel b_printkartuall1;
    private javax.swing.JPanel b_printkehdiran;
    private javax.swing.JPanel b_printketerangan;
    private javax.swing.JPanel babsengr;
    private javax.swing.JPanel babsengr1;
    private javax.swing.JPanel babsensw;
    private javax.swing.JPanel babsensw1;
    private javax.swing.JPanel badmin;
    private javax.swing.JPanel badmin1;
    private javax.swing.JPanel badmin2;
    private javax.swing.JPanel bguru;
    private javax.swing.JPanel bguru1;
    private javax.swing.JLabel hh;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_id_admin;
    private javax.swing.JLabel lb_nama_admin;
    private javax.swing.JLabel lbabsen;
    private javax.swing.JLabel lbabsen1;
    private javax.swing.JLabel lbabsengr;
    private javax.swing.JLabel lbabsengr1;
    private javax.swing.JLabel lbabsensw;
    private javax.swing.JLabel lbabsensw1;
    private javax.swing.JLabel lbadmin;
    private javax.swing.JLabel lbadmin1;
    private javax.swing.JLabel lbadmin2;
    private javax.swing.JLabel lbdata;
    private javax.swing.JLabel lbdata1;
    private javax.swing.JLabel lbguru;
    private javax.swing.JLabel lbguru1;
    private javax.swing.JLabel lbhome;
    private javax.swing.JLabel lbhome1;
    private javax.swing.JLabel lbl_jam;
    private javax.swing.JLabel lbl_tgl;
    private javax.swing.JLabel lblaporan;
    private javax.swing.JLabel lblaporan1;
    private javax.swing.JLabel lblkodeadm;
    private javax.swing.JLabel lblnamaadm;
    private javax.swing.JLabel lblnamaadm3;
    private javax.swing.JLabel lbseting;
    private javax.swing.JLabel lbseting1;
    private javax.swing.JLabel lbversi;
    private javax.swing.JPanel p_home;
    private javax.swing.JPanel p_laporan_guru;
    private javax.swing.JPanel pabsen;
    private javax.swing.JPanel panel_laporan;
    private javax.swing.JPanel panel_master;
    private javax.swing.JPanel panel_side;
    private javax.swing.JPanel pdata;
    private javax.swing.JPanel pgerak;
    private javax.swing.JPanel phome;
    private javax.swing.JPanel pnel_top;
    private javax.swing.JPanel pnl_laporan;
    private javax.swing.JPanel pnl_setting;
    private javax.swing.JPanel pnldata;
    private javax.swing.JPanel pnldataabsen;
    private javax.swing.JPanel pnlhome;
    private javax.swing.JTable tbdasbor;
    private javax.swing.JPanel textgerak;
    private javax.swing.JLabel textgerak1;
    private javax.swing.JLabel textgerak2;
    private javax.swing.JTextField txtcaritglhadir;
    // End of variables declaration//GEN-END:variables
protected void nama(){
           
        try {
            String sql = "SELECT * FROM admin WHERE id_admin='"+lblkodeadm.getText()+"' AND  nama_admin='"+lblnamaadm.getText()+"'";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
               lblkodeadm.setText(hasil.getString("id_admin"));
               lblnamaadm.setText(hasil.getString("nama_admin"));
               lb_id_admin.setText(hasil.getString("id_admin"));
              
               lblnamaadm3.setText(hasil.getString("nama_admin"));
               lb_nama_admin.setText(hasil.getString("nama_admin"));
              
            }
           } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Di Panggil"+e);
        }
       }
   public void dasbortengah(){
           DefaultTableCellRenderer center = new DefaultTableCellRenderer();
            center.setHorizontalAlignment(SwingConstants.CENTER);
             tbdasbor.getColumnModel().getColumn(0).setCellRenderer(center);
              tbdasbor.getColumnModel().getColumn(1).setCellRenderer(center);
         tbdasbor.getColumnModel().getColumn(2).setCellRenderer(center);
        tbdasbor.getColumnModel().getColumn(3).setCellRenderer(center);
        tbdasbor.getColumnModel().getColumn(4).setCellRenderer(center);
        tbdasbor.getColumnModel().getColumn(5).setCellRenderer(center);
      
     }
   
   public void headerdasbor(){
         Font font = new Font("Times New Roman", Font.BOLD, 12);
         JTableHeader header = tbdasbor.getTableHeader();
         header.setFont(font); 
         header.setBackground(Color.CYAN);
      }
   // pencarian tglyg update dengan row sorter
//   public void tgl(){
//       TableRowSorter<TableModel>sorter= new TableRowSorter<TableModel>(((DefaultTableModel)tbdasbor.getModel()));
//        sorter.setRowFilter(RowFilter.regexFilter(txtcaritglhadir.getText()));
//        tbdasbor.setRowSorter(sorter); 
//   }
   
    private void toExcel(JTable table, File file) {
        
        try {
            TableModel model = tbdasbor.getModel();
            FileWriter excel = new FileWriter(file);
            for (int i = 0; i < model.getColumnCount(); i++) {
                excel.write(model.getColumnName(i)+"\t");
                
            }
            excel.write("\n");
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    excel.write(model.getValueAt(i, j).toString()+"\t");
                    
                }
                excel.write("\n");
            }
            excel.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
