/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class LoginModel {
    private String result="";
    Statement stmt=null;
    ResultSet rs=null;
    
    
    public void validPassword(String username, String password){
        if(password.isEmpty()){
            result="Please enter the Password ! ! !";
        }else{
            try {
                Database db=new Database();
                Connection con=db.getConnection();
//                System.out.println(password);
                String query="select u_id from user where username='"+username+"' and password='"+password+"'";
                stmt=con.createStatement();
                rs=stmt.executeQuery(query);
                if(rs.next()==false){
                    result="Password is incorrect ! ! !";
                }else{
                    result="";
                }
                rs.close();
                stmt.close();
                con.close();
                db.closeConnecion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
//    public ArrayList<String> getUser(){
//        ArrayList<String> users=new ArrayList<String>();
//        try {
//            Database db=new Database();
//            Connection con=db.getConnection();
//            String query="select username from user";
//            stmt=con.createStatement();
//            rs=stmt.executeQuery(query);
//            while(rs.next()){
//                users.add(rs.getString("username"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
    
    public String getResult(){
        return result;
    }
}
