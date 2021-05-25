/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ocp.countdowntimer;

import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author dennesshen
 */
class CountDownThread implements Runnable {

    private long startTime;
    private long endtime;
    private Util util;
    private CaculatorGoal cg;
    private javax.swing.JTextArea jTextArea;
    private ScheduledExecutorService service;
    private String show;
    private int checkNumber;

    public CountDownThread(long startTime, Util util, CaculatorGoal cg, javax.swing.JTextArea jTextArea,ScheduledExecutorService service) {
        this.startTime = startTime;
        this.util = util;
        this.cg = cg;
        this.jTextArea = jTextArea;
        this.service = service;
    }

    public int getCheckNumber() {
        return checkNumber = 1;
    }

    public String getShow() {
        return show;
    }

    @Override
    public void run() {
        endtime = System.currentTimeMillis();

        int diff = (int) ((endtime - startTime) / 1000);
        //System.out.println(diff);
        int minutesReduce = diff / 60;
        int secondsReduce = diff % 60;
        int minutesShow = util.getMinutes();
        int secondsShow = util.getSeconds();
        if (secondsShow == 0) {
            minutesShow--;
            secondsShow = 60;
        }
        minutesShow = minutesShow - minutesReduce;
        secondsShow = secondsShow - secondsReduce;
        if (secondsShow == 60) {
            minutesShow++;
            secondsShow = 00;
        }
        //System.out.println(minutesShow);
        //System.out.println(secondsShow);

        checkNumber = cg.getGoalnumbers() - diff;
        if (checkNumber > 0) {
            show = String.format("剩餘時間  %02d ： %02d", minutesShow, secondsShow);
        } else {
            show = String.format("剩餘時間  00 ： 00\n倒數計時結束，請按Reset!");
            checkNumber = 0;
            service.shutdown();
            //System.out.println(service.isShutdown());
        }
        jTextArea.setText(show);


    }

}
