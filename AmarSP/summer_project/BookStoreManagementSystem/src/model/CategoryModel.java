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
public class CategoryModel {
    
    Statement stmt;
    ResultSet rs;
    
    
    int id;
    
    public int getCategoryId(String catName){
        
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
            String query="select cat_id from category where cat_name='"+catName+"'";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            if(rs.next()){
                id=rs.getInt("cat_id");
            }else{
                id=-1;
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
    
    
    public String[] getCategoryNames(){
        ArrayList<String> category=new ArrayList<String>();
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
            String query="select cat_name from category ";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               category.add(rs.getString("cat_name"));
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String[] categoryNames = new String[category.size()];
        for (int i = 0; i < category.size(); i++) {
            categoryNames[i] = category.get(i);
        }
        return categoryNames;
    }
    
    
    
    
//    public static void main(String[] args) {
//        CategoryModel cm=new CategoryModel();
//        System.out.println(cm.getCategoryName("1"));
//    }
    
}
