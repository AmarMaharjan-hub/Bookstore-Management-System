/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.AurthorModel;
import model.CategoryModel;
import model.InventoryModel;
import model.PurchaseModel;
import model.SupplierModel;

/**
 *
 * @author DELL
 */
public class PurchaseAddView extends JPanel{
    
    
    private JLabel id,name,qty,rate,sup,cat,aur,purchaseId;
    
    private JTextField idT,nameT,qtyT,rateT,purchaseT;
    
    private JComboBox supT,catT,aurT;
    
    private Dimension textD=new Dimension(80,20);
    
    private Dimension boxD=new Dimension(150,20);
    
    private PurchaseModel pm=new PurchaseModel();
    
    private SupplierModel sm=new SupplierModel();
    
    private InventoryModel im=new InventoryModel();
    
    private CategoryModel cm=new CategoryModel();
    
    private AurthorModel am=new AurthorModel();
    
    private String[] supplierNames,catNames, aurthorNames;

    
    public PurchaseAddView(){
        
        setLayout(new FlowLayout(FlowLayout.LEFT,30,40));
        
        
        id=new JLabel("Book ID : ",JLabel.RIGHT);
        name=new JLabel("Book Title : ",JLabel.RIGHT);
        qty=new JLabel("Quantity : ",JLabel.RIGHT);
        rate=new JLabel("Rate : ",JLabel.RIGHT);
        sup=new JLabel("Supplier : ",JLabel.RIGHT);
        cat=new JLabel("Category : ",JLabel.RIGHT);
        aur=new JLabel("Aurthor : ",JLabel.RIGHT);
        purchaseId=new JLabel("Purchase ID : ",JLabel.RIGHT);
       
        
        
        idT=new JTextField();
        nameT=new JTextField();
        qtyT=new JTextField();
        rateT=new JTextField();
        purchaseT=new JTextField();
        
        
        setPurchaseId();
        setId();
        
        
        supplierNames=sm.getSupplierNames();
        catNames=cm.getCategoryNames();
        aurthorNames=am.getAurthorNames();
        
                
        setComboBoxNames();
        
        
        id.setPreferredSize(textD);
        name.setPreferredSize(textD);
        qty.setPreferredSize(textD);
        rate.setPreferredSize(textD);
        cat.setPreferredSize(textD);
        sup.setPreferredSize(textD);
        aur.setPreferredSize(textD);
        purchaseId.setPreferredSize(textD);
        
        
        idT.setPreferredSize(boxD);
        nameT.setPreferredSize(boxD);
        qtyT.setPreferredSize(boxD);
        rateT.setPreferredSize(boxD);
        catT.setPreferredSize(boxD);
        supT.setPreferredSize(boxD);
        aurT.setPreferredSize(boxD);
        purchaseT.setPreferredSize(boxD);
        
        
        purchaseT.setEditable(false);
        idT.setEditable(false);
        
        
        
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
        add(cat);
        add(catT);
        add(aur);
        add(aurT);
        add(purchaseId);
        add(purchaseT);
        
        
        
        
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
    
    public String getCat(){
        return ""+catT.getSelectedItem();
    }
    
    public String getAur(){
        return ""+aurT.getSelectedItem();
    }
    
    public String getPurchase(){
        return purchaseT.getText();
    }
    
    
    
    public void setId(){
        idT.setText(""+im.getLastID());
    }
//    
//    public void setTitle(String str){
//        nameT.setText(str);
//    }
//    
//    public void setQty(String str){
//        qtyT.setText(str);
//    }
//    
//    public void setRate(String str){
//        rateT.setText(str);
//    }
//    
//    public void setCat(String str){
        //refresh combobox
//    }
//    
//    public void setAur(String str){
        //refresh combobox
//    }
//    
    public void setPurchaseId(){
        purchaseT.setText(""+pm.getLastID());
    }
    
    
    
    public void resetField(){
        
        nameT.setText("");
        qtyT.setText("");
        rateT.setText("");
        
        
        supT.setSelectedIndex(0);
        catT.setSelectedIndex(0);
        aurT.setSelectedIndex(0);
        
    }
    
    
    public void setComboBoxNames(){
    
        supT=new JComboBox(supplierNames);
        catT=new JComboBox(catNames);
        aurT=new JComboBox(aurthorNames);
    }
    
    
}
