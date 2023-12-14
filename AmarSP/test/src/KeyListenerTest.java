
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class KeyListenerTest extends JFrame{
    
    public KeyListenerTest(){
        
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        JTextField t1=new JTextField();
        t1.setPreferredSize(new Dimension(100,50));
        JButton b1=new JButton("add");
        JButton b2=new JButton("clear");
        JLabel l1=new JLabel("jkdjf");
        
        setLayout(new FlowLayout());
        
        add(l1);
        add(t1);
        add(b1);
        add(b2);
        
        
        b1.addActionListener(new ActionListener(){
            
            
            @Override
            public void actionPerformed(ActionEvent ae){
                
                t1.setText("set");
                    
            }
        
        });
        
        
        b2.addActionListener(new ActionListener(){
            
            
            @Override
            public void actionPerformed(ActionEvent ae){
                
                t1.setText("");
                    
            }
        
        });
        
        t1.addKeyListener(new KeyAdapter(){
        
            @Override
            
            public void keyPressed(KeyEvent ke){
            
                
                l1.setText(l1.getText()+"jeje");
            }
            
            
        });
        
        
        
        setVisible(true);
        
        
        
    
        
    }
    
    public static void main(String[] args) {
        new KeyListenerTest();
    }
    
}
