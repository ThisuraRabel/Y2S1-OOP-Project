/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Thisura
 */
public class Non_User implements Person{

    
    protected String NurseNum;
    protected String fName;
    protected String lName;
    protected String wardNo;
    protected String contractNum;
    protected String eMail;
    protected  javax.swing.JTextField C_fName_tBox;
    protected  javax.swing.JTextField C_lName_tBox;
    protected  javax.swing.JTextField C_wardNo_tBox;
    protected  javax.swing.JTextField C_contractNo_tBox;
    protected  javax.swing.JTextField C_eMail_tBox;
    protected javax.swing.JLabel C_nurseID_label;
    
    
    public Non_User( JTextField C_fName_tBox, JTextField C_lName_tBox, JTextField C_wardNo_tBox, JTextField C_contractNo_tBox, 
                                        JTextField C_eMail_tBox, JLabel C_nurseID_label){
        
        this.C_fName_tBox = C_fName_tBox;
        this.C_lName_tBox = C_lName_tBox;
        this.C_wardNo_tBox = C_wardNo_tBox;
        this.C_contractNo_tBox = C_contractNo_tBox;
        this.C_eMail_tBox = C_eMail_tBox;
        this.C_nurseID_label = C_nurseID_label;
   
    }
    @Override
    public void getValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearFeilds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void insertToTable(JTable C_Table_view, JLabel C__id_label) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateTable(JTable C_Table_view, JLabel C_id_label, JButton C_jButton3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteItem(JTable C_Table_view, JLabel C_id_label, JButton C_jButton3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getSelectedValues(JButton C_jButton3, JLabel C_id_label, JTable C_Table_view) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
