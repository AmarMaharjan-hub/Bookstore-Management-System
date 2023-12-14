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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.CategoryModel;
import model.DateAndTimer;
import model.InventoryModel;
import model.MessageModel;
import model.Validation;

/**
 *
 * @author DELL
 */
public class InventoryView extends JPanel{
    
    private JTable inventoryTable;
    private JScrollPane inventoryScroll;
    private JLabel title,searchLabel;
    private JPanel topPanel,tablePanel,bottomPanel,titlePanel,searchPanel;
    private JLabel titleLabel,categoryLabel,quantityLabel,priceLabel,searchMessage;
    private JTextField titleT,categoryT,quantityT,priceT,searchT;
    private JButton update,delete,search,clear;
    //table.setSelectionInterval(index0,index1);        to set the search selected
    private JComboBox searchType, categoryCB;
    
    private String[] colHead={"Book ID", "Title", "Category", "Quantity", "Price"};
    private String[][] tableData;
    private String[] searchBy={"Title", "Book ID"};
    private String[] categoryOpt;
    
    private Color bg=new Color(28,28,28);
    
    private DefaultTableModel mod;
    
    private InventoryModel im=new InventoryModel();
    
    private CategoryModel cm=new CategoryModel();
    
    private DateAndTimer date=new DateAndTimer();
    
    private Validation valid=new Validation();
    
    private MessageModel mm=new MessageModel();
    
    private ImageIcon searchIcon=new ImageIcon("/Icons/searchIcon.png");
    
//    private int selectedRow=-1;
    
    
    public InventoryView(){
        
        setLayout(new BorderLayout());
        
        
        topPanel=new JPanel(new BorderLayout());
        tablePanel=new JPanel(new FlowLayout());
        bottomPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));
        titlePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT,50,15));
        searchPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,10,15));
        
        
        title=new JLabel("Current Inventory Level");
        searchLabel=new JLabel("Search By: ");
//        inventoryScroll=new JScrollPane(inventoryTable);
        searchMessage=new JLabel("Search not found");   //hasn't been added. visible for about 5 seconds
        mod=new DefaultTableModel(tableData,colHead);
        inventoryTable=new JTable(mod){
            private static final long serialVersionUID = 1L;
            
            @Override
            public boolean isCellEditable(int row, int column) {                
                return false;               
            };
        };
        inventoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        inventoryScroll=new JScrollPane(inventoryTable);
        
        categoryOpt=cm.getCategoryNames();
        
        
        titleLabel=new JLabel("Title",JLabel.RIGHT);
        categoryLabel=new JLabel("Category",JLabel.RIGHT);
        quantityLabel=new JLabel("Quantity",JLabel.RIGHT);
        priceLabel=new JLabel("Price",JLabel.RIGHT);
        
        
        titleT=new JTextField();
        categoryT=new JTextField();
        quantityT=new JTextField();
        priceT=new JTextField();
        searchT=new JTextField();
        
        
        searchType=new JComboBox(searchBy);
        categoryCB=new JComboBox(categoryOpt);
        
        
        update=new JButton("Update");
        delete=new JButton("Delete");
        search=new JButton(searchIcon);
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/searchIcon.png")));
        clear=new JButton("Clear");
        
        
        inventoryScroll.setPreferredSize(new Dimension(800,200));
        
        
        titleT.setPreferredSize(new Dimension(155,20));
//        categoryT.setPreferredSize(new Dimension(155,20));
        quantityT.setPreferredSize(new Dimension(155,20));
        priceT.setPreferredSize(new Dimension(155,20));
        searchT.setPreferredSize(new Dimension(100,30));
        
        categoryCB.setPreferredSize(new Dimension(155,20));
        
        
        search.setPreferredSize(new Dimension(30,30));
        
        
        titleLabel.setPreferredSize(new Dimension(60,20));
        categoryLabel.setPreferredSize(new Dimension(60,20));
        quantityLabel.setPreferredSize(new Dimension(60,20));
        priceLabel.setPreferredSize(new Dimension(60,20));
        
        
//        inventoryTable.setEnabled(false);
        topPanel.setPreferredSize(new Dimension(1000,70));
        bottomPanel.setPreferredSize(new Dimension(1000,100));
        searchPanel.setPreferredSize(new Dimension(350,50));
        titlePanel.setPreferredSize(new Dimension(650,50));
        
        
        categoryT.setEditable(false);
        
        
        setBookList();
        
        
//        searchPanel.setBackground(Color.red);
//        titlePanel.setBackground(Color.yellow);

            
        titlePanel.setBackground(bg);
        searchPanel.setBackground(bg);
        tablePanel.setBackground(bg);
        bottomPanel.setBackground(bg);
        
        
        bottomPanel.add(titleLabel);
        bottomPanel.add(titleT);
        bottomPanel.add(categoryLabel);
//        bottomPanel.add(categoryT);
        bottomPanel.add(categoryCB);
        bottomPanel.add(quantityLabel);
        bottomPanel.add(quantityT);
        bottomPanel.add(priceLabel);
        bottomPanel.add(priceT);
        bottomPanel.add(update);
        bottomPanel.add(delete);
        bottomPanel.add(clear);
        
        
        titlePanel.add(title);
        
        
        searchPanel.add(searchLabel);
        searchPanel.add(searchType);
        searchPanel.add(searchT);
        searchPanel.add(search);
        
        
        topPanel.add(titlePanel, BorderLayout.CENTER);
        topPanel.add(searchPanel,BorderLayout.EAST);
        tablePanel.add(inventoryScroll);
        
        
        add(topPanel,BorderLayout.NORTH);
        add(tablePanel,BorderLayout.CENTER);
        add(bottomPanel,BorderLayout.SOUTH);
        
        
        
        update.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
                
                if(inventoryTable.getSelectedRow() != -1){
                    if(updateValidator()){
                        im.updateData(""+inventoryTable.getValueAt(inventoryTable.getSelectedRow(), 0),titleT.getText(),""+cm.getCategoryId(""+categoryCB.getSelectedItem()),quantityT.getText(),priceT.getText() );                        
                        inventoryCheck();
                        setBookList();

                        

                        //reset fields after operation
                        titleT.setText("");
                        categoryT.setText("");
                        categoryCB.setSelectedIndex(0);
                        quantityT.setText("");
                        priceT.setText("");
                    }
                    

                }else{
                    //error for row not selected
//                    System.out.println("row not selected");
                    JOptionPane.showMessageDialog(null, "Row Not Selected", "Low Inventory Level", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        });
        
        
        
        delete.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
                if(inventoryTable.getSelectedRow() != -1){
                    im.deleteData(""+inventoryTable.getValueAt(inventoryTable.getSelectedRow(), 0));
                    
                    
                    mod.removeRow(inventoryTable.getSelectedRow());
                    
                    
                    //empty fields after operation
                    titleT.setText("");
//                    categoryT.setText("");
                    categoryCB.setSelectedIndex(0);
                    quantityT.setText("");
                    priceT.setText("");
                }else{
                    //error for not selected row
                }
            }
            
        });
        
        
        clear.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
                inventoryTable.clearSelection();
                categoryCB.setSelectedIndex(0);
            }
            
        });
        
        
        search.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
                
                boolean search=false;
                String type=""+searchType.getSelectedItem();
                String value=searchT.getText();
                
                int id=im.getSearch(type, value);
                int row=inventoryTable.getRowCount();
                
                for(int j=0;j<row;j++){
                    String gId= ""+inventoryTable.getModel().getValueAt(j, 0);
                    String tId=""+id;

                    if(tId.compareTo(gId)==0){
                            inventoryTable.getSelectionModel().addSelectionInterval(0,j);
                    }


                }
                
            }
            
        });
        
        
        
        
        inventoryTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            
            
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if(inventoryTable.getSelectedRow()!= -1){
//                    selectedRow=inventoryTable.getSelectedRow();
//                    System.out.println(inventoryTable.getSelectedRow()+"  "+inventoryTable.getSelectedColumn());
                    
                    titleT.setText(""+inventoryTable.getValueAt(inventoryTable.getSelectedRow(), 1));
//                    categoryT.setText(""+inventoryTable.getValueAt(inventoryTable.getSelectedRow(), 2));
                    categoryCB.setSelectedItem(""+inventoryTable.getValueAt(inventoryTable.getSelectedRow(), 2));
                    quantityT.setText(""+inventoryTable.getValueAt(inventoryTable.getSelectedRow(), 3));
                    priceT.setText(""+inventoryTable.getValueAt(inventoryTable.getSelectedRow(), 4));
                }else{
                    titleT.setText("");
                    categoryT.setText("");
                    quantityT.setText("");
                    priceT.setText("");
                }
                
                
//                if(inventoryTable.getSelectedRow() == selectedRow){
//                    selectedRow=-1;
//                    
//                    
//                    inventoryTable.clearSelection();
//                    
//                    
//                    titleT.setText("");
//                    categoryT.setText("");
//                    quantityT.setText("");
//                    priceT.setText("");
//                }
            }
        });
        
    }
    
    
    
    public void setBookList(){
        
                
        ArrayList<String[]> inventoryList= im.getInventoryList();
        
        int size=mod.getRowCount();
        
        for(int i=0; i<size; i++){
            mod.removeRow(0);
        }

        for(int i=0;i<inventoryList.size();i++){
           mod.addRow(inventoryList.get(i));
        }
       
    }
    
    
    public boolean updateValidator(){
    
        if( (valid.isVoid(this, "Title", titleT.getText()) || valid.isVoid(this, "Quantity", quantityT.getText()) || valid.isVoid(this, "Price", priceT.getText()) )){
            return false;
        }
        
        if(!valid.onlyNumbers(this, "Quantity", quantityT.getText())){
            return false;
        }
        
        if(!valid.onlyNumbers(this, "Rate", priceT.getText())){
            return false;
        }
        
        return true;
    }
    
    public void inventoryCheck(){
        
//        int num=Integer.parseInt((quantityT.getText()).trim());
//        System.out.println(num);


//        System.out.println(quantityT.getText());
    
        
        if(Integer.parseInt(quantityT.getText()) < 10){
            
            String msg=mod.getValueAt(inventoryTable.getSelectedRow(),0)+" | "+titleT.getText()+" is Low on Stock. Currently "+quantityT.getText()+" in stock";
            JOptionPane.showMessageDialog(this, msg, "Low Inventory Level", JOptionPane.INFORMATION_MESSAGE);
            mm.setData(""+date.getCurDate(), msg, ""+date.getCurTime(),titleT.getText());
            
        }else if(Integer.parseInt(quantityT.getText()) > 100){
            
            String msg=mod.getValueAt(inventoryTable.getSelectedRow(),0)+" | "+titleT.getText()+" is High on Stock. Currently "+quantityT.getText()+" in stock";
            JOptionPane.showMessageDialog(this, msg, "High Inventory Level", JOptionPane.INFORMATION_MESSAGE);
            mm.setData(""+date.getCurDate(), msg, ""+date.getCurTime(),titleT.getText());
        
        }else if(Integer.parseInt(quantityT.getText()) == 0){
        
            String msg=mod.getValueAt(inventoryTable.getSelectedRow(),0)+" | "+titleT.getText()+" is Out of Stock.";
            JOptionPane.showMessageDialog(this, msg, "Out of Stock", JOptionPane.INFORMATION_MESSAGE);
            mm.setData(""+date.getCurDate(), msg, ""+date.getCurTime(),titleT.getText());
            
        }else{
                mm.deleteAnoData(titleT.getText());
        }
        
    
    }
    
}
