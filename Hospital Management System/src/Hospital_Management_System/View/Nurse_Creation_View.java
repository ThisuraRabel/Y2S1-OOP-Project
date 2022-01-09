/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.View;

import Hospital_Management_System.Controller.Nurse;
import Hospital_Management_System.Model.Nurse_creation_Model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Asus
 */
public class Nurse_Creation_View extends javax.swing.JFrame {
    private String name;
    /**
     * Creates new form NurseInterface     nurse_table, nurseID_label, contractNo_tBox
     */
    public Nurse_Creation_View() {
        initComponents();
        Utility_Class_View.Date(date);
        Utility_Class_View.Time(time);
        Nurse_creation_Model ac = new Nurse_creation_Model(nurse_table, nurseID_label);
        ac.nurse_table();
        ac.autoAID();
    }
    
     public Nurse_Creation_View(String n) {
        name = n;
        initComponents();
        Utility_Class_View.Date(date);
        Utility_Class_View.Time(time);
        Nurse_creation_Model ac = new Nurse_creation_Model(nurse_table, nurseID_label);
        ac.nurse_table();
        ac.autoAID();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nurse_table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        contractNo_tBox = new javax.swing.JTextField();
        fName_tBox = new javax.swing.JTextField();
        lName_tBox = new javax.swing.JTextField();
        wardNo_tBox = new javax.swing.JTextField();
        eMail_tBox = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        search_tBox = new javax.swing.JTextField();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nurseID_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nurse_table.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        nurse_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nurse ID", "First Name", "Last Name", "Ward No", "Contact No", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        nurse_table.setRowHeight(25);
        nurse_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nurse_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(nurse_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 760, 460));

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Nurse Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 370, 50));

        jButton2.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 590, -1, -1));

        jButton8.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 590, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 820, 650));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Display", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setText("Hospital Pvt.Ltd.");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 340, 60));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, 30));

        jButton3.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jButton3.setText("Insert");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 590, -1, -1));

        jButton4.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("First Name :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 30));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, 30));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nurse ID :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 30));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ward No :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, 30));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Contact No :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, 30));

        contractNo_tBox.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jPanel2.add(contractNo_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 260, 30));

        fName_tBox.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jPanel2.add(fName_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 260, 30));

        lName_tBox.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jPanel2.add(lName_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 260, 30));

        wardNo_tBox.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jPanel2.add(wardNo_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 260, 30));

        eMail_tBox.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jPanel2.add(eMail_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 260, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Search Name Here", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Malgun Gothic", 1, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search_tBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_tBoxKeyReleased(evt);
            }
        });
        jPanel3.add(search_tBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 200, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 370, 70));

        date.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 130, 30));

        time.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 120, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("Time: ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("Date: ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        nurseID_label.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        nurseID_label.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(nurseID_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 80, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:   Insert   
        
        Nurse ad1;
        ad1 = new Nurse(fName_tBox, lName_tBox, wardNo_tBox, contractNo_tBox, eMail_tBox, nurseID_label);
        ad1.insertToTable(nurse_table, nurseID_label);
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here: update
        
        Nurse ad2;
        ad2 = new Nurse(fName_tBox, lName_tBox, wardNo_tBox, contractNo_tBox, eMail_tBox, nurseID_label);
        ad2.updateTable(nurse_table, nurseID_label, jButton3); 

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here: delete
        
        Nurse ad4;
        ad4 = new Nurse(fName_tBox, lName_tBox, wardNo_tBox, contractNo_tBox, eMail_tBox, nurseID_label);
        ad4.deleteItem(nurse_table, nurseID_label, jButton3);

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
            Administrative_S_M_View ob = new Administrative_S_M_View(name);
            ob.setVisible(true); 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void nurse_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nurse_tableMouseClicked
        // TODO add your handling code here:   get selected item
         Nurse ad3;
        ad3 = new Nurse(fName_tBox, lName_tBox, wardNo_tBox, contractNo_tBox, eMail_tBox, nurseID_label);
        ad3.getSelectedValues(jButton3, nurse_table);
    }//GEN-LAST:event_nurse_tableMouseClicked

    private void search_tBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_tBoxKeyReleased
        Nurse_creation_Model ob = new Nurse_creation_Model();
        ob.search(search_tBox, nurse_table);
    }//GEN-LAST:event_search_tBoxKeyReleased

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
            java.util.logging.Logger.getLogger(Nurse_Creation_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nurse_Creation_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nurse_Creation_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nurse_Creation_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nurse_Creation_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contractNo_tBox;
    private javax.swing.JLabel date;
    private javax.swing.JTextField eMail_tBox;
    private javax.swing.JTextField fName_tBox;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lName_tBox;
    private javax.swing.JLabel nurseID_label;
    private javax.swing.JTable nurse_table;
    private javax.swing.JTextField search_tBox;
    private javax.swing.JLabel time;
    private javax.swing.JTextField wardNo_tBox;
    // End of variables declaration//GEN-END:variables
}
