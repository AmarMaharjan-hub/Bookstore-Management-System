    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class NotificationView extends JPanel{
    
    public NotificationView(){
        setLayout(new GridLayout());
        JLabel l=new JLabel("notification");
        add(l);
        setVisible(true);
    }
    
}
