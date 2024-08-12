/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.tools.ValueOf
 */
package com.luck.picture.lib.tools;

import com.luck.picture.lib.tools.ValueOf;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    private static final SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public static String cdTime(long l, long l2) {
        CharSequence charSequence;
        if ((l = l2 - l) > 1000L) {
            charSequence = new StringBuilder();
            charSequence.append(l / 1000L);
            charSequence.append("\u79d2");
            charSequence = charSequence.toString();
        } else {
            charSequence = new StringBuilder();
            charSequence.append(l);
            charSequence.append("\u6beb\u79d2");
            charSequence = charSequence.toString();
        }
        return charSequence;
    }

    public static int dateDiffer(long l) {
        try {
            l = Math.abs(DateUtils.getCurrentTimeMillis() - l);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return -1;
        }
        return (int)l;
    }

    public static String formatDurationTime(long l) {
        return String.format(Locale.getDefault(), "%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(l), TimeUnit.MILLISECONDS.toSeconds(l) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
    }

    public static String getCreateFileName() {
        long l = System.currentTimeMillis();
        return sf.format(l);
    }

    public static String getCreateFileName(String string) {
        long l = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(sf.format(l));
        return stringBuilder.toString();
    }

    public static long getCurrentTimeMillis() {
        String string;
        String string2 = string = ValueOf.toString((Object)System.currentTimeMillis());
        if (string.length() <= 10) return ValueOf.toLong((Object)string2);
        string2 = string.substring(0, 10);
        return ValueOf.toLong((Object)string2);
    }
}
