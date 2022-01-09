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
public class Appointment_creation_Model {
    
    private Connection con = null;
    private PreparedStatement pst;
    private ResultSet rs;
    private javax.swing.JTable D_ReceptionistTable_view;
    private javax.swing.JLabel D_receptionist_id_label;
    
    
    public Appointment_creation_Model(){
          con = Utility_Class_connection.connect();
          
    }
    public Appointment_creation_Model(JTable D_ReceptionistTable_view, JLabel D_receptionist_id_label){
          con = Utility_Class_connection.connect();
          this.D_ReceptionistTable_view = D_ReceptionistTable_view;
          this.D_receptionist_id_label = D_receptionist_id_label;
          
    }
    
    //fName, lName, time, fee, date, contractNum, eMail, AppointmentNum
    public void insertValues(String DfName, String DlName, String Dtime, String Dfee, String Ddate,
                             String DcontractNum, String DeMail, String DappointmentNo, String DuserName) throws SQLException{
        
        pst = con.prepareStatement("insert into appointment(appointment_no,first_name,last_name,time,fee,date,contract_num,email,d_user_name)values(?,?,?,?,?,?,?,?,?)");
               pst.setString(1,DappointmentNo); 
               pst.setString(2, DfName);
               pst.setString(3, DlName);
               pst.setString(4, Dtime);
               pst.setString(5, Dfee);
               pst.setString(6, Ddate);
               pst.setString(7, DcontractNum);
               pst.setString(8, DeMail);
               pst.setString(9, DuserName);
               pst.executeUpdate();
        
    }
    
    public void updateValues(String DfName, String DlName, String Dtime, String Dfee, String Ddate,
                             String DcontractNum, String DeMail, String DappointmentNo, String DuserName) throws SQLException{
        
        pst = con.prepareStatement("update appointment set first_name = ?,last_name = ?,time = ?,fee = ?,date = ?,contract_num = ?, email = ?, d_user_name = ? where appointment_no = ?");
               pst.setString(1, DfName);
               pst.setString(2, DlName);
               pst.setString(3, Dtime);
               pst.setString(4, Dfee);
               pst.setString(5, Ddate);
               pst.setString(6, DcontractNum);
               pst.setString(7, DeMail);
                pst.setString(8, DuserName);
               pst.setString(9,DappointmentNo); 
               pst.executeUpdate();
        
    }
    
    
    
    public void deleteValues(JLabel D_receptionist_id_label){
        this.D_receptionist_id_label = D_receptionist_id_label;
        
        try {  
            pst = con.prepareStatement("delete from appointment where appointment_no = ?");
            pst.setString(1, D_receptionist_id_label.getText());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Appointment_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
    
    public void search(JTextField sBox, JTable t){
        String searchT = sBox.getText();
        
        try {
            String sql = "SELECT * FROM appointment WHERE first_name LIKE'%"+searchT+"%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void appointment_table(){
        try {
           
            pst = con.prepareStatement("select *from appointment");
            
            rs = pst.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int c;
            c = rsm.getColumnCount();
            DefaultTableModel dt = (DefaultTableModel)D_ReceptionistTable_view.getModel();
            
            dt.setRowCount(0);
            
            while(rs.next()){
                
                Vector v1 = new Vector();
                
                for(int i = 1; i < c; i++){
                     
                     v1.add(rs.getString("appointment_no"));
                     v1.add(rs.getString("first_name"));
                     v1.add(rs.getString("last_name"));
                     v1.add(rs.getString("date"));
                     v1.add(rs.getString("time"));                    
                     v1.add(rs.getString("contract_num"));
                     v1.add(rs.getString("email"));
                     v1.add(rs.getString("fee"));
                     v1.add(rs.getString("d_user_name"));
                }
                
                dt.addRow(v1);
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Appointment_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    
    
            
        
    public void autoAID(){
    
        Statement s;
        try {
            s = con.createStatement();
            rs = s.executeQuery("select MAX(appointment_no) from appointment");
            rs.next();
            rs.getString("MAX(appointment_no)");
            
            if( rs.getString("MAX(appointment_no)") == null){
                
                D_receptionist_id_label.setText("AP001");
            }
            else{
                
                long id = Long.parseLong(rs.getString("MAX(appointment_no)").substring(2,rs.getString("MAX(appointment_no)").length()));
                id++;
                 D_receptionist_id_label.setText("AP" + String.format("%03d", id));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Appointment_creation_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
            
  
            
        
       
    }
           
            
          
    
}
