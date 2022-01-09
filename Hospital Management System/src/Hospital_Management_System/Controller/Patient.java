/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Thisura
 */
public class Patient implements Person{
    
    protected String patientNum;
    protected String fName;
    protected String lName;
    protected String age;
    protected String gender;
    protected String nic;
    protected String contractNum;
    protected String patientType;
    
    protected  javax.swing.JTextField C_lName_tBox;
    protected  javax.swing.JComboBox C_patientTypeSelection;
    protected  javax.swing.JLabel C_patient_id_label;
    protected  javax.swing.JTextField C_NICNo_tBox;
    protected  javax.swing.JTextField C_age_tbox;
    protected  javax.swing.JTextField C_conNumber_tbox;
    protected  javax.swing.JTextField C_fName_tBox;
    protected  javax.swing.JComboBox C_genderSelection;
    
     public Patient( JTextField C_fName_tBox, JTextField C_lName_tBox, JTextField C_age_tbox, JComboBox C_genderSelection, JTextField C_NICNo_tBox,
                     JTextField C_conNumber_tbox,JComboBox C_patientTypeSelection, JLabel C_patient_id_label){
        this.C_patientTypeSelection = C_patientTypeSelection;
        this.C_fName_tBox = C_fName_tBox;
        this.C_lName_tBox = C_lName_tBox;
        this.C_age_tbox = C_age_tbox;
        this.C_genderSelection = C_genderSelection;
        this.C_NICNo_tBox = C_NICNo_tBox;
        this.C_conNumber_tbox = C_conNumber_tbox;
        this.C_patient_id_label = C_patient_id_label;
      
    }

    @Override
    public void getValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearFeilds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    @Override
    public void insertToTable(JTable C_Table_view, JLabel C_id_label) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateTable(JTable C_Table_view, JLabel C_id_label, JButton C_jButton3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteItem(JTable C_Table_view, JLabel C_id_label, JButton C_jButton3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getSelectedValues(JButton C_jButton3, JLabel C_id_label, JTable CTable_view) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
