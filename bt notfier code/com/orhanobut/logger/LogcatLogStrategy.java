/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.orhanobut.logger.LogStrategy
 *  com.orhanobut.logger.Utils
 */
package com.orhanobut.logger;

import android.util.Log;
import com.orhanobut.logger.LogStrategy;
import com.orhanobut.logger.Utils;

public class LogcatLogStrategy
implements LogStrategy {
    static final String DEFAULT_TAG = "NO_TAG";

    public void log(int n, String string, String string2) {
        Utils.checkNotNull((Object)string2);
        String string3 = string;
        if (string == null) {
            string3 = DEFAULT_TAG;
        }
        Log.println((int)n, (String)string3, (String)string2);
    }
}
