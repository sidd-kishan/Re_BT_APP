/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Logger$LogcatLogger
 */
package androidx.work;

import androidx.work.Logger;

public abstract class Logger {
    private static final int MAX_PREFIXED_TAG_LENGTH = 20;
    private static final int MAX_TAG_LENGTH = 23;
    private static final String TAG_PREFIX = "WM-";
    private static Logger sLogger;

    public Logger(int n) {
    }

    public static Logger get() {
        synchronized (Logger.class) {
            Object object;
            if (sLogger == null) {
                object = new LogcatLogger(3);
                sLogger = object;
            }
            object = sLogger;
            return object;
        }
    }

    public static void setLogger(Logger logger) {
        synchronized (Logger.class) {
            sLogger = logger;
            return;
        }
    }

    public static String tagWithPrefix(String string) {
        int n = string.length();
        StringBuilder stringBuilder = new StringBuilder(23);
        stringBuilder.append(TAG_PREFIX);
        int n2 = MAX_PREFIXED_TAG_LENGTH;
        if (n >= n2) {
            stringBuilder.append(string.substring(0, n2));
        } else {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public abstract void debug(String var1, String var2, Throwable ... var3);

    public abstract void error(String var1, String var2, Throwable ... var3);

    public abstract void info(String var1, String var2, Throwable ... var3);

    public abstract void verbose(String var1, String var2, Throwable ... var3);

    public abstract void warning(String var1, String var2, Throwable ... var3);
}
