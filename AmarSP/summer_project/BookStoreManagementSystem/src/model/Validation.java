/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Validation {
    
    
    
    
    public int isWhiteSpace(view.DashBoardView dsh, String comp, String str){
    
        int counter=0;
        for( int i=0; i<str.length(); i++ ) {
         if(str.charAt(i) == ' ' ) {
          counter++;
           }
          }
         System.out.println("Number of spaces "+ counter);
         //This will print Number of spaces 4
        
        
        return counter;
    }
    
    
    public boolean onlyNumbers(JPanel panel, String comp, String str){
        
        
        if (str.matches("[0-9]+")){
            // your operations
            return true;
        }else{
            onlyNumbersPop(panel, comp);
            return false;
        }
        
        
//        return true;
    }
    
    
    
    public boolean isNegative(JPanel panel, String comp, String str){
        
        
        if(str.charAt(0)=='-'){
            isNegativePop(panel,comp);
            return true;
            
        }else{
            return false;
        }
        
    
    }
    
    
    public boolean isVoid(JPanel panel, String comp, String str){
        
        if(str.equals("")){
            emptyFieldPop(panel,comp);
            return true;
        }else{
            return false;
        }
        
    }
    
    
    public void emptyFieldPop(JPanel panel, String comp){
        
        String error=comp+" field is empty !!!";
        
        JOptionPane.showMessageDialog(panel, error, "ERROR !", JOptionPane.ERROR_MESSAGE);
    }
    
    public void onlyNumbersPop(JPanel panel, String comp){
        
        String error="Only Numbers allowed in "+comp+" field !!!";
        
        JOptionPane.showMessageDialog(panel, error, "ERROR !", JOptionPane.ERROR_MESSAGE);
    }
    
    public void isNegativePop(JPanel panel, String comp){
        
        String error=comp+" field cannot be in negative value !!!";
        
        JOptionPane.showMessageDialog(panel, error, "ERROR !", JOptionPane.ERROR_MESSAGE);
    }
    
    
    
    public static void main(String[] args) {
        Validation v=new Validation();
        
        
//        v.isVoid(new view.DashBoardView(), "TextField", "");
        
        
        
    }
    
    
    
}
