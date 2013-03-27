package com.demo1.thread.active;

public class RequestQueue {
    private static int REQUEST_COUNT = 100;
    private Request[] requests = new Request[REQUEST_COUNT];
    private int count = 0;
    private int head = 0, tail = 0;

    public synchronized void setQueue(Request request) {
        try {
            while (count >= REQUEST_COUNT) {
                wait();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        requests[tail++] = request;
        if (tail >= REQUEST_COUNT) {
            tail = tail % REQUEST_COUNT;
        }
        count++;
        notifyAll();
    }

    public synchronized Request getQueue() {
        try {
            while (count == 0) {
                wait();
            }

        } catch (InterruptedException e) {
        }
        Request request = requests[head++];
        if (head >= REQUEST_COUNT) {
            head = head % REQUEST_COUNT;
        }
        count--;
        notifyAll();
        return request;
    }
}
