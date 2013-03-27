package com.demo1.thread.active;

public class MakerThread extends Thread {
    private String name;
    private ActiveObject activeObject;

    public MakerThread(String name, ActiveObject activeObject) {
        this.name = name;
        this.activeObject = activeObject;
    }

    public void run() {
        try {
            for (int i = 0; true; i++) {
                Result result = this.activeObject.makeString(name.charAt(0), i);
                Thread.sleep(500);
                System.out.println("Thread[ " + this.name + " ]: " + (String)result.getResult());
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
