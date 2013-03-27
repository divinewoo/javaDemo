package com.demo1.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils {
    public static MessageDigest getMD5Digest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("MD5");
    }

    public static MessageDigest getSHADigest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA");
    }

    public static byte[] getMD5(byte[] data) throws NoSuchAlgorithmException {
        return getMD5Digest().digest(data);
    }

    public static byte[] getMD5String(String data) throws NoSuchAlgorithmException {
        return getMD5(data.getBytes());
    }

    public static char[] getMD5Chars(String data) throws NoSuchAlgorithmException {
        return HexUtils.encodeHex(getMD5String(data));
    }

    public static byte[] getSHA(byte[] data) throws NoSuchAlgorithmException {
        return getSHADigest().digest(data);
    }

    public static byte[] getSHAString(String data) throws NoSuchAlgorithmException {
        return getSHA(data.getBytes());
    }

    public static char[] getSHAChars(String data) throws NoSuchAlgorithmException {
        return HexUtils.encodeHex(getSHAString(data));
    }
}
