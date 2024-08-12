/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.util;

public class NumberUtils {
    private NumberUtils() {
    }

    public static long parseHexLong(String string) {
        if (string.length() <= 16) {
            if (string.length() != 16) return Long.parseLong(string, 16);
            long l = Long.parseLong(string.substring(8), 16);
            return Long.parseLong(string.substring(0, 8), 16) << 32 | l;
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 37);
        stringBuilder.append("Invalid input: ");
        stringBuilder.append(string);
        stringBuilder.append(" exceeds 16 characters");
        throw new NumberFormatException(stringBuilder.toString());
    }
}
