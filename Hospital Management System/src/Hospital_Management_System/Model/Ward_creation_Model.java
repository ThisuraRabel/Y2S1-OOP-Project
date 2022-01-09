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
public class Ward_creation_Model {
    
    private Connection con = null;
    private PreparedStatement pst;
    private ResultSet rs;
    private javax.swing.JTable D_ward_table_view;
    private javax.swing.JLabel D_ward_id_label;
    
    
    public Ward_creation_Model(){
          con = Utility_Class_connection.connect();
          
    }
    public Ward_creation_Model(JTable D_ward_table_view, JLabel D_ward_id_label){
          con = Utility_Class_connection.connect();
          this.D_ward_table_view = D_ward_table_view;
          this.D_ward_id_label = D_ward_id_label;
          
    }
    //Dwardtype, Ddnameboxme, Dnoofnurse, Dnoofbeds, Dnoofpatients, DwardNum
    
    
    public void insertValues(String Dwardtype, String Ddnameboxme, String Dnoofnurse,String Dnoofbeds, String Dnoofpatients, String DwardNum) throws SQLException{
        
        pst = con.prepareStatement("insert into ward(WardNo,WardType,DoctorName,NoOfNurses,NoOfBeds,NoOfPatients)values(?,?,?,?,?,?)");
               
               pst.setString(1, DwardNum);
               pst.setString(2,Dwardtype); 
               pst.setString(3, Ddnameboxme);
               pst.setString(4, Dnoofnurse);
               pst.setString(5, Dnoofbeds);
               pst.setString(6, Dnoofpatients);
               
               pst.executeUpdate();
        
    }
    
    public void updateValues(String Dwardtype, String Ddnameboxme, String Dnoofnurse,String Dnoofbeds, String Dnoofpatients, String DwardNum) throws SQLException{
        
        pst = con.prepareStatement("update ward set WardType = ?,DoctorName = ?,NoOfNurses = ?,NoOfBeds = ?,NoOfPatients = ? where WardNo = ?");
               pst.setString(1,Dwardtype); 
               pst.setString(2, Ddnameboxme);
               pst.setString(3, Dnoofnurse);
               pst.setString(4, Dnoofbeds);
               pst.setString(5, Dnoofpatients);
               pst.setString(6, DwardNum);
               pst.executeUpdate();
        
    }
    
    
    
    public void deleteValues(JLabel D_ward_id_label){
        this.D_ward_id_label = D_ward_id_label;
        
        try {  
            pst = con.prepareStatement("delete from ward where WardNo = ?");
            pst.setString(1, D_ward_id_label.getText());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Ward_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
    
     public void search(JTextField sBox, JTable t){
        String searchT = sBox.getText();
        
        try {
            String sql = "SELECT * FROM ward WHERE WardNo LIKE'%"+searchT+"%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
    public void ward_table(){
        try {
           
            pst = con.prepareStatement("select *from ward");
            
            rs = pst.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int c;
            c = rsm.getColumnCount();
            DefaultTableModel dt = (DefaultTableModel)D_ward_table_view.getModel();
            
            dt.setRowCount(0);
            
            while(rs.next()){
                
                Vector v1 = new Vector();
                
                for(int i = 1; i < c; i++){
                     
                     v1.add(rs.getString("WardNo"));
                     v1.add(rs.getString("WardType"));
                     v1.add(rs.getString("DoctorName"));
                     v1.add(rs.getString("NoOfNurses"));
                     v1.add(rs.getString("NoOfBeds"));
                     v1.add(rs.getString("NoOfPatients"));
                }
                
                dt.addRow(v1);
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Ward_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
        public void ward_table(JTable t){
        try {
           
            pst = con.prepareStatement("select *from ward");
            
            rs = pst.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int c;
            c = rsm.getColumnCount();
            DefaultTableModel dt = (DefaultTableModel)t.getModel();
            
            dt.setRowCount(0);
            
            while(rs.next()){
                
                Vector v1 = new Vector();
                
                for(int i = 1; i < c; i++){
                     
                     v1.add(rs.getString("WardNo"));
                     v1.add(rs.getString("WardType"));
                     v1.add(rs.getString("DoctorName"));
                     v1.add(rs.getString("NoOfNurses"));
                     v1.add(rs.getString("NoOfBeds"));
                     v1.add(rs.getString("NoOfPatients"));
                }
                
                dt.addRow(v1);
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Ward_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
            
        
    public void autoAID(){
    
        Statement s;
        try {
            s = con.createStatement();
            rs = s.executeQuery("select MAX(WardNo) from ward");
            rs.next();
            rs.getString("MAX(WardNo)");
            
            if( rs.getString("MAX(WardNo)") == null){
                
                D_ward_id_label.setText("WD001");
            }
            else{
                
                long id = Long.parseLong(rs.getString("MAX(WardNo)").substring(2,rs.getString("MAX(WardNo)").length()));
                id++;
                 D_ward_id_label.setText("WD" + String.format("%03d", id));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Ward_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
            
  
            
        
       
    }
           
            
          
    
}
