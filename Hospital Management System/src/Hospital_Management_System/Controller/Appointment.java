/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Controller;

import Hospital_Management_System.Model.Appointment_creation_Model;
import Hospital_Management_System.View.Appointment_Creation_View;
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
public class Appointment /*extends User*/{
 
    private String AppointmentNum;
    private String fName;
    private String lName;
    private String time;
    private String fee;
    private String date;
    private String contractNum;
    private String eMail;
    private String docUsername;
    
    private final javax.swing.JTextField C_fName_tBox;
    private final javax.swing.JTextField C_lName_tBox;
    private final javax.swing.JTextField C_time_tBox;
    private final javax.swing.JTextField C_fee_tBox;
    private final javax.swing.JTextField C_date_tBox;
    private final javax.swing.JTextField C_conNum_pBox;
    private final javax.swing.JTextField C_email_pBox;
    private javax.swing.JTable C_AppointmentTable_view;
    private javax.swing.JLabel C_appointment_id_label;
    private final javax.swing.JTextField C_doctor_id_tBox;
    
  
    public Appointment( JTextField C_fName_tBox, JTextField C_lName_tBox, JTextField C_time_tBox, JTextField C_fee_tBox, JTextField C_date_tBox,
                                        JTextField C_conNum_pBox,JTextField C_email_pBox, JLabel C_appointment_id_label, JTextField C_doctor_id_tBox){
        
        this.C_fName_tBox = C_fName_tBox;
        this.C_lName_tBox = C_lName_tBox;
        this.C_time_tBox = C_time_tBox;
        this.C_fee_tBox = C_fee_tBox;
        this.C_date_tBox = C_date_tBox;
        this.C_conNum_pBox = C_conNum_pBox;
        this.C_email_pBox = C_email_pBox;
        this.C_appointment_id_label = C_appointment_id_label;
        this.C_doctor_id_tBox = C_doctor_id_tBox;
    
    }
    
    public void clearFeilds(){
            C_fName_tBox.setText("");
            C_lName_tBox.setText("");
            C_time_tBox.setText("");
            C_fee_tBox.setText("");
            C_date_tBox.setText("");
            C_conNum_pBox.setText("");
            C_email_pBox.setText("");
            C_doctor_id_tBox.setText("");
            C_fName_tBox.requestFocus();  // move cursor to first name feild
    }
    
    public void getValues(){
      fName = C_fName_tBox.getText();
      lName = C_lName_tBox.getText();
      time = C_time_tBox.getText();
      fee = C_fee_tBox.getText();
      eMail = C_email_pBox.getText();
      date = C_date_tBox.getText();  
      contractNum = C_conNum_pBox.getText();
      AppointmentNum = C_appointment_id_label.getText();
      docUsername = C_doctor_id_tBox.getText();
        
    }


    public void insertToTable(JTable C_AppointmentTable_view, JLabel C_appointment_id_label){
        
        this.C_AppointmentTable_view = C_AppointmentTable_view;
        this.C_appointment_id_label = C_appointment_id_label;
        
        this.getValues();

            Appointment_creation_Model a;
            a = new Appointment_creation_Model();  // object Creation
            
            try {
                a.insertValues(fName, lName, time, fee, date, contractNum, eMail, AppointmentNum, docUsername);
            } catch (SQLException ex) {
                Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
            }
               
              //object creation
            Appointment_Creation_View AdIn = new Appointment_Creation_View();
            JOptionPane.showMessageDialog(AdIn, "Appointment created successfully! ");
            
            clearFeilds();
            
            Appointment_creation_Model ac = new Appointment_creation_Model(C_AppointmentTable_view, C_appointment_id_label);
            ac.appointment_table();
            ac.autoAID();
      
    }
    
    
    public void updateTable(JTable C_AppointmentTable_view, JLabel C_appointment_id_label, JButton C_jButton3){
        
        this.C_AppointmentTable_view = C_AppointmentTable_view;
        this.C_appointment_id_label = C_appointment_id_label;
        
        this.getValues();
     
            Appointment_creation_Model a;
            a = new Appointment_creation_Model();
        
            try {
                a.updateValues(fName, lName, time, fee, date, contractNum, eMail, AppointmentNum, docUsername);
            } catch (SQLException ex) {
                Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                Appointment_Creation_View AdIn = new Appointment_Creation_View();
                JOptionPane.showMessageDialog(AdIn, "Appointment Updated successfully! ");
          
           
                clearFeilds();
            
                Appointment_creation_Model ac = new Appointment_creation_Model(C_AppointmentTable_view, C_appointment_id_label);
                ac.appointment_table();
                ac.autoAID();
            
                C_jButton3.setEnabled(true);
        
    }
    
    
    public void deleteItem(JTable C_AppointmentTable_view, JLabel C_appointment_id_label, JButton C_jButton3){
        
            AppointmentNum = C_appointment_id_label.getText();
            
            this.C_AppointmentTable_view = C_AppointmentTable_view;
            this.C_appointment_id_label = C_appointment_id_label;
        
            Appointment_creation_Model ac = new Appointment_creation_Model(C_AppointmentTable_view, C_appointment_id_label);
            ac.deleteValues(C_appointment_id_label);
        
            Appointment_Creation_View AdIn = new Appointment_Creation_View();
            JOptionPane.showMessageDialog(AdIn, "Appointment Deleted successfully! ");
          
            ac.appointment_table();
            ac.autoAID();
           
            clearFeilds();
            C_jButton3.setEnabled(true);
    
    }
    
    
    public void getSelectedValues(JButton C_jButton3, JTable C_AppointmentTable_view){
    
            DefaultTableModel d1 = (DefaultTableModel)C_AppointmentTable_view.getModel();
            int SelectIndex = C_AppointmentTable_view.getSelectedRow();   
        
            C_appointment_id_label.setText(d1.getValueAt(SelectIndex, 0).toString());
            C_fName_tBox.setText(d1.getValueAt(SelectIndex, 1).toString());
            C_lName_tBox.setText(d1.getValueAt(SelectIndex, 2).toString());
            C_date_tBox.setText(d1.getValueAt(SelectIndex, 3).toString());
            C_time_tBox.setText(d1.getValueAt(SelectIndex, 4).toString());
            C_conNum_pBox.setText(d1.getValueAt(SelectIndex, 5).toString());
            C_email_pBox.setText(d1.getValueAt(SelectIndex, 6).toString());
            C_fee_tBox.setText(d1.getValueAt(SelectIndex, 7).toString());
            C_doctor_id_tBox.setText(d1.getValueAt(SelectIndex, 8).toString());
            
            C_jButton3.setEnabled(false);    //invissible create button 
   
    }
 
}
    
    
    
    

