package com.demo1.thread;

public class InterruptedDemo {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
                // while(true) {
                try {
                    System.out.println("[Begin]State:=" + this.isInterrupted());
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println("[catch Exception]State:=" + this.isInterrupted());
                }
                // }
            }
        };

        thread.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        thread.interrupt();
    }
}
