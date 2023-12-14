/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import model.UserModel;


/**
 *
 * @author DELL
 */
public class DashBoardView extends JFrame{
    
    CardLayout cd=new CardLayout();
    private JPanel header,body,logoPanel,timeAndDatePanel,menuPanel,salesMenu,purchaseMenu,activityMenu,inventoryMenu,profileMenu,notificationMenu,supplierMenu;
    private JLabel logoLabel,salesLabel,purchaseLabel,activityLabel,profileLabel,notificationLabel,inventoryLabel,supplierLabel;
    
    //defaults
    private Color dashBoardBG=new Color(51, 51, 51);
    private Font unselectedFont=new Font("Baskerville Old Face",Font.PLAIN,16);
    private Color dashBoardText=new Color(209, 209, 209);
    
    
    //selected
    private Color selectedBG=new Color(28, 28, 28);
    private Font selectedFont=new Font("Baskerville Old Face",Font.BOLD,18);
    private Color selectedFontColor=new Color(176, 212, 15);
    
    
    //hover
    private Color hoverBG=new Color(82, 82, 82);
    private Font hoverFont=new Font("Baskerville Old Face",Font.PLAIN,17);
    private Color hoverFontColor=new Color(240, 240, 240);
    
    
    private SalesView sv=new SalesView();
    private PurchaseView pv=new PurchaseView();
    private ActivityView av=new ActivityView();
    private InventoryView iv=new InventoryView();
    private ProfileView prv=new ProfileView();
    private NotificationView nv=new NotificationView();
    private SupplierView suv=new SupplierView();
    
    
    private UserModel um=new UserModel();
    
    
    private int selected=1;
    
    
    public DashBoardView(){
        setSize(1000,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        setTitle("UNITED BOOK");
        
        
        header=new JPanel(new BorderLayout());
        body=new JPanel(cd);
        logoPanel=new JPanel(new GridLayout());
        timeAndDatePanel=new JPanel();
        menuPanel=new JPanel(new GridLayout(1,6));
        
        salesMenu = new JPanel(new GridLayout());
        purchaseMenu = new JPanel(new GridLayout());
        activityMenu = new JPanel(new GridLayout());
        inventoryMenu = new JPanel(new GridLayout());
        profileMenu = new JPanel(new GridLayout());
        notificationMenu = new JPanel(new GridLayout());
        supplierMenu = new JPanel(new GridLayout());
        
        
        logoLabel=new JLabel("UNITED BOOK");
        salesLabel=new JLabel("Sales");
        purchaseLabel=new JLabel("Purchase");
        activityLabel=new JLabel("Activity");
        profileLabel=new JLabel("Profile");
        notificationLabel=new JLabel("Notifications");
//        notificationLabel=new JLabel("Messages");
        inventoryLabel=new JLabel("Inventory");
        supplierLabel=new JLabel("Supplier");
        
        
        //foreground of header texts
        logoLabel.setForeground(dashBoardText);
        salesLabel.setForeground(dashBoardText);
        purchaseLabel.setForeground(dashBoardText);
        activityLabel.setForeground(dashBoardText);
        profileLabel.setForeground(dashBoardText);
        notificationLabel.setForeground(dashBoardText);
        inventoryLabel.setForeground(dashBoardText);
        supplierLabel.setForeground(dashBoardText);
        
        
        //horizonal alignment of header texts
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        salesLabel.setHorizontalAlignment(JLabel.CENTER);
        purchaseLabel.setHorizontalAlignment(JLabel.CENTER);
        activityLabel.setHorizontalAlignment(JLabel.CENTER);
        profileLabel.setHorizontalAlignment(JLabel.CENTER); 
        notificationLabel.setHorizontalAlignment(JLabel.CENTER);
        inventoryLabel.setHorizontalAlignment(JLabel.CENTER);
        supplierLabel.setHorizontalAlignment(JLabel.CENTER);
//        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        

        //font and size of header texts
        logoLabel.setFont(new Font("Baskerville Old Face",Font.BOLD,20));
        salesLabel.setFont(unselectedFont);
        purchaseLabel.setFont(unselectedFont);
        activityLabel.setFont(unselectedFont);
        profileLabel.setFont(unselectedFont);
        notificationLabel.setFont(unselectedFont);
        inventoryLabel.setFont(unselectedFont);
        supplierLabel.setFont(unselectedFont);
        
        
        //background of panels in the header
        logoPanel.setBackground(dashBoardBG);
//        logoPanel.setBackground(Color.red);
        menuPanel.setBackground(dashBoardBG);
        salesMenu.setBackground(dashBoardBG);
        purchaseMenu.setBackground(dashBoardBG);
        activityMenu.setBackground(dashBoardBG);
        inventoryMenu.setBackground(dashBoardBG);   
        profileMenu.setBackground(dashBoardBG);
        notificationMenu.setBackground(dashBoardBG);
        supplierMenu.setBackground(dashBoardBG);
        timeAndDatePanel.setBackground(dashBoardBG);
//        timeAndDatePanel.setBackground(Color.blue);
        
        
        header.setPreferredSize(new Dimension(1000,80));
//        logoPanel.setPreferredSize(new Dimension(180,80));
        logoPanel.setPreferredSize(new Dimension(170,80));
//        timeAndDatePanel.setPreferredSize(new Dimension(120,80));
        timeAndDatePanel.setPreferredSize(new Dimension(100,80));
        

        body.add("sales",sv);
        body.add("purchase",pv);
        body.add("activity",av);
        body.add("inventory",iv);
        body.add("profile",prv);
        body.add("notification",nv);
        
        
        if(um.getUserAccess(um.getUserId()).equals("admin")){
           body.add("supplier",suv);
        }
        
        
        logoPanel.add(logoLabel);
        salesMenu.add(salesLabel);
        purchaseMenu.add(purchaseLabel);
        activityMenu.add(activityLabel);
        inventoryMenu.add(inventoryLabel);
        profileMenu.add(profileLabel);
        notificationMenu.add(notificationLabel);
//        supplierMenu.add(supplierLabel);
        
        if(um.getUserAccess(um.getUserId()).equals("admin")){
           supplierMenu.add(supplierLabel);
        }
        
        menuPanel.add(salesMenu);
        menuPanel.add(purchaseMenu);
        menuPanel.add(activityMenu);
        menuPanel.add(inventoryMenu);
        menuPanel.add(profileMenu);
        //menuPanel.add(notificationMenu);
         
        
        if(um.getUserAccess(um.getUserId()).equals("admin")){
           menuPanel.add(supplierMenu);
        }
        
        
        
        header.add(logoPanel, BorderLayout.WEST);
        header.add(menuPanel, BorderLayout.CENTER);
        header.add(timeAndDatePanel, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
        
        salesMenu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me){
                if(selected!=1)setHover(salesMenu,salesLabel);
            }
            @Override
            public void mouseExited(MouseEvent me){
                if(selected!=1)setDefault(salesMenu, salesLabel);
            }
            @Override
            public void mousePressed(MouseEvent me){
                setAllDefault();
                selected=1;
                setSelected(salesMenu, salesLabel);
                //any table reload code here
                sv.setBillView();
                
                
                cd.show(body,"sales");
            }
            
        });
        
        purchaseMenu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me){
                if(selected!=2)setHover(purchaseMenu,purchaseLabel);
            }
            @Override
            public void mouseExited(MouseEvent me){
                if(selected!=2)setDefault(purchaseMenu, purchaseLabel);
            }
            @Override
            public void mousePressed(MouseEvent me){
                setAllDefault();
                selected=2;
                setSelected(purchaseMenu, purchaseLabel);
                //any table reload code here
                
                cd.show(body,"purchase");
            }
        });
        
        activityMenu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me){
                if(selected!=3)setHover(activityMenu,activityLabel);
            }
            @Override
            public void mouseExited(MouseEvent me){
                if(selected!=3)setDefault(activityMenu, activityLabel);
            }
            @Override
            public void mousePressed(MouseEvent me){
                setAllDefault();
                selected=3;
                setSelected(activityMenu, activityLabel);
                //any  table reload code here
                av.checkSelected();
                
                cd.show(body,"activity");
            }
        });
        
        inventoryMenu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me){
                if(selected!=4)setHover(inventoryMenu,inventoryLabel);
            }
            @Override
            public void mouseExited(MouseEvent me){
                if(selected!=4)setDefault(inventoryMenu, inventoryLabel);
            }
            @Override
            public void mousePressed(MouseEvent me){
                setAllDefault();
                selected=4;
                setSelected(inventoryMenu, inventoryLabel);
                iv.setBookList();
                cd.show(body,"inventory");
            }
        });
        
        profileMenu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me){
                if(selected!=5)setHover(profileMenu,profileLabel);
            }
            @Override
            public void mouseExited(MouseEvent me){
                if(selected!=5)setDefault(profileMenu, profileLabel);
            }
            @Override
            public void mousePressed(MouseEvent me){
                setAllDefault();
                selected=5;
                setSelected(profileMenu, profileLabel);
                //any  table reload code here
                prv.setUsersList();
                prv.setProfile();
                prv.setNotificationList();
                
                cd.show(body,"profile");
                sendFrame();
            }
        });
        
        notificationMenu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me){
                if(selected!=6)setHover(notificationMenu,notificationLabel);
            }
            @Override
            public void mouseExited(MouseEvent me){
                if(selected!=6)setDefault(notificationMenu, notificationLabel);
            }
            @Override
            public void mousePressed(MouseEvent me){
                setAllDefault();
                selected=6;
                setSelected(notificationMenu, notificationLabel);
                //any  table reload code here
                
                cd.show(body,"notification");
            }
        });
        
        supplierMenu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me){
                if(selected!=7)setHover(supplierMenu,supplierLabel);
            }
            @Override
            public void mouseExited(MouseEvent me){
                if(selected!=7)setDefault(supplierMenu, supplierLabel);
            }
            @Override
            public void mousePressed(MouseEvent me){
                setAllDefault();
                selected=7;
                setSelected(supplierMenu, supplierLabel);
                //any  table reload code here
                suv.setSupplierList();
                
                
                cd.show(body,"supplier");
            }
        });
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                um.deleteSelectedUser();
            }
        });
        
        setVisible(true);
    }
    
//    public static void main(String[] args) {
//        new DashBoardView();
//    }
    
    
    public void setSelected(JPanel p, JLabel l){
        p.setBackground(selectedBG);
        l.setFont(selectedFont);
        l.setForeground(selectedFontColor);
    }
    
    
    public void setHover(JPanel p, JLabel l){
//        p.setBackground(hoverBG);
        l.setFont(hoverFont);
        l.setForeground(hoverFontColor);
    }
    
    
    public void setDefault(JPanel p, JLabel l){
        p.setBackground(dashBoardBG);
        l.setFont(unselectedFont);
        l.setForeground(dashBoardText);
    }
    
    public void setAllDefault(){
        salesMenu.setBackground(dashBoardBG);
        salesLabel.setFont(unselectedFont);
        salesLabel.setForeground(dashBoardText);
        
        purchaseMenu.setBackground(dashBoardBG);
        purchaseLabel.setFont(unselectedFont);
        purchaseLabel.setForeground(dashBoardText);
        
        inventoryMenu.setBackground(dashBoardBG);
        inventoryLabel.setFont(unselectedFont);
        inventoryLabel.setForeground(dashBoardText);
        
        profileMenu.setBackground(dashBoardBG);
        profileLabel.setFont(unselectedFont);
        profileLabel.setForeground(dashBoardText);
        
        activityMenu.setBackground(dashBoardBG);
        activityLabel.setFont(unselectedFont);
        activityLabel.setForeground(dashBoardText);
        
        notificationMenu.setBackground(dashBoardBG);
        notificationLabel.setFont(unselectedFont);
        notificationLabel.setForeground(dashBoardText);
        
        supplierMenu.setBackground(dashBoardBG);
        supplierLabel.setFont(unselectedFont);
        supplierLabel.setForeground(dashBoardText);
    }
    
    public JPanel getDefaultSelectedPanel(){
        return salesMenu;
    }
    
    public JLabel getDefaultSelectedLabel(){
        return salesLabel;
    }
    
    public void sendFrame(){
        prv.setFrame(this);
    }
    
    
    
    
    public static void main(String[] args) {
        new DashBoardView();
    }
    
}
