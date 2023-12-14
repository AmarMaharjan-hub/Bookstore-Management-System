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
public class PurchaseModel {

    Statement stmt;
    ResultSet rs;
    
    
//    public void updateData(String pid, String bid, String size, String rate,String total){
//        try {
//            Database db=new Database();
//            Connection con=db.getConnection();
//            String query="";
//            stmt=con.createStatement();
//            int result=stmt.executeUpdate(query);
//            if(result!=0){
//                
//            }
//            rs.close();
//            stmt.close();
//            con.close();
//            db.closeConnecion();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    
    public ArrayList<String[]> getPurchaseList(String date){
        ArrayList<String[]> purchase=new ArrayList<String[]>();
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
           
            
            
            String query="select purchase.pdate,book.book_title,purchase.size,purchase.rate from purchase,book where purchase.b_id=book.book_id and purchase.pdate='"+date+"' order by purchase.pdate desc";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               //purchase
               
               String str[]={""+rs.getDate("pdate"),rs.getString("book_title"),""+rs.getInt("size"),""+rs.getInt("rate")};
               purchase.add(str);
               
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
        return purchase;
    }
    
    
    
    public ArrayList<String[]> getPurchaseList(int year){
        ArrayList<String[]> purchase=new ArrayList<String[]>();
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
            String query="select purchase.pdate,book.book_title,purchase.size,purchase.rate from purchase,book where purchase.b_id=book.book_id and purchase.pdate in (select pdate from purchase where year(pdate)="+year+") order by purchase.pdate desc";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               //purchase
               
               String str[]={""+rs.getDate("pdate"),rs.getString("book_title"),""+rs.getInt("size"),""+rs.getInt("rate")};
               purchase.add(str);
               
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return purchase;
    }
    
    
    
    public ArrayList<String[]> getPurchaseList(int year, int month){
        ArrayList<String[]> purchase=new ArrayList<String[]>();
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
            String query="select purchase.pdate,book.book_title,purchase.size,purchase.rate from purchase,book where purchase.b_id=book.book_id and purchase.pdate in (select pdate from purchase where year(pdate)="+year+" and month(pdate)="+month+") order by purchase.pdate desc";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               //purchase
               
               String str[]={""+rs.getDate("pdate"),rs.getString("book_title"),""+rs.getInt("size"),""+rs.getInt("rate")};
               purchase.add(str);
               
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return purchase;
    }
    
     public ArrayList<String[]> getPurchaseList(){
        ArrayList<String[]> purchase=new ArrayList<String[]>();
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
           
            
            
            String query="select purchase.pdate,book.book_title,purchase.size,purchase.rate from purchase,book where purchase.b_id=book.book_id order by purchase.pdate desc";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               //purchase
               
               String str[]={""+rs.getDate("pdate"),rs.getString("book_title"),""+rs.getInt("size"),""+rs.getInt("rate")};
               purchase.add(str);
               
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
        return purchase;
    }
    
    
    
    public void insertPurchase(String pid, String bid, String size,String rate,String sid,String date,String uid){
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="insert into purchase values('"+pid+"','"+bid+"','"+size+"','"+rate+"','"+sid+"','"+date+"','"+uid+"')";
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
    
    
    public int getLastID(){
        int id=0;
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="select pid from purchase order by pid desc limit 1";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               id=rs.getInt("pid");
            }
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id+1;
    }
    
}
