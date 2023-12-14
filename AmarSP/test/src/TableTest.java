/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DELL
 */
public class TableTest extends JFrame{
    
    JTextField t1,t2;
    
    JButton b1,b2;
    
    JTable ta1;
    
    JScrollPane jsp;
    
    
    String[] head={"Hello","World"};
    
    String[][] data={{"ksjdf","skdjf"},
                    {"sldkfj","sdklfj"},
                    {"jslkdf","dlskjf"},
                    {"Hello","Looo"}};
    
    
    public TableTest(){
        setSize(900,400);
        setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        t1=new JTextField();
        t2=new JTextField();
        
        t1.setPreferredSize(new Dimension(100,20));
        t2.setPreferredSize(new Dimension(100,20));
        
        b1=new JButton("add");
        b2=new JButton("remove");
        
        DefaultTableModel model=new DefaultTableModel(data,head);
        ta1=new JTable(model){
            private static final long serialVersionUID = 1L;
            
            @Override   
            public boolean isCellEditable(int row, int column) {                
                return false;               
            };
        };
//        ta1=new JTable(model);
        
        jsp=new JScrollPane(ta1);
        
        
        add(t1);
        add(t2);
        add(b1);
        add(b2);
        add(jsp);
        System.out.println(model.getRowCount());
        
        
        b1.addActionListener(new ActionListener(){
           
           public void actionPerformed(ActionEvent ae){
               model.addRow(new Object[]{t1.getText(),t2.getText()});
               System.out.println(model.getRowCount());
           } 
        });
        
        b2.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent ae){
//                model.removeRow(ta1.getSelectedRow());
//                System.out.println(ta1.getSelectedRow());
                int si=model.getRowCount();

                for(int i=0;i<si;i++){
                    model.removeRow(0);
                }
            }
        });
        
        
        
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new TableTest();
    }
}
