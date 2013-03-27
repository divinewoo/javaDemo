package com.demo1.digest;

public class Demo {
    public static void main(String[] args) {
        String hello1 = "Hello, wusl";
        String hello2 = "Hello wusl";
        
        try {
            char[] cs = DigestUtils.getSHAChars(hello1);
            System.out.println("hello1= '" + new String(cs) + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            char[] cs2 = DigestUtils.getSHAChars(hello2);
            System.out.println("hello2= '" + new String(cs2) + "'");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
