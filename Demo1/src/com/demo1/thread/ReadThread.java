package com.demo1.thread;

public class ReadThread extends Thread{
    private Data data;
    
    public ReadThread(Data data) {
        this.data = data;
    }
    
    public void run() {
        while(true) {
            this.getInfo();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void getInfo() {
        try {
            System.out.println("Read-Thread[" + this.getId() + "], getInfo: " + String.valueOf(this.data.readContent()));
        } catch (InterruptedException e) {
            System.out.println("Read-Thread[" + this.getId() + "] is interrupted.");
        }
    }
}
