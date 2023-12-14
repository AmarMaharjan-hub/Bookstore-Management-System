/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author DELL
 */
public class Database {
    private Connection con=null;
    private String url="jdbc:mysql://localhost:3306/book_store";
    private String user="root";
    private String password="";
//    private Statement stmt=null;
//    private PreparedStatement pstmt=null;
    //database conneciton
    public Database() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, user, password);
            if(con==null){
                con.close();
                System.exit(0);
            }else{
                //statements
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't connect to database ! ! !");
            System.exit(0);
        }
    }
    
    public Connection getConnection(){
        return con;
    }
    
    public void closeConnecion(){
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
