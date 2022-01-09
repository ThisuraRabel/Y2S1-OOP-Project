/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.Controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Thisura
 */
public interface Person {
    
    public abstract void getValues();
    
    public abstract void clearFeilds();
    
    public abstract void insertToTable(JTable C_Table_view, JLabel C__id_label);
    
    public abstract void updateTable(JTable C_Table_view, JLabel C_id_label, JButton C_jButton3);
    
    public abstract void deleteItem(JTable C_Table_view, JLabel C_id_label, JButton C_jButton3);
    
    /**
     *
     * @param C_jButton3
     * @param C_id_label
     * @param C_Table_view
     */
    public abstract void getSelectedValues(JButton C_jButton3, JLabel C_id_label, JTable C_Table_view);
}
