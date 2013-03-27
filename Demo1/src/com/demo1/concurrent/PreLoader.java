package com.demo1.concurrent;

import java.sql.Date;
import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class PreLoader {
    private final FutureTask<String> future = new FutureTask<String>(new Callable<String>(){
        public String call() {
            return getName();
        }
        
        private String getName() {
            System.out.println("[Get Info Thread]: begin,,,," );
            try {
                Thread.sleep(3000);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "wusl";
        }
    });
    
    public static void main(String[] args) {
        PreLoader preLoader = new PreLoader();
        
        new Thread(preLoader.future).start();
        
        System.out.println("[Main Thread:]: start,,," + Calendar.getInstance().getTime());
        try {
            String name = preLoader.future.get();
            System.out.println("[Main Thread]: getValue--" + name);
            System.out.println("[Main Thread]: end,,," + Calendar.getInstance().getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
