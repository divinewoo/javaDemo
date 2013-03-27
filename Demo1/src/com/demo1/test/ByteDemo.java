package com.demo1.test;


public class ByteDemo {
	public static void main(String[] args) {
		String name = "10005";
		byte[] nameArr = name.getBytes();
		
		byte[] test = new byte[10];

		System.arraycopy(nameArr, 0, test, 0, 5);
		
		for(int i = 0; i < test.length; i++) {
			if(test[i] <= 0) {
                break;
            }
            
			System.out.println((char)test[i]);
		}
	}
}
