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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Thisura
 */
public class Admin_creation_Model {
    
    private Connection con = null;
    private PreparedStatement pst;
    private ResultSet rs;
    private javax.swing.JTable D_AdminTable_view;
    private javax.swing.JLabel D_admin_id_label;
    
    
    public Admin_creation_Model(){
          con = Utility_Class_connection.connect();
          
    }
    public Admin_creation_Model(JTable D_AdminTable_view, JLabel D_admin_id_label){
          con = Utility_Class_connection.connect();
          this.D_AdminTable_view = D_AdminTable_view;
          this.D_admin_id_label = D_admin_id_label;
          
    }
    
    public void insertValues(String DfName, String DlName, String DuserName, String Dpassword, String DreEnterPass, String DvalidPass,
                             String DcontractNum, String DeMail, String DadminNum) throws SQLException{
        
        pst = con.prepareStatement("insert into admin(admin_no,first_name,last_name,username,password,contract_number,email)values(?,?,?,?,?,?,?)");
               pst.setString(1,DadminNum); 
               pst.setString(2, DfName);
               pst.setString(3, DlName);
               pst.setString(4, DuserName);
               pst.setString(5, Dpassword);
               pst.setString(6, DcontractNum);
               pst.setString(7, DeMail);
               pst.executeUpdate();
        
    }
    
    public void updateValues(String DfName, String DlName, String DuserName, String Dpassword, String DreEnterPass, String DvalidPass,
                             String DcontractNum, String DeMail, String DadminNum) throws SQLException{
        
        pst = con.prepareStatement("update admin set first_name = ?,last_name = ?,username = ?,password = ?,contract_number = ?,email = ? where admin_no = ?");
               pst.setString(1, DfName);
               pst.setString(2, DlName);
               pst.setString(3, DuserName);
               pst.setString(4, Dpassword);
               pst.setString(5, DcontractNum);
               pst.setString(6, DeMail);
               pst.setString(7,DadminNum); 
               pst.executeUpdate();
        
    }
    
    
    
    public void deleteValues(JLabel D_admin_id_label){
        this.D_admin_id_label = D_admin_id_label;
        
        try {  
            pst = con.prepareStatement("delete from admin where admin_no = ?");
            pst.setString(1, D_admin_id_label.getText());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
    
    
    public void admin_table(){
        try {
           
            pst = con.prepareStatement("select *from admin");
            
            rs = pst.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int c;
            c = rsm.getColumnCount();
            DefaultTableModel dt = (DefaultTableModel)D_AdminTable_view.getModel();
            
            dt.setRowCount(0);
            
            while(rs.next()){
                
                Vector v1 = new Vector();
                
                for(int i = 1; i < c; i++){
                     
                     v1.add(rs.getString("admin_no"));
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
            Logger.getLogger(Admin_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    
    
            
        
    public void autoAID(){
    
        Statement s;
        try {
            s = con.createStatement();
            rs = s.executeQuery("select MAX(admin_no) from admin");
            rs.next();
            rs.getString("MAX(admin_no)");
            
            if( rs.getString("MAX(admin_no)") == null){
                
                D_admin_id_label.setText("AD001");
            }
            else{
                
                long id = Long.parseLong(rs.getString("MAX(admin_no)").substring(2,rs.getString("MAX(admin_no)").length()));
                id++;
                 D_admin_id_label.setText("AD" + String.format("%03d", id));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }
           
            
          
    
}
