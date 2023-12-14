/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class WhiteSpaceTest {
    String p="Particular                                     ";
    String q="Qty         ";
    String r="Rate       ";
    String a="Qty        ";
    String str1="Particular";
    String str2="Qty";
    int tlen=47;
    
    public WhiteSpaceTest(){
        System.out.println(p.length());
        System.out.println(q.length());
        System.out.println(r.length());
        
        System.out.println("Mad Country\t\t1".length());
        System.out.println("Mad Country\t\t1");
        
        
        
//        System.out.println(str1+ws(str1.length()));
//        System.out.println(str2+ws(str2.length()));
    
    }
    
    public String ws(int len){
        String s="";
        int sp=tlen-len;
        
        for(int i=0;i<sp;i++){
            s=s+"-";
        }
        
//        System.out.println(s);
        return s;
    }
    
    public static void main(String[] args) {
       new WhiteSpaceTest(); 
        
    }
}
