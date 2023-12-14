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
 * @author Admin
 */
public class MessageModel {
    
    private Statement stmt=null;
    private ResultSet rs=null;
    
    

    public ArrayList<String[]> getMessageList(){
        ArrayList<String[]> message=new ArrayList<String[]>();
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
            String query="select * from notification order by date desc, time desc";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
                String str[]={""+rs.getDate("date"),""+rs.getString("message")};
                message.add(str);
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    
    
    public void setData(String date, String message, String time, String book){
        try {
            deleteAnoData(book);
            Database db=new Database();
            Connection con=db.getConnection();
            String query="insert into notification values('"+date+"','"+message+"','"+time+"','"+book+"')";
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
    
    
    public void deleteData(String message){
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="delete from notification where message='"+message+"'";
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
    
    public void deleteAnoData(String book){
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="delete from notification where book='"+book+"'";
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
    
    
    public void deleteAllData(){
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="delete from notification";
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
    
    
     public boolean getMessage(String message){
        
         boolean mes=false;
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
            String query="select count(message) as count from notification where message='"+message+"'";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            if(rs.next()){
                if(rs.getLong("count")==0){
                    mes=false;
                }else{
                
                    mes=true;
                }
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return mes;
    }

    
}
