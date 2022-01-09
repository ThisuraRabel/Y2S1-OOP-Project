/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Controller;

import Hospital_Management_System.Model.Nurse_creation_Model;
import Hospital_Management_System.View.Pharmasist_Creation_View;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Thisura
 */
public class Nurse extends Non_User{
    

    public Nurse( JTextField C_fName_tBox, JTextField C_lName_tBox, JTextField C_wardNo_tBox, JTextField C_contractNo_tBox, 
                                        JTextField C_eMail_tBox, JLabel C_nurseID_label){
        
     
                super (C_fName_tBox, C_lName_tBox, C_wardNo_tBox, C_contractNo_tBox, C_eMail_tBox, C_nurseID_label);
   
    }
    
    @Override
    public void getValues(){
      fName = C_fName_tBox.getText();
      lName = C_lName_tBox.getText();
      wardNo = C_wardNo_tBox.getText();
      contractNum = C_contractNo_tBox.getText();
      eMail = C_eMail_tBox.getText();
      NurseNum = C_nurseID_label.getText();
        
    }
    
    @Override
    public void clearFeilds(){
            C_fName_tBox.setText("");
            C_lName_tBox.setText("");
            C_wardNo_tBox.setText("");
            C_contractNo_tBox.setText("");
            C_eMail_tBox.setText("");            
            C_fName_tBox.requestFocus();  // move cursor to first name feild   
    }

    /**
     *
     * @param C_nurse_table
     * @param C_nurseID_label
     */
    @Override
    public void insertToTable(JTable C_nurse_table, JLabel C_nurseID_label){
   
        this.getValues();

        Nurse_creation_Model a;
        a = new Nurse_creation_Model();  // object Creation

        try {
            a.insertValues(fName, lName, wardNo, contractNum, eMail, NurseNum);
        } catch (SQLException ex) {
            Logger.getLogger(Nurse.class.getName()).log(Level.SEVERE, null, ex);
        }

          //object creation
        Pharmasist_Creation_View AdIn = new Pharmasist_Creation_View();
        JOptionPane.showMessageDialog(AdIn, "Nurse created successfully! ");
        this.clearFeilds();

        Nurse_creation_Model ac = new Nurse_creation_Model(C_nurse_table, C_nurseID_label);
        ac.nurse_table();
        ac.autoAID();           
    }
    
    /**
     *
     * @param C_nurse_table
     * @param C_nurseID_label
     * @param C_jButton3
     */
    @Override
    public void updateTable(JTable C_nurse_table, JLabel C_nurseID_label, JButton C_jButton3){
        
            this.getValues();

            try {
                Nurse_creation_Model a1;
                a1 = new Nurse_creation_Model();
                a1.updateValues(fName, lName, wardNo, contractNum, eMail, NurseNum);
            } catch (SQLException ex) {
                Logger.getLogger(Nurse.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                Pharmasist_Creation_View AdIn = new Pharmasist_Creation_View();
                JOptionPane.showMessageDialog(AdIn, "Nurse Updated successfully! ");
          
           
                this.clearFeilds();
            
                Nurse_creation_Model ac = new Nurse_creation_Model(C_nurse_table, C_nurseID_label);
                ac.nurse_table();
                ac.autoAID();
            
                C_jButton3.setEnabled(true);
    
    }
    
    /**
     *
     * @param C_nurse_table
     * @param C_nurseID_label
     * @param C_jButton3
     */
    @Override
    public void deleteItem(JTable C_nurse_table, JLabel C_nurseID_label, JButton C_jButton3){
        
            NurseNum = C_nurseID_label.getText();
   
            Nurse_creation_Model ac = new Nurse_creation_Model(C_nurse_table, C_nurseID_label);
            ac.deleteValues(C_nurseID_label);
        
            Pharmasist_Creation_View AdIn = new Pharmasist_Creation_View();
            JOptionPane.showMessageDialog(AdIn, "Nurse Deleted successfully! ");
          
            ac.nurse_table();
            ac.autoAID();
           
            this.clearFeilds();
            C_jButton3.setEnabled(true);
    
    }
    
    
    public void getSelectedValues(JButton C_jButton3, JTable C_nurse_table){
    
            DefaultTableModel d1 = (DefaultTableModel)C_nurse_table.getModel();
            int SelectIndex = C_nurse_table.getSelectedRow();   
        
            C_nurseID_label.setText(d1.getValueAt(SelectIndex, 0).toString());
            C_fName_tBox.setText(d1.getValueAt(SelectIndex, 1).toString());
            C_lName_tBox.setText(d1.getValueAt(SelectIndex, 2).toString());
            C_wardNo_tBox.setText(d1.getValueAt(SelectIndex, 3).toString());
            C_contractNo_tBox.setText(d1.getValueAt(SelectIndex, 4).toString());
            C_eMail_tBox.setText(d1.getValueAt(SelectIndex, 5).toString());
            C_jButton3.setEnabled(false);    //invissible create button 
    
    
    }
       
    
}
    
    
    
    

