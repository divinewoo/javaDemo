package com.demo1.digest;

public class HexUtils {
    private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f' };

    private static final char[] DIGITS_UPPER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
            'E', 'F' };

    public static char[] encodeHex(byte[] bytes) {
        return encodeHex(bytes, true);
    }

    public static char[] encodeHex(byte[] bytes, boolean isLower) {
        return encodeHex(bytes, isLower ? DIGITS_LOWER : DIGITS_UPPER);
    }

    public static char[] encodeHex(byte[] bytes, char[] toDigest) {
        int length = bytes.length;
        char[] results = new char[length << 1];
        int k = 0;
        for(int i = 0; i < length; i++) {
            byte data = bytes[i];
            results[k++] = toDigest[(data & 0xf0) >>> 4];
            results[k++] = toDigest[(data & 0x0f)];
        }
        return results;
    }
    
    public static String encodeHexString(byte[] data) {
        return new String(encodeHex(data));
    }

}
