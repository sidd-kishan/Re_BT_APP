/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package org.greenrobot.greendao;

import android.util.Log;

public class DaoLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final String TAG = "greenDAO";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    public static int d(String string) {
        return Log.d((String)TAG, (String)string);
    }

    public static int d(String string, Throwable throwable) {
        return Log.d((String)TAG, (String)string, (Throwable)throwable);
    }

    public static int e(String string) {
        return Log.w((String)TAG, (String)string);
    }

    public static int e(String string, Throwable throwable) {
        return Log.e((String)TAG, (String)string, (Throwable)throwable);
    }

    public static String getStackTraceString(Throwable throwable) {
        return Log.getStackTraceString((Throwable)throwable);
    }

    public static int i(String string) {
        return Log.i((String)TAG, (String)string);
    }

    public static int i(String string, Throwable throwable) {
        return Log.i((String)TAG, (String)string, (Throwable)throwable);
    }

    public static boolean isLoggable(int n) {
        return Log.isLoggable((String)TAG, (int)n);
    }

    public static int println(int n, String string) {
        return Log.println((int)n, (String)TAG, (String)string);
    }

    public static int v(String string) {
        return Log.v((String)TAG, (String)string);
    }

    public static int v(String string, Throwable throwable) {
        return Log.v((String)TAG, (String)string, (Throwable)throwable);
    }

    public static int w(String string) {
        return Log.w((String)TAG, (String)string);
    }

    public static int w(String string, Throwable throwable) {
        return Log.w((String)TAG, (String)string, (Throwable)throwable);
    }

    public static int w(Throwable throwable) {
        return Log.w((String)TAG, (Throwable)throwable);
    }
}
