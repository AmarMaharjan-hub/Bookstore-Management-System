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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.AurthorModel;
import model.CategoryModel;
import model.DateAndTimer;
import model.InventoryModel;
import model.MessageModel;
import model.PurchaseModel;
import model.SupplierModel;
import model.UserModel;
import model.Validation;

/**
 *
 * @author DELL
 */
public class PurchaseView extends JPanel{
    
    
    private JPanel upper, center, bottom;
    
    private JTabbedPane tab;
    
    private JButton purchase,reorder;
    
    private JLabel error;
    
    private Color bg=new Color(28,28,28);
    
    private PurchaseAddView pav=new PurchaseAddView();
    
    private PurchaseReorderView prv=new PurchaseReorderView();
    
    private InventoryModel im=new InventoryModel();
    
    private CategoryModel cm=new CategoryModel();
    
    private AurthorModel am=new AurthorModel();
    
    private PurchaseModel pm=new PurchaseModel();
    
    private SupplierModel sm=new SupplierModel();
    
    private DateAndTimer dat=new DateAndTimer();
    
    private UserModel um=new UserModel();
    
    private Validation valid=new Validation();
    
    private MessageModel mm=new MessageModel();
    
    private DateAndTimer date=new DateAndTimer();
    
    
    public PurchaseView(){
        setLayout(new BorderLayout());
//        setBackground(bg);
        
        
        tab=new JTabbedPane();
        
        
        upper=new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));
        center=new JPanel();
        bottom=new JPanel();
        
        
        purchase=new JButton("Purchase New");
        reorder=new JButton("Purchase Reorder");
        
        
        error=new JLabel("error");
        
        
        tab.setPreferredSize(new Dimension(900,250));
        
        
        bottom.setPreferredSize(new Dimension(1000,50));
        upper.setPreferredSize(new Dimension(1000,50));
        
        
//        upper.setBackground(Color.red);
//        center.setBackground(Color.blue);
//        bottom.setBackground(Color.green);


        upper.setBackground(bg);
        center.setBackground(bg);
        bottom.setBackground(bg);

        
        

//        tab.add("Purcase Existing",new PurchaseReorderView());
//        tab.add("Purchase New",new PurchaseAddView());
        tab.add("Purcase Existing",prv);
        tab.add("Purchase New",pav);

        
        tab.setSelectedIndex(0);
        purchase.setEnabled(false);
        
        tab.addChangeListener(new ChangeListener(){
            
            @Override
            public void stateChanged(ChangeEvent ce){
                if(tab.getSelectedIndex() == 0){
                    purchase.setEnabled(false);
                    reorder.setEnabled(true);
                    
                    prv.setPurchaseId();
                    prv.setSupplierName();
                    
                    
                }else if(tab.getSelectedIndex() == 1){
                    purchase.setEnabled(true);
                    reorder.setEnabled(false);
                    
                    
                    pav.setPurchaseId();
                    pav.setId();
                    pav.setComboBoxNames();
                    
                }
            }
            
        });
        
//        upper.add(error);
        
        
        center.add(tab);
        
        
        bottom.add(reorder);
        bottom.add(purchase);
        
        
        add(upper,BorderLayout.NORTH);
        add(center,BorderLayout.CENTER);
        add(bottom,BorderLayout.SOUTH);
        
        
        purchase.addActionListener(new ActionListener(){
            
        
            @Override
            public void actionPerformed(ActionEvent ae){
                
                String[] options={"CONFIRM","Cancel"};
                
                
                int confirm=JOptionPane.showOptionDialog(null,"Please Confirm before Proceeding !!!","CONFIRM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                
                if(confirm==JOptionPane.YES_OPTION){
                
                    if(purchaseValidator()){
                        im.insertBook(pav.getId(), pav.getTitle(), ""+cm.getCategoryId(pav.getCat()), pav.getQty(), pav.getRate());
                        pm.insertPurchase(pav.getPurchase(), pav.getId(), pav.getQty(), pav.getRate(), ""+sm.getSupplierId(pav.getSup()), ""+dat.getCurDate(), ""+um.getUserId());

                        addInventoryCheck();

                        pav.resetField();
                        pav.setId();
                        pav.setPurchaseId();

                    }
                }
                
            }
            
        });
        
        reorder.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent ae){
                
                String[] options={"CONFIRM","Cancel"};
                
                
                int confirm=JOptionPane.showOptionDialog(null,"Please Confirm before Proceeding !!!","CONFIRM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                
                if(confirm==JOptionPane.YES_OPTION){
                
                    if(reorderValidator()){
                        im.updateData(prv.getId(), calculateQuantity(Integer.parseInt(prv.getQty()),prv.getId()));
                        pm.insertPurchase(prv.getPurchase(), prv.getId(), prv.getQty(), prv.getRate(), ""+sm.getSupplierId(prv.getSup()), ""+dat.getCurDate(), ""+um.getUserId());

                        reorderInventoryCheck();

                        prv.setPurchaseId();
                        prv.resetField();
                    }
                }
                
                
            }
            
        });
        
    }
    
    
    public int calculateQuantity(int up, String id){
        
        int origin=im.getQuantity(id);
        
        return origin+up;
    
    }
    
    public boolean reorderValidator(){
    
        if( (valid.isVoid(this, "ID", prv.getId()) || valid.isVoid(this, "Title", prv.getTitle()) || valid.isVoid(this, "Quantity", prv.getQty()) )){
            return false;
        }
        
        if(!valid.onlyNumbers(this, "Quantity", prv.getQty())){
            return false;
        }
        
        if(Integer.parseInt(prv.getQty()) == 0){
            JOptionPane.showMessageDialog(this, "Quantity cannot be Zero !!!", "ERROR !", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
    
        return true;
    }
    
    public boolean purchaseValidator(){
    
        if( (valid.isVoid(this, "Title", pav.getTitle()) || valid.isVoid(this, "Quantity", pav.getQty()) || valid.isVoid(this,"Rate", pav.getRate()))){
            return false;
        }
        
        if(!valid.onlyNumbers(this, "Quantity", pav.getQty())){
            return false;
        }
        
        if(Integer.parseInt(pav.getQty()) == 0){
            JOptionPane.showMessageDialog(this, "Quantity cannot be Zero !!!", "ERROR !", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(!valid.onlyNumbers(this, "Rate", pav.getRate())){
            return false;
        }
        
        if(Integer.parseInt(pav.getRate()) == 0){
            JOptionPane.showMessageDialog(this, "Rate cannot be Zero !!!", "ERROR !", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
    
        return true;
    }
    
    
    public void addInventoryCheck(){
        
        int qty=im.getQuantity(im.getIdFromName(pav.getTitle()));
    
        if(im.getQuantity(pav.getId())>100){
            
            String msg=pav.getId()+" | "+pav.getTitle()+" is High on Stock. Currently "+qty+" in stock";
            
            JOptionPane.showMessageDialog(this, msg, "High Inventory Level", JOptionPane.INFORMATION_MESSAGE);

            mm.setData(""+date.getCurDate(), msg, ""+date.getCurTime(), pav.getTitle());
            
        }else if(qty < 10){
                
            String msg=pav.getId()+" | "+pav.getTitle()+" is Low on Stock. Only "+qty+" remaining";

            JOptionPane.showMessageDialog(this, msg, "Low Inventory Level", JOptionPane.INFORMATION_MESSAGE);

            mm.setData(""+date.getCurDate(), msg, ""+date.getCurTime(), pav.getTitle());

        }else{
                mm.deleteAnoData(pav.getTitle());
        }
        
    }
    

    public void reorderInventoryCheck(){
        
        int qty=im.getQuantity(im.getIdFromName(prv.getTitle()));
    
        if(im.getQuantity(prv.getId())>100){
            
            String msg=prv.getId()+" | "+prv.getTitle()+" is High on Stock. Currently "+qty+" in stock";
            
            JOptionPane.showMessageDialog(this, msg, "High Inventory Level", JOptionPane.INFORMATION_MESSAGE);

            mm.setData(""+date.getCurDate(), msg, ""+date.getCurTime(), pav.getTitle());
            
        }else if(qty < 10){
                
            String msg=prv.getId()+" | "+prv.getTitle()+" is Low on Stock. Only "+qty+" remaining";

            JOptionPane.showMessageDialog(this, msg, "Low Inventory Level", JOptionPane.INFORMATION_MESSAGE);

            mm.setData(""+date.getCurDate(), msg, ""+date.getCurTime(), prv.getTitle());

        }else{
                mm.deleteAnoData(prv.getTitle());
        }
        
    }    
    
    
}
