/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import SessionLogin.UserID;
import controller.KoneksiDB;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author User
 */
public class CetakKehadiranGuru extends javax.swing.JInternalFrame {

    /**
     * Creates new form CetakKehadiranGuru
     */
     private Connection conn = new KoneksiDB().getKoneksi();
     
    public CetakKehadiranGuru() {
        initComponents();
           String KD = UserID.getUserLogin();
        lb_id_admin.setText(KD);
        String NM = UserID.getNamaLogin();
        lb_nama_admin.setText(NM);
      
    }
     public void runReportDefault(String sourcefilename, HashMap hash) {
        //Connection con = KoneksiDB.getKoneksi();
        try {
            InputStream report;
            report = getClass().getResourceAsStream(sourcefilename);
           JasperPrint jprint = JasperFillManager.fillReport(report,hash, conn);
           JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setFitPageZoomRatio();
            viewer.setVisible(true);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_laporan_harian = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jdtgl2 = new com.toedter.calendar.JDateChooser();
        jLabel117 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jdtgl1 = new com.toedter.calendar.JDateChooser();
        jLabel120 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jcal_tanggalhadir = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lb_id_admin = new javax.swing.JLabel();
        lb_nama_admin = new javax.swing.JLabel();

        setTitle("Cetak Data Absen Guru");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-attendance-25.png"))); // NOI18N

        p_laporan_harian.setBackground(new java.awt.Color(255, 255, 255));
        p_laporan_harian.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel30.setText("Form Cetak Data Absensi Guru ");
        p_laporan_harian.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));
        p_laporan_harian.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 24, -1, -1));

        jLabel119.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/20180716093058.png"))); // NOI18N
        jLabel119.setText("Logo");
        p_laporan_harian.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 160, 150));

        jPanel2.setBackground(new java.awt.Color(0, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cetak Absensi Periode", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel116.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel116.setText("TANGGAL :");

        jdtgl2.setDateFormatString("dd MMM, yyyy");

        jLabel117.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel117.setText(" TANGGAL :");

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 0, 0));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-print-file-25.png"))); // NOI18N
        jButton15.setText("Cetak Laporan Periode");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jdtgl1.setDateFormatString("dd MMM, yyyy");

        jLabel120.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel120.setText("S/D");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel116)
                    .addComponent(jLabel117))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jdtgl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jdtgl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel120)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jdtgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel120, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdtgl2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel117, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        p_laporan_harian.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 350, 170));

        jPanel3.setBackground(new java.awt.Color(0, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cetak Absensi Harian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel123.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel123.setText("TANGGAL :");

        jcal_tanggalhadir.setDateFormatString("dd MMM, yyyy");

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 51));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-print-file-25.png"))); // NOI18N
        jButton4.setText("Cetak Laporan Harian");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel123)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcal_tanggalhadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcal_tanggalhadir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        p_laporan_harian.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, 170));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Pengguna.png"))); // NOI18N

        lb_id_admin.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_id_admin.setForeground(new java.awt.Color(204, 0, 0));
        lb_id_admin.setText("ID ADMIN");

        lb_nama_admin.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_nama_admin.setForeground(new java.awt.Color(204, 0, 0));
        lb_nama_admin.setText("NAMA ADMIN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_id_admin)
                    .addComponent(lb_nama_admin))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_id_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_nama_admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        p_laporan_harian.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 883, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(p_laporan_harian, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(p_laporan_harian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        Connection con = KoneksiDB.getKoneksi();

        String NamaFile = "/report/report_bulanan.jasper";
        HashMap hash = new HashMap();
        try {

            hash.put("tgl1", jdtgl1.getDate());
            hash.put("tgl2", jdtgl2.getDate());
             hash.put("adm", lb_nama_admin.getText());

            runReportDefault(NamaFile,hash);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

      

        Connection con = KoneksiDB.getKoneksi();
        String NamaFile = "/report/reportharian.jasper";
        HashMap hash = new HashMap();
        try {
            hash.put("tanggalhadir", jcal_tanggalhadir.getDate()); 
            hash.put("adm", lb_nama_admin.getText());
            
           
            runReportDefault(NamaFile, hash);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JDateChooser jcal_tanggalhadir;
    private com.toedter.calendar.JDateChooser jdtgl1;
    private com.toedter.calendar.JDateChooser jdtgl2;
    private javax.swing.JLabel lb_id_admin;
    private javax.swing.JLabel lb_nama_admin;
    private javax.swing.JPanel p_laporan_harian;
    // End of variables declaration//GEN-END:variables
protected void nama(){
           
        try {
            String sql = "SELECT * FROM admin WHERE id_admin='"+lb_id_admin.getText()+"' AND  nama_admin='"+lb_nama_admin.getText()+"'";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
              
               lb_id_admin.setText(hasil.getString("id_admin"));
               lb_nama_admin.setText(hasil.getString("nama_admin"));
              
            }
           } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Di Panggil"+e);
        }
       }

}
