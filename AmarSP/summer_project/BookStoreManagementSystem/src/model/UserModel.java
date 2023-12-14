/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class UserModel {

    private Statement stmt;
    private ResultSet rs;
    private int userid;
    
    public void setUserId(String username){
        
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
//            String query="select U_id from user where username='"+username+"'";
            String query="insert into selected_user value((select U_id from user where username='"+username+"'))";
            
            stmt=con.createStatement();
            int res=stmt.executeUpdate(query);
            
            
            if(res!=0){
                //insert successful
            }
            
            stmt.close();
            con.close();
            db.closeConnecion();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }

    public int getUserId(){

        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
            String query="select * from selected_user order by suid desc limit 1";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               userid=rs.getInt("suid");
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return userid;
    }
    
    
    
    public String getUserAccess(int id){
        String access="";
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
            String query="select access_level from user where U_id="+id+"";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               access=rs.getString("access_level");
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return access;
        
    }
    
    
    public ArrayList<String[]> getUsersList(){
        ArrayList<String[]> users=new ArrayList<String[]>();
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
           
            
            
            String query="select profile.name,profile.contact,profile.address from user,profile where user.profile_id=profile.profile_id and user.access_level <> 'admin'";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               //purchase
               
               String str[]={rs.getString("name"),rs.getString("contact"),rs.getString("address")};
               users.add(str);
               
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
        return users;
    }
    
    
    public String[] getProfile(int id){
        
        String[] profile=new String[6];
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
           
            
            
            String query=" select user.username, profile.name,profile.contact,profile.address,profile.gender from user,profile where user.profile_id=profile.profile_id and user.U_id='"+id+"'";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               //purchase
               
                profile[0]=rs.getString("username");
                profile[1]=rs.getString("name");
                profile[2]=rs.getString("contact");
                profile[3]=rs.getString("address");
                profile[4]=rs.getString("gender");
                
               
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return profile;
    }
    
    
    public void updateUser(String user,String name, String contact, String address,String gender){
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="update user set username='"+user+"' where U_id='"+getUserId()+"'";
            stmt=con.createStatement();
            int result=stmt.executeUpdate(query);
            if(result!=0){
                
            }
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="update profile set name='"+name+"', contact='"+contact+"', address='"+address+"', gender='"+gender+"' where profile_id=(select profile_id from user where U_id='"+getUserId()+"')";
            stmt=con.createStatement();
            int result=stmt.executeUpdate(query);
            if(result!=0){
                
            }
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    }
    
    
    public String getIdFromProfileName(String str){
        String id="";
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="select profile_id from profile where name='"+str+"'";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               id=""+rs.getInt("profile_id");
            }
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public void deleteProfile(String profileName){
        
        try {
            System.out.println("user delete"+profileName);
            Database db=new Database();
            Connection con=db.getConnection();
            String query="delete from user where profile_id=(select profile_id from profile where profile_id='"+getIdFromProfileName(profileName)+"')";
            stmt=con.createStatement();
            int result=stmt.executeUpdate(query);
            if(result!=0){
                
            }
            stmt.close();
            con.close();
            db.closeConnecion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            System.out.println("profile delete"+profileName);
            Database db=new Database();
            Connection con=db.getConnection();
            String query="delete from profile where profile_id='"+getIdFromProfileName(profileName)+"'";
            stmt=con.createStatement();
            int result=stmt.executeUpdate(query);
            if(result!=0){
                
            }
            stmt.close();
            con.close();
            db.closeConnecion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public int checkUsername(String user){
        
        int num=0;
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
           
            
            
            String query=" select count(username) as count from user where username='"+user+"'";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               
               
               if(rs.getLong("count")<=1){
                    num=0;
                }else{
                
                    num=1;
                }
                
               
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return num;
    }
    
    public int checkContact(String contact){
        
        int num=0;
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
           
            
            
            String query=" select count(contact) as count from profile where contact='"+contact+"'";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               
               
               if(rs.getLong("count")<=1){
                    num=0;
                }else{
                
                    num=1;
                }
                
               
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return num;
    }
    
    
    public void deleteSelectedUser(){
    
         try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="delete from selected_user";
            stmt=con.createStatement();
            int result=stmt.executeUpdate(query);
            if(result!=0){
                
            }
            stmt.close();
            con.close();
            db.closeConnecion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    
    
//    public static void main(String[] args) {
//        UserModel u=new UserModel();
//        
//        System.out.println(u.getUserId("tempuser"));
//    }
}
