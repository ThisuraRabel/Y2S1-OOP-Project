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
public class Prescription_creation_Model {
    
    private Connection con = null;
    private PreparedStatement pst;
    private ResultSet rs;
    private javax.swing.JTable D_pTable;
    private javax.swing.JLabel D_pres_id_label;
    
    
    public Prescription_creation_Model(){
          con = Utility_Class_connection.connect();
          
    }
    public Prescription_creation_Model(JTable D_pTable, JLabel D_pres_id_label){
          con = Utility_Class_connection.connect();
          this.D_pTable = D_pTable;
          this.D_pres_id_label = D_pres_id_label;
          
    }
   
    
    public void insertValues(String DpName, String DpAge, String DpGender, String Dpdesease, String DpDescription,String DdName, String DpresID) throws SQLException{
        
        pst = con.prepareStatement("insert into prescription(prescription_no,patient_name,age,gender,desease,discription,doctor_name)values(?,?,?,?,?,?,?)");
               pst.setString(1,DpresID); 
               pst.setString(2, DpName);
               pst.setString(3, DpAge);
               pst.setString(4, DpGender);
               pst.setString(5, Dpdesease);
               pst.setString(6, DpDescription);
               pst.setString(7, DdName);
               pst.executeUpdate();
        
    }
    
    public void updateValues(String DpName, String DpAge, String DpGender, String Dpdesease, String DpDescription,String DdName, String DpresID) throws SQLException{
        
        pst = con.prepareStatement("update prescription set patient_name = ?,age = ?,gender = ?,desease = ?,discription = ?,doctor_name = ? where prescription_no = ?");
              
               pst.setString(1, DpName);
               pst.setString(2, DpAge);
               pst.setString(3, DpGender);
               pst.setString(4, Dpdesease);
               pst.setString(5, DpDescription);
               pst.setString(6, DdName);
               pst.setString(7,DpresID); 
               pst.executeUpdate();
        
    }
    
    
    
    public void deleteValues(JLabel D_pres_id_label){
        this.D_pres_id_label = D_pres_id_label;
        
        try {  
            pst = con.prepareStatement("delete from prescription where prescription_no = ?");
            pst.setString(1, D_pres_id_label.getText());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Prescription_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
    
    public void search(JTextField sBox, JTable t){
        String searchT = sBox.getText();
        
        try {
            String sql = "SELECT * FROM prescription WHERE patient_name LIKE'%"+searchT+"%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void prescription_table(){
        try {
           
            pst = con.prepareStatement("select *from prescription");
            
            rs = pst.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int c;
            c = rsm.getColumnCount();
            DefaultTableModel dt = (DefaultTableModel)D_pTable.getModel();
            
            dt.setRowCount(0);
            
            while(rs.next()){
                
                Vector v1 = new Vector();
                
                for(int i = 1; i < c; i++){
                     
                     v1.add(rs.getString("prescription_no"));
                     v1.add(rs.getString("patient_name"));
                     v1.add(rs.getString("age"));
                     v1.add(rs.getString("gender"));
                     v1.add(rs.getString("desease"));                    
                     v1.add(rs.getString("discription"));
                     v1.add(rs.getString("doctor_name"));
                     
                }
                
                dt.addRow(v1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Prescription_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void prescription_table(JTable t){
        try {
           
            pst = con.prepareStatement("select *from prescription");
            
            rs = pst.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int c;
            c = rsm.getColumnCount();
            DefaultTableModel dt = (DefaultTableModel)t.getModel();
            
            dt.setRowCount(0);
            
            while(rs.next()){
                
                Vector v1 = new Vector();
                
                for(int i = 1; i < c; i++){
                     
                     v1.add(rs.getString("prescription_no"));
                     v1.add(rs.getString("patient_name"));
                     v1.add(rs.getString("age"));
                     v1.add(rs.getString("gender"));
                     v1.add(rs.getString("desease"));                    
                     v1.add(rs.getString("discription"));
                     v1.add(rs.getString("doctor_name"));
                     
                }
                
                dt.addRow(v1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Prescription_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
   
    public void autoAID(){
    
        Statement s;
        try {
            s = con.createStatement();
            rs = s.executeQuery("select MAX(prescription_no) from prescription");
            rs.next();
            rs.getString("MAX(prescription_no)");
            
            if( rs.getString("MAX(prescription_no)") == null){
                
                D_pres_id_label.setText("PR001");
            }
            else{
                
                long id = Long.parseLong(rs.getString("MAX(prescription_no)").substring(2,rs.getString("MAX(prescription_no)").length()));
                id++;
                 D_pres_id_label.setText("PR" + String.format("%03d", id));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Prescription_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

}
