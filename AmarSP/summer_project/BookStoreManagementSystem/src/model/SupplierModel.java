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
public class SupplierModel {
    
    private Statement stmt=null;
    private ResultSet rs=null;
    
    
    
    public ArrayList<String[]> getSupplierList(){
        ArrayList<String[]> suppliers=new ArrayList<String[]>();
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
            String query="select * from supplier";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               String str[]={""+rs.getInt("supplier_id"),rs.getString("supplier_name"),rs.getString("supplier_address"),rs.getString("supplier_phone")};
               suppliers.add(str);
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suppliers;
    }
    
    public String[] getSupplierNames(){
        ArrayList<String> suppliers=new ArrayList<String>();
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
            String query="select supplier_name from supplier";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               suppliers.add(rs.getString("supplier_name"));
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String[] supplierNames = new String[suppliers.size()];
        for (int i = 0; i < suppliers.size(); i++) {
            supplierNames[i] = suppliers.get(i);
        }
        return supplierNames;
    }
    
    
    public void setData(String id, String name, String address, String phone){
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="insert into supplier values("+id+",'"+name+"','"+address+"','"+phone+"')";
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
    
    
    public void updateData(String id, String name, String address, String phone){
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="update supplier set supplier_name='"+name+"',supplier_address='"+address+"', supplier_phone='"+phone+"' where supplier_id='"+id+"'";
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
            String query="delete from supplier where supplier_id='"+id+"'";
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
    
    
    public int getSupplierId(String supName){
        int id=-1;
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
            String query="select supplier_id from supplier where supplier_name='"+supName+"'";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            if(rs.next()){
                id=rs.getInt("supplier_id");
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
    
    
    
    public int getLastID(){
        int id=0;
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="select supplier_id from supplier order by supplier_id desc limit 1";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               id=rs.getInt("supplier_id");
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
    
    
    public int checkName(String name){
        
        int num=0;
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
           
            
            
            String query=" select count(supplier_name) as count from supplier where supplier_name='"+name+"'";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               
               
               if(rs.getLong("count")==0){
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
            
           
            
            
            String query=" select count(supplier_phone) as count from supplier where supplier_phone='"+contact+"'";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               
               
               if(rs.getLong("count")==0){
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
    
    
    
    
    
    
    public static void main(String[] args) {
        
        
        
        
        
//        SupplierModel s=new SupplierModel();
//        ArrayList<String[]> arr= s.getSupplierList();
//        
//        for(String[] u: arr){
//            for(String elem: u){
//                System.out.println(elem);
//            }
//        }
////        s.setData(""+s.getLastID(), "supA", "Teku", "9090909090");
//        
//        int count=0;
//        
//        for(String[] i:arr){
//            for(String j:i){
//                count++;
//            }
//            break;
//        }
//        
//        System.out.println(arr.size()+"  "+count);
    }
    
}
