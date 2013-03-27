package com.demo1.transform;

public class Util {
	public static byte[] int2byte(int origin) {
		byte[] bytes = new byte[4];
		for (int i = 0; i < 4; i++) {
			bytes[3 - i] = (byte) (origin >>> (i * 8));
		}
		return bytes;
	}
	
	public static String str2hex(byte[] bytes) {
	    StringBuilder sb = new StringBuilder();
	    
	    String tmp = null;
	    for(int i = 0; i < bytes.length; i++) {
	        byte byte_tmp = bytes[i];
	        
	        tmp = Integer.toHexString((byte_tmp >>> 4) & 0x0f);
	        sb.append(tmp);
	        tmp = Integer.toHexString(byte_tmp & 0x0f);
	        sb.append(tmp);
	        
	    }
	    
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		byte[] xx = int2byte(3);
		for(int i = 0; i < xx.length; i++) {
			System.out.println(xx[i]);
		}
	}
}
