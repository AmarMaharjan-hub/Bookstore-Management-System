/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragdrop_test;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author DELL
 */
public class Yellow extends JPanel{
    public Yellow(){
        setBackground(Color.yellow);
        JLabel l1=new JLabel("YELLOW");
        JTextField t1=new JTextField();
        t1.setPreferredSize(new Dimension(200,20));
        add(t1);
        add(l1);
    }
}
