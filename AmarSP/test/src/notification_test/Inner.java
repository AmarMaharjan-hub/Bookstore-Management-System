    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notification_test;

import dragdrop_test.Cyan;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
    public class Inner extends JPanel implements ActionListener{
        
//        NotificationTest n=new NotificationTest();
        JLabel l2=new JLabel("");
        Cyan c;
//        NotificationTest n;
        
        public Inner(){
            JPanel p1=new JPanel();
            JPanel p2=new JPanel();
            JPanel p3=new JPanel();
//            JPanel p4=new JPanel(new BorderLayout());
            setLayout(new BorderLayout());
            
            p1.setBackground(Color.DARK_GRAY);
            p2.setBackground(Color.DARK_GRAY);
            p3.setBackground(Color.DARK_GRAY);
            
//            p4.setPreferredSize(new Dimension(700,80));
            setPreferredSize(new Dimension(700,100));


            JLabel l1=new JLabel("Date");
            
//            JLabel l3=new JLabel("jlakjsdf");
            JButton b1=new JButton("Delete");
            
            l1.setForeground(Color.white);
            l2.setForeground(Color.white);
            
            p1.add(l1);
            p2.add(l2);
            p3.add(b1);
            
            
//            p4.add(p1,BorderLayout.NORTH);
//            p4.add(p1,BorderLayout.NORTH);
//            p4.add(p1,BorderLayout.NORTH);

            add(p1,BorderLayout.NORTH);
            add(p2,BorderLayout.CENTER);
            add(p3,BorderLayout.SOUTH);
            
            

            
        }
        
        public Inner(Cyan c, String str){
            this.c=c;
            l2.setText(str);
        }
        
        public void iner(Cyan c, String str){
            this.c=c;
            l2.setText(str);
        }
        
        public void setLabel(String str){
            l2.setText(str);

        }
        
        
        @Override
        public void actionPerformed(ActionEvent ae){
            
//            n.displayNot();
            l2.setText("Hllo");
            System.out.println("hello");
        }
        
    }
