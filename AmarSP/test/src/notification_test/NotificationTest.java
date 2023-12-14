/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notification_test;
import dragdrop_test.Cyan;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author DELL
 */
public class NotificationTest extends JFrame{
    
    
    
    JPanel center=new JPanel(new BorderLayout());
    
   
    
    int height=0;
    
    JPanel notPanel= new JPanel(new FlowLayout(FlowLayout.CENTER,0,30));
    
    
    public NotificationTest(){
        setSize(1000,500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        
        JPanel upper=new JPanel();
//        JPanel center=new JPanel(new BorderLayout());
//        JPanel notPanel= new JPanel(new FlowLayout(FlowLayout.CENTER,0,30));
        upper.setPreferredSize(new Dimension(1000,80));
//        notPanel.setPreferredSize(new Dimension(950,420));
        JLabel l=new JLabel("dashboard");
        
        JScrollPane jsp=new JScrollPane(notPanel);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setPreferredSize(new Dimension(950,10000));
//        jsp.setVerticalScrollBar(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        notPanel.setBackground(Color.gray);
        
        

        JLabel l1=new JLabel("recent");
        
        displayNot();
        
        
//        for(int i=0; i<notificationCount; i++){
//            Inner in=new Inner();
//            in.iner(c, str, this);
//            notPanel.add(in);
//            height+=140;
////            new Inner(c,str);
////            notPanel.add(new Inner());
//        }
        notPanel.setPreferredSize(new Dimension(950,height));
        
        upper.add(l);
        center.add(jsp);
        center.add(l1,BorderLayout.NORTH);
        add(upper,BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
   
    
    public void displayNot(){
//        this.removeAll();
        for(int i=0; i<5; i++){
            Inner in=new Inner();
            notPanel.add(in);
            height+=140;
            
//            new Inner(c,str);
//            notPanel.add(new Inner());
        }
        
    }
    
    
    
    public static void main(String[] args) {
        new NotificationTest();
    }
    
    
//    public class Inner extends JPanel{
//        public Inner(){
//            JPanel p1=new JPanel();
//            JPanel p2=new JPanel();
//            JPanel p3=new JPanel();
////            JPanel p4=new JPanel(new BorderLayout());
//            setLayout(new BorderLayout());
//            
//            p1.setBackground(Color.DARK_GRAY);
//            p2.setBackground(Color.DARK_GRAY);
//            p3.setBackground(Color.DARK_GRAY);
//            
////            p4.setPreferredSize(new Dimension(700,80));
//            setPreferredSize(new Dimension(700,100));
//
//
//            JLabel l1=new JLabel("Date");
//            JLabel l2=new JLabel("message");
////            JLabel l3=new JLabel("jlakjsdf");
//            JButton b1=new JButton("Delete");
//            
//            l1.setForeground(Color.white);
//            l2.setForeground(Color.white);
//            
//            p1.add(l1);
//            p2.add(l2);
//            p3.add(b1);
//            
//            
////            p4.add(p1,BorderLayout.NORTH);
////            p4.add(p1,BorderLayout.NORTH);
////            p4.add(p1,BorderLayout.NORTH);
//
//            add(p1,BorderLayout.NORTH);
//            add(p2,BorderLayout.CENTER);
//            add(p3,BorderLayout.SOUTH);
//            
//            
//
//            
//        }
//        
//    }

    

    
}
