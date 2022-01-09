/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Controller;

import Hospital_Management_System.Model.Doctor_creation_Model;
import Hospital_Management_System.View.Admin_Creation_View;
import Hospital_Management_System.View.Doctor_Creation_View;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Thisura
 */
public class Doctor extends User{
   
    private String spec;
    private String qual;
   
    private final javax.swing.JTextField C_specialization_tbox;
    private final javax.swing.JTextField C_Qualifications_tbox;

 
    
    public Doctor( JTextField C_fName_tBox, JTextField C_lName_tBox, JTextField C_username_tBox, JTextField C_contractNo_tBox, 
                   JTextField C_eMail_tBox, JPasswordField C_pass_pBox,JPasswordField C_reEnterPass_pBox, JLabel C_id_label,
                   JTextField C_specialization_tbox, JTextField C_Qualifications_tbox){
        
        super(C_fName_tBox, C_lName_tBox ,C_username_tBox, C_contractNo_tBox, C_eMail_tBox , C_pass_pBox, C_reEnterPass_pBox, C_id_label);
        
        this.C_specialization_tbox = C_specialization_tbox;
        this.C_Qualifications_tbox = C_Qualifications_tbox;
        
    
    }
    
    @Override
    public void getValues(){
      fName = C_fName_tBox.getText();
      lName = C_lName_tBox.getText();
      userName = C_username_tBox.getText();
      contractNum = C_contractNo_tBox.getText();
      eMail = C_eMail_tBox.getText();
      password = C_pass_pBox.getText();  
      reEnterPass = C_reEnterPass_pBox.getText();
      ID = C_id_label.getText();
      spec = C_specialization_tbox.getText();
      qual = C_Qualifications_tbox.getText();
        
    }
    
    public void clearFields(){
        C_fName_tBox.setText("");
        C_lName_tBox.setText("");
        C_username_tBox.setText("");
        C_contractNo_tBox.setText("");
        C_eMail_tBox.setText("");
        C_pass_pBox.setText("");
        C_reEnterPass_pBox.setText("");
        C_specialization_tbox.setText("");
        C_Qualifications_tbox.setText("");
        C_fName_tBox.requestFocus();  // move cursor to first name feild
    }

    /**
     *
     * @param C_DoctorTable_view
     * @param C_doctor_id_label
     */
    @Override
    public void insertToTable(JTable C_DoctorTable_view, JLabel C_doctor_id_label){
      
        this.getValues();

        if( password.equals(reEnterPass)){
            validPass = C_pass_pBox.getText();
          
            Doctor_creation_Model a;
            a = new Doctor_creation_Model();  // object Creation
            
            try {
                a.insertValues(fName, lName, userName, password, reEnterPass, validPass, contractNum, eMail, ID, spec, qual);
            } catch (SQLException ex) {
                Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            }
               
              //object creation
            Doctor_Creation_View AdIn = new Doctor_Creation_View();
            JOptionPane.showMessageDialog(AdIn, "Doctor created successfully! ");
            this.clearFields();
            
            Doctor_creation_Model ac = new Doctor_creation_Model(C_DoctorTable_view, C_doctor_id_label);
            ac.doctor_table();
            ac.autoAID();
            
        }
        else{
            Admin_Creation_View AdIn = new Admin_Creation_View();
            
            JOptionPane.showMessageDialog(AdIn, "Given Passwords are not Matching! ");
           this.clearFields();

        }
        
    }
    
    /**
     *
     * @param C_DoctorTable_view
     * @param C_doctor_id_label
     * @param C_jButton3
     */
    @Override
    public void updateTable(JTable C_DoctorTable_view, JLabel C_doctor_id_label, JButton C_jButton3){
        
       
        this.getValues();
        if( password.equals(reEnterPass)){
            validPass = C_pass_pBox.getText();
        
            Doctor_creation_Model a;
            a = new Doctor_creation_Model();
        
            try {
                a.updateValues(fName, lName, userName, password, reEnterPass, validPass, contractNum, eMail, ID, spec, qual);
            } catch (SQLException ex) {
                Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                Doctor_Creation_View AdIn = new Doctor_Creation_View();
                JOptionPane.showMessageDialog(AdIn, "Doctor Updated successfully! ");
          
                this.clearFields();
            
                Doctor_creation_Model ac = new Doctor_creation_Model(C_DoctorTable_view, C_doctor_id_label);
                ac.doctor_table();
                ac.autoAID();
            
                C_jButton3.setEnabled(true);
        }
        else{
             Doctor_Creation_View AdIn = new Doctor_Creation_View();
            
            this.clearFields();
            C_jButton3.setEnabled(true);
            
        }
      
    }
    
    /**
     *
     * @param C_DoctorTable_view
     * @param C_doctor_id_label
     * @param C_jButton3
     */
    @Override
    public void deleteItem(JTable C_DoctorTable_view, JLabel C_doctor_id_label, JButton C_jButton3){
        
            ID = C_doctor_id_label.getText();
          
            Doctor_creation_Model ac = new Doctor_creation_Model(C_DoctorTable_view, C_doctor_id_label);
            ac.deleteValues(C_doctor_id_label);
        
            Doctor_Creation_View AdIn = new Doctor_Creation_View();
            JOptionPane.showMessageDialog(AdIn, "Doctor Deleted successfully! ");
          
            ac.doctor_table();
            ac.autoAID();
           
            this.clearFields();
            C_jButton3.setEnabled(true);
    
    }
    
    
    public void getSelectedValues(JButton C_jButton3, JTable C_DoctorTable_view){
    
            DefaultTableModel d1 = (DefaultTableModel)C_DoctorTable_view.getModel();
            int SelectIndex = C_DoctorTable_view.getSelectedRow();   
        
            C_id_label.setText(d1.getValueAt(SelectIndex, 0).toString());
            C_fName_tBox.setText(d1.getValueAt(SelectIndex, 1).toString());
            C_lName_tBox.setText(d1.getValueAt(SelectIndex, 2).toString());
            C_username_tBox.setText(d1.getValueAt(SelectIndex, 3).toString());
            C_pass_pBox.setText(d1.getValueAt(SelectIndex, 4).toString());
            C_contractNo_tBox.setText(d1.getValueAt(SelectIndex, 5).toString());
            C_eMail_tBox.setText(d1.getValueAt(SelectIndex, 6).toString());
            C_specialization_tbox.setText(d1.getValueAt(SelectIndex, 7).toString());
            C_Qualifications_tbox.setText(d1.getValueAt(SelectIndex, 8).toString());
            C_jButton3.setEnabled(false);    //invissible create button 
    
    
    }
       
    
}
    
    
    
    

