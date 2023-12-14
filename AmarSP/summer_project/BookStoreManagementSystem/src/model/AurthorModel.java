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
public class AurthorModel {
    Statement stmt;
    ResultSet rs;
    
    
    int id;
    
    public int getAurthorId(String aurName){
        
        
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
            String query="select aurthor_id from aurthor where aurthor_name='"+aurName+"'";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            if(rs.next()){
                id=rs.getInt("aurthor_id");
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
    
    
    public String[] getAurthorNames(){
        ArrayList<String> aurthor=new ArrayList<String>();
        try {
            Database db=new Database();
            Connection con=db.getConnection();
            
            String query="select aurthor_name from aurthor";
            
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()){
               aurthor.add(rs.getString("aurthor_name"));
            }
            
            rs.close();
            stmt.close();
            con.close();
            db.closeConnecion();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String[] aurthorNames = new String[aurthor.size()];
        for (int i = 0; i < aurthor.size(); i++) {
            aurthorNames[i] = aurthor.get(i);
        }
        return aurthorNames;
    }
}
