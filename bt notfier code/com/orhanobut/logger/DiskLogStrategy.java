/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.orhanobut.logger.LogStrategy
 *  com.orhanobut.logger.Utils
 */
package com.orhanobut.logger;

import android.os.Handler;
import com.orhanobut.logger.LogStrategy;
import com.orhanobut.logger.Utils;

public class DiskLogStrategy
implements LogStrategy {
    private final Handler handler;

    public DiskLogStrategy(Handler handler) {
        this.handler = (Handler)Utils.checkNotNull((Object)handler);
    }

    public void log(int n, String string, String string2) {
        Utils.checkNotNull((Object)string2);
        string = this.handler;
        string.sendMessage(string.obtainMessage(n, (Object)string2));
    }
}
