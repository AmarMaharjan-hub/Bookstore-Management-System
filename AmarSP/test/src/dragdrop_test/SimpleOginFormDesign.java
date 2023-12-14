/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragdrop_test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author DELL
 */
public class SimpleOginFormDesign extends JFrame{
    GridBagConstraints gbc=new GridBagConstraints();
    public SimpleOginFormDesign(){
        setSize(1000,500);
        setLayout(new GridLayout(1,2));
        //BorderLayout bb=new BorderLayout(); 
        //setLayout(bb);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);
        setLocationRelativeTo(null);
        
        JPanel p1=new JPanel();
        p1.setBackground(Color.red);
        
        JPanel p2=new JPanel();
        p2.setBackground(Color.blue);
        CardLayout cl=new CardLayout();
        p2.setLayout(cl);
                
//        JPanel p3=new JPanel();
//        p3.setBackground(Color.green);
//        JLabel l1=new JLabel("this is the first panel named first in the main panel of card layout");
//        p3.add(l1);
//        p2.add("first",p3);
        p2.add("first",new Green());

        
//        JPanel p4=new JPanel();
//        p4.setBackground(Color.YELLOW);
//        JLabel l2=new JLabel("this is the second panel named second in the main panel of card layout");
//        p4.add(l2);
        p2.add("second",new Yellow());
        
//        JPanel p5=new JPanel();
//        p5.setBackground(Color.cyan);
//        JLabel l3=new JLabel("this is the third panel named third in the main panel of card layout");
//        p5.add(l3);
        p2.add("third",new Cyan());
        
        JButton b1=new JButton("next");
        JToggleButton b2=new JToggleButton("green");
        JToggleButton b3=new JToggleButton("yellow");
        JToggleButton b4=new JToggleButton("cyan");
        
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        add(p1);
        add(p2);
        
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                cl.next(p2);
            }
        });
        
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                b2.setSelected(true);
                b3.setSelected(false);
                b4.setSelected(false);
                cl.show(p2,"first");
            }
        });
        
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                b2.setSelected(false);
                b3.setSelected(true);
                b4.setSelected(false);
                
                cl.show(p2,"second");
            }
        });
        
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                b2.setSelected(false);
                b3.setSelected(false);
                b4.setSelected(true);
                cl.show(p2,"third");
            }
        });
        
        setVisible(true);
    }
    public static void main(String[] args) {
//         try {
//            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
//        } catch (Exception e) {
//            e.printStackTrace();
//            
//        }
        new SimpleOginFormDesign();
        String str="";
        System.out.println(str.isEmpty());
        
        
        
    }
}
