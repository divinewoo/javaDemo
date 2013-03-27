package com.demo1.concurrent;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {

    }

    class Pool<T> {
        private final Set<T> dbConnSet;
        private final Semaphore sem;

        public Pool(int size) {
           this.dbConnSet = new ConcurrentSkipListSet<T>();
           this.sem = new Semaphore(size);
        }
        
        public boolean add(T o) throws InterruptedException{
            sem.acquire();
            boolean isAdded = false;
            try {
                isAdded = dbConnSet.add(o);
            } finally {
                if(!isAdded) {
                    sem.release();
                }
            }
            return isAdded;
        }
        
        public boolean delete(T o) {
            boolean isDeleted = false;
            isDeleted = dbConnSet.remove(o);
            if(isDeleted) {
                sem.release();
            }
            return isDeleted;
        }
    }

}
