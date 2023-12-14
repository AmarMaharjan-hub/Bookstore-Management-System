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
public class SalesModel {
    
    Statement stmt;
    ResultSet rs;
 
    
    
   public ArrayList<String[]> getSalesList(int year, int month){
        ArrayList<String[]> sales=new ArrayList<String[]>();
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
//            String query="select * from book";
            String query="select bill.date, book.book_title,sales.quantity,sales.price from sales,book,bill where sales.book_id=book.book_id and sales.bill_no=bill.bill_no and bill.date in (select date from bill where year(date)="+year+" and month(date)="+month+") order by bill.date desc;";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               String str[]={""+rs.getDate("date"),rs.getString("book_title"),""+rs.getInt("quantity"),""+rs.getInt("price")};
//                System.out.println(rs.getInt("book_id")+"   "+rs.getString("book_title")+"  "+rs.getString("cat_name")+"    "+rs.getInt("quantity")+"   "+rs.getInt("price"));
               sales.add(str);
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sales;
    }
   
   
   public ArrayList<String[]> getSalesList(int year){
        ArrayList<String[]> sales=new ArrayList<String[]>();
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
//            String query="select * from book";
            String query="select bill.date, book.book_title,sales.quantity,sales.price from sales,book,bill where sales.book_id=book.book_id and sales.bill_no=bill.bill_no and bill.date in (select date from bill where year(date)="+year+") order by bill.date desc;";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               String str[]={""+rs.getDate("date"),rs.getString("book_title"),""+rs.getInt("quantity"),""+rs.getInt("price")};
//                System.out.println(rs.getInt("book_id")+"   "+rs.getString("book_title")+"  "+rs.getString("cat_name")+"    "+rs.getInt("quantity")+"   "+rs.getInt("price"));
               sales.add(str);
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sales;
    }
   
   
   
   public ArrayList<String[]> getSalesList(String date){
        ArrayList<String[]> sales=new ArrayList<String[]>();
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
//            String query="select * from book";
            String query="select bill.date, book.book_title,sales.quantity,sales.price from sales,book,bill where sales.book_id=book.book_id and sales.bill_no=bill.bill_no and bill.date='"+date+"' order by bill.date desc";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               String str[]={""+rs.getDate("date"),rs.getString("book_title"),""+rs.getInt("quantity"),""+rs.getInt("price")};
//                System.out.println(rs.getInt("book_id")+"   "+rs.getString("book_title")+"  "+rs.getString("cat_name")+"    "+rs.getInt("quantity")+"   "+rs.getInt("price"));
               sales.add(str);
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sales;
    }
   
   public ArrayList<String[]> getSalesList(){
        ArrayList<String[]> sales=new ArrayList<String[]>();
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
//            String query="select * from book";
            String query="select bill.date, book.book_title,sales.quantity,sales.price from sales,book,bill where sales.book_id=book.book_id and sales.bill_no=bill.bill_no order by bill.date desc";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               String str[]={""+rs.getDate("date"),rs.getString("book_title"),""+rs.getInt("quantity"),""+rs.getInt("price")};
//                System.out.println(rs.getInt("book_id")+"   "+rs.getString("book_title")+"  "+rs.getString("cat_name")+"    "+rs.getInt("quantity")+"   "+rs.getInt("price"));
               sales.add(str);
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sales;
    }
    
    
    
    
    public void insertSales(String sid, String bid, String size,String rate,String bno){
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="insert into sales values('"+sid+"','"+bid+"','"+size+"','"+rate+"','"+bno+"')";
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
            String query="select sales_id from sales order by sales_id desc limit 1";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               id=rs.getInt("sales_id");
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
