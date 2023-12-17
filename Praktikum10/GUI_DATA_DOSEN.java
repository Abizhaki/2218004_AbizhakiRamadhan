/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Praktikum10;

import Praktikum9.*;
import Praktikum8.*;
import Praktikum7.*;
import Praktikum6.*;
import Praktikum5.*;
import Praktikum4.*;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTableModel; 
/**
 *
 * @author LENOVO
 */
public class GUI_DATA_DOSEN extends javax.swing.JFrame {
String kode1, nama1, no_hp1;
public Connection conn;

public  GUI_DATA_DOSEN(){
    initComponents();
    tampil();
}
  // variabel koneksi
    public void koneksi() throws SQLException {      
   
        try {
           conn=null;
           Class.forName("com.mysql.cj.jdbc.Driver");
           conn= DriverManager.getConnection("jdbc:mysql://localhost/oop_syllabusonline?user=root&password=");
        }
        catch (ClassNotFoundException ex){
            Logger.getLogger(GUI_DATA_DOSEN.class.getName()).log(Level.SEVERE,null, ex);
        }
        catch (SQLException e) {
             Logger.getLogger(GUI_DATA_DOSEN.class.getName()).log(Level.SEVERE,null, e);
        }
        catch (Exception es) {
            Logger.getLogger(GUI_DATA_DOSEN.class.getName()).log(Level.SEVERE,null, es);
        }
    }

    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("Kode MK");
        tabelhead.addColumn("Nama Dosen");
        tabelhead.addColumn("No HP");
        try {
            koneksi();
            String sql = "SELECT * FROM data_dosen"; //membuat variabel sql untuk menyimpan perintah select from
            Statement stat = conn.createStatement(); //membuat statement
            ResultSet res = stat.executeQuery(sql);//mengeksekusi isi dari variabel sql
            while(res.next()){ // menggeser ke baris berikutnya 
                tabelhead.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3)});
            }
            txttabel.setModel(tabelhead);//mengambil data dari while untuk dieksekusi
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
    public void refresh(){
    new GUI_DATA_DOSEN().setVisible(true);
        this.setVisible(false);
    }
    public void insert(){
        DataDosenNoHP dsn = new DataDosenNoHP ();
        String Kode  = txtKode.getText();
        try {
       koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO data_dosen(Kode, Nama, No_Hp)" 
                                    +"VALUES('"+Kode+"','"+dsn.DataDosen(txtKode.getText())+"','"+dsn.DataNoHP(txtKode.getText())+"')");
            statement.close(); 
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Dosen!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }
    
 public void update(){
        DataDosenNoHP dsn = new DataDosenNoHP ();
        String Kode  = txtKode.getText();
//        String Nama  = dsn.DataDosen(Kode);
//        String No_HP= dsn.DataNoHP(Kode);
        String Kodelama = kode1;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE data_dosen SET Kode='"+Kode+"'," + "Nama='"+dsn.DataDosen(Kode)+"'"
                    + ",No_HP='"+dsn.DataNoHP(Kode)+"'WHERE Kode = '"+Kodelama+"'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Dosen!");
        } catch (Exception e) {
            System.out.println("Error : "+e);
        }
        refresh();
}   
public void delete(){
    int ok=JOptionPane.showConfirmDialog(null,"Apakah Anda yakin akan menghapus data ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
    if(ok==0){
        try{
            String sql="DELETE FROM data_dosen WHERE Kode='"+txtKode.getText()+"'";
            java.sql.PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil di hapus");
            batal();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data gagal di hapus");
        }
        }
        refresh();
}

public void cari(){
    String Kode = txtKode.getText();
    try{
        try (Statement statement = conn.createStatement()) {
            DataDosenNoHP dsn = new DataDosenNoHP();
            String sql="SELECT * FROM data_dosen WHERE `Kode`  LIKE '%"+txtCari.getText()+"%'";
            ResultSet rs=statement.executeQuery(sql); //menampilkan data dari sql query
            if(rs.next()) // .next() = scanner method
            {
                txtKode.setText(rs.getString(1));
            }
            else{
            JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
            }
        }
        }catch (Exception ex){
            System.out.println("Error."+ex);
        }
    }
public void itempilih(){
    DataDosenNoHP dsn = new DataDosenNoHP();
        txtKode.setText(kode1);
        
}
//private DefaultTableModel tabeltampil;
//    void DATABASE(){
//    tabeltampil.getDataVector().removeAllElements(); // mengkosongkan isi dalam form
//    tabeltampil.fireTableDataChanged();
//    try{
//        Connection c = tes_koneksi.koneksi();
//        Statement s = c.createStatement();
//        String sql = "SELECT*FROM data_dosen";
//        ResultSet r = s.executeQuery(sql);
//        while(r.next()){
//            Object[] kolom = new Object[3];
//            kolom[0]=r.getString("Kode_MK");
//            kolom[1]=r.getString("Nama_Dosen");
//            kolom[2]=r.getString("No HP");
//         tabeltampil.addRow(kolom);
//        }
//        r.close();
//        s.close();
//    }
//    catch(SQLException a){
//        JOptionPane.showMessageDialog(null, "gagal koneksi"+a.getMessage());
//    }
//    }
//    /**
//     * Creates new form GUI_DATA_DOSEN
//     */
//    public GUI_DATA_DOSEN() {
//        initComponents();
//        tabeltampil = new DefaultTableModel();
//        txttabel.setModel(tabeltampil);
//        tabeltampil.addColumn("Kode MK");
//        tabeltampil.addColumn("Nama");
//        tabeltampil.addColumn("No HP");
//     DATABASE();
//    }
//    
//    int x =0;
    
  
    void batal(){
        txtKode.setText("");
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtTombol = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCombo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txttabel = new javax.swing.JTable();
        txtbatal = new javax.swing.JButton();
        txthapus = new javax.swing.JButton();
        txtubah = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        txtCari = new javax.swing.JButton();
        txtcek = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("KODE MK");

        txtTombol.setText("Tampilkan");
        txtTombol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTombolActionPerformed(evt);
            }
        });

        jLabel2.setText("DATA DOSEN");

        txtCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IF110", "IF210", "IF310", "IF410" }));
        txtCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComboActionPerformed(evt);
            }
        });

        txttabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Kode MK", "Nama Dosen", "No HP"
            }
        ));
        txttabel.setToolTipText("");
        txttabel.setShowHorizontalLines(true);
        txttabel.setShowVerticalLines(true);
        txttabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(txttabel);

        txtbatal.setText("Batal");
        txtbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbatalActionPerformed(evt);
            }
        });

        txthapus.setText("Hapus");
        txthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthapusActionPerformed(evt);
            }
        });

        txtubah.setText("Ubah");
        txtubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtubahActionPerformed(evt);
            }
        });

        txtCari.setText("Cari");
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });

        txtcek.setText("Cek");
        txtcek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtcek)
                                .addGap(18, 18, 18)
                                .addComponent(txtubah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txthapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbatal))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(64, 64, 64)
                                        .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(txtCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTombol)
                                        .addGap(95, 95, 95)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCari)))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addComponent(txtTombol, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCari))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbatal)
                    .addComponent(txthapus)
                    .addComponent(txtubah)
                    .addComponent(txtcek))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTombolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTombolActionPerformed
        // TODO add your handling code here:
        insert();
        
//        DataDosenNoHP dsn = new DataDosenNoHP ();
////        txttabel.setValueAt(txtKode.getText(), x, 0);
//        // txttabel.setText(" ");
//       // txttabel.append(dsn.DataDosen(txtKode.getText()));
//       try{
//            String sql="INSERT INTO data_dosen VALUES('"+txtKode.getText()+"','"+dsn.DataDosen(txtKode.getText())+"','"+dsn.DataNoHP(txtKode.getText())+"')";
//            java.sql.Connection conn=(Connection)tes_koneksi.koneksi();
//            java.sql.PreparedStatement pstm=conn.prepareStatement(sql);
//            pstm.execute();
//            JOptionPane.showMessageDialog(this, "data berhasil di tambahkan");
//            DATABASE();
//        } catch (HeadlessException | SQLException e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        }finally{
//        batal();
    }//GEN-LAST:event_txtTombolActionPerformed
    
    private void txtComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComboActionPerformed
        // TODO add your handling code here:
        switch(txtCombo.getSelectedIndex()){
            case 0 : txtKode.setText((String) txtCombo.getSelectedItem()); break;
            case 1 : txtKode.setText((String) txtCombo.getSelectedItem()); break;
            case 2 : txtKode.setText((String) txtCombo.getSelectedItem()); break;
            case 3 : txtKode.setText((String) txtCombo.getSelectedItem()); break;
        }
    }//GEN-LAST:event_txtComboActionPerformed

    private void txtbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbatalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_txtbatalActionPerformed

    private void txtcekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcekActionPerformed
        // TODO add your handling code here:
        try{
            if("IF110".equals(txtKode.getText())){
                
                throw new Exception ();
            }else if("IF210".equals(txtKode.getText())){
                throw new Exception ();
            }else if("IF310".equals(txtKode.getText())){
                throw new Exception ();
            }else if("IF410".equals(txtKode.getText())){
                throw new Exception ();
            }
            
        }
        catch(Exception a){
            JOptionPane.showMessageDialog(null, "Masukkan Input \n"+a);
        }
     
    }//GEN-LAST:event_txtcekActionPerformed

    private void txttabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttabelMouseClicked
        // TODO add your handling code here:
        int tabel = txttabel.getSelectedRow();
        kode1 = txttabel.getValueAt(tabel, 0).toString();
        nama1 = txttabel.getValueAt(tabel, 1).toString();
        no_hp1 = txttabel.getValueAt(tabel, 2).toString();
        itempilih();
    }//GEN-LAST:event_txttabelMouseClicked

    private void txtubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtubahActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_txtubahActionPerformed

    private void txthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_txthapusActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_txtCariActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_DATA_DOSEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_DATA_DOSEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_DATA_DOSEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_DATA_DOSEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_DATA_DOSEN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton txtCari;
    private javax.swing.JComboBox<String> txtCombo;
    private javax.swing.JTextField txtKode;
    private javax.swing.JButton txtTombol;
    private javax.swing.JButton txtbatal;
    private javax.swing.JTextField txtcari;
    private javax.swing.JButton txtcek;
    private javax.swing.JButton txthapus;
    private javax.swing.JTable txttabel;
    private javax.swing.JButton txtubah;
    // End of variables declaration//GEN-END:variables
}
