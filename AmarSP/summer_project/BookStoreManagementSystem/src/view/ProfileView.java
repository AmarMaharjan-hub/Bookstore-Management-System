/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import mainn.LoginMain;
import model.MessageModel;
import model.UserModel;
import model.Validation;

/**
 *
 * @author Admin
 */
public class ProfileView extends JPanel{
    
    // select user.username,profile.name,profile.contact,profile.address,profile.gender from user,profile where user.profile_id=profile.profile_id and user.access_level <> "admin";
    
    private JLabel userL,notificationsL,nameL,addressL,contactL,genderL,prePasswordL,passwordL,rePasswordL;
    
    private JButton edit,done,deleteNot,deleteUser, passwordB, clear, cancel,logout;
    
    private JTextField nameT,userT,addressT,contactT,prePasswordT,passwordT,rePasswordT;
    
    private JComboBox genderCB;
    
    private JTable mesTable, userTable;
    
    private DefaultTableModel modMessage, modUser;
    
    private JPanel left, right;
    
    private JPanel perInfoPanel, userInfoPanel, passwordPanel;
    
    private JPanel perInfo;
    
    private String[] colHead={"name","contact","address"};
    
    private String[] colHeadm={"Date","Message"};
    
    private String[][] data;
    
    private String[][] datam;
    
    private JScrollPane userPane,messagePane;
    
    private Dimension labelSize=new Dimension(100,20);
    
    private Dimension tfSize=new Dimension(100,20);
    
    private UserModel um=new UserModel();
    
    private MessageModel mm= new MessageModel();
    
    private Validation valid=new Validation();
    
    private JFrame f;
    
    private Color bg=new Color(28,28,28);
    
//    private static int logCount=0;
    
    
    
    
    
    
    public ProfileView(){
        
        setLayout(new GridLayout(1,2));
        
        
        
        
        nameL=new JLabel("Name",JLabel.RIGHT);
        notificationsL=new JLabel("Notification",JLabel.RIGHT);
        userL=new JLabel("UserName",JLabel.RIGHT);
        addressL=new JLabel("Address",JLabel.RIGHT);
        contactL=new JLabel("Contact",JLabel.RIGHT);
        genderL=new JLabel("Gender",JLabel.RIGHT);
        prePasswordL=new JLabel("Previous Password",JLabel.RIGHT);
        passwordL=new JLabel("New Password",JLabel.RIGHT);
        rePasswordL=new JLabel("Retype Password",JLabel.RIGHT);
        
        
        
        edit=new JButton("Edit");
        done=new JButton("Done");
        deleteNot=new JButton("Delete");
        deleteUser=new JButton("Delete");
        passwordB=new JButton("Change Password");
        clear=new JButton("Clear all");
        cancel=new JButton("Cancel");
        logout=new JButton("Logout");
        
        
        
        nameT=new JTextField();
        addressT=new JTextField();
        contactT=new JTextField();
        userT=new JTextField();
        prePasswordT=new JTextField();
        passwordT=new JTextField();
        rePasswordT=new JTextField();
        
        
        
        genderCB=new JComboBox(new String[]{"Male","Female","Other"});
        
        genderCB.setSelectedItem("female");
        
        
        left=new JPanel(new GridLayout(2,1));
        right=new JPanel(new FlowLayout(FlowLayout.CENTER,5,20));
        
        
        
        perInfoPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,20,15));
        userInfoPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,5,15));
        passwordPanel=new JPanel(new GridLayout(3,2));
        
        
        perInfo=new JPanel(new FlowLayout(FlowLayout.LEFT,5,15));
        
        
        
        modUser=new DefaultTableModel(data,colHead);
        
        userTable=new JTable(modUser){
            private static final long serialVersionUID = 1L;
            
            @Override
            public boolean isCellEditable(int row, int column) {                
                return false;               
            };
        };
        
        userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        userPane=new JScrollPane(userTable);
        
        
        modMessage=new DefaultTableModel(datam,colHeadm);
        
        mesTable=new JTable(modMessage){
            private static final long serialVersionUID = 1L;
            
            @Override
            public boolean isCellEditable(int row, int column) {                
                return false;               
            };
        };
        

        
        
        mesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        mesTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        mesTable.getColumnModel().getColumn(1).setPreferredWidth(367);

        
        
        messagePane=new JScrollPane(mesTable);
        
        
        
        nameT.setEditable(false);
        addressT.setEditable(false);
        contactT.setEditable(false);
        userT.setEditable(false);
        
        genderCB.setEnabled(false);
        
        
        
        done.setEnabled(false);
        cancel.setEnabled(false);
        
        
        
        nameL.setPreferredSize(labelSize);
        addressL.setPreferredSize(labelSize);
        contactL.setPreferredSize(labelSize);
        genderL.setPreferredSize(labelSize);
        userL.setPreferredSize(labelSize);
        notificationsL.setPreferredSize(labelSize);
        prePasswordL.setPreferredSize(labelSize);
        passwordL.setPreferredSize(labelSize);
        rePasswordL.setPreferredSize(labelSize);
        
        
        nameT.setPreferredSize(tfSize);
        addressT.setPreferredSize(tfSize);
        contactT.setPreferredSize(tfSize);
        userT.setPreferredSize(tfSize);
        prePasswordT.setPreferredSize(tfSize);
        passwordT.setPreferredSize(tfSize);
        rePasswordT.setPreferredSize(tfSize);
        
        genderCB.setPreferredSize(tfSize);
        
        perInfo.setPreferredSize(new Dimension(450,120));
        
        
        userPane.setPreferredSize(new Dimension(450,120));
        
        
        
        messagePane.setPreferredSize(new Dimension(450,250));
        
        
        perInfoPanel.setBackground(bg);
        userInfoPanel.setBackground(bg);
        right.setBackground(bg);
        perInfo.setBackground(bg);
        left.setBackground(bg);
        
        
        
        setUsersList();
        setProfile();
        setNotificationList();
        
        
        
        
        passwordPanel.add(prePasswordL);
        passwordPanel.add(prePasswordT);
        passwordPanel.add(passwordL);
        passwordPanel.add(passwordT);
        passwordPanel.add(rePasswordL);
        passwordPanel.add(rePasswordT);
        
        
        perInfo.add(userL);
        perInfo.add(userT);
        perInfo.add(nameL);
        perInfo.add(nameT);
        perInfo.add(addressL);
        perInfo.add(addressT);
        perInfo.add(contactL);
        perInfo.add(contactT);
        perInfo.add(genderL);
        perInfo.add(genderCB);

                
        
                
        perInfoPanel.add(edit);
        perInfoPanel.add(done);
        perInfoPanel.add(cancel);
//        perInfoPanel.add(passwordB);
        perInfoPanel.add(perInfo);
        
        
        
        userInfoPanel.add(userPane);
        userInfoPanel.add(deleteUser);
        
        
        
        left.add(perInfoPanel);
        
//        if(um.getUserAccess(um.getUserId()).equals("Admin")){
//            left.add(userInfoPanel);
//        }
        
        if(um.getUserAccess(um.getUserId()).equals("admin")){
           left.add(userInfoPanel);
        }
        
        
        
//        left.add(perInfoPanel);
//        left.add(userInfoPanel);
        
        right.add(logout);
        right.add(messagePane);
        right.add(deleteNot);
        right.add(clear);
        
        
        
        add(left);
        add(right);
        
        
        deleteUser.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent ae){
                if(userTable.getSelectedRow()>0){
                    //delete code
                    
                    um.deleteProfile(""+modUser.getValueAt(userTable.getSelectedRow(), 0));
                    
                }
            }
            
        });
        
        edit.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
                edit.setEnabled(false);
                done.setEnabled(true);
                cancel.setEnabled(true);
                
                
                userT.setEditable(true);
                nameT.setEditable(true);
                addressT.setEditable(true);
                contactT.setEditable(true);
                genderCB.setEnabled(true);
                
                
                
            
            }
            
        });
        
        
        
        done.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
                if(doneValidator()){
                    edit.setEnabled(true);
                    done.setEnabled(false);
                    cancel.setEnabled(false);


                    updateProfile(userT.getText(),nameT.getText(),contactT.getText(), addressT.getText(), ""+genderCB.getSelectedItem());


                    userT.setEditable(false);
                    nameT.setEditable(false);
                    addressT.setEditable(false);
                    contactT.setEditable(false);
                    genderCB.setEnabled(false);
                }
                
                
            }
            
        });
        
        cancel.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
            
                edit.setEnabled(true);
                done.setEnabled(false);
                cancel.setEnabled(false);
                setProfile();
            
                 userT.setEditable(false);
                nameT.setEditable(false);
                addressT.setEditable(false);
                contactT.setEditable(false);
                genderCB.setEnabled(false);
            }
            
        });
        
        
        
        deleteNot.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
            
                if(mesTable.getSelectedRow() != -1){
                    mm.deleteData(""+mesTable.getValueAt(mesTable.getSelectedRow(), 1));
                    
                    
                    setNotificationList();
                    
                    
                    
                }else{
                    //error for not selected row
                }
                
            }
            
        });
        
        
        clear.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
            
                mm.deleteAllData();
                
                setNotificationList();
                
            }
            
        });
        
        logout.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae){
                um.deleteSelectedUser();
                f.dispose();
                
                runMain();
                
            }
        
        });
        
        
        
        
        passwordB.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent ae){
            
                String buttons[]={"Done","Cancel"};

                UIManager.put("OptionPane.minimumSize",new Dimension(350,120));

                int rc=JOptionPane.showOptionDialog(f,passwordPanel,"alert",JOptionPane.WARNING_MESSAGE,0,null,buttons,buttons[1]);  
                             
//                System.out.println(t1.getText()+"\n"+t2.getText()+"\n"+t3.getText()+"\n");
            
            }
            
        });
        
    
    }
    
    
    public void setUsersList(){
//        SupplierModel sm=new SupplierModel();
                
        ArrayList<String[]> userList= um.getUsersList();
        
        int size=modUser.getRowCount();
        
        for(int i=0; i<size; i++){
            modUser.removeRow(0);
        }

        for(int i=0;i<userList.size();i++){
           modUser.addRow(userList.get(i));
        }
       
    }
    
    
    public void setNotificationList(){
//        SupplierModel sm=new SupplierModel();
                
        ArrayList<String[]> notificationList= mm.getMessageList();
        
        int size=modMessage.getRowCount();
        
        for(int i=0; i<size; i++){
            modMessage.removeRow(0);
        }

        for(int i=0;i<notificationList.size();i++){
           modMessage.addRow(notificationList.get(i));
        }
       
    }
    
    
    public void setProfile(){
        
        String[] profile=um.getProfile(um.getUserId());
        
        userT.setText(profile[0]);
        nameT.setText(profile[1]);
        contactT.setText(profile[2]);
        addressT.setText(profile[3]);
        genderCB.setSelectedItem(profile[4]);
        
    }
    
    
    
    public void updateProfile(String user, String emName, String contact, String address, String gender){
        um.updateUser(user, emName, contact, address, gender);
        
    }
    
    public boolean doneValidator(){
    
        if( (valid.isVoid(this, "User", userT.getText()) || valid.isVoid(this, "Name", nameT.getText()) || valid.isVoid(this, "Contact", contactT.getText()) || valid.isVoid(this, "Address", addressT.getText()) )){
            return false;
        }
        
        if(!valid.onlyNumbers(this, "Contact", contactT.getText())){
            return false;
        }
        
        if(contactT.getText().length() != 10){
            JOptionPane.showMessageDialog(this, "Contact should be of length 10", " ", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(contactT.getText().charAt(0) != '9' || contactT.getText().charAt(1) != '8'){
            JOptionPane.showMessageDialog(this, "Incorrect Phone number format", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(um.checkUsername(userT.getText()) != 0){
            JOptionPane.showMessageDialog(this, userT.getText()+" username already used", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(um.checkContact(contactT.getText()) != 0){
            JOptionPane.showMessageDialog(this, contactT.getText()+" phone number already used", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    
    
    
    public void setFrame(JFrame f){
    
        this.f=f;
    
    }
    
    static void runMain(){
        
        int logCount=0;
    
        System.out.println(logCount);
        
        LoginMain log=new LoginMain();
        
        if(logCount==0)
            log.main(null);
        
        logCount++;
    
    }
    
}
