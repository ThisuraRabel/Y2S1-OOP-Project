/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital_Management_System.View;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;

/**
 *
 * @author Thisura
 */
public class Utility_Class_View {
    
    
    
    public static void Date(JLabel pDate){
        DateTimeFormatter dtr = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        pDate.setText(dtr.format(now));
    }
    
    public static void Time(JLabel pTime){
        DateTimeFormatter dtr = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        pTime.setText(dtr.format(now));
    }

    
    
    
    
}
