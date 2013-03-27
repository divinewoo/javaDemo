package com.demo1.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        System.out.println("Thread[" + Thread.currentThread().getId() + "]------");
        timer.schedule(new MyTimerTask("task1"), 1000, 3000);
        timer.schedule(new MyTimerTask("task2"), 2000, 2000);
    }
}

class MyTimerTask extends TimerTask {
    private String name;

    public MyTimerTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread[" + Thread.currentThread().getId() + "]:" + this.name);
    }

}