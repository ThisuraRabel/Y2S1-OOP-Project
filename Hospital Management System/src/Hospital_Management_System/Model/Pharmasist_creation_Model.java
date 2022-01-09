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
public class Pharmasist_creation_Model {
    
    private Connection con = null;
    private PreparedStatement pst;
    private ResultSet rs;
    private javax.swing.JTable D_ReceptionistTable_view;
    private javax.swing.JLabel D_receptionist_id_label;
    
    
    public Pharmasist_creation_Model(){
          con = Utility_Class_connection.connect();
          
    }
    public Pharmasist_creation_Model(JTable D_ReceptionistTable_view, JLabel D_receptionist_id_label){
          con = Utility_Class_connection.connect();
          this.D_ReceptionistTable_view = D_ReceptionistTable_view;
          this.D_receptionist_id_label = D_receptionist_id_label;
          
    }
    
    public void insertValues(String DfName, String DlName, String DuserName, String Dpassword, String DreEnterPass, String DvalidPass,
                             String DcontractNum, String DeMail, String DPharmasistNum) throws SQLException{
        
        pst = con.prepareStatement("insert into pharmasist(pharmasist_no,first_name,last_name,username,password,contract_number,email)values(?,?,?,?,?,?,?)");
               pst.setString(1,DPharmasistNum); 
               pst.setString(2, DfName);
               pst.setString(3, DlName);
               pst.setString(4, DuserName);
               pst.setString(5, Dpassword);
               pst.setString(6, DcontractNum);
               pst.setString(7, DeMail);
               pst.executeUpdate();
        
    }
    
    public void updateValues(String DfName, String DlName, String DuserName, String Dpassword, String DreEnterPass, String DvalidPass,
                             String DcontractNum, String DeMail, String DPharmasistNum) throws SQLException{
        
        pst = con.prepareStatement("update pharmasist set first_name = ?,last_name = ?,username = ?,password = ?,contract_number = ?,email = ? where pharmasist_no = ?");
               pst.setString(1, DfName);
               pst.setString(2, DlName);
               pst.setString(3, DuserName);
               pst.setString(4, Dpassword);
               pst.setString(5, DcontractNum);
               pst.setString(6, DeMail);
               pst.setString(7,DPharmasistNum); 
               pst.executeUpdate();
        
    }
    
    
    
    public void deleteValues(JLabel D_receptionist_id_label){
        this.D_receptionist_id_label = D_receptionist_id_label;
        
        try {  
            pst = con.prepareStatement("delete from pharmasist where pharmasist_no = ?");
            pst.setString(1, D_receptionist_id_label.getText());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Pharmasist_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
    
    
      public void search(JTextField sBox, JTable t){
        String searchT = sBox.getText();
        
        try {
            String sql = "SELECT * FROM pharmasist WHERE first_name LIKE'%"+searchT+"%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void pharmasist_table(){
        try {
           
            pst = con.prepareStatement("select *from pharmasist");
            
            rs = pst.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int c;
            c = rsm.getColumnCount();
            DefaultTableModel dt = (DefaultTableModel)D_ReceptionistTable_view.getModel();
            
            dt.setRowCount(0);
            
            while(rs.next()){
                
                Vector v1 = new Vector();
                
                for(int i = 1; i < c; i++){
                     
                     v1.add(rs.getString("pharmasist_no"));
                     v1.add(rs.getString("first_name"));
                     v1.add(rs.getString("last_name"));
                     v1.add(rs.getString("username"));
                     v1.add(rs.getString("password"));
                     v1.add(rs.getString("contract_number"));
                     v1.add(rs.getString("email"));
                }
                
                dt.addRow(v1);
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Pharmasist_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    
    
            
        
    public void autoAID(){
    
        Statement s;
        try {
            s = con.createStatement();
            rs = s.executeQuery("select MAX(pharmasist_no) from pharmasist");
            rs.next();
            rs.getString("MAX(pharmasist_no)");
            
            if( rs.getString("MAX(pharmasist_no)") == null){
                
                D_receptionist_id_label.setText("PH001");
            }
            else{
                
                long id = Long.parseLong(rs.getString("MAX(pharmasist_no)").substring(2,rs.getString("MAX(pharmasist_no)").length()));
                id++;
                 D_receptionist_id_label.setText("PH" + String.format("%03d", id));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Pharmasist_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
            
  
            
        
       
    }
           
            
          
    
}
