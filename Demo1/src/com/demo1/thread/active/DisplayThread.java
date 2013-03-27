package com.demo1.thread.active;

public class DisplayThread extends Thread {
    private String name;
    private ActiveObject activeObject;
    
    public DisplayThread(String name, ActiveObject activeObject) {
        this.name = name;
        this.activeObject = activeObject;
    }
    
    public void run() {
        for(int i = 0; true; i++) {
            String desc = this.name + ", count : " + i;
            
            this.activeObject.displayString(desc);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
