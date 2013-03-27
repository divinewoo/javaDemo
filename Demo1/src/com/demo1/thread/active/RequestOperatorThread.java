package com.demo1.thread.active;

public class RequestOperatorThread extends Thread {
    private RequestQueue queue;

    public RequestOperatorThread(RequestQueue queue) {
        this.queue = queue;
    }
    
    public void addRequest(Request request) {
        this.queue.setQueue(request);
    }

    public void run() {
        while (true) {
            Request request = this.queue.getQueue();
            request.execute();
        }
    }
}
