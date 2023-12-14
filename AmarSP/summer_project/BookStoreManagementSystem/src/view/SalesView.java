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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.BillModel;
import model.DateAndTimer;
import model.InventoryModel;
import model.MessageModel;
import model.OrgInfoModel;
import model.SalesModel;
import model.UserModel;
import model.Validation;



//import java.awt.print.PageFormat;
//import java.awt.print.Printable;
//import java.awt.print.PrinterException;
//import java.awt.print.PrinterJob;

/**
 *
 * @author DELL
 */
public class SalesView extends JPanel{
    
    
    private JLabel idLabel, titleLabel, quantityLabel, rateLabel, customerLabel, totalLabel, paidLabel, returnLabel, viewBillLabel, phonePayLabel;
    private JButton add, delete, printBill,updateBill,clear;
    private JTable selection;
    private JTextArea billView;
    private JCheckBox phonePayCB;
    private JTextField titleTF, idTF, quantityTF, rateTF, customerTF, totalTF, paidTF, returnTF;
    private JScrollPane scrollSelect;
//    private JComboBox currency;
    
    private JPanel right,left,upperPanel,middlePanel,bottomPanel,paymentPanel,checkBoxPanel;
    
    private Dimension textFieldDM=new Dimension(100,20);
    private Dimension labelDM = new Dimension(90,20);
    
    private Color bg=new Color(28,28,28);
    
    private DefaultTableModel mod;
    
    private String[] colHead={"Sales ID","Title","Quantity","Rate","Total"};
    
//    private String[][] tableData={
//        {"","","","",""},
//        {"","","","",""},
//        {"","","","",""},
//        {"","","","",""},
//        {"","","","",""},
//    };
    private String[][] tableData={};
    
    
    private InventoryModel im=new InventoryModel();
    
    private SalesModel sm=new SalesModel();
    
    private BillModel bm=new BillModel();
    
    private OrgInfoModel om=new OrgInfoModel();
    
    private UserModel um=new UserModel();
    
    private Validation valid=new Validation();
    
    private MessageModel mm=new MessageModel();
    
    
    
    private int salesId=sm.getLastID();
    
    private DateAndTimer date= new DateAndTimer();
    
    private String cusPaid="";
    
   
    
    
    
    
    public SalesView(){
        
        setLayout(new GridLayout(1,2));
        
        left=new JPanel(new BorderLayout());
        right=new JPanel(new FlowLayout(FlowLayout.CENTER,30,10));
        upperPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));
        middlePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT,20,10));
        bottomPanel=new JPanel(new GridLayout(1,2));
        paymentPanel=new JPanel(new FlowLayout());
        checkBoxPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,10,25));
        
        
        idLabel=new JLabel("Book ID : ",JLabel.RIGHT);
        titleLabel=new JLabel(" Book Title : ",JLabel.RIGHT);
        quantityLabel=new JLabel("Quantity : ",JLabel.RIGHT);
        rateLabel=new JLabel("Book Rate : ",JLabel.RIGHT);
        customerLabel=new JLabel("Customer : ",JLabel.RIGHT);
        totalLabel=new JLabel("Total (in Rs.) : ",JLabel.RIGHT);
        paidLabel=new JLabel("Paid (in Rs.) : ",JLabel.RIGHT);
        returnLabel=new JLabel("Return (in Rs.) : ",JLabel.RIGHT);
        viewBillLabel=new JLabel("* * * * BILL VIEW * * * *");
        phonePayLabel=new JLabel("Phonepay");
        
//        viewBillLabel.setFont(font)
        
        
        add=new JButton("Add");
        delete=new JButton("Delete");
        printBill=new JButton("Print Bill");
        updateBill=new JButton("Update Bill");
        clear=new JButton("Clear All");
        
        
        titleTF=new JTextField();
        idTF=new JTextField();
        quantityTF=new JTextField();
        rateTF=new JTextField();
        customerTF=new JTextField();
        totalTF=new JTextField();
        paidTF=new JTextField();
        returnTF=new JTextField();
        
        
        titleTF.setPreferredSize(textFieldDM);
        idTF.setPreferredSize(textFieldDM);
        quantityTF.setPreferredSize(textFieldDM);
        rateTF.setPreferredSize(textFieldDM);
        customerTF.setPreferredSize(textFieldDM);
        totalTF.setPreferredSize(textFieldDM);
        paidTF.setPreferredSize(textFieldDM);
        returnTF.setPreferredSize(textFieldDM);
        
        idLabel.setPreferredSize(labelDM);
        titleLabel.setPreferredSize(labelDM);
        quantityLabel.setPreferredSize(labelDM);
        rateLabel.setPreferredSize(labelDM);
        customerLabel.setPreferredSize(labelDM);
        totalLabel.setPreferredSize(labelDM);
        paidLabel.setPreferredSize(labelDM);
        returnLabel.setPreferredSize(labelDM);
        
        
        phonePayCB=new JCheckBox();
        
        
        billView=new JTextArea("",18,40);
        
        
        setBillView();
        
        
        
        billView.setBackground(new Color(120, 120, 120));
//        billView.setBackground(new Color(195, 201, 0));
        
        
        mod=new DefaultTableModel(tableData,colHead);
//        selection=new JTable(tableData, colHead);
        selection = new JTable(mod) {
            private static final long serialVersionUID = 1L;
            
            @Override
            public boolean isCellEditable(int row, int column) {                
                return false;               
            };
        };
        
        
        totalTF.setEditable(false);
        returnTF.setEditable(false);
        billView.setEditable(false);
        rateTF.setEditable(false);
        
        printBill.setEnabled(false);
        
        selection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollSelect=new JScrollPane(selection);
        scrollSelect.setPreferredSize(new Dimension(450,103));
        
        
        upperPanel.setPreferredSize(new Dimension(400,140));
        middlePanel.setPreferredSize(new Dimension(400,90));
        bottomPanel.setPreferredSize(new Dimension(400,80));
        
        
//        upperPanel.setBackground(Color.red);
//        middlePanel.setBackground(Color.blue);
//        paymentPanel.setBackground(Color.green);
//        checkBoxPanel.setBackground(Color.CYAN);


        upperPanel.setBackground(bg);
        middlePanel.setBackground(bg);
        paymentPanel.setBackground(bg);
        checkBoxPanel.setBackground(bg);
        right.setBackground(bg);
        
        
        paymentPanel.add(totalLabel);
        paymentPanel.add(totalTF);
        paymentPanel.add(paidLabel);
        paymentPanel.add(paidTF);
        paymentPanel.add(returnLabel);
        paymentPanel.add(returnTF);
        
        
        checkBoxPanel.add(phonePayCB);
        checkBoxPanel.add(phonePayLabel);
        
        
        upperPanel.add(idLabel);
        upperPanel.add(idTF);
        upperPanel.add(titleLabel);
        upperPanel.add(titleTF);
        upperPanel.add(quantityLabel);
        upperPanel.add(quantityTF);
        upperPanel.add(rateLabel);
        upperPanel.add(rateTF);
        upperPanel.add(customerLabel);
        upperPanel.add(customerTF);
        
        
        middlePanel.add(add);
        middlePanel.add(delete);
        middlePanel.add(clear);
        middlePanel.add(scrollSelect);
        
        
        bottomPanel.add(paymentPanel);
        bottomPanel.add(checkBoxPanel);
        
        
        left.add(upperPanel,BorderLayout.NORTH);
        left.add(middlePanel);
        left.add(bottomPanel, BorderLayout.SOUTH);
        
        
        right.add(viewBillLabel);
        right.add(billView);
        //right.add(updateBill);
        right.add(printBill);
        
        
        add(left);
        add(right);
        
        idTF.addKeyListener(new KeyAdapter(){
        
            @Override
            public void keyReleased(KeyEvent ke){
                
                String str=im.getNameFromId(idTF.getText());
                
                titleTF.setText(str);
                
                String rate=im.getRate(idTF.getText(),titleTF.getText());
                
                rateTF.setText(rate);
                
            }
            
        });
        
        
        
        titleTF.addKeyListener(new KeyAdapter(){
        
            @Override
            public void keyReleased(KeyEvent ke){
                
                String str=im.getIdFromName(titleTF.getText());
                
                idTF.setText(str);

                String rate=im.getRate(idTF.getText(),titleTF.getText());
                
                rateTF.setText(rate);                
                
                
            }
            
        });
        
        
        clear.addActionListener(new ActionListener(){
            
            
            @Override
            public void actionPerformed(ActionEvent ae){
                
                mod.setRowCount(0);
                salesId=sm.getLastID();
                customerTF.setText("");
                totalTF.setText("");
                
                printBill.setEnabled(false);
                
                returnTF.setText("");
                
                setBillView();
                
            }
            
        });
        
        
        add.addActionListener(new ActionListener(){
        
        
            @Override
            public void actionPerformed(ActionEvent ae){
//                im.updateData(idTF.getText(), calculateQuantity(Integer.parseInt(quantityTF.getText()),idTF.getText()));
                
                if(AddValidator()){
                    mod.addRow(new Object[]{salesId,titleTF.getText(),quantityTF.getText(),rateTF.getText(),calculateTotal(Integer.parseInt(quantityTF.getText()),Integer.parseInt(rateTF.getText()))});


                    salesId++;


                    idTF.setText("");
                    titleTF.setText("");
                    rateTF.setText("");
                    quantityTF.setText("");


                    calculateGrandTotal();


                    setBillView();

                    printBill.setEnabled(true);
                }
                
            
            }
            
        });
        
        
        
        delete.addActionListener(new ActionListener(){
        
        
            @Override
            public void actionPerformed(ActionEvent ae){
                    
                mod.removeRow(selection.getSelectedRow());
                
                if(mod.getRowCount()==0){
                
                    salesId=sm.getLastID();
                    customerTF.setText("");
                    
                    printBill.setEnabled(false);
                    
                    returnTF.setText("");
                  
                
                }
                
                calculateGrandTotal();
                
                setBillView();
                
                if(!totalTF.getText().equals("") && !paidTF.getText().equals("")){
                    if(Integer.parseInt(paidTF.getText())>=Integer.parseInt(totalTF.getText())){
                        returnTF.setText(""+(Integer.parseInt(paidTF.getText())-Integer.parseInt(totalTF.getText())));
                    }else{
                        returnTF.setText("");
                    }
                }
            
            }
            
        });
        
        
        
        phonePayCB.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent ae){
                
                if(phonePayCB.isSelected()){
                    
                    paidTF.setEditable(false);
                    paidTF.setText(totalTF.getText());
                    
                
                }else{
                    
                    paidTF.setEditable(true);
                    paidTF.setText(cusPaid);
                    
                    
                }
            
            }
            
        
        });


        totalTF.getDocument().addDocumentListener(new DocumentListener(){
            
                
            @Override
            public void changedUpdate(DocumentEvent de){
//                    if(phonePayCB.isSelected()){
//
//                        paidTF.setEditable(false);
//                        paidTF.setText(totalTF.getText());
//
//
//                    }else{
//
//                        paidTF.setEditable(true);
//                        paidTF.setText("");
//
//
//                    }

                

            }


            @Override
            public void removeUpdate(DocumentEvent de){
                if(phonePayCB.isSelected()){

                    paidTF.setEditable(false);
                    paidTF.setText(totalTF.getText());


                }else{

                    paidTF.setEditable(true);
                    paidTF.setText(cusPaid);


                }


            }


            @Override
            public void insertUpdate(DocumentEvent de){
                if(phonePayCB.isSelected()){

                    paidTF.setEditable(false);
                    paidTF.setText(totalTF.getText());


                }else{

                    paidTF.setEditable(true);
                    paidTF.setText(cusPaid);


                }


            }

        });
        
        
        paidTF.getDocument().addDocumentListener(new DocumentListener(){
            
                
            @Override
            public void changedUpdate(DocumentEvent de){
                
                if(paidTF.getText().matches("[0-9]+")){
                    if(!totalTF.getText().equals("") && !paidTF.getText().equals("")){
                        if(Integer.parseInt(paidTF.getText())>=Integer.parseInt(totalTF.getText())){
                            returnTF.setText(""+(Integer.parseInt(paidTF.getText())-Integer.parseInt(totalTF.getText())));
                        }else{
                            returnTF.setText("");
                        }
                    }
                }else{
                    returnTF.setText("");
                }
                
                

            }


            @Override
            public void removeUpdate(DocumentEvent de){
                
                if(paidTF.getText().matches("[0-9]+")){
                    if(!totalTF.getText().equals("") && !paidTF.getText().equals("")){
                        if(Integer.parseInt(paidTF.getText())>=Integer.parseInt(totalTF.getText())){
                            returnTF.setText(""+(Integer.parseInt(paidTF.getText())-Integer.parseInt(totalTF.getText())));
                        }else{
                            returnTF.setText("");
                        }
                    }
                }else{
                    returnTF.setText("");
                }

            }


            @Override
            public void insertUpdate(DocumentEvent de){
                
                if(paidTF.getText().matches("[0-9]+")){
                    if(!totalTF.getText().equals("") && !paidTF.getText().equals("")){
                        if(Integer.parseInt(paidTF.getText())>=Integer.parseInt(totalTF.getText())){
                            returnTF.setText(""+(Integer.parseInt(paidTF.getText())-Integer.parseInt(totalTF.getText())));
                        }else{
                            returnTF.setText("");
                        }
                    }
                }else{
                    returnTF.setText("");
                }


            }

        });
        
        
        paidTF.addKeyListener(new KeyAdapter(){
        
            @Override
            public void keyReleased(KeyEvent ke){
                
                cusPaid=paidTF.getText();
            
            }
            
        
        });
        
        
        
        updateBill.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent ae){
                
                setBillView();
                
            }
        
        });
        
        
        printBill.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent ae){
                
                String[] options={"CONFIRM","Cancel"};
                
                
                int confirm=JOptionPane.showOptionDialog(null,"Please Confirm before Proceeding !!!","CONFIRM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                
                
                if(confirm==JOptionPane.YES_OPTION){
                    if(printValidator()){

                        try {


        //                    JTextArea txt=new JTextArea(billView.getText());

        //                    billView.print();
        //                    txt.print();
                            PrintSupport.printComponent(billView);

        //                    System.out.println(txt.getText());


                        } catch (Exception e) {
                            System.out.println("notPrinted");
                            e.printStackTrace();
                        }

                        tableBookUpdate();

                        bm.insertBill(""+bm.getLastID(), ""+um.getUserId(),""+date.getCurDate(), customerTF.getText());


                        tableSalesInsert();
                        
                        inventoryCheck();

                        emptyAllFields();

                        printBill.setEnabled(false);

                        setBillView();    

                    }
                }

                    
                
                
            }
        
        });
        
        
        
        
    }
    
    
    public void emptyAllFields(){
    
        customerTF.setText("");
        mod.setRowCount(0);
        totalTF.setText("");
        paidTF.setText("");
        returnTF.setText("");
        
    }
    
    public void tableSalesInsert(){
        
        
        for(int i=0;i<mod.getRowCount();i++){
            sm.insertSales(""+mod.getValueAt(i, 0), im.getIdFromName(""+mod.getValueAt(i, 1)), ""+mod.getValueAt(i, 2), ""+mod.getValueAt(i, 3), ""+(bm.getLastID()-1));
        }
        
    }
    
    public void tableBookUpdate(){
        
        
        for(int i=0;i<mod.getRowCount();i++){
            im.updateData(im.getIdFromName(""+mod.getValueAt(i, 1)), calculateQuantity(Integer.parseInt(""+mod.getValueAt(i, 2)),im.getIdFromName(""+mod.getValueAt(i, 1))));
        }
        
    }
    
    
    
    public int calculateQuantity(int up, String id){
        
        int origin=im.getQuantity(id);
        
        return origin-up;
    
    }
    
    public int calculateTotal(int qty, int rate){
    
        return (qty*rate);
        
    }
    
    
    public void calculateGrandTotal(){
        
        int total=0;
        
        for(int i=0;i<mod.getRowCount();i++){
            total+=Integer.parseInt(""+mod.getValueAt(i, 4));
        }
        
        totalTF.setText(""+total);
    }
    
    
    
    public void setBillView(){
    
        billView.setText( "\n"
                        + "      Bill.No.: "+bm.getLastID()+"                             "+om.getName()+" \n"
                        + "                                     "+om.getLocation()+"\n"
                        + "                                                Ph:   "+om.getContact()+"\n"
                        + "      Pan No: "+om.getPanNo()+"                                          Date:   "+date.getCurDate()+"\n"
                        + "      M/S: "+customerTF.getText()+"\n"
                        + "      Particular                                 Qty\tRate\tAmount\n"
                        + tranDisplay()
                        + "      Total: Rs. "+totalTF.getText()+"\n"
                        + "      Note: Goods once sold will not be taken back.");
    
    }
    
    
    
    public String tranDisplay(){
    
        String tran="";
        
        int row;
        
        if(totalTF.getText().equals("")){
            row=0;
        }else{
            row=mod.getRowCount();
        }
        
            
        for(int i=0;i<row;i++){
            String title=""+mod.getValueAt(i,1);
            String quantity=""+mod.getValueAt(i,2);
            String rate=""+mod.getValueAt(i,3);
            String total=""+mod.getValueAt(i,4);
            
            
//            tran+="      " + title + getSpace(title.length(),47) + "" + quantity + getSpace(quantity.length(),12) + "" + rate + getSpace(rate.length(),11) + "" + total + "\n";
            
            tran+="      " + title + getSpace(title.length()) + "\t" + quantity + "\t" + rate + "\t" + total + "\n";


        }
        
        return tran;
    
    }
    
    
    public String getSpace(int len){
        
        String space="";
        
        if (len<=10){
            space="\t";
        }
        
        return space;
    }
    
    
    
    public boolean AddValidator(){
    
        if( (valid.isVoid(this, "ID", idTF.getText()) || valid.isVoid(this, "Title", titleTF.getText()) || valid.isVoid(this, "Quantity", quantityTF.getText()) )){
            return false;
        }
        
        if(!valid.onlyNumbers(this, "Quantity", quantityTF.getText())){
            return false;
        }
        
        if(Integer.parseInt(quantityTF.getText()) == 0){
            JOptionPane.showMessageDialog(this, "Quantity cannot be Zero !!!", "ERROR !", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(calculateQuantity(Integer.parseInt(quantityTF.getText()), idTF.getText()) < 0){
            JOptionPane.showMessageDialog(this, "Required quantity exceeds current inventory level !!!", "ERROR !", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        
        return true;
    }
    
    
    public boolean printValidator(){
        
        if(valid.isVoid(this, "Customer", customerTF.getText()) || valid.isVoid(this, "Paid", paidTF.getText())){
            return false;
        }
        
        if(!valid.onlyNumbers(this, "Paid", paidTF.getText())){
            return false;
        }
        
        if(Integer.parseInt(paidTF.getText()) <  Integer.parseInt(totalTF.getText())){
            JOptionPane.showMessageDialog(this, "Paid amount is not sufficient !!!", "ERROR !", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        
        
        return true;
    }
    
    public void inventoryCheck(){
    
        
        
        for(int i=0;i<mod.getRowCount();i++){
            int qty=im.getQuantity(im.getIdFromName(""+mod.getValueAt(i,1)));
            
            if(qty < 10){
                
                String msg=im.getIdFromName(""+mod.getValueAt(i,1))+" | "+mod.getValueAt(i, 1)+" is Low on Stock. Only "+qty+" remaining";
            
                JOptionPane.showMessageDialog(this, msg, "Low Inventory Level", JOptionPane.INFORMATION_MESSAGE);
                
                mm.setData(""+date.getCurDate(), msg, ""+date.getCurTime(), titleTF.getText());
                
            }else if(qty==0){
                
                String msg=im.getIdFromName(""+mod.getValueAt(i,1))+" | "+mod.getValueAt(i, 1)+" is out of Stock";
            
                JOptionPane.showMessageDialog(this, msg, "Out Of Stock", JOptionPane.WARNING_MESSAGE);
                
                mm.setData(""+date.getCurDate(), msg, ""+date.getCurTime(), titleTF.getText());
                
            }else if(qty > 100){
            
                String msg=im.getIdFromName(""+mod.getValueAt(i,1))+" | "+mod.getValueAt(i, 1)+" is High on Stock. Currently "+qty+" in stock";

                JOptionPane.showMessageDialog(this, msg, "High Inventory Level", JOptionPane.INFORMATION_MESSAGE);

                mm.setData(""+date.getCurDate(), msg, ""+date.getCurTime(), titleTF.getText());

            }else{
                mm.deleteAnoData(titleTF.getText());
            }
            
        }
        
    
    }
    
   
}
