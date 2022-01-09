/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Model;

import Hospital_Management_System.View.Administrative_S_M_View;
import Hospital_Management_System.View.Doctor_View;
import Hospital_Management_System.View.Pharmasist_View;
import Hospital_Management_System.View.Receptionist_View;
import Hospital_Management_System.View.User_Login_View;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author Thisura
 */
public class Check_Login_Details {
    
    
    Connection con = null;
    PreparedStatement pst;
    ResultSet rs;
   // private javax.swing.JPasswordField D_password_userLogin;
   // private javax.swing.JTextField D_username_userLogin;
   // private javax.swing.JComboBox D_userType_userLogin;
    private final String username;
    private final String password;
    private final String D_userType;

    
    public Check_Login_Details(JComboBox D_userType_userLogin, JTextField D_username_userLogin, JPasswordField D_password_userLogin){
        
        this.D_userType = D_userType_userLogin.getSelectedItem().toString();
        this.username = D_username_userLogin.getText();
        this.password = D_password_userLogin.getText();
        
        
         con = Utility_Class_connection.connect();
        /*
        
        Administrative Staff Member
        Receptionist
        Doctor
        Pharmasist
        Laboratory Tecnician
         */
         

        
    }
    
    
    public int checkDetails(){
        int i = 0;
        
            if (D_userType == "Administrative Staff Member"){
                try {
                     pst = con.prepareStatement("select * from admin where username = ? and password = ?");
                     
                     pst.setString(1, username);
                     pst.setString(2, password);
                     rs = pst.executeQuery();
             
                    if (rs.next()){
             
                        new Administrative_S_M_View(username).setVisible(true); 
                        i++;
                    }
                    else{
                 
                        User_Login_View ulint = new User_Login_View();
                        JOptionPane.showMessageDialog(ulint, "Username or Password incorrect! ");
                       
                    } 
                     
                } catch (SQLException ex) {
                     Logger.getLogger(Check_Login_Details.class.getName()).log(Level.SEVERE, null, ex);
                }
   
            }
            else if(D_userType == "Receptionist"){
                 try {
                     pst = con.prepareStatement("select * from receptionist where username = ? and password = ?");
                     pst.setString(1, username);
                     pst.setString(2, password);
                     rs = pst.executeQuery();
             
                    if (rs.next()){
                        new Receptionist_View(username).setVisible(true); 
                        i++;
                    }
                    else{
                 
                        User_Login_View ulint = new User_Login_View();
                        JOptionPane.showMessageDialog(ulint, "Username or Password incorrect! ");
                        
                    } 
                     
                } catch (SQLException ex) {
                     Logger.getLogger(Check_Login_Details.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(D_userType == "Doctor"){
                 try {
                     pst = con.prepareStatement("select * from doctor where username = ? and password = ?");
                     pst.setString(1, username);
                     pst.setString(2, password);
                     rs = pst.executeQuery();
             
                    if (rs.next()){
                 
                       new Doctor_View(username).setVisible(true); 
                       i++;
                    }
                    else{
                 
                        User_Login_View ulint = new User_Login_View();
                        JOptionPane.showMessageDialog(ulint, "Username or Password incorrect! ");
                        
                    } 
                     
                } catch (SQLException ex) {
                     Logger.getLogger(Check_Login_Details.class.getName()).log(Level.SEVERE, null, ex);
                }
         
            }
            else if (D_userType == "Pharmasist"){
                   try {
                     pst = con.prepareStatement("select * from pharmasist where username = ? and password = ?");
                     pst.setString(1, username);
                     pst.setString(2, password);
                     rs = pst.executeQuery();
             
                    if (rs.next()){
                 
                        new Pharmasist_View(username).setVisible(true); 
                        i++;
                    }
                    else{
                 
                        User_Login_View ulint = new User_Login_View();
                        JOptionPane.showMessageDialog(ulint, "Username or Password incorrect! ");
                        
                    } 
                     
                } catch (SQLException ex) {
                     Logger.getLogger(Check_Login_Details.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
           
            
        return i;
        
    }
    
}
