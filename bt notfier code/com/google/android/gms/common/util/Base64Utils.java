/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.google.android.gms.common.util;

import android.util.Base64;

public final class Base64Utils {
    public static byte[] decode(String string) {
        if (string != null) return Base64.decode((String)string, (int)0);
        return null;
    }

    public static byte[] decodeUrlSafe(String string) {
        if (string != null) return Base64.decode((String)string, (int)10);
        return null;
    }

    public static byte[] decodeUrlSafeNoPadding(String string) {
        if (string != null) return Base64.decode((String)string, (int)11);
        return null;
    }

    public static String encode(byte[] byArray) {
        if (byArray != null) return Base64.encodeToString((byte[])byArray, (int)0);
        return null;
    }

    public static String encodeUrlSafe(byte[] byArray) {
        if (byArray != null) return Base64.encodeToString((byte[])byArray, (int)10);
        return null;
    }

    public static String encodeUrlSafeNoPadding(byte[] byArray) {
        if (byArray != null) return Base64.encodeToString((byte[])byArray, (int)11);
        return null;
    }
}
