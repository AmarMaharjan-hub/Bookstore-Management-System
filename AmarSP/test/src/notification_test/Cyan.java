/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notification_test;
import dragdrop_test.*;
import notification_test.NotificationTest;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author DELL
 */
public class Cyan extends JPanel{
    NotificationTest n=new NotificationTest();
    
    int count=3;
    
    
    public int getCount(){
        return count;
    }
    
    public void decCount(){
        count--;
//        n.revalidate();
//        n.repaint();
    }
    
    public Cyan(){
        setBackground(Color.cyan);
//        JLabel l1=new JLabel("CYAN");
//        JTextField t1=new JTextField();
//        t1.setPreferredSize(new Dimension(200,20));
        String[] colHead={"ID","Title","Quantity","Rate","Total"};
    
        String[][] tableData={
            {"","","","",""},
            {"","","","",""},
            {"","","","",""},
            {"","","","",""}
        };
        JTable table=new JTable(tableData,colHead);
        JScrollPane sp = new JScrollPane(table);
        add(sp);
        
//        add(t1);
//        add(l1);
    }
    
}
