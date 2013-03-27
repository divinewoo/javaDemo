package com.demo1.thread.active;

public class MakeStringRequest extends Request {
    private char c;
    private int count;

    public MakeStringRequest(ActiveObject activeObject, char c, int count, FutureResult result) {
        super(activeObject, result);
        this.c = c;
        this.count = count;
    }

    public void execute() {
        Result result = this.servant.makeString(this.c, this.count);
        this.result.setResult(result);
    }
}
