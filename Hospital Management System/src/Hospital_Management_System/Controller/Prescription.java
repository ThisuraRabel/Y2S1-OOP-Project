/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Controller;

import Hospital_Management_System.Model.Prescription_creation_Model;
import Hospital_Management_System.View.Add_Prescription_View;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Thisura
 */
public class Prescription /*extends User*/{
    
    private String presID;
    private String pName;
    private String pAge;
    private String pGender;
    private String pdesease;
    private String pDescription;
    private String dName;
   
    private final javax.swing.JTextField C_pName;
    private final javax.swing.JTextField C_pAge;
    private final javax.swing.JComboBox C_pGender;
    private final javax.swing.JTextField C_pdesease;
    private final javax.swing.JTextArea C_pDescription;
    private final javax.swing.JTextField C_dName;
    
    private javax.swing.JTable C_pTable;
    private javax.swing.JLabel C_pres_id_label;
 

    public Prescription( JTextField C_pName, JTextField C_pAge, JComboBox C_pGender, JTextField C_pdesease, JTextArea C_pDescription,
                         JTextField C_dName, JLabel C_pres_id_label ){
        
        this.C_pName = C_pName;
        this.C_pAge = C_pAge;
        this.C_pGender = C_pGender;
        this.C_pdesease = C_pdesease;
        this.C_pDescription = C_pDescription;
        this.C_dName = C_dName;
        this.C_pres_id_label = C_pres_id_label;
        
        
    }
    
    public void clearFeilds(){
        C_pName.setText("");
        C_pAge.setText("");
        C_pGender.setSelectedIndex(-1);
        C_pdesease.setText("");
        C_pDescription.setText("");
        C_dName.setText("");
        C_pName.requestFocus();  // move cursor to first name feild
    }
    
    public void getValues(){
        
        pName = C_pName.getText();
        pAge = C_pAge.getText();
        pGender = C_pGender.getSelectedItem().toString();
        pdesease = C_pdesease.getText();
        pDescription = C_pDescription.getText();
        dName = C_pName.getText();
        presID = C_pres_id_label.getText();
     
    }


    public void insertToTable(JTable C_pTable, JLabel C_pres_id_label){
        
        this.C_pTable = C_pTable;
        this.C_pres_id_label = C_pres_id_label;
        
        this.getValues();

            Prescription_creation_Model a;
            a = new Prescription_creation_Model();  // object Creation
            
            try {
                a.insertValues(pName, pAge, pGender, pdesease, pDescription, dName, presID);
            } catch (SQLException ex) {
                Logger.getLogger(Prescription.class.getName()).log(Level.SEVERE, null, ex);
            }
               
             
            Add_Prescription_View AdIn = new Add_Prescription_View(); //object creation
            JOptionPane.showMessageDialog(AdIn, "Prescription created successfully! ");
            
            clearFeilds();
            
            Prescription_creation_Model ac = new Prescription_creation_Model(C_pTable, C_pres_id_label);
            ac.prescription_table();
            ac.autoAID();
       
    }
    
    
    public void updateTable(JTable C_pTable, JLabel C_pres_id_label, JButton C_jButton3){
        
        this.C_pTable = C_pTable;
        this.C_pres_id_label = C_pres_id_label;
        
        this.getValues();
     
            Prescription_creation_Model a;
            a = new Prescription_creation_Model();
        
            try {
                a.updateValues(pName, pAge, pGender, pdesease, pDescription, dName, presID);
            } catch (SQLException ex) {
                Logger.getLogger(Prescription.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                Add_Prescription_View AdIn = new Add_Prescription_View();
                JOptionPane.showMessageDialog(AdIn, "Prescription Updated successfully! ");
          
                clearFeilds();
            
                Prescription_creation_Model ac = new Prescription_creation_Model(C_pTable, C_pres_id_label);
                ac.prescription_table();
                ac.autoAID();
            
                C_jButton3.setEnabled(true);
        
    }
    
    
    public void deleteItem(JTable C_pTable, JLabel C_pres_id_label, JButton C_jButton3){
        
            presID = C_pres_id_label.getText();
            
            this.C_pTable = C_pTable;
            this.C_pres_id_label = C_pres_id_label;
        
            Prescription_creation_Model ac = new Prescription_creation_Model(C_pTable, C_pres_id_label);
            ac.deleteValues(C_pres_id_label);
        
            Add_Prescription_View AdIn = new Add_Prescription_View();
            JOptionPane.showMessageDialog(AdIn, "Prescription Deleted successfully! ");
          
            ac.prescription_table();
            ac.autoAID();
           
            clearFeilds();
            C_jButton3.setEnabled(true);
    
    }
    
    
    public void getSelectedValues(JButton C_jButton3, JTable C_pTable){
    
            DefaultTableModel d1 = (DefaultTableModel)C_pTable.getModel();
            int SelectIndex = C_pTable.getSelectedRow();   
   
            C_pres_id_label.setText(d1.getValueAt(SelectIndex, 0).toString());
            C_pName.setText(d1.getValueAt(SelectIndex, 1).toString());
            C_pAge.setText(d1.getValueAt(SelectIndex, 2).toString());
            C_pGender.setSelectedItem(d1.getValueAt(SelectIndex, 3).toString());
            C_pdesease.setText(d1.getValueAt(SelectIndex, 4).toString());
            C_pDescription.setText(d1.getValueAt(SelectIndex, 5).toString());
            C_dName.setText(d1.getValueAt(SelectIndex, 6).toString());
            
            
            C_jButton3.setEnabled(false);    //invissible create button 
   
    }
 
}
    
    
    
    

