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


public class Util {

    private int minutes;
    private int seconds;

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void changeTimeType(int wholeTime) {
        minutes = wholeTime / 60;
        seconds = wholeTime % 60;
    }

}
