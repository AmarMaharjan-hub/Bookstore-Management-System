/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainn;
import model.LoginModel;
import model.Database;
import view.LoginView;
import controller.LoginController;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.UIManager;
/**
 *
 * @author DELL
 */
public class LoginMain {
    private static String[] userString;
    public static void main(String[] args) {
//        LoginView theView=new LoginView();
           
        LoginMain lm=new LoginMain();
        lm.getUser();
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoginModel theModel=new LoginModel();
        LoginView theView=new LoginView(userString);
        LoginController theController=new LoginController(theView, theModel);
//        theController.loginData();
        theView.setVisible(true);
        
    }
    
    
    public ArrayList<String> getUser(){
        ArrayList<String> users=new ArrayList<String>();
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            Statement stmt;
            ResultSet rs;
            
            String query="select username from user";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
                users.add(rs.getString("username"));
            }
            
            rs.close();
            stmt.close();
            
            loginData(users);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public void loginData(ArrayList<String> userList){
//        ArrayList<String> userList=theModel.getUser();
//        String userString = String.join(", ", userList);
        userString = new String[userList.size()];
        for (int i = 0; i < userList.size(); i++) {
            userString[i] = userList.get(i);
        }

         
        
//        theView.setComboBoxUsers(userString);
    }
}
