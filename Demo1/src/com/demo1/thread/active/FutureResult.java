package com.demo1.thread.active;

public class FutureResult extends Result {
    private Result realResult;
    private boolean hasGot = false;
    
    public synchronized void setResult(Result result) {
        this.realResult = result;
        this.hasGot = true;
        notifyAll();
    }
    @Override
    public synchronized Object getResult() {
        while(!hasGot) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.realResult.getResult();
    }

}
