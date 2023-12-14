/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import view.LoginView;
import model.LoginModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import model.UserModel;
/**
 *
 * @author DELL
 */
public class LoginController {
    private LoginView theView;
    private LoginModel theModel;
    private UserModel user;
    
    public LoginController(LoginView theView, LoginModel theModel){
        this.theView=theView;
        this.theModel=theModel;
        
        this.theView.addloginListener(new LoginListener());
        
        this.theView.addResetListener(new ResetListener());
        
        this.theView.addJToogleButtonListener(new PasswordListener());
        
//        loginData();

    }
    
//    public void loginData(){
//        ArrayList<String> userList=theModel.getUser();
////        String userString = String.join(", ", userList);
//        String[] userString = new String[userList.size()];
//        for (int i = 0; i < userList.size(); i++) {
//            userString[i] = userList.get(i);
//        }
//
//            
//        theView.setComboBoxUsers(userString);
//    }
    
    class ResetListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae){
//            System.out.println("reset");
                theView.resetComp();
        }
        
    }
    
    class LoginListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae){
//            System.out.println("login");
            theModel.validPassword(theView.getUsername(), theView.getPassword());
            //System.out.println(theView.getPassword());
            String result=theModel.getResult();
            theView.setError(result);
            
            if(result.isEmpty()){
                //redirect to the dashboard.
                System.out.println("Working");
                
                //DashboardMain should be invoked
                
               theView.dispose();
                
               user=new UserModel();
               user.deleteSelectedUser();
               user.setUserId(theView.getUsername());
                //DashBoardView d=new DashBoardView();
                DashBoardController ds=new DashBoardController();
                
                
                
            }
        }
    }
    
    class PasswordListener implements ItemListener{
        
        @Override
        public void itemStateChanged(ItemEvent ie){
            if(ie.getStateChange()==ItemEvent.SELECTED){
                theView.showPassword();
            }else{
                theView.hidePassword();
            }
            
        }
    }
}
