package com.demo1.thread.active;

public class Servant implements ActiveObject {
    
    @Override
    public void displayString(String name) {
        System.out.println("display: [ " + name + " ]");
    }

    @Override
    public Result makeString(char c, int count) {
        StringBuffer sb = new StringBuffer();
        while(count > 0) {
            sb.append(c);
            count--;
        }
        return new RealResult(sb.toString());
    }

}
