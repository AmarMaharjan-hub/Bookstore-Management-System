/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.DashBoardView;

/**
 *
 * @author DELL
 */
public class DashBoardController {
    
    private DashBoardView theView;
    
    
    public DashBoardController(){
        //this.theView=theView;
        
        theView=new DashBoardView();
        theView.setSelected(theView.getDefaultSelectedPanel(), theView.getDefaultSelectedLabel());
    }
    
    
    public static void main(String[] args) {
//        new DashBoardController();
    }
}
