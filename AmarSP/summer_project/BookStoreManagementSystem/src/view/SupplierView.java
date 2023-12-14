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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.SupplierModel;
import model.Validation;

/**
 *
 * @author DELL
 */
public class SupplierView extends JPanel{
    
    
    private JTable supplierTable;
    private JScrollPane supplierScroll;
    private JButton delete,apply;
    private JLabel idLabel,nameLabel,addressLabel,phoneLabel;
    private JTextField idTF,nameTF,addressTF,phoneTF;
    private JToggleButton add, update;
    private JPanel upper,lower,tablePanel,removePanel,bottomPanel,centerPanel,southPanel,centerContainer,southContainer,northPanel,northContainer;
    
    private String[] colhead={"ID","Name","Address","Phone"};
    private String[][] data;
    
    private String name,address,phone;
    
    private SupplierModel sm=new SupplierModel();
    
    private Validation valid=new Validation();
    
    private Color bg=new Color(28,28,28);
    
    private DefaultTableModel mod;
    
    
    public SupplierView(){
        
        setLayout(new GridLayout(2,1));
//        setSupplierList();
        
        //initialization of label
        idLabel=new JLabel("ID : ",JLabel.RIGHT);
        nameLabel=new JLabel("Name : ",JLabel.RIGHT);
        addressLabel=new JLabel("Address : ",JLabel.RIGHT);
        phoneLabel=new JLabel("Phone : ",JLabel.RIGHT);
        
        //initialization of textfield
        idTF = new JTextField(getLastSupplierId());
        nameTF = new JTextField();
        addressTF = new JTextField();
        phoneTF = new JTextField();
        
        //initialization of buttons
        delete=new JButton("Delete");
        apply=new JButton("apply");
        
        //initialization of toogle buttons
        add=new JToggleButton("Add");
        update=new JToggleButton("Update");
        
        //initialization of table
        mod=new DefaultTableModel(data,colhead);
        supplierTable=new JTable(mod){
            private static final long serialVersionUID = 1L;
            
            @Override
            public boolean isCellEditable(int row, int column) {                
                return false;               
            };
        };
        
        //scroll
        supplierTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        supplierScroll=new JScrollPane(supplierTable);
        
        //panel initialization
        upper=new JPanel(new BorderLayout());
        lower=new JPanel(new BorderLayout());
        tablePanel=new JPanel(new FlowLayout());
        removePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel=new JPanel(new FlowLayout());
        centerPanel=new JPanel(new FlowLayout());
        southPanel=new JPanel(new FlowLayout());
        centerContainer=new JPanel(new FlowLayout(FlowLayout.CENTER,5,20));
        southContainer=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        northPanel=new JPanel(new FlowLayout());
        northContainer=new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
        
        
        idTF.setEditable(false);
        
        
        add.setSelected(true);
        
        
        idTF.setPreferredSize(new Dimension(100,20));
        nameTF.setPreferredSize(new Dimension(100,20));
        addressTF.setPreferredSize(new Dimension(100,20));
        phoneTF.setPreferredSize(new Dimension(100,20));
        
        idLabel.setPreferredSize(new Dimension(60,20));
        nameLabel.setPreferredSize(new Dimension(60,20));
        addressLabel.setPreferredSize(new Dimension(60,20));
        phoneLabel.setPreferredSize(new Dimension(60,20));
        
        
        supplierScroll.setPreferredSize(new Dimension(800,103));
        
        removePanel.setPreferredSize(new Dimension(810,70));
//        centerPanel.setBackground(Color.red);
        northPanel.setPreferredSize(new Dimension(1000,40));
        southPanel.setPreferredSize(new Dimension(1000,40));

        centerContainer.setPreferredSize(new Dimension(350,100));
        northContainer.setPreferredSize(new Dimension(350,40));
        southContainer.setPreferredSize(new Dimension(350,40));
        
        
        delete.setEnabled(false);
        setSupplierList();
        
//        centerContainer.setBackground(Color.red);
//        southContainer.setBackground(Color.blue);
//        northContainer.setBackground(Color.yellow);


        northContainer.setBackground(bg);
        southContainer.setBackground(bg);
        northPanel.setBackground(bg);
        centerPanel.setBackground(bg);
        southPanel.setBackground(bg);
        tablePanel.setBackground(bg);
        bottomPanel.setBackground(bg);
        removePanel.setBackground(bg);
        
        
        centerContainer.add(idLabel);
        centerContainer.add(idTF);
        centerContainer.add(nameLabel);
        centerContainer.add(nameTF);
        centerContainer.add(addressLabel);
        centerContainer.add(addressTF);
        centerContainer.add(phoneLabel);
        centerContainer.add(phoneTF);
        
        northContainer.add(add);
        northContainer.add(update);
        
        southContainer.add(apply);
        
        
        bottomPanel.add(removePanel);
        centerPanel.add(centerContainer);
        tablePanel.add(supplierScroll);
        removePanel.add(delete);
        northPanel.add(northContainer);
        southPanel.add(southContainer);
        
        
        upper.add(northPanel,BorderLayout.NORTH);
        upper.add(centerPanel);
        upper.add(southPanel,BorderLayout.SOUTH);
        lower.add(tablePanel,BorderLayout.CENTER);
        lower.add(bottomPanel,BorderLayout.SOUTH);
        
        add(upper);
        add(lower);
        
        
        
        
        add.addItemListener(new ItemListener(){
            
            @Override
            public void itemStateChanged(ItemEvent ie){
                if(add.isSelected()){
                    update.setSelected(false);
                    delete.setEnabled(false);
                    idTF.setText(getLastSupplierId());
                }
                
                if(!add.isSelected() && !update.isSelected()){
                    apply.setEnabled(false);
                    nameTF.setEditable(false);
                    addressTF.setEditable(false);
                    phoneTF.setEditable(false);
                    
                    delete.setEnabled(true);
                }else{
                    apply.setEnabled(true);
                    nameTF.setEditable(true);
                    addressTF.setEditable(true);
                    phoneTF.setEditable(true);
                }
            }
            
        });
        
        
        update.addItemListener(new ItemListener(){
            
            @Override
            public void itemStateChanged(ItemEvent ie){
                if(update.isSelected()){
                    add.setSelected(false);
                    delete.setEnabled(false);
                    idTF.setText("");
                }
                
                if(!add.isSelected() && !update.isSelected()){
                    apply.setEnabled(false);
                    nameTF.setEditable(false);
                    addressTF.setEditable(false);
                    phoneTF.setEditable(false);
                    
                    
                    delete.setEnabled(true);
                }else{
                    apply.setEnabled(true);
                    nameTF.setEditable(true);
                    addressTF.setEditable(true);
                    phoneTF.setEditable(true);
                }
                
                if(supplierTable.getSelectedRow() != -1){
                    idTF.setText(""+supplierTable.getValueAt(supplierTable.getSelectedRow(), 0));
                    nameTF.setText(""+supplierTable.getValueAt(supplierTable.getSelectedRow(), 1));
                    addressTF.setText(""+supplierTable.getValueAt(supplierTable.getSelectedRow(), 2));
                    phoneTF.setText(""+supplierTable.getValueAt(supplierTable.getSelectedRow(), 3));
                }
            }
            
        });
        
        apply.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
                
                if(applyValidator()){
                
                    if(add.isSelected()){
                        sm.setData(idTF.getText(), nameTF.getText(), addressTF.getText(), phoneTF.getText());
                        setSupplierList();

                        //empty fields after operation
                        idTF.setText(getLastSupplierId());
                        nameTF.setText("");
                        addressTF.setText("");
                        phoneTF.setText("");
                    }else if(update.isSelected()){
                        sm.updateData(idTF.getText(), nameTF.getText(), addressTF.getText(), phoneTF.getText());
                        setSupplierList();

                        //empty fields after operation
                        idTF.setText("");
                        nameTF.setText("");
                        addressTF.setText("");
                        phoneTF.setText("");
                    }
                
                }
                
                    
            }
            
        });
        
        
        delete.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
                if(supplierTable.getSelectedRow() != -1){
                    sm.deleteData(""+supplierTable.getValueAt(supplierTable.getSelectedRow(), 0));
                    
                    
                    mod.removeRow(supplierTable.getSelectedRow());
                    
                    
                    //empty fields after operation
                    idTF.setText("");
                    nameTF.setText("");
                    addressTF.setText("");
                    phoneTF.setText("");
                }else{
                    //error for not selected row
                }
            }
            
        });
        

        supplierTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            
            
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if(supplierTable.getSelectedRow()!= -1  &&  update.isSelected()){           
                            
                    idTF.setText(""+supplierTable.getValueAt(supplierTable.getSelectedRow(), 0));
                    nameTF.setText(""+supplierTable.getValueAt(supplierTable.getSelectedRow(), 1));
                    addressTF.setText(""+supplierTable.getValueAt(supplierTable.getSelectedRow(), 2));
                    phoneTF.setText(""+supplierTable.getValueAt(supplierTable.getSelectedRow(), 3));
                }
            }
        });
        
    }
    
    
    
    
    public void setSupplierList(){
//        SupplierModel sm=new SupplierModel();
                
        ArrayList<String[]> supplierList= sm.getSupplierList();
        
        int size=mod.getRowCount();
        
        for(int i=0; i<size; i++){
            mod.removeRow(0);
        }

        for(int i=0;i<supplierList.size();i++){
           mod.addRow(supplierList.get(i));
        }
       
    }
    
    
    public String getLastSupplierId(){
//        SupplierModel sm=new SupplierModel();
        return ""+sm.getLastID();
    }
    
    
    
    public boolean applyValidator(){
    
        if( (valid.isVoid(this, "Name", nameTF.getText()) || valid.isVoid(this, "Address", addressTF.getText()) || valid.isVoid(this, "Phone", phoneTF.getText()) )){
            return false;
        }
        
        if(!valid.onlyNumbers(this, "Phone", phoneTF.getText())){
            return false;
        }
        
        if(phoneTF.getText().length() != 10){
            JOptionPane.showMessageDialog(this, "Phone should be of length 10", " ", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(phoneTF.getText().charAt(0) != '9' || phoneTF.getText().charAt(1) != '8'){
            JOptionPane.showMessageDialog(this, "Incorrect Phone number format", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(sm.checkName(nameTF.getText()) != 0){
            JOptionPane.showMessageDialog(this, nameTF.getText()+" Supplier name already used", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(sm.checkContact(phoneTF.getText()) == 1){
            JOptionPane.showMessageDialog(this, phoneTF.getText()+" Phone number already used", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
        return true;
    }
    
    
    
}
