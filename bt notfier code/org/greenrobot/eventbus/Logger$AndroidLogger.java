/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  org.greenrobot.eventbus.Logger
 */
package org.greenrobot.eventbus;

import android.util.Log;
import java.util.logging.Level;
import org.greenrobot.eventbus.Logger;

public static class Logger.AndroidLogger
implements Logger {
    static final boolean ANDROID_LOG_AVAILABLE;
    private final String tag;

    /*
     * Unable to fully structure code
     */
    static {
        var0 = false;
        try {
            var1_1 = Class.forName("android.util.Log");
            if (var1_1 != null) {
                var0 = true;
            }
lbl6:
            // 4 sources

            while (true) {
                Logger.AndroidLogger.ANDROID_LOG_AVAILABLE = var0;
                return;
            }
        }
        catch (ClassNotFoundException var1_2) {
            ** continue;
        }
    }

    public Logger.AndroidLogger(String string) {
        this.tag = string;
    }

    public static boolean isAndroidLogAvailable() {
        return ANDROID_LOG_AVAILABLE;
    }

    public void log(Level level, String string) {
        if (level == Level.OFF) return;
        Log.println((int)this.mapLevel(level), (String)this.tag, (String)string);
    }

    public void log(Level object, String string, Throwable throwable) {
        if (object == Level.OFF) return;
        int n = this.mapLevel((Level)object);
        object = this.tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("\n");
        stringBuilder.append(Log.getStackTraceString((Throwable)throwable));
        Log.println((int)n, (String)object, (String)stringBuilder.toString());
    }

    protected int mapLevel(Level level) {
        int n = level.intValue();
        if (n < 800) {
            if (n >= 500) return 3;
            return 2;
        }
        if (n < 900) {
            return 4;
        }
        if (n >= 1000) return 6;
        return 5;
    }
}
