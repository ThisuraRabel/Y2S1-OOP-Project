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
public class Drug_creation_Model {
    
    private Connection con = null;
    private PreparedStatement pst;
    private ResultSet rs;
    private javax.swing.JTable D_ward_table_view;
    private javax.swing.JLabel D_ward_id_label;
    
    
    public Drug_creation_Model(){
          con = Utility_Class_connection.connect();
          
    }
    public Drug_creation_Model(JTable D_ward_table_view, JLabel D_ward_id_label){
          con = Utility_Class_connection.connect();
          this.D_ward_table_view = D_ward_table_view;
          this.D_ward_id_label = D_ward_id_label;
          
    }
    //DdName, DdType, DdQuantity, DdExp, DdrugNum
    
    
    public void insertValues(String DdName, String DdType, String DdQuantity,String DdExp, String DdrugNum) throws SQLException{
        
        pst = con.prepareStatement("insert into drug(DrugID,Name,Type,Quantity,ExpYear)values(?,?,?,?,?)");
               
               pst.setString(1, DdrugNum);
               pst.setString(2,DdName); 
               pst.setString(3, DdType);
               pst.setString(4, DdQuantity);
               pst.setString(5, DdExp);
     
               pst.executeUpdate();
        
    }
    
    public void updateValues(String DdName, String DdType, String DdQuantity,String DdExp, String DdrugNum) throws SQLException{
        
        pst = con.prepareStatement("update drug set Name = ?,Type = ?,Quantity = ?,ExpYear = ? where DrugID = ?");
               
               pst.setString(1,DdName); 
               pst.setString(2, DdType);
               pst.setString(3, DdQuantity);
               pst.setString(4, DdExp);
               pst.setString(5, DdrugNum);
               pst.executeUpdate();
        
    }
    
    
    
    public void deleteValues(JLabel D_ward_id_label){
        this.D_ward_id_label = D_ward_id_label;
        
        try {  
            pst = con.prepareStatement("delete from drug where DrugID = ?");
            pst.setString(1, D_ward_id_label.getText());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Drug_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
    
    public void search(JTextField sBox, JTable t){
        String searchT = sBox.getText();
        
        try {
            String sql = "SELECT * FROM drug WHERE Name LIKE'%"+searchT+"%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void drug_table(){
        try {
           
            pst = con.prepareStatement("select *from drug");
            
            rs = pst.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int c;
            c = rsm.getColumnCount();
            DefaultTableModel dt = (DefaultTableModel)D_ward_table_view.getModel();
            
            dt.setRowCount(0);
            
            while(rs.next()){
                
                Vector v1 = new Vector();
                
                for(int i = 1; i < c; i++){
                     //DrugID,Name,Type,Quantity,ExpYear
                     v1.add(rs.getString("DrugID"));
                     v1.add(rs.getString("Name"));
                     v1.add(rs.getString("Type"));
                     v1.add(rs.getString("Quantity"));
                     v1.add(rs.getString("ExpYear"));
                   
                }
                
                dt.addRow(v1);
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Drug_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
        public void drug_table(JTable t){
        try {
           
            pst = con.prepareStatement("select *from drug");
            
            rs = pst.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int c;
            c = rsm.getColumnCount();
            DefaultTableModel dt = (DefaultTableModel)t.getModel();
            
            dt.setRowCount(0);
            
            while(rs.next()){
                
                Vector v1 = new Vector();
                
                for(int i = 1; i < c; i++){
                     
                     v1.add(rs.getString("DrugID"));
                     v1.add(rs.getString("Name"));
                     v1.add(rs.getString("Type"));
                     v1.add(rs.getString("Quantity"));
                     v1.add(rs.getString("ExpYear"));
                }
                
                dt.addRow(v1);
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Drug_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
            
        
    public void autoAID(){
    
        Statement s;
        try {
            s = con.createStatement();
            rs = s.executeQuery("select MAX(DrugID) from drug");
            rs.next();
            rs.getString("MAX(DrugID)");
            
            if( rs.getString("MAX(DrugID)") == null){
                
                D_ward_id_label.setText("DG001");
            }
            else{
                
                long id = Long.parseLong(rs.getString("MAX(DrugID)").substring(2,rs.getString("MAX(DrugID)").length()));
                id++;
                 D_ward_id_label.setText("DG" + String.format("%03d", id));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Drug_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
            
  
            
        
       
    }
           
            
          
    
}
