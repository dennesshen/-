/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ocp.countdowntimer;

/**
 *
 * @author dennesshen
 */
public class CaculatorGoal {
    public  boolean ifRun = false;

    private int goalnumbers;

   

    public int getGoalnumbers() {
        return goalnumbers;
    }
    
    public void setGoalnumbers(int goalnumbers) {
        this.goalnumbers = goalnumbers;
    }
    
    public void buttonSetGoalnumbers(int goalnumbers) {
        this.goalnumbers = this.goalnumbers+goalnumbers;
    }

    
    
    
}
