/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Thisura
 */
public class User implements Person{

    protected String ID;
    protected String fName;
    protected String lName;
    protected String userName;
    protected String password;
    protected String reEnterPass;
    protected String validPass;
    protected String contractNum;
    protected String eMail;
    
    
    protected final javax.swing.JTextField C_fName_tBox;
    protected final javax.swing.JTextField C_lName_tBox;
    protected final javax.swing.JTextField C_username_tBox;
    protected final javax.swing.JTextField C_contractNo_tBox;
    protected final javax.swing.JTextField C_eMail_tBox;
    protected final javax.swing.JPasswordField C_pass_pBox;
    protected final javax.swing.JPasswordField C_reEnterPass_pBox;
    protected final javax.swing.JLabel C_id_label;
    
     public User( JTextField C_fName_tBox, JTextField C_lName_tBox, JTextField C_username_tBox, JTextField C_contractNo_tBox, 
                                        JTextField C_eMail_tBox, JPasswordField C_pass_pBox,JPasswordField C_reEnterPass_pBox, JLabel C_id_label){
        
        this.C_fName_tBox = C_fName_tBox;
        this.C_lName_tBox = C_lName_tBox;
        this.C_username_tBox = C_username_tBox;
        this.C_contractNo_tBox = C_contractNo_tBox;
        this.C_eMail_tBox = C_eMail_tBox;
        this.C_pass_pBox = C_pass_pBox;
        this.C_reEnterPass_pBox = C_reEnterPass_pBox;
        this.C_id_label = C_id_label;
        
    
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
