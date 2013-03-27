package com.demo1.thread.active;

public class RealResult extends Result {
    private String result;
    
    public RealResult(String result) {
        this.result = result;
    }
    
    @Override

    public Object getResult() {
        return this.result;
    }

}
