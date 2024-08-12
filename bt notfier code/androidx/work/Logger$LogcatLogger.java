/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.work.Logger
 */
package androidx.work;

import android.util.Log;
import androidx.work.Logger;

public static class Logger.LogcatLogger
extends Logger {
    private int mLoggingLevel;

    public Logger.LogcatLogger(int n) {
        super(n);
        this.mLoggingLevel = n;
    }

    public void debug(String string, String string2, Throwable ... throwableArray) {
        if (this.mLoggingLevel > 3) return;
        if (throwableArray != null && throwableArray.length >= 1) {
            Log.d((String)string, (String)string2, (Throwable)throwableArray[0]);
        } else {
            Log.d((String)string, (String)string2);
        }
    }

    public void error(String string, String string2, Throwable ... throwableArray) {
        if (this.mLoggingLevel > 6) return;
        if (throwableArray != null && throwableArray.length >= 1) {
            Log.e((String)string, (String)string2, (Throwable)throwableArray[0]);
        } else {
            Log.e((String)string, (String)string2);
        }
    }

    public void info(String string, String string2, Throwable ... throwableArray) {
        if (this.mLoggingLevel > 4) return;
        if (throwableArray != null && throwableArray.length >= 1) {
            Log.i((String)string, (String)string2, (Throwable)throwableArray[0]);
        } else {
            Log.i((String)string, (String)string2);
        }
    }

    public void verbose(String string, String string2, Throwable ... throwableArray) {
        if (this.mLoggingLevel > 2) return;
        if (throwableArray != null && throwableArray.length >= 1) {
            Log.v((String)string, (String)string2, (Throwable)throwableArray[0]);
        } else {
            Log.v((String)string, (String)string2);
        }
    }

    public void warning(String string, String string2, Throwable ... throwableArray) {
        if (this.mLoggingLevel > 5) return;
        if (throwableArray != null && throwableArray.length >= 1) {
            Log.w((String)string, (String)string2, (Throwable)throwableArray[0]);
        } else {
            Log.w((String)string, (String)string2);
        }
    }
}
