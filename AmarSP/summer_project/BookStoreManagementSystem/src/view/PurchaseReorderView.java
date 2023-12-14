/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.InventoryModel;
import model.PurchaseModel;
import model.SupplierModel;

/**
 *
 * @author DELL
 */
public class PurchaseReorderView extends JPanel{
    
    private JLabel id,name,qty,rate,sup,purchaseId;
    
    private JTextField idT,nameT,qtyT,rateT,purchaseT;
    
    private JComboBox supT;
    
    private Dimension textD=new Dimension(80,20);
    
    private Dimension boxD=new Dimension(150,20);
    
    private PurchaseModel pm=new PurchaseModel();
    
    private SupplierModel sm=new SupplierModel();
    
    private InventoryModel im=new InventoryModel();
    
    private String[] supplierNames;

    
    public PurchaseReorderView(){
        
        setLayout(new FlowLayout(FlowLayout.LEFT,30,40));
        
        
        id=new JLabel("Book ID : ",JLabel.RIGHT);
        name=new JLabel("Book Title : ",JLabel.RIGHT);
        qty=new JLabel("Quantity : ",JLabel.RIGHT);
        rate=new JLabel("Rate : ",JLabel.RIGHT);
        sup=new JLabel("Supplier : ",JLabel.RIGHT);
        purchaseId=new JLabel("Purchase ID : ",JLabel.RIGHT);
       
        
        
        idT=new JTextField();
        nameT=new JTextField();
        qtyT=new JTextField();
        rateT=new JTextField();
        purchaseT=new JTextField();
        
        
        setPurchaseId();
//        setId();
        
        
        setSupplierName();
        
                
        supT=new JComboBox(supplierNames);
        
        
        id.setPreferredSize(textD);
        name.setPreferredSize(textD);
        qty.setPreferredSize(textD);
        rate.setPreferredSize(textD);
        sup.setPreferredSize(textD);
        purchaseId.setPreferredSize(textD);
        
        
        idT.setPreferredSize(boxD);
        nameT.setPreferredSize(boxD);
        qtyT.setPreferredSize(boxD);
        rateT.setPreferredSize(boxD);
        supT.setPreferredSize(boxD);
        purchaseT.setPreferredSize(boxD);
        
        
        purchaseT.setEditable(false);
        rateT.setEditable(false);
//        idT.setEditable(false);
        
        
        
        add(id);
        add(idT);
        add(name);
        add(nameT);
        add(qty);
        add(qtyT);
        add(rate);
        add(rateT);
        add(sup);
        add(supT);
        add(purchaseId);
        add(purchaseT);
        
        
        idT.addKeyListener(new KeyAdapter(){
        
            @Override
            public void keyReleased(KeyEvent ke){
                
                String str=im.getNameFromId(idT.getText());
                
                nameT.setText(str);
                
                String rate=im.getRate(idT.getText(),nameT.getText());
                
                rateT.setText(rate);
                
            }
            
        });
        
        
        
        nameT.addKeyListener(new KeyAdapter(){
        
            @Override
            public void keyReleased(KeyEvent ke){
                
                String str=im.getIdFromName(nameT.getText());
                
                idT.setText(str);

                String rate=im.getRate(idT.getText(),nameT.getText());
                
                rateT.setText(rate);                
                
                
            }
            
        });
        
        
        
    }
    
    public String getId(){
        return idT.getText();
    }
    
    public String getTitle(){
        return nameT.getText();
    }
    
    public String getQty(){
        return qtyT.getText();
    }
    
    public String getRate(){
        return rateT.getText();
    }
    
    public String getSup(){
        return ""+supT.getSelectedItem();
    }
    
    public String getPurchase(){
        return purchaseT.getText();
    }
    
    
    
    public void setId(String str){
        idT.setText(str);
    }
    
    public void setTitle(String str){
        nameT.setText(str);
    }
    
//    public void setQty(String str){
//        qtyT.setText(str);
//    }
    
    public void setRate(String str){
        rateT.setText(str);
    }
    

    public void setPurchaseId(){
        purchaseT.setText(""+pm.getLastID());
    }
    
    
    
    
    public void setSupplierName(){
        supplierNames=sm.getSupplierNames();
    }
    
    
    public void resetField(){
        
        idT.setText("");
        nameT.setText("");
        qtyT.setText("");
        rateT.setText("");
        
        
        supT.setSelectedIndex(0);
        
    }
        
}
