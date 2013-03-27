package com.demo1.thread;

public class Demo {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReadWriteLock();
        Data data = new Data(12, readWriteLock);

        for (int i = 0; i < 5; i++) {
            ReadThread readThread = new ReadThread(data);
            readThread.start();
        }

        new WriteThread(data, "abcdefghijklmn").start();
        new WriteThread(data, "ABCDEFGHIJKLMN").start();
    }
}
