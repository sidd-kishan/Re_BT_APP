/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.camera.core;

import android.os.Build;
import android.util.Log;

public final class Logger {
    static final int DEFAULT_MIN_LOG_LEVEL = 3;
    private static final int MAX_TAG_LENGTH = 23;
    private static int sMinLogLevel = 3;

    private Logger() {
    }

    public static void d(String string, String string2) {
        Logger.d(string, string2, null);
    }

    public static void d(String string, String string2, Throwable throwable) {
        if (!Logger.isDebugEnabled(string)) return;
        Log.d((String)Logger.truncateTag(string), (String)string2, (Throwable)throwable);
    }

    public static void e(String string, String string2) {
        Logger.e(string, string2, null);
    }

    public static void e(String string, String string2, Throwable throwable) {
        if (!Logger.isErrorEnabled(string)) return;
        Log.e((String)Logger.truncateTag(string), (String)string2, (Throwable)throwable);
    }

    public static void i(String string, String string2) {
        Logger.i(string, string2, null);
    }

    public static void i(String string, String string2, Throwable throwable) {
        if (!Logger.isInfoEnabled(string)) return;
        Log.i((String)Logger.truncateTag(string), (String)string2, (Throwable)throwable);
    }

    public static boolean isDebugEnabled(String string) {
        boolean bl = sMinLogLevel <= 3 || Log.isLoggable((String)Logger.truncateTag(string), (int)3);
        return bl;
    }

    public static boolean isErrorEnabled(String string) {
        boolean bl = sMinLogLevel <= 6 || Log.isLoggable((String)Logger.truncateTag(string), (int)6);
        return bl;
    }

    public static boolean isInfoEnabled(String string) {
        boolean bl = sMinLogLevel <= 4 || Log.isLoggable((String)Logger.truncateTag(string), (int)4);
        return bl;
    }

    public static boolean isWarnEnabled(String string) {
        boolean bl = sMinLogLevel <= 5 || Log.isLoggable((String)Logger.truncateTag(string), (int)5);
        return bl;
    }

    static void resetMinLogLevel() {
        sMinLogLevel = 3;
    }

    static void setMinLogLevel(int n) {
        sMinLogLevel = n;
    }

    private static String truncateTag(String string) {
        String string2 = string;
        if (23 >= string.length()) return string2;
        string2 = string;
        if (Build.VERSION.SDK_INT >= 24) return string2;
        string2 = string.substring(0, 23);
        return string2;
    }

    public static void w(String string, String string2) {
        Logger.w(string, string2, null);
    }

    public static void w(String string, String string2, Throwable throwable) {
        if (!Logger.isWarnEnabled(string)) return;
        Log.w((String)Logger.truncateTag(string), (String)string2, (Throwable)throwable);
    }
}
