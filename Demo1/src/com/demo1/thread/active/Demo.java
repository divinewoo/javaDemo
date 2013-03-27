package com.demo1.thread.active;

public class Demo {
    public static void main(String[] args) {
        ActiveObject proxy = ActiveObjectFactory.getActiveObject();
        
        new MakerThread("Apple", proxy).start();
        new MakerThread("Banana", proxy).start();
        new DisplayThread("Cherry", proxy).start();
    }
}
