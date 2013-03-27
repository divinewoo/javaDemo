package com.demo1.transform;

public class Demo {
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString((-15) & 0xff));
		System.out.println(Integer.toHexString((-15) & 0xff));
		
		System.out.println("===================");
		
		float xiaoshu = 0.76f;
		int zhengshu = 42949672;
		System.out.println(Float.toHexString(xiaoshu));
		System.out.println(Integer.toBinaryString(zhengshu));
		float xxx = 42949672.76f;
		System.out.println(Float.toHexString(xxx));
		
		System.out.println("=====================");
		
		Long money = 4294967276l;
		System.out.println(Long.toHexString(money));
		System.out.println(Long.toBinaryString(money));
		
		System.out.println("===================");
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		
		System.out.println("====================");
		System.out.println(Util.str2hex("жа".getBytes()));
		
		
		
	}
}
