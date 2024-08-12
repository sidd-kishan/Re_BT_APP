/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.util;

public class Hex {
    private static final char[] zza = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] zzb = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String bytesToStringLowercase(byte[] byArray) {
        int n = byArray.length;
        char[] cArray = new char[n + n];
        n = 0;
        int n2 = 0;
        while (n < byArray.length) {
            int n3 = byArray[n] & 0xFF;
            int n4 = n2 + 1;
            char[] cArray2 = zzb;
            cArray[n2] = cArray2[n3 >>> 4];
            n2 = n4 + 1;
            cArray[n4] = cArray2[n3 & 0xF];
            ++n;
        }
        return new String(cArray);
    }

    public static String bytesToStringUppercase(byte[] byArray) {
        return Hex.bytesToStringUppercase(byArray, false);
    }

    public static String bytesToStringUppercase(byte[] byArray, boolean bl) {
        int n = byArray.length;
        StringBuilder stringBuilder = new StringBuilder(n + n);
        int n2 = 0;
        while (n2 < n) {
            if (bl && n2 == n - 1) {
                if ((byArray[n2] & 0xFF) == 0) return stringBuilder.toString();
            }
            stringBuilder.append(zza[(byArray[n2] & 0xF0) >>> 4]);
            stringBuilder.append(zza[byArray[n2] & 0xF]);
            ++n2;
        }
        return stringBuilder.toString();
    }

    public static byte[] stringToBytes(String object) throws IllegalArgumentException {
        int n = ((String)object).length();
        if (n % 2 != 0) {
            object = new IllegalArgumentException("Hex string has odd number of characters");
            throw object;
        }
        byte[] byArray = new byte[n / 2];
        int n2 = 0;
        while (n2 < n) {
            int n3 = n2 + 2;
            byArray[n2 / 2] = (byte)Integer.parseInt(((String)object).substring(n2, n3), 16);
            n2 = n3;
        }
        return byArray;
    }
}
