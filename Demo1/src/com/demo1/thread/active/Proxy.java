package com.demo1.thread.active;

public class Proxy implements ActiveObject {
    private RequestOperatorThread rot;
    private ActiveObject activeObject;
    
    public Proxy(RequestOperatorThread rot, ActiveObject activeObject) {
        this.rot = rot;
        this.activeObject = activeObject;
    }
    
    @Override
    public void displayString(String name) {
        this.rot.addRequest(new DisplayStringRequest(this.activeObject, name));
    }

    @Override
    public Result makeString(char c, int count) {
        FutureResult result = new FutureResult();
        this.rot.addRequest(new MakeStringRequest(this.activeObject, c, count, result));
        return result;
    }

}
