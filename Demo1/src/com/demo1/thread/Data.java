package com.demo1.thread;

public class Data {
    private char[] content;
    private ReadWriteLock readWriteLock;
    
    public Data(int size, ReadWriteLock readWriteLock) {
        this.readWriteLock = readWriteLock;
        this.content = new char[size];
        for (int i = 0; i < size; i++) {
            this.content[i] = '*';
        }
    }
    
    public char[] readContent() throws InterruptedException {
        this.readWriteLock.readLock();
        
        try {
           return this.doRead();
        } finally {
            this.readWriteLock.readUnlock();
        }
    }
    
    public void writeContent(char c) throws InterruptedException {
        this.readWriteLock.writeLock();
        try {
            this.doWrite(c);
        } finally {
            this.readWriteLock.writeUnlock();
        }
    }
    
    private char[] doRead() {
        char[] temps = new char[this.content.length];
        for(int i = 0 ; i < temps.length; i++) {
            temps[i] = this.content[i];
        }
        return temps;
    }
    
    private void doWrite(char c) {
        for(int i = 0; i < this.content.length; i++) {
            this.content[i] = c;
        }
    }

}
