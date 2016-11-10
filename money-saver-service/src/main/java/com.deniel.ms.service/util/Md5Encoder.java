package com.deniel.ms.service.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by DenielNote on 09.11.2016.
 */
public class Md5Encoder {
    public static String md5Custom(String st) {
        MessageDigest messageDigest;
        byte[] digest = new byte[0];
        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        while (md5Hex.length() < 32) {
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }
}
