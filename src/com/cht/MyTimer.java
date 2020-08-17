package com.cht;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {
    Timer timer = new Timer();
    TimerTask timertask = new TimerTask() {
        @Override
        public void run() {
            System.out.printf("執行時間:%s%n", new Date());
        }
    };

    void test() {
        System.out.printf("執行時間:%s%n", new Date());
        timer.schedule(timertask, 3000, 2000);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("end timer");
    }
}
