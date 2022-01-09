/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Controller;


import Hospital_Management_System.Model.Utility_Class_connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayanjit.Das
 */
public class Worker {
    
    private int workerID;
    private String fName;
    private String lName;
    private String buildingAddress;
    private String phoneNumber;
    
    public int getWorkerID(){
        return this.workerID;
    }
    public String getFName(){
        return this.fName;
    }
    public String getLName(){
        return this.lName;
    }
    public String getBuildingAddress(){
        return this.buildingAddress;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setWorkerID(int _id){
        this.workerID = _id;
    }
    public void setFName(String _fName){
        this.fName = _fName;
    }
    public void setLName(String _lName){
        this.lName = _lName;
    }
    public void setBuildingAddress(String _address){
        this.buildingAddress = _address;
    }
    public void setPhoneNumber(String _number){
        this.phoneNumber = _number;
    }
    
    public Worker(int _id, String _fName, String _lName, String _address, String _phoneNumber){
        this.workerID = _id;
        this.fName = _fName;
        this.lName = _lName;
        this.buildingAddress = _address;
        this.phoneNumber = _phoneNumber;
    }
    
    public Boolean addToDB(){
        
        PreparedStatement ps;
        
        String addQuery = "INSERT INTO `worker_t`(`firstname`, `lastname`, `buildingaddress`, `phonenumber`) VALUES (?,?,?,?)";
        
        try {
            ps = Utility_Class_connection.getTheConnection().prepareStatement(addQuery);
            ps.setString(1, this.fName);
            ps.setString(2, this.lName);
            ps.setString(3, this.buildingAddress);
            ps.setString(4, this.phoneNumber);
            
            return (ps.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(this.fName).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Boolean deleteFromDB(){
        PreparedStatement ps;
        
        String delQuery = "DELETE FROM `worker_t` WHERE `workerID`=?";
        
        try {
            ps = Utility_Class_connection.getTheConnection().prepareStatement(delQuery);
            
            ps.setInt(1, this.workerID);
            
            return (ps.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(this.fName).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Boolean updateToDB(){
        
        PreparedStatement ps;
        
        String updateQuery = "UPDATE `worker_t` SET `firstname`=?,`lastname`=?,`buildingaddress`=?,`phonenumber`=? WHERE `workerID`=?";
        
        
        try {
            ps = Utility_Class_connection.getTheConnection().prepareStatement(updateQuery);
            ps.setString(1, this.fName);
            ps.setString(2, this.lName);
            ps.setString(3, this.buildingAddress);
            ps.setString(4, this.phoneNumber);
            ps.setInt(5, this.workerID);
            
            return (ps.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(this.fName).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static ArrayList<Worker> getWorkerListFromDB(){
        ArrayList<Worker> list = new ArrayList<>();
        
        Statement sm;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `worker_t`";
        
        try {
            sm = Utility_Class_connection.getTheConnection().createStatement();
            rs = sm.executeQuery(selectQuery);
            
            while (rs.next()) {
              
                Worker worker = new Worker(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                
            list.add(worker);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger("Worker List").log(Level.SEVERE, null, ex);
        }
                
        return list;
    }
}
