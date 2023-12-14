/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class BillModel {
    Statement stmt;
    ResultSet rs;
 
    
    
    public void insertBill(String bid, String uid,String date,String customer){
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="insert into bill values('"+bid+"','"+uid+"','"+date+"','"+customer+"')";
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
            String query="select bill_no from bill order by bill_no desc limit 1";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               id=rs.getInt("bill_no");
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
