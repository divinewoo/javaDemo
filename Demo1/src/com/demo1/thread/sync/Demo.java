package com.demo1.thread.sync;

public class Demo {
    public static void main(String[] args) {
        MyObj obj = new MyObj();

        new MyThread(obj, 1).start();
        new MyThread(obj, 2).start();
    }
}

class MyThread extends Thread {
    private MyObj obj;
    private int count;

    public MyThread(MyObj obj, int count) {
        this.obj = obj;
        this.count = count;
    }

    public void run() {
        if (this.count == 1) {
            this.obj.sayYes();
        } else {
            this.obj.sayHi();
        }

    }
}
