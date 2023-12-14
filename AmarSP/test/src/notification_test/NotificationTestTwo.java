/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notification_test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class NotificationTestTwo extends JFrame{
    
    JTextField t1=new JTextField();
    JButton su=new JButton("submit");
    
    JPanel[] parr,p1,p2,p3;
    
    JLabel[] l1,l2;
    
    JButton[] b1;
    
    int num=10;
    
    
    JPanel bottom=new JPanel(new FlowLayout(FlowLayout.CENTER,0,30));
    
    JPanel temp=new JPanel(new BorderLayout());
    
    
    JScrollPane jsp;
    
    int height=0;
    
    public NotificationTestTwo(){
        setSize(1000,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        

        JPanel top=new JPanel();
        t1.setPreferredSize(new Dimension(100,20));
        
        
        top.add(t1);
        top.add(su);
        
//        JPanel bottom=new JPanel(new FlowLayout(FlowLayout.CENTER,0,30));
        jsp=new JScrollPane(bottom);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setPreferredSize(new Dimension(950,10000));
        
        
        bottom.setBackground(Color.gray);
        
        refreshNot();
        
        
        
        
        
        
        for(int i=0;i<num;i++){
            bottom.add(parr[i]);
        }
        
        
        bottom.setPreferredSize(new Dimension(950,height));
        
        top.add(t1);
        top.add(su);
        
        temp.add(jsp);
    
        add(top,BorderLayout.NORTH);
        add(temp,BorderLayout.CENTER);
        
        su.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent ae){
                removeAllPan();
                num++;
                refreshNot();
                
//                bottom.repaint();
                
                for(int i=0;i<num;i++){
                    jsp.add(parr[i]);
                }
                
                

                bottom.setPreferredSize(new Dimension(950,height));
                
            }
            
        });
        
        setVisible(true);
    }
        
    
    
    public static void main(String[] args) {
        NotificationTestTwo ntt=new NotificationTestTwo();
    }
    
    
    public void refreshNot(){

        
//        num=Integer.parseInt(t1.getText());
        
        

        parr= new JPanel[num];
        p1= new JPanel[num];
        p2= new JPanel[num];
        p3= new JPanel[num];
        
        l1=new JLabel[num];
        l2=new JLabel[num];
        
        b1=new JButton[num];
        
        
        for(int i=0;i<num;i++){
            l2[i]=new JLabel(""+i);
            parr[i]=new JPanel();
            p1[i]=new JPanel();
            p2[i]=new JPanel();
            p3[i]=new JPanel();
            
            parr[i].setLayout(new BorderLayout());
            
            p1[i].setBackground(Color.DARK_GRAY);
            p2[i].setBackground(Color.DARK_GRAY);
            p3[i].setBackground(Color.DARK_GRAY);
            
            parr[i].setPreferredSize(new Dimension(700,100));


            l1[i]=new JLabel("Date");
            b1[i]=new JButton("Delete");
            
            l1[i].setForeground(Color.white);
            l2[i].setForeground(Color.white);
            
            p1[i].add(l1[i]);
            p2[i].add(l2[i]);
            p3[i].add(b1[i]);
            
            parr[i].add(p1[i],BorderLayout.NORTH);
            parr[i].add(p2[i],BorderLayout.CENTER);
            parr[i].add(p3[i],BorderLayout.SOUTH);
            
            height+=140;
            
            
            b1[i].addActionListener(new ActionListener(){
                    
                @Override
                public void actionPerformed(ActionEvent ae){
                    decNum();   
                }
                
                
            });
            
        }
    
    }
    
    
    public void removeAllPan(){
            
        for(int i=0;i<num;i++){
            jsp.remove(parr[i]);
//            bottom.invalidate();
//            bottom.validate();
            
            height-=140;
        }
        jsp.repaint();
        
    }
    
    public void decNum(){
        num--;
    }
    
}
