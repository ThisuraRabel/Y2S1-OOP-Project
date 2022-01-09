/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.View;

import Hospital_Management_System.Controller.Receptionist;
import Hospital_Management_System.Model.Receptionist_creation_Model;


/**
 *
 * @author Thisura
 */
public class Receptionist_Creation_View extends javax.swing.JFrame {
    
    private String name;
    /**
     * Creates new form Administrator_Creation_Interface
     */
    public Receptionist_Creation_View() {
       initComponents();
       Receptionist_creation_Model ac = new Receptionist_creation_Model(ReceptionistTable_view, receptionist_id_label);
       ac.receptionist_table();
       ac.autoAID();
       //auto AID
 
    }
    
     public Receptionist_Creation_View(String n) {
         name = n;
       initComponents();
       Receptionist_creation_Model ac = new Receptionist_creation_Model(ReceptionistTable_view, receptionist_id_label);
       ac.receptionist_table();
       ac.autoAID();
       //auto AID
 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        ReceptionistTable_view = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        fName_tBox = new javax.swing.JTextField();
        username_tBox = new javax.swing.JTextField();
        contractNo_tBox = new javax.swing.JTextField();
        lName_tBox = new javax.swing.JTextField();
        eMail_tBox = new javax.swing.JTextField();
        pass_pBox = new javax.swing.JPasswordField();
        reEnterPass_pBox = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        receptionist_id_label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ReceptionistTable_view.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Receptionist ID", "First Name", "Last Name", "Username", "Password", "Contract Number", "Email"
            }
        ));
        ReceptionistTable_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReceptionistTable_viewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ReceptionistTable_view);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 980, 338));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("First Name: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Last Name: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Username:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Password:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Re-Enter Password:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 161, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Contract Number: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 221, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Email: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 294, -1, -1));

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 294, -1, -1));

        jButton3.setText("Create");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 294, -1, -1));

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 294, 72, -1));

        fName_tBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fName_tBoxActionPerformed(evt);
            }
        });
        jPanel1.add(fName_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 153, -1));
        jPanel1.add(username_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 162, -1));
        jPanel1.add(contractNo_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, 160, -1));
        jPanel1.add(lName_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 153, 24));
        jPanel1.add(eMail_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 153, -1));
        jPanel1.add(pass_pBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 162, -1));

        reEnterPass_pBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reEnterPass_pBoxActionPerformed(evt);
            }
        });
        jPanel1.add(reEnterPass_pBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 160, 160, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("Receptionist Creation");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 23, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Receptionist  ID:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 91, -1, -1));

        receptionist_id_label.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.add(receptionist_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 91, 99, 14));

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Receptionist Username Here", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/The-Must-Have-modules-of-a-Hospital-Management-System-1200x675.jpg"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1030, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fName_tBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fName_tBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fName_tBoxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO pass var of feilds
        //"fName_tBox", "lName_tBox", "username_tBox", "pass_pBox", "reEnterPass_pBox", "contractNo_tBox", "eMail_tBox"
        // admin_id_label
        
        Receptionist ad1;
        ad1 = new Receptionist(fName_tBox, lName_tBox, username_tBox, contractNo_tBox, eMail_tBox, pass_pBox, reEnterPass_pBox, receptionist_id_label);
        ad1.insertToTable(ReceptionistTable_view, receptionist_id_label);
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void reEnterPass_pBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reEnterPass_pBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reEnterPass_pBoxActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       this.dispose();
            Administrative_S_M_View ob = new Administrative_S_M_View(name);
            ob.setVisible(true); 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO update
        Receptionist ad2;
        ad2 = new Receptionist(fName_tBox, lName_tBox, username_tBox, contractNo_tBox, eMail_tBox, pass_pBox, reEnterPass_pBox, receptionist_id_label);
        ad2.updateTable(ReceptionistTable_view, receptionist_id_label, jButton3); 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ReceptionistTable_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReceptionistTable_viewMouseClicked
        // TODO add your handling code here:
        
        Receptionist ad3;
        ad3 = new Receptionist(fName_tBox, lName_tBox, username_tBox, contractNo_tBox, eMail_tBox, pass_pBox, reEnterPass_pBox, receptionist_id_label);
        ad3.getSelectedValues(jButton3, ReceptionistTable_view);
        
        
    }//GEN-LAST:event_ReceptionistTable_viewMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:   
        Receptionist ad4;
        ad4 = new Receptionist(fName_tBox, lName_tBox, username_tBox, contractNo_tBox, eMail_tBox, pass_pBox, reEnterPass_pBox, receptionist_id_label);
        ad4.deleteItem(ReceptionistTable_view, receptionist_id_label, jButton3);
        
        
     
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased

        Receptionist_creation_Model ob = new Receptionist_creation_Model();
        ob.search(searchbox, ReceptionistTable_view);

    }//GEN-LAST:event_searchboxKeyReleased

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
            java.util.logging.Logger.getLogger(Receptionist_Creation_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receptionist_Creation_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receptionist_Creation_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receptionist_Creation_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receptionist_Creation_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ReceptionistTable_view;
    private javax.swing.JTextField contractNo_tBox;
    private javax.swing.JTextField eMail_tBox;
    private javax.swing.JTextField fName_tBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lName_tBox;
    private javax.swing.JPasswordField pass_pBox;
    private javax.swing.JPasswordField reEnterPass_pBox;
    private javax.swing.JLabel receptionist_id_label;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTextField username_tBox;
    // End of variables declaration//GEN-END:variables
}