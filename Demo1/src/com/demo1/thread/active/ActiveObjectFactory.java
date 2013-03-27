package com.demo1.thread.active;

public class ActiveObjectFactory {
    public static ActiveObject getActiveObject() {
        RequestQueue queue = new RequestQueue();
        Servant servant = new Servant();
        
        RequestOperatorThread thread = new RequestOperatorThread(queue);
        Proxy proxy = new Proxy(thread, servant);
        thread.start();
        
        return proxy;
    }
}
