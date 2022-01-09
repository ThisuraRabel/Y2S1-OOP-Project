/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Controller;

import Hospital_Management_System.Model.Patient_Creation_Model;
import Hospital_Management_System.View.Patient_Creation_View;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thisura
 */
public class Staying_Patient extends Patient {

    
    private String wardNo;
 
    private final javax.swing.JTextField C_ward_number_tbox;

    
    public Staying_Patient( JTextField C_fName_tBox, JTextField C_lName_tBox, JTextField C_age_tbox, JComboBox C_genderSelection, JTextField C_NICNo_tBox,
                        JTextField C_conNumber_tbox,  JTextField C_ward_number_tbox, JComboBox C_patientTypeSelection, JLabel C_patient_id_label){
       
        
        super(C_fName_tBox, C_lName_tBox, C_age_tbox, C_genderSelection, C_NICNo_tBox, C_conNumber_tbox, C_patientTypeSelection, C_patient_id_label);       
        this.C_ward_number_tbox = C_ward_number_tbox;
  
    }
   
    
    @Override
    public void getValues(){
      fName = C_fName_tBox.getText();
      lName = C_lName_tBox.getText();
      age = C_age_tbox.getText();
      gender = C_genderSelection.getSelectedItem().toString();
      nic = C_NICNo_tBox.getText();
      contractNum = C_conNumber_tbox.getText();  
      patientNum = C_patient_id_label.getText();
      patientType = C_patientTypeSelection.getSelectedItem().toString();
      wardNo = C_ward_number_tbox.getText();
        
    }
    
    @Override
    public void clearFeilds(){
        C_fName_tBox.setText("");
        C_lName_tBox.setText("");
        C_patientTypeSelection.setSelectedIndex(-1);
        C_NICNo_tBox.setText("");
        C_age_tbox.setText("");
        C_conNumber_tbox.setText("");
        C_genderSelection.setSelectedIndex(-1);
        C_fName_tBox.requestFocus();  // move cursor to first name feild
    }
    
    /**
     *
     * @param C_jButton3
     * @param C_patient_id_label
     * @param C_PatientTable_view
     */
    @Override
     public void getSelectedValues(JButton C_jButton3, JLabel C_patient_id_label, JTable C_PatientTable_view){
    
            DefaultTableModel d1 = (DefaultTableModel)C_PatientTable_view.getModel();
            int SelectIndex = C_PatientTable_view.getSelectedRow();   
        
            C_patient_id_label.setText(d1.getValueAt(SelectIndex, 0).toString());
            C_fName_tBox.setText(d1.getValueAt(SelectIndex, 1).toString());
            C_lName_tBox.setText(d1.getValueAt(SelectIndex, 2).toString());
            C_age_tbox.setText(d1.getValueAt(SelectIndex, 3).toString());
            C_genderSelection.setSelectedItem(d1.getValueAt(SelectIndex, 4).toString());
            C_NICNo_tBox.setText(d1.getValueAt(SelectIndex, 5).toString());
            C_conNumber_tbox.setText(d1.getValueAt(SelectIndex, 6).toString());
            C_patientTypeSelection.setSelectedItem(d1.getValueAt(SelectIndex, 7).toString());
            C_ward_number_tbox.setText(d1.getValueAt(SelectIndex, 8).toString());

            C_jButton3.setEnabled(false);    //invissible create button 

    }

    /**
     *
     * @param C_PatientTable_view
     * @param C_patient_id_label
     */
    @Override
    public void insertToTable(JTable C_PatientTable_view, JLabel C_patient_id_label){
        
        this.getValues();

            Patient_Creation_Model a;
            a = new Patient_Creation_Model();  // object Creation
        try {            
            a.insertValues(fName, lName, age, gender, nic, contractNum, patientNum, patientType, wardNo);
        } catch (SQLException ex) {
            Logger.getLogger(Staying_Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
           
              //object creation
            Patient_Creation_View AdIn = new Patient_Creation_View();
            JOptionPane.showMessageDialog(AdIn, "Patient created successfully! ");
            
            this.clearFeilds();
            
            Patient_Creation_Model ac = new Patient_Creation_Model(C_PatientTable_view, C_patient_id_label);
            ac.patient_table();
            ac.autoAID();
        }
       
    /**
     *
     * @param C_PatientTable_view
     * @param C_patient_id_label
     * @param C_jButton3
     */
    @Override
    public void updateTable(JTable C_PatientTable_view, JLabel C_patient_id_label, JButton C_jButton3){

        this.getValues();
       
        Patient_Creation_Model a;
        a = new Patient_Creation_Model();
                  
        try {
            a.updateValues(fName, lName, age, gender, nic, contractNum, patientNum, patientType, wardNo);
        } catch (SQLException ex) {
            Logger.getLogger(OPD_Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            Patient_Creation_View AdIn = new Patient_Creation_View();
            JOptionPane.showMessageDialog(AdIn, "Patient Updated successfully! ");
           
            this.clearFeilds();
            
            Patient_Creation_Model ac = new Patient_Creation_Model(C_PatientTable_view, C_patient_id_label);
            ac.patient_table();
            ac.autoAID();

            C_jButton3.setEnabled(true);
        }
        
    /**
     *
     * @param C_PatientTable_view
     * @param C_patient_id_label
     * @param C_jButton3
     */
    @Override
    public void deleteItem(JTable C_PatientTable_view, JLabel C_patient_id_label, JButton C_jButton3){
        
            patientNum = C_patient_id_label.getText();

            Patient_Creation_Model ac = new Patient_Creation_Model(C_PatientTable_view, C_patient_id_label);
            ac.deleteValues(C_patient_id_label);
        
            Patient_Creation_View AdIn = new Patient_Creation_View();
            JOptionPane.showMessageDialog(AdIn, "User Deleted successfully! ");
          
            ac.patient_table();
            ac.autoAID();
           
            this.clearFeilds();
    
    }
    

}