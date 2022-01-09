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
public class Nurse_creation_Model {
    
    private Connection con = null;
    private PreparedStatement pst;
    private ResultSet rs;
    private javax.swing.JTable D_nurse_table;
    private javax.swing.JLabel D_nurseID_label;
    
    
    public Nurse_creation_Model(){
          con = Utility_Class_connection.connect();
          
    }
    public Nurse_creation_Model(JTable D_nurse_table, JLabel D_nurseID_label){
          con = Utility_Class_connection.connect();
          this.D_nurse_table = D_nurse_table;
          this.D_nurseID_label = D_nurseID_label;
          
    }
    //wardNo, contractNum, eMail, NurseNum
    
    public void insertValues(String DfName, String DlName, String DwardNo,String DcontractNum, String DeMail, String DNurseNum) throws SQLException{
        
        pst = con.prepareStatement("insert into nurse(nurse_no,first_name,last_name,ward_no,contract_number,email)values(?,?,?,?,?,?)");
               pst.setString(1,DNurseNum); 
               pst.setString(2, DfName);
               pst.setString(3, DlName);
               pst.setString(4, DwardNo);
               pst.setString(5, DcontractNum);
               pst.setString(6, DeMail);
               pst.executeUpdate();
        
    }
    
    public void updateValues(String DfName, String DlName, String DwardNo, String DcontractNum, String DeMail, String DNurseNum) throws SQLException{
        
        pst = con.prepareStatement("update nurse set first_name = ?,last_name = ?,ward_no = ?,contract_number = ?,email = ? where nurse_no = ?");
               pst.setString(1, DfName);
               pst.setString(2, DlName);
               pst.setString(3, DwardNo);
               pst.setString(4, DcontractNum);
               pst.setString(5, DeMail);
               pst.setString(6,DNurseNum); 
               pst.executeUpdate();
        
    }
    
    
    
    public void deleteValues(JLabel D_nurseID_label){
        this.D_nurseID_label = D_nurseID_label;
        
        try {  
            pst = con.prepareStatement("delete from nurse where nurse_no = ?");
            pst.setString(1, D_nurseID_label.getText());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Nurse_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
    
    public void search(JTextField sBox, JTable t){
        String searchT = sBox.getText();
        
        try {
            String sql = "SELECT * FROM nurse WHERE first_name LIKE'%"+searchT+"%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void nurse_table(){
        try {
           
            pst = con.prepareStatement("select *from nurse");
            
            rs = pst.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int c;
            c = rsm.getColumnCount();
            DefaultTableModel dt = (DefaultTableModel)D_nurse_table.getModel();
            
            dt.setRowCount(0);
            
            while(rs.next()){
                
                Vector v1 = new Vector();
                
                for(int i = 1; i < c; i++){
                     
                     v1.add(rs.getString("nurse_no"));
                     v1.add(rs.getString("first_name"));
                     v1.add(rs.getString("last_name"));
                     v1.add(rs.getString("ward_no"));
                     v1.add(rs.getString("contract_number"));
                     v1.add(rs.getString("email"));
                }
                
                dt.addRow(v1);
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Nurse_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    
    
            
        
    public void autoAID(){
    
        Statement s;
        try {
            s = con.createStatement();
            rs = s.executeQuery("select MAX(nurse_no) from nurse");
            rs.next();
            rs.getString("MAX(nurse_no)");
            
            if( rs.getString("MAX(nurse_no)") == null){
                
                D_nurseID_label.setText("NR001");
            }
            else{
                
                long id = Long.parseLong(rs.getString("MAX(nurse_no)").substring(2,rs.getString("MAX(nurse_no)").length()));
                id++;
                 D_nurseID_label.setText("NR" + String.format("%03d", id));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Nurse_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
            
  
            
        
       
    }
           
            
          
    
}
