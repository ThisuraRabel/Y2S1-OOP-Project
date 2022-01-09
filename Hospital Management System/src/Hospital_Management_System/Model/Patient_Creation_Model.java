/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Thisura
 */
public class Patient_Creation_Model {
 
    
   
    private Connection con = null;
    private PreparedStatement pst;
    private ResultSet rs;
    private javax.swing.JTable D_PatientTable_view;
    private javax.swing.JLabel D_patient_id_label;
    
    
    public Patient_Creation_Model(){
          con = Utility_Class_connection.connect();
          
    }
    public Patient_Creation_Model(JTable D_PatientTable_view, JLabel D_patient_id_label){
          con = Utility_Class_connection.connect();
          this.D_PatientTable_view = D_PatientTable_view;
          this.D_patient_id_label = D_patient_id_label;
          
    }
    
    public void insertValues(String DfName, String DlName, String Dage, String Dgender, String Dnic, String DcontractNum,
                             String DpatientNum, String DpatientType, String DwardNo) throws SQLException{
        
        pst = con.prepareStatement("insert into patient(patient_no,first_name,last_name,age,gender,nic_num,contract_num,patient_type,ward_no)values(?,?,?,?,?,?,?,?,?)");
               pst.setString(1,DpatientNum); 
               pst.setString(2, DfName);
               pst.setString(3, DlName);
               pst.setString(4, Dage);
               pst.setString(5, Dgender);
               pst.setString(6, Dnic);
               pst.setString(7, DcontractNum);
               pst.setString(8, DpatientType);
               pst.setString(9, DwardNo);
               
               pst.executeUpdate();
        
    }
    
    public void updateValues(String DfName, String DlName, String Dage, String Dgender, String Dnic, String DcontractNum,
                             String DpatientNum, String DpatientType, String DwardNo) throws SQLException{
        
        pst = con.prepareStatement("update patient set first_name = ?, last_name = ?, age = ?, gender = ?, nic_num = ?, contract_num = ?,patient_type = ?,ward_no = ? where patient_no = ?");
               pst.setString(1, DfName);
               pst.setString(2, DlName);
               pst.setString(3, Dage);
               pst.setString(4, Dgender);
               pst.setString(5, Dnic);
               pst.setString(6, DcontractNum);
               pst.setString(7, DpatientType);
               pst.setString(8, DwardNo);
               pst.setString(9,DpatientNum); 
                
               pst.executeUpdate();
        
    }
    
    
    
    public void deleteValues(JLabel D_patient_id_label){
        this.D_patient_id_label = D_patient_id_label;
        
        try {  
            pst = con.prepareStatement("delete from patient where patient_no = ?");
            pst.setString(1, D_patient_id_label.getText());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
    
    
       public void search(JTextField sBox, JTable t){
        String searchT = sBox.getText();
        
        try {
            String sql = "SELECT * FROM patient WHERE first_name LIKE'%"+searchT+"%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
    public void patient_table(){
        try {
            
            pst = con.prepareStatement("select *from patient");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsm = rs.getMetaData();
            int c;
            c = rsm.getColumnCount();
            DefaultTableModel dt = (DefaultTableModel)D_PatientTable_view.getModel();
            
            dt.setRowCount(0);
            
            while(rs.next()){
                
                Vector v1 = new Vector();
                
                for(int i = 1; i < c; i++){
                     
                     v1.add(rs.getString("patient_no"));
                     v1.add(rs.getString("first_name"));
                     v1.add(rs.getString("last_name"));
                     v1.add(rs.getString("age"));
                     v1.add(rs.getString("gender"));
                     v1.add(rs.getString("nic_num"));
                     v1.add(rs.getString("contract_num"));
                     v1.add(rs.getString("patient_type"));
                     v1.add(rs.getString("ward_no"));
                }
                
                dt.addRow(v1);              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient_Creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }
    
    
           
        
    public void autoAID(){
    
        Statement s;
        try {
            
            s = con.createStatement();
            rs = s.executeQuery("select MAX(patient_no) from patient");
            rs.next();
            rs.getString("MAX(patient_no)");
            
            if( rs.getString("MAX(patient_no)") == null){
                
                D_patient_id_label.setText("PD001");
            }
            else{
                
                long id = Long.parseLong(rs.getString("MAX(patient_no)").substring(2,rs.getString("MAX(patient_no)").length()));
                id++;
                 D_patient_id_label.setText("PD" + String.format("%03d", id));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient_Creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
       
    }

 
           
  

    
    
}
