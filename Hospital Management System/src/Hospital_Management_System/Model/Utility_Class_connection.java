/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Model;

/**
 *
 * @author Thisura
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Utility_Class_connection {
    
   public static Connection connect(){
       
       Connection connection = null;
       
       try{
           Class.forName("com.mysql.jdbc.Driver");
           connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "");
       }catch(ClassNotFoundException | SQLException e){
           System.out.println("Error Details: " + e);
       }
       
       return connection;
   }
   
    public static java.sql.Connection getTheConnection(){
        
        java.sql.Connection con = null;
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
        
    }
   
    
}