/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Controller;

import Hospital_Management_System.Model.Ward_creation_Model;
import Hospital_Management_System.View.Enter_Ward_Details_View;
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
public class Ward /*extends User*/{
    
    
    private String wardNum;
    private String wardtype;
    private String dnameboxme;
    private String noofnurse;
    private String noofbeds;
    private String noofpatients;
    private javax.swing.JComboBox C_wardtypebox;
    private final javax.swing.JTextField C_dnamebox;
    private final javax.swing.JTextField C_noofnursesbox;
    private final javax.swing.JTextField C_noofbedsbox;
    private final javax.swing.JTextField C_noofpatientsbox;
    private javax.swing.JTable C_ward_table_view;
    private javax.swing.JLabel C_ward_id_label;
     
    //wardtypebox, dnamebox, noofnursesbox, noofbedsbox, noofpatientsbox, ward_id_label
    
    public Ward( JComboBox C_wardtypebox, JTextField C_dnamebox, JTextField C_noofnursesbox, JTextField C_noofbedsbox,JTextField C_noofpatientsbox,
                 JLabel C_ward_id_label){
        
        this.C_wardtypebox = C_wardtypebox;
        this.C_dnamebox = C_dnamebox;
        this.C_noofnursesbox = C_noofnursesbox;
        this.C_noofbedsbox = C_noofbedsbox;
        this.C_noofpatientsbox = C_noofpatientsbox;
        this.C_ward_id_label = C_ward_id_label;
         
    }
    
    public void clearFields(){
     
        C_wardtypebox.setSelectedItem(-1);
        C_dnamebox.setText("");
        C_noofnursesbox.setText("");
        C_noofbedsbox.setText("");
        C_noofpatientsbox.setText("");
        C_dnamebox.requestFocus();  // move cursor to first name feild
    }
    
    public void getValues(){
           
     
      wardtype = C_wardtypebox.getSelectedItem().toString();
      dnameboxme = C_dnamebox.getText();
      noofnurse = C_noofnursesbox.getText();
      noofbeds = C_noofbedsbox.getText();
      noofpatients = C_noofpatientsbox.getText();
      wardNum = C_ward_id_label.getText();
        
    }


    public void insertToTable(JTable C_ward_table_view, JLabel C_receptionist_id_label){
        
        this.C_ward_table_view = C_ward_table_view;
        this.C_ward_id_label = C_receptionist_id_label;
        
        this.getValues();

        
            Ward_creation_Model a;
            a = new Ward_creation_Model();  // object Creation
            
            try {
            
                a.insertValues(wardtype, dnameboxme, noofnurse, noofbeds, noofpatients, wardNum);
            } catch (SQLException ex) {
                Logger.getLogger(Ward.class.getName()).log(Level.SEVERE, null, ex);
            }
               
              //object creation
            Enter_Ward_Details_View AdIn = new Enter_Ward_Details_View();
            JOptionPane.showMessageDialog(AdIn, "Ward created successfully! ");
           
            this.clearFields();
            Ward_creation_Model ac = new Ward_creation_Model(C_ward_table_view, C_receptionist_id_label);
            ac.ward_table();
            ac.autoAID();
            
        
        
    }
    
    
    public void updateTable(JTable C_ward_table_view, JLabel C_ward_id_label, JButton C_jButton3){
        
        this.C_ward_table_view = C_ward_table_view;
        this.C_ward_id_label = C_ward_id_label;
        
        this.getValues();
       
            Ward_creation_Model a;
            a = new Ward_creation_Model();
        
            try {
                a.updateValues(wardtype, dnameboxme, noofnurse, noofbeds, noofpatients, wardNum);
            } catch (SQLException ex) {
                Logger.getLogger(Ward.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                Enter_Ward_Details_View AdIn = new Enter_Ward_Details_View();
                JOptionPane.showMessageDialog(AdIn, "Ward Updated successfully! ");
          
                this.clearFields();
            
                Ward_creation_Model ac = new Ward_creation_Model(C_ward_table_view, C_ward_id_label);
                ac.ward_table();
                ac.autoAID();
            
                C_jButton3.setEnabled(true);
       
    }
    
    
    public void deleteItem(JTable C_ward_table_view, JLabel C_ward_id_label, JButton C_jButton3){
        
            wardNum = C_ward_id_label.getText();
            
            this.C_ward_table_view = C_ward_table_view;
            this.C_ward_id_label = C_ward_id_label;
        
            Ward_creation_Model ac = new Ward_creation_Model(C_ward_table_view, C_ward_id_label);
            ac.deleteValues(C_ward_id_label);
        
            Enter_Ward_Details_View AdIn = new Enter_Ward_Details_View();
            JOptionPane.showMessageDialog(AdIn, "Ward Deleted successfully! ");
          
            ac.ward_table();
            ac.autoAID();
           
           this.clearFields();
            C_jButton3.setEnabled(true);
    
    }
    
    
    public void getSelectedValues(JButton C_jButton3, JTable C_ward_table_view){
    
            DefaultTableModel d1 = (DefaultTableModel)C_ward_table_view.getModel();
            int SelectIndex = C_ward_table_view.getSelectedRow();   
        
            C_ward_id_label.setText(d1.getValueAt(SelectIndex, 0).toString());
            C_wardtypebox.setSelectedItem(d1.getValueAt(SelectIndex, 1).toString());
            C_dnamebox.setText(d1.getValueAt(SelectIndex, 2).toString());
            C_noofnursesbox.setText(d1.getValueAt(SelectIndex, 3).toString());
            C_noofbedsbox.setText(d1.getValueAt(SelectIndex, 4).toString());
            C_noofpatientsbox.setText(d1.getValueAt(SelectIndex, 5).toString());
            C_jButton3.setEnabled(false);    //invissible create button 
      
    }
  
}
    
    
    
    

