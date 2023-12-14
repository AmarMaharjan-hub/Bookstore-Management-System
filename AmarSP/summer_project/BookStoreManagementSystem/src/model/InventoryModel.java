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
public class InventoryModel {
    
    Statement stmt;
    ResultSet rs;
    
//    DashBoardController dc=new DashBoardController();
    
    public ArrayList<String[]> getInventoryList(){
        ArrayList<String[]> books=new ArrayList<String[]>();
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
//            String query="select * from book";
            String query="select book.book_id, book.book_title,category.cat_name,book.quantity,book.price from book,category where book.cat_id=category.cat_id order by book_id asc";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               String str[]={""+rs.getInt("book_id"),rs.getString("book_title"),rs.getString("cat_name"),""+rs.getInt("quantity"),""+rs.getInt("price")};
//                System.out.println(rs.getInt("book_id")+"   "+rs.getString("book_title")+"  "+rs.getString("cat_name")+"    "+rs.getInt("quantity")+"   "+rs.getInt("price"));
               books.add(str);
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return books;
    }
    
    
    public void updateData(String id, String title, String cat, String qty, String price){
        try {
            Database db=new Database();
            Connection con=db.getConnection();
             String query="update book set book_title='"+title+"',cat_id='"+cat+"', quantity='"+qty+"',price='"+price+"' where book_id='"+id+"'";
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
    
    
        public void updateData(String id, int qty){
        try {
            Database db=new Database();
            Connection con=db.getConnection();
             String query="update book set quantity='"+qty+"' where book_id='"+id+"'";
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
    
    
    public void deleteData(String id){
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="delete from book where book_id='"+id+"'";
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
        
        
    public int getSearch(String type,String value){
        int res=-1;
        
        if(type.equals("Title")){
            type="book_title";
        }else{
            type="book_id";
        }
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
            
            String query="select book_id from book where "+type+"='"+value+"'";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            if(rs.next()){
               res=rs.getInt("book_id");
                System.out.println("selected book id: "+res);
            }else{
                res=-1;
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return res;
    }
    
    public String getNameFromId(String id){
        String str="";
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="select book_title from book where book_id='"+id+"'";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               str=rs.getString("book_title");
            }
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    
    
    
    public String getIdFromName(String str){
        String id="";
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="select book_id from book where book_title='"+str+"'";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               id=""+rs.getInt("book_id");
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
    

    public String getRate(String id,String title){
        String rate="";
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="select price from book where book_id='"+id+"' and book_title='"+title+"'";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               rate=""+rs.getInt("price");
            }
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rate;
    }

    
    
    public void insertBook(String id, String title, String cat_id,String size,String rate){
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="insert into book values("+id+",'"+title+"',"+cat_id+","+size+","+rate+")";
//            System.out.println(query);
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
            String query="select book_id from book order by book_id desc limit 1";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               id=rs.getInt("book_id");
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
    
    
public int getQuantity(String id){
        int qty=0;
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="select quantity from book where book_id="+id;
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               qty=rs.getInt("quantity");
            }
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qty;
    }    
    
}
