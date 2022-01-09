/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.View;

import Hospital_Management_System.Controller.Doctor;
import Hospital_Management_System.Model.Doctor_creation_Model;


/**
 *
 * @author Thisura
 */
public class Doctor_Creation_View extends javax.swing.JFrame {
    private String name;
    /**
     * Creates new form Administrator_Creation_Interface
     */
    public Doctor_Creation_View() {
        
       initComponents();
       Doctor_creation_Model ac = new Doctor_creation_Model(DoctorTable_view, doctor_id_label);
       ac.doctor_table();
       ac.autoAID();
       
    }
    
     public Doctor_Creation_View(String n) {
        name = n;
       initComponents();
       Doctor_creation_Model ac = new Doctor_creation_Model(DoctorTable_view, doctor_id_label);
       ac.doctor_table();
       ac.autoAID();
       
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
        DoctorTable_view = new javax.swing.JTable();
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
        doctor_id_label = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        specialization_tbox = new javax.swing.JTextField();
        Qualifications_tbox = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DoctorTable_view.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor ID", "First Name", "Last Name", "Username", "Password", "Contract Number", "Email", "Specialization", "Qualification"
            }
        ));
        DoctorTable_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DoctorTable_viewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DoctorTable_view);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 367, 969, 316));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("First Name: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 138, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Last Name: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 176, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Username:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 222, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Password:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 138, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Re-Enter Password:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 176, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Contract Number: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 176, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Email: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 222, -1, -1));

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 294, -1, -1));

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 294, -1, -1));

        jButton3.setText("Create");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 294, -1, -1));

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(923, 294, 71, -1));

        fName_tBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fName_tBoxActionPerformed(evt);
            }
        });
        jPanel1.add(fName_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 136, 147, -1));
        jPanel1.add(username_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 220, 147, -1));
        jPanel1.add(contractNo_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(848, 174, 165, -1));
        jPanel1.add(lName_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 174, 147, -1));
        jPanel1.add(eMail_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(848, 220, 165, -1));
        jPanel1.add(pass_pBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 136, 159, -1));

        reEnterPass_pBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reEnterPass_pBoxActionPerformed(evt);
            }
        });
        jPanel1.add(reEnterPass_pBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 174, 159, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("Doctor Creation");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 15, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Doctor ID:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 62, -1, -1));

        doctor_id_label.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.add(doctor_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(882, 62, 99, 15));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Specialization: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 222, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Qualifications: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 138, -1, -1));
        jPanel1.add(specialization_tbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 220, 159, -1));
        jPanel1.add(Qualifications_tbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(846, 136, 167, -1));

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Doctor Name Here", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        searchbox.setToolTipText("Patient name");
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 269, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/11.jpeg"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fName_tBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fName_tBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fName_tBoxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO pass var of feilds  specialization_tbox, Qualifications_tbox
      
        Doctor ad1;
        ad1 = new Doctor(fName_tBox, lName_tBox, username_tBox, contractNo_tBox, eMail_tBox, pass_pBox, reEnterPass_pBox, doctor_id_label,
                         specialization_tbox, Qualifications_tbox);
        ad1.insertToTable(DoctorTable_view, doctor_id_label);
        
        
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
        Doctor ad2;
        ad2 = new Doctor(fName_tBox, lName_tBox, username_tBox, contractNo_tBox, eMail_tBox, pass_pBox, reEnterPass_pBox, doctor_id_label,
                         specialization_tbox, Qualifications_tbox);
        ad2.updateTable(DoctorTable_view, doctor_id_label, jButton3); //pass  table and label
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DoctorTable_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DoctorTable_viewMouseClicked
        // TODO add your handling code here:
        
        Doctor ad3;
        ad3 = new Doctor(fName_tBox, lName_tBox, username_tBox, contractNo_tBox, eMail_tBox, pass_pBox, reEnterPass_pBox, doctor_id_label,
                         specialization_tbox, Qualifications_tbox);
        ad3.getSelectedValues(jButton3, DoctorTable_view);
        
        
    }//GEN-LAST:event_DoctorTable_viewMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:   
        Doctor ad4;
        ad4 = new Doctor(fName_tBox, lName_tBox, username_tBox, contractNo_tBox, eMail_tBox, pass_pBox, reEnterPass_pBox, doctor_id_label,
                         specialization_tbox, Qualifications_tbox);
        ad4.deleteItem(DoctorTable_view, doctor_id_label, jButton3);
        
        
     
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        // TODO add your handling code here:
        Doctor_creation_Model ob = new Doctor_creation_Model();
        ob.search(searchbox, DoctorTable_view);
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
            java.util.logging.Logger.getLogger(Doctor_Creation_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doctor_Creation_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doctor_Creation_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doctor_Creation_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doctor_Creation_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DoctorTable_view;
    private javax.swing.JTextField Qualifications_tbox;
    private javax.swing.JTextField contractNo_tBox;
    private javax.swing.JLabel doctor_id_label;
    private javax.swing.JTextField eMail_tBox;
    private javax.swing.JTextField fName_tBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField searchbox;
    private javax.swing.JTextField specialization_tbox;
    private javax.swing.JTextField username_tBox;
    // End of variables declaration//GEN-END:variables
}
