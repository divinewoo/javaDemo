package com.demo1.threadlocal;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<Integer> tl = new ThreadLocal<Integer>(){
            @Override
            public Integer initialValue() {
                return 0;
            }
        };
        for(int i = 1; i <= 10; i++) {
            ReadThread rt = new ReadThread(i, tl);
            rt.start();
        }
        
        System.out.println("=====" + tl.get());
    }


}

class ReadThread extends Thread {
    public ThreadLocal<Integer> counters;
    
    public ReadThread(Integer name, ThreadLocal<Integer> counters) {
        super(String.valueOf(name));
        this.counters = counters;
        int initValue = this.counters.get() + name;
        System.out.println("ThreadID[" + this.getName() + "]≥ı º÷µ: " + initValue);
    }
    
    public void run() {
        this.counters.set(Integer.parseInt(this.getName()));
        while (true) {
            int currentValue = this.counters.get();
            System.out.println("ThreadID[" + this.getName() + "]: " + currentValue);
            this.counters.set(++currentValue);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}