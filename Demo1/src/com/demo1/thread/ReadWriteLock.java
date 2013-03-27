package com.demo1.thread;

public class ReadWriteLock {
    private int readingReaders = 0;
    private int waitingWriters = 0;
    private int writingWriters = 0;
    private boolean preferWriter = true;
    
    public synchronized void readLock() throws InterruptedException {
        while(this.writingWriters > 0 || (this.preferWriter && this.waitingWriters > 0)) {
            wait();
        }
        this.readingReaders++;
    }
    
    public synchronized void readUnlock() {
        this.readingReaders--;
        this.preferWriter = true;
        notifyAll();
    }
    
    public synchronized void writeLock() throws InterruptedException {
        this.waitingWriters++;
        try {
            while(this.writingWriters > 0 || this.readingReaders > 0) {
                wait();
            }
            
        } finally {
            this.waitingWriters--;
        }
        
        this.writingWriters++;
    }
    
    public synchronized void writeUnlock() {
        this.writingWriters--;
        this.preferWriter = false;
        notifyAll();
    }
}
