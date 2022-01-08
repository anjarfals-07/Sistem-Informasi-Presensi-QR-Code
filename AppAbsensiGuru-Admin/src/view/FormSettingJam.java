/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Renderer.TableCellRenderer;
import controller.KoneksiDB;
import controller.ManajemenDashbord;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ModelKehadiran;

/**
 *
 * @author User
 */
public class FormSettingJam extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormSettingJam
     */
        private DefaultTableModel tabmode;
          private Connection conn = new KoneksiDB().getKoneksi();
          
     DefaultTableModel tabeldasborhadir;
    public void loadTblDashboarhadir() throws SQLException{
       ManajemenDashbord h = new ManajemenDashbord();
        h.loaadData(tabeldasborhadir);
        
    }

    public FormSettingJam() throws SQLException {
        initComponents();
         
         
         tabeldasborhadir = new DefaultTableModel();
        //menambahkan TableModel ke Tabel
        tbdatahadir.setModel(tabeldasborhadir); 
      
        tabeldasborhadir.addColumn("TANGGAL");
        tabeldasborhadir.addColumn("NIP");
        tabeldasborhadir.addColumn("NAMA GURU");
        tabeldasborhadir.addColumn("JABATAN");
        tabeldasborhadir.addColumn("ABSEN MASUK");
        tabeldasborhadir.addColumn("ABSEN KELUAR");
        tbdatahadir.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer());
         hadirtengah();
         headerhadir();
         
          loadTblDashboarhadir();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_setting = new javax.swing.JPanel();
        jdtglhadir = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbdatahadir = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        btn_hapusdata1 = new javax.swing.JButton();
        jLabel111 = new javax.swing.JLabel();
        txtcaritgl = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Setting");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-services-25.png"))); // NOI18N

        p_setting.setBackground(new java.awt.Color(255, 255, 255));

        jdtglhadir.setDateFormatString(" yyyy-MM-dd");
        jdtglhadir.setEnabled(false);

        tbdatahadir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbdatahadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdatahadirMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbdatahadir);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("SETTING TABLE  KEHADIRAN");

        btn_hapusdata1.setBackground(new java.awt.Color(255, 255, 255));
        btn_hapusdata1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_hapusdata1.setForeground(new java.awt.Color(255, 0, 0));
        btn_hapusdata1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-trash-25.png"))); // NOI18N
        btn_hapusdata1.setText("Hapus Data Per Tanggal");
        btn_hapusdata1.setToolTipText("Menghapus data yang terseleksi");
        btn_hapusdata1.setFocusPainted(false);
        btn_hapusdata1.setRequestFocusEnabled(false);
        btn_hapusdata1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusdata1ActionPerformed(evt);
            }
        });

        jLabel111.setBackground(new java.awt.Color(255, 255, 255));
        jLabel111.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel111.setText("DATA SETTING");
        jLabel111.setOpaque(true);

        txtcaritgl.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        txtcaritgl.setToolTipText("");
        txtcaritgl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcaritglKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-more-25.png"))); // NOI18N

        javax.swing.GroupLayout p_settingLayout = new javax.swing.GroupLayout(p_setting);
        p_setting.setLayout(p_settingLayout);
        p_settingLayout.setHorizontalGroup(
            p_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_settingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(p_settingLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jdtglhadir, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_hapusdata1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(p_settingLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcaritgl, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        p_settingLayout.setVerticalGroup(
            p_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_settingLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(p_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcaritgl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdtglhadir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapusdata1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_setting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_setting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbdatahadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdatahadirMouseClicked
        // TODO add your handling code here:
        //txtanip.setEnabled(false);
        jdtglhadir.setEnabled(false);
        // radaizin.setEnabled(false);
        //radacuti.setEnabled(false);
        // txtaketerangan.setEnabled(false);

        //cek apakah salah satu baris sudah diklik
        int i = tbdatahadir.getSelectedRow();
        if(i== -1){
            //tidak melakukan apa-apa
            return;
        }

        /*
        mengambil isi dari tabel yang di klik, lalu menampilkannya
        * di field-field
        */

        // String No_rec_absen = (tabeldasborhadir.getValueAt(i, 0)).toString();
        // txtkode.setText(No_rec_absen);

        Date tanggal = ( Date )tabeldasborhadir.getValueAt(i, 0);
        jdtglhadir.setDate(tanggal);

        // String nip = (String) tabelabsen.getValueAt(i, 2);
        // txtanip.setText(nip)
        ///String keterangan = (String) tabelabsen.getValueAt(i, 6);
        //txtaketerangan.setText(keterangan);

        // String foto = (String) tabelabsen.getValueAt(i, 7);
        // img_foto_absen.setIcon((new javax.swing.ImageIcon("C:/Users/ASUS/Documents/NetBeansProjects/kkp_foto/"+foto)));
        // img_foto_absen.setIcon((new javax.swing.ImageIcon("../kkp_foto/"+foto)));
    }//GEN-LAST:event_tbdatahadirMouseClicked

    private void btn_hapusdata1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusdata1ActionPerformed
        // TODO add your handling code here:
        int i = tbdatahadir.getSelectedRow();
        if(i== -1){
            return;
        }
        // int no = Integer.parseInt(txtkode.getText());
        ModelKehadiran mod = new ModelKehadiran();
        String tgl_hadir = "";
        if(jdtglhadir.getDate() != null){
            SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
            tgl_hadir = Format.format(jdtglhadir.getDate());
        }
        mod.setTgl(tgl_hadir);
        int konfirmasiHapus = JOptionPane.showConfirmDialog(rootPane, "Apakah anda yakin akan menghapus data absensi tersebut?", "Hapus Pegawai", JOptionPane.YES_NO_OPTION);
        if(konfirmasiHapus == JOptionPane.YES_OPTION){
            try{
                ManajemenDashbord mana = new ManajemenDashbord();
                mana.hapusAbsensi(mod);
                JOptionPane.showMessageDialog(rootPane, "Data berhasil dihapus", "Berhasil Menghapus Data",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(rootPane, "Terjadi kesalahan menghapus data","Kesalahan Menghapus Data",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(FormSettingJam.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                  //  loadTblDashboard();
                  //  loadTblDashboards();
                   // loadTblDashboardTelat();
                   loadTblDashboarhadir();

                    jdtglhadir.setDate(null);

                } catch (SQLException ex) {
                    Logger.getLogger(FormSettingJam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_hapusdata1ActionPerformed

    private void txtcaritglKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcaritglKeyReleased
        // TODO add your handling code here:
         TableRowSorter<TableModel>sorter= new TableRowSorter<TableModel>(((DefaultTableModel)tbdatahadir.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(txtcaritgl.getText().toString()));
        tbdatahadir.setRowSorter(sorter);
    }//GEN-LAST:event_txtcaritglKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapusdata1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JScrollPane jScrollPane4;
    private com.toedter.calendar.JDateChooser jdtglhadir;
    private javax.swing.JPanel p_setting;
    private javax.swing.JTable tbdatahadir;
    private javax.swing.JFormattedTextField txtcaritgl;
    // End of variables declaration//GEN-END:variables
  public void hadirtengah(){
           DefaultTableCellRenderer center = new DefaultTableCellRenderer();
            center.setHorizontalAlignment(SwingConstants.CENTER);
        tbdatahadir.getColumnModel().getColumn(0).setCellRenderer(center);
        tbdatahadir.getColumnModel().getColumn(1).setCellRenderer(center);
        tbdatahadir.getColumnModel().getColumn(2).setCellRenderer(center);
        tbdatahadir.getColumnModel().getColumn(3).setCellRenderer(center);
        tbdatahadir.getColumnModel().getColumn(4).setCellRenderer(center);
        tbdatahadir.getColumnModel().getColumn(5).setCellRenderer(center);
      
         
     }
 
  
 
      public void headerhadir(){
         Font font = new Font("Times New Roman", Font.BOLD, 12);
         JTableHeader header = tbdatahadir.getTableHeader();
         header.setFont(font); 
         header.setBackground(Color.CYAN);
      }


}
