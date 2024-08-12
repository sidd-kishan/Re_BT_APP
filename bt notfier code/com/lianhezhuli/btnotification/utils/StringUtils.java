/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

public class StringUtils {
    private static final char[] DIGITS_UPPER;
    public static SimpleDateFormat HH_MM;
    public static SimpleDateFormat yyyy_MM_dd;
    public static SimpleDateFormat yyyy_MM_dd_HH;
    public static SimpleDateFormat yyyy_M_d;

    static {
        yyyy_MM_dd_HH = new SimpleDateFormat("yyyy-MM-dd HH");
        yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
        yyyy_M_d = new SimpleDateFormat("yyyy-M-d");
        HH_MM = new SimpleDateFormat("HH:mm");
        DIGITS_UPPER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    private static char[] encodeHex(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        int n = byArray.length;
        char[] cArray = new char[n << 1];
        int n2 = 0;
        int n3 = 0;
        while (n2 < n) {
            int n4 = n3 + 1;
            char[] cArray2 = DIGITS_UPPER;
            cArray[n3] = cArray2[(byArray[n2] & 0xF0) >>> 4];
            n3 = n4 + 1;
            cArray[n4] = cArray2[byArray[n2] & 0xF];
            ++n2;
        }
        return cArray;
    }

    public static String formatStr(String string, Object ... objectArray) {
        return String.format(Locale.ENGLISH, string, objectArray);
    }

    public static String getRandomNum() {
        return String.valueOf(new Random().nextInt(1000000) + 10000);
    }

    public static String hexStringToByte(int n) {
        return Integer.toBinaryString(n);
    }

    public static String md5Encode32(String string) {
        return StringUtils.md5Encode32(string.getBytes());
    }

    public static String md5Encode32(byte[] byArray) {
        try {
            byArray = MessageDigest.getInstance("MD5").digest(byArray);
            return new String(StringUtils.encodeHex(byArray));
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException("NoSuchAlgorithmException", noSuchAlgorithmException);
        }
    }
}
