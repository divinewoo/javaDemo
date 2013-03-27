package com.demo1.thread.active;

public abstract class Request {
    protected ActiveObject servant;
    protected FutureResult result;
    
    public Request(ActiveObject servant, FutureResult result) {
        this.servant = servant;
        this.result = result;
    }
    
    public abstract void execute();
}
