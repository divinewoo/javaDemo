package com.demo1.random;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random1 = new Random(12312312l);
        Random random2 = new Random(12312312l);
        for(int i = 0; i < 10; i++) {
            System.out.println("random1 = " + random1.nextInt(20));
            System.out.println("random2 = " + random2.nextInt(20));
        }
    }
}
