/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragdrop_test;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author DELL
 */
public class FrameDesign extends JFrame{
    
    public FrameDesign(){
        setSize(1000,500);
        setLayout(new GridLayout());
        
        JPanel p1=new JPanel();
        p1.setBackground(Color.red);
        
        JPanel p2=new JPanel();
        p2.setBackground(Color.green);
        
        JPanel p3=new JPanel();
        p3.setBackground(Color.blue);
        
        JPanel p4=new JPanel();
        p4.setBackground(Color.cyan);
        
        
//        add(p1, BorderLayout.NORTH);
//        add(p2, BorderLayout.CENTER);
        
        
        JTabbedPane jtp=new JTabbedPane();
        
        jtp.add("hello",p1);
        jtp.add("world",p2);
        jtp.add("this",p3);
        jtp.add("is",p4);

        add(jtp);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        try{
           UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        new FrameDesign();
        
    }
}
