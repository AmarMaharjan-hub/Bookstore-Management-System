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
public class OrgInfoModel {
    
    Statement stmt;
    ResultSet rs;
    
    public String getPanNo(){
        String str="";
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="select pan_no from org limit 1";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               str=rs.getString("pan_no");
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
    
    public String getName(){
        String str="";
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="select name from org limit 1";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               str=rs.getString("name");
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
    
    public String getLocation(){
        String str="";
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="select Location from org limit 1";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               str=rs.getString("Location");
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
    
    public String getContact(){
        String str="";
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            String query="select contact_no from org limit 1";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next()){
               str=rs.getString("contact_no");
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
}
