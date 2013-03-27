package com.demo1.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private static int THREAD_SIZE = 2;
    private static int[] arr = new int[3];
    private static CyclicBarrier barrier = new CyclicBarrier(THREAD_SIZE, new Runnable() {
        public void run() {
            arr[2] = arr[0] + arr[1]; 
            System.out.println("Barrier----Total Sum=" + (arr[2]));
            arr[0] = arr[1];
            arr[1] = arr[2];
        }
    });

    public static void testCyclicBarrier() {
        new Worker(barrier, 0, arr).start();
        new Worker(barrier, 1, arr).start();
    }

    static class Worker extends Thread {
        private CyclicBarrier barrier;
        private int ID;
        private int[] arr;

        public Worker(CyclicBarrier barrier, int ID, int[] arr) {
            this.barrier = barrier;
            this.ID = ID;
            this.arr = arr;
        }

        public void run() {
            this.arr[ID] = ID;
            while (true) {
                try {
                    Thread.sleep((ID + 1) * 1000);
                    System.out.println("Thread[" + ID + "] set value= " + arr[ID]);
                    this.barrier.await();
                    System.out.println("Thread[" + ID + "] await end.");
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        testCyclicBarrier();
    }

}
