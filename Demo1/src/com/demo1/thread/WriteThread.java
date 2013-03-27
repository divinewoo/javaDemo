package com.demo1.thread;

public class WriteThread extends Thread {
    private Data data;
    private String seed;
    private int index = 0;
    
    public WriteThread(Data data, String seed) {
        this.data = data;
        this.seed = seed;
    }
    
    public void run() {
        while(true) {
            this.writeInfo();
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void writeInfo() {
        char c = this.seed.charAt(getIndex());
        try {
            this.data.writeContent(c);
            System.out.println("Write-Thread[" + this.getId() + "] is writing '" + c + "'" );
        } catch (Exception e) {
            System.out.println("Write-Thread[" + this.getId() + "] is writing failed.");
        }
    }
    
    private int getIndex() {
        int temp = index++;
        
        if(index / this.seed.length() >= 1) {
            index = index % this.seed.length();
        }
        
        return temp;
    }
    
    
    
    
}
