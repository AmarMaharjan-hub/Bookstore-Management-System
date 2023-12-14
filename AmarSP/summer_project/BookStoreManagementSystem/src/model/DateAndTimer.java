/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

/**
 *
 * @author DELL
 */
public class DateAndTimer {
    
   private LocalDate date;
   private LocalTime time;
   private SimpleDateFormat formatter;
   
   
   
   public LocalDate getCurDate(){
       formatter= new SimpleDateFormat("yyy/MM/dd");
       
       date=LocalDate.now(); 
       
       return date;
   }
   
   public LocalTime getCurTime(){
       formatter= new SimpleDateFormat("HH:mm:ss");
       
       time=LocalTime.now();
       
       return time;
   }
   
   
   public int getCurMonth(){
       
       date = LocalDate.now();
       int month = date.getMonthValue();
       
       return month;

   }
   
   public int getCurYear(){
       
//       date = LocalDate.now();
//       int year = date.getYearValue();
//       
//       return year;

        int year = Calendar.getInstance().get(Calendar.YEAR);
        
        return year;

   }
   
   
    public static void main(String[] args) {
        DateAndTimer d1=new DateAndTimer();
//        System.out.println(d1.getCurDate());
//        System.out.println(d1.getCurMonth());
//        System.out.println(d1.getCurYear());


        System.out.println(d1.getCurTime());
    }
    
}
