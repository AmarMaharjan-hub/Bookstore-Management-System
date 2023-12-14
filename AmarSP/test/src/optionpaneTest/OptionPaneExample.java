/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optionpaneTest;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Admin
 */
public class OptionPaneExample {
    JFrame f;  
    OptionPaneExample(){  
        f=new JFrame();  
        
        JButton b1=new JButton("ckk");
        
        f.setSize(400,200);
        
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel p=new JPanel(new GridLayout(3,2));
        
        
        
        JTextField t1=new JTextField();
        JLabel l1=new JLabel("Previous Password:");
        
        JTextField t2=new JTextField();
        JLabel l2=new JLabel("New Password:");
        
        JTextField t3=new JTextField();
        JLabel l3=new JLabel("Retype Password:");
        
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);
        
        
        
        f.add(b1);
        
        
        b1.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent e){
            
//                String name=JOptionPane.showInputDialog(p);  
//                System.out.println(name);

                String buttons[]={"Done","Cancel"};

                UIManager.put("OptionPane.minimumSize",new Dimension(350,100));

                int rc=JOptionPane.showOptionDialog(f,p,"alert",JOptionPane.WARNING_MESSAGE,0,null,buttons,buttons[1]);  
                             
                System.out.println(t1.getText()+"\n"+t2.getText()+"\n"+t3.getText()+"\n");
                
                
//                System.out.println(rc);
                
            }
        
        
            
        });
        
        
        f.setVisible(true);
        
    }  
    public static void main(String[] args) {  
        new OptionPaneExample();  
       
        
        
        
        
        
        //For custom button
//        String[] buttons = { "Yes", "Yes to all", "No", "Cancel" };
//
//        int rc = JOptionPane.showOptionDialog(null, "Question ?", "Confirmation",
//            JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[0]);
//
//        System.out.println(rc);
    }  
}
