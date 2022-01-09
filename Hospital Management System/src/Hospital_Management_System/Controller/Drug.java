/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Controller;

import Hospital_Management_System.Model.Drug_creation_Model;
import Hospital_Management_System.View.Drug_Enter_View;
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
public class Drug /*extends User*/{
    
    
    private String drugNum;
    private String dName;
    private String dType;
    private String dQuantity;
    private String dExp;
    
    private final javax.swing.JTextField C_dName;
    private final javax.swing.JComboBox C_dType;
    private final javax.swing.JTextField C_dQuantity;
    private final javax.swing.JComboBox C_dExp;
  
    private javax.swing.JTable C_drug_table_view;
    private javax.swing.JLabel C_dId;
     
    
    
    public Drug( JTextField C_dName, JComboBox C_dType, JTextField C_dQuantity, JComboBox C_dExp, JLabel C_dId){
        
        this.C_dName = C_dName;
        this.C_dType = C_dType;
        this.C_dQuantity = C_dQuantity;
        this.C_dExp = C_dExp;
        this.C_dId = C_dId;
         
    }
    
    public void clearFields(){
     
        C_dName.setText("");
        C_dType.setSelectedItem(-1);
        C_dQuantity.setText("");
        C_dExp.setSelectedItem(-1);
        C_dName.requestFocus();  // move cursor to first name feild
    }
    
    public void getValues(){
           
      dName = C_dName.getText();
      dType = C_dType.getSelectedItem().toString();
      dQuantity = C_dQuantity.getText();
      dExp = C_dExp.getSelectedItem().toString();
      drugNum = C_dId.getText();
        
    }


    public void insertToTable(JTable C_drug_table_view, JLabel C_dId){
        
        this.C_drug_table_view = C_drug_table_view;
        this.C_dId = C_dId;
        
        this.getValues();

        
            Drug_creation_Model a;
            a = new Drug_creation_Model();  // object Creation
            
            try {
            
                a.insertValues(dName, dType, dQuantity, dExp, drugNum);
            } catch (SQLException ex) {
                Logger.getLogger(Drug.class.getName()).log(Level.SEVERE, null, ex);
            }
               
              //object creation
            Drug_Enter_View AdIn = new Drug_Enter_View();
            JOptionPane.showMessageDialog(AdIn, "Drug created successfully! ");
           
            this.clearFields();
            Drug_creation_Model ac = new Drug_creation_Model(C_drug_table_view, C_dId);
            ac.drug_table();
            ac.autoAID();
            
        
        
    }
    
    
    public void updateTable(JTable C_drug_table_view, JLabel C_dId, JButton C_jButton3){
        
        this.C_drug_table_view = C_drug_table_view;
        this.C_dId = C_dId;
        
        this.getValues();
       
            Drug_creation_Model a;
            a = new Drug_creation_Model();
        
            try {
                a.updateValues(dName, dType, dQuantity, dExp, drugNum);
            } catch (SQLException ex) {
                Logger.getLogger(Drug.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                Drug_Enter_View AdIn = new Drug_Enter_View();
                JOptionPane.showMessageDialog(AdIn, "Drug Updated successfully! ");
          
                this.clearFields();
            
                Drug_creation_Model ac = new Drug_creation_Model(C_drug_table_view, C_dId);
                ac.drug_table();
                ac.autoAID();
            
                C_jButton3.setEnabled(true);
       
    }
    
    
    public void deleteItem(JTable C_drug_table_view, JLabel C_dId, JButton C_jButton3){
        
            drugNum = C_dId.getText();
            
            this.C_drug_table_view = C_drug_table_view;
            this.C_dId = C_dId;
        
            Drug_creation_Model ac = new Drug_creation_Model(C_drug_table_view, C_dId);
            ac.deleteValues(C_dId);
        
            Drug_Enter_View AdIn = new Drug_Enter_View();
            JOptionPane.showMessageDialog(AdIn, "Drug Deleted successfully! ");
          
            ac.drug_table();
            ac.autoAID();
           
           this.clearFields();
            C_jButton3.setEnabled(true);
    
    }
    
    
    public void getSelectedValues(JButton C_jButton3, JTable C_drug_table_view){
    
            DefaultTableModel d1 = (DefaultTableModel)C_drug_table_view.getModel();
            int SelectIndex = C_drug_table_view.getSelectedRow();   
        
            C_dId.setText(d1.getValueAt(SelectIndex, 0).toString());
            C_dName.setText(d1.getValueAt(SelectIndex, 1).toString());
            C_dType.setSelectedItem(d1.getValueAt(SelectIndex, 2).toString());
            C_dQuantity.setText(d1.getValueAt(SelectIndex, 3).toString());
            C_dExp.setSelectedItem(d1.getValueAt(SelectIndex, 4).toString());
           
            
            C_jButton3.setEnabled(false);    //invissible create button 
       
      
    }
  
}
    
    
    
    

