/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Controller;

import Hospital_Management_System.Model.Pharmasist_creation_Model;
import Hospital_Management_System.View.Pharmasist_Creation_View;
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
public class Pharmasist extends User{
    
 
    public Pharmasist( JTextField C_fName_tBox, JTextField C_lName_tBox, JTextField C_username_tBox, JTextField C_contractNo_tBox, 
                                        JTextField C_eMail_tBox, JPasswordField C_pass_pBox,JPasswordField C_reEnterPass_pBox, JLabel C_id_label){
        
                super(C_fName_tBox, C_lName_tBox ,C_username_tBox, C_contractNo_tBox, C_eMail_tBox , C_pass_pBox, C_reEnterPass_pBox, C_id_label);
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
        
    }
    
    public void clearFields(){
            C_fName_tBox.setText("");
            C_lName_tBox.setText("");
            C_username_tBox.setText("");
            C_contractNo_tBox.setText("");
            C_eMail_tBox.setText("");
            C_pass_pBox.setText("");
            C_reEnterPass_pBox.setText("");
            C_fName_tBox.requestFocus();  // move cursor to first name feild
    }

  
    @Override
    public void insertToTable(JTable C_PharmasistTable_view, JLabel C_pharmasist_id_label){
       
        
        this.getValues();

        if( password.equals(reEnterPass)){
            validPass = C_pass_pBox.getText();
          
            Pharmasist_creation_Model a;
            a = new Pharmasist_creation_Model();  // object Creation
            
            try {
                a.insertValues(fName, lName, userName, password, reEnterPass, validPass, contractNum, eMail, ID);
            } catch (SQLException ex) {
                Logger.getLogger(Pharmasist.class.getName()).log(Level.SEVERE, null, ex);
            }
               
              //object creation
            Pharmasist_Creation_View AdIn = new Pharmasist_Creation_View();
            JOptionPane.showMessageDialog(AdIn, "Pharmasist created successfully! ");
            this.clearFields();
            
            Pharmasist_creation_Model ac = new Pharmasist_creation_Model(C_PharmasistTable_view, C_pharmasist_id_label);
            ac.pharmasist_table();
            ac.autoAID();
            
        }
        else{
            Pharmasist_Creation_View AdIn = new Pharmasist_Creation_View();
            
            JOptionPane.showMessageDialog(AdIn, "Given Passwords are not Matching! ");
            this.clearFields();
                 

        }
        
    }
    
   
    @Override
    public void updateTable(JTable C_PharmasistTable_view, JLabel C_pharmasist_id_label, JButton C_jButton3){
        
        this.getValues();
        if( password.equals(reEnterPass)){
            validPass = C_pass_pBox.getText();
        
            Pharmasist_creation_Model a;
            a = new Pharmasist_creation_Model();
        
            try {
                a.updateValues(fName, lName, userName, password, reEnterPass, validPass, contractNum, eMail, ID);
            } catch (SQLException ex) {
                Logger.getLogger(Pharmasist.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                Pharmasist_Creation_View AdIn = new Pharmasist_Creation_View();
                JOptionPane.showMessageDialog(AdIn, "Pharmasist Updated successfully! ");
          
                this.clearFields();
            
                Pharmasist_creation_Model ac = new Pharmasist_creation_Model(C_PharmasistTable_view, C_pharmasist_id_label);
                ac.pharmasist_table();
                ac.autoAID();
            
                C_jButton3.setEnabled(true);
        }
        else{
             Pharmasist_Creation_View AdIn = new Pharmasist_Creation_View();
            
            JOptionPane.showMessageDialog(AdIn, "Given Passwords are not Matching! ");
            this.clearFields();
            C_jButton3.setEnabled(true);
            
        }
      
    }
    
    /**
     *
     * @param C_PharmasistTable_view
     * @param C_pharmasist_id_label
     * @param C_jButton3
     */
    @Override
    public void deleteItem(JTable C_PharmasistTable_view, JLabel C_pharmasist_id_label, JButton C_jButton3){
        
            ID = C_pharmasist_id_label.getText();
            
            Pharmasist_creation_Model ac = new Pharmasist_creation_Model(C_PharmasistTable_view, C_pharmasist_id_label);
            ac.deleteValues(C_pharmasist_id_label);
        
            Pharmasist_Creation_View AdIn = new Pharmasist_Creation_View();
            JOptionPane.showMessageDialog(AdIn, "Pharmasist Deleted successfully! ");
          
            ac.pharmasist_table();
            ac.autoAID();
           
            this.clearFields();
            C_jButton3.setEnabled(true);
    
    }
    
    
    public void getSelectedValues(JButton C_jButton3, JTable C_PharmasistTable_view){
    
            DefaultTableModel d1 = (DefaultTableModel)C_PharmasistTable_view.getModel();
            int SelectIndex = C_PharmasistTable_view.getSelectedRow();   
        
            C_id_label.setText(d1.getValueAt(SelectIndex, 0).toString());
            C_fName_tBox.setText(d1.getValueAt(SelectIndex, 1).toString());
            C_lName_tBox.setText(d1.getValueAt(SelectIndex, 2).toString());
            C_username_tBox.setText(d1.getValueAt(SelectIndex, 3).toString());
            C_pass_pBox.setText(d1.getValueAt(SelectIndex, 4).toString());
            C_contractNo_tBox.setText(d1.getValueAt(SelectIndex, 5).toString());
            C_eMail_tBox.setText(d1.getValueAt(SelectIndex, 6).toString());
            C_jButton3.setEnabled(false);    //invissible create button 
   
    }
       
    
}
    
    
    
    

