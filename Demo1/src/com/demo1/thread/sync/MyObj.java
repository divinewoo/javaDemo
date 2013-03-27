package com.demo1.thread.sync;

public class MyObj {
    public synchronized void sayYes() {
        System.out.println("Yes, man");
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public synchronized void sayHi() {
        System.out.println("Hi, Man");
        try {
            Thread.sleep(400000);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
