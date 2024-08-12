/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class PreJava9DateFormatProvider {
    private static String getDateFormatPattern(int n) {
        if (n == 0) return "EEEE, MMMM d, y";
        if (n == 1) return "MMMM d, y";
        if (n == 2) return "MMM d, y";
        if (n == 3) {
            return "M/d/yy";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown DateFormat style: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static String getDatePartOfDateTimePattern(int n) {
        if (n == 0) return "EEEE, MMMM d, yyyy";
        if (n == 1) return "MMMM d, yyyy";
        if (n == 2) return "MMM d, yyyy";
        if (n == 3) {
            return "M/d/yy";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown DateFormat style: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static String getTimePartOfDateTimePattern(int n) {
        if (n == 0) return "h:mm:ss a z";
        if (n == 1) return "h:mm:ss a z";
        if (n == 2) return "h:mm:ss a";
        if (n == 3) {
            return "h:mm a";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown DateFormat style: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static DateFormat getUSDateFormat(int n) {
        return new SimpleDateFormat(PreJava9DateFormatProvider.getDateFormatPattern(n), Locale.US);
    }

    public static DateFormat getUSDateTimeFormat(int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PreJava9DateFormatProvider.getDatePartOfDateTimePattern(n));
        stringBuilder.append(" ");
        stringBuilder.append(PreJava9DateFormatProvider.getTimePartOfDateTimePattern(n2));
        return new SimpleDateFormat(stringBuilder.toString(), Locale.US);
    }
}
