/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.DateAndTimer;
import model.PurchaseModel;
import model.SalesModel;

/**
 *
 * @author DELL
 */
public class ActivityView extends JPanel{
    
    private JPanel upper, center, bottom;
    
    private JTable activity;
    
    private String[] colHead={"Date","Particular","quantity","rate","total"};
    
    private String[][] data={};
    
    private String[] timeData={"Today", "This Month", "This Year","All time"};
    
    private String[] typeData={"Sales","Purchase"};
    
    private JLabel totalSales,totalPurchase,totalProfit;
    
    private JTextField salesT,purchaseT,profitT;
    
    private JComboBox time, type;
    
    private JScrollPane scrollTable;
    
    private Color bg=new Color(28,28,28);
    
    private PurchaseModel pm=new PurchaseModel();
    
    private SalesModel sm=new SalesModel();
    
    private DateAndTimer dm=new DateAndTimer();
    
    private DefaultTableModel mod;
    
    
    
    public ActivityView(){
        
        setLayout(new BorderLayout());
        
        
        upper= new JPanel(new FlowLayout(FlowLayout.CENTER,50,10));
        center=new JPanel();
        bottom=new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
        
        
        totalSales=new JLabel("sales",JLabel.RIGHT);
        totalPurchase=new JLabel("purchase",JLabel.RIGHT);
        totalProfit=new JLabel("profit",JLabel.RIGHT);
        
        
        
        salesT=new JTextField();
        purchaseT=new JTextField();
        profitT=new JTextField();
        
        
        
        
        
        salesT.setPreferredSize(new Dimension(70,20));
        purchaseT.setPreferredSize(new Dimension(70,20));
        profitT.setPreferredSize(new Dimension(70,20));
        
        
        
        totalSales.setPreferredSize(new Dimension(100,20));
        totalPurchase.setPreferredSize(new Dimension(100,20));
        totalProfit.setPreferredSize(new Dimension(100,20));
        
        
        
        mod=new DefaultTableModel(data,colHead);
        activity=new JTable(mod){
            private static final long serialVersionUID = 1L;
            
            @Override
            public boolean isCellEditable(int row, int column) {                
                return false;               
            };
        };
        activity.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        scrollTable=new JScrollPane(activity);
        
        
        time=new JComboBox(timeData);
        type=new JComboBox(typeData);
        
        
        
        
        upper.setPreferredSize(new Dimension(1000,40));
//        center.setPreferredSize(new Dimension(1000,30));
        bottom.setPreferredSize(new Dimension(1000,70));
        
        
//        activity.setPreferredSize(new Dimension(700,100));
        scrollTable.setPreferredSize(new Dimension(900,250));
        
        
        
        checkSelected();
        
        
        
        salesT.setEditable(false);
        purchaseT.setEditable(false);
        profitT.setEditable(false);
        
        
//        upper.setBackground(Color.BLUE);
//        center.setBackground(Color.CYAN);
//        bottom.setBackground(Color.LIGHT_GRAY);


        upper.setBackground(bg);
        center.setBackground(bg);
        bottom.setBackground(bg);
        
        
        upper.add(time);
        upper.add(type);
        
        
        center.add(scrollTable);
        
        
        bottom.add(totalSales);
        bottom.add(salesT);
        bottom.add(totalPurchase);
        bottom.add(purchaseT);
        //bottom.add(totalProfit);
//        bottom.add(profitT);
        
        
        add(upper,BorderLayout.NORTH);
        add(center,BorderLayout.CENTER);
        add(bottom,BorderLayout.SOUTH);
        
        
        
        type.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
                checkSelected();
            }
            
        });
        
        
        time.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
                checkSelected();
            }
            
        });
        
        
    }
    
    
    public void checkSelected(){
        
        if(type.getSelectedIndex()==0){
               
            setSalesList(time.getSelectedIndex());
        
        }else if(type.getSelectedIndex()==1){
            
            setPurchaseList(time.getSelectedIndex());
        
        }
        
    }
    

    
    
    public void setSalesList(int time){

//        ArrayList<String[]> salesList= sm.getSalesList(""+dm.getCurDate());
        int total=0;

        ArrayList<String[]> salesList;
        
         switch(time){
            
            case 0:
                salesList=sm.getSalesList(""+dm.getCurDate());
                break;
            case 1:
                salesList=sm.getSalesList(dm.getCurYear(),dm.getCurMonth());
                
                break;
            case 2:
                salesList=sm.getSalesList(dm.getCurYear());
                
                break;
            case 3:
                salesList=sm.getSalesList();
                
                break;
            default:
                salesList=sm.getSalesList(""+dm.getCurDate());
                break;
        }

        int size=mod.getRowCount();
        
        for(int i=0; i<size; i++){
            mod.removeRow(0);
        }

        for(int i=0;i<salesList.size();i++){
                
                
                
                String[] str=new String[4];
                
                str=salesList.get(i);

                String[] s={str[0],str[1],str[2],str[3],""+(Integer.parseInt(str[2])*Integer.parseInt(str[3]))};
                
                
                mod.addRow(s);
                
                total+=Integer.parseInt(str[2])*Integer.parseInt(str[3]);
                
                
        

            
        }
        salesT.setText(""+total);
       
    }
    
    
    
    public void setPurchaseList(int time){
        int total=0;
//        ArrayList<String[]> purchaseList= pm.getPurchaseList(""+dm.getCurDate());

        ArrayList<String[]> purchaseList;
        
         switch(time){
            
            case 0:
                purchaseList=pm.getPurchaseList(""+dm.getCurDate());
                break;
            case 1:
                purchaseList=pm.getPurchaseList(dm.getCurYear(),dm.getCurMonth());
                
                break;
            case 2:
                purchaseList=pm.getPurchaseList(dm.getCurYear());
                
                break;
            case 3:
                purchaseList=pm.getPurchaseList();
                
                break;
            default:
                purchaseList=pm.getPurchaseList(""+dm.getCurDate());
                break;
        }

        
        
        
        int size=mod.getRowCount();
        
        for(int i=0; i<size; i++){
            mod.removeRow(0);
        }
        
        
//        for(int i=0;i<purchaseList.size();i++){
//            System.out.println(purchaseList.get(i));
//            mod.addRow(purchaseList.get(i));
//            System.out.println("Hello");
//        }

        for(int i=0;i<purchaseList.size();i++){

                
            String[] str1=new String[4];

            str1=purchaseList.get(i);

            String[] s={str1[0],str1[1],str1[2],str1[3],""+(Integer.parseInt(str1[2])*Integer.parseInt(str1[3]))};

//            System.out.println(s[0]+s[1]+s[2]+s[3]+s[4]);

            mod.addRow(s);
            
            
            total+=Integer.parseInt(str1[2])*Integer.parseInt(str1[3]);
                

            
        }
        
        purchaseT.setText(""+total);
       
    }
    
    
    
    
    
    
}
