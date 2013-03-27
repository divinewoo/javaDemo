package com.demo1.thread.active;

public class DisplayStringRequest extends Request {
    private String name;

    public DisplayStringRequest(ActiveObject activeObject, String name) {
        super(activeObject, null);
        this.name = name;
    }

    public void execute() {
        this.servant.displayString(name);
    }
}
