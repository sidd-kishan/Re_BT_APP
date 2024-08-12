/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.orhanobut.logger.FormatStrategy
 *  com.orhanobut.logger.LogAdapter
 *  com.orhanobut.logger.PrettyFormatStrategy
 *  com.orhanobut.logger.Utils
 */
package com.orhanobut.logger;

import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.LogAdapter;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.orhanobut.logger.Utils;

public class AndroidLogAdapter
implements LogAdapter {
    private final FormatStrategy formatStrategy;

    public AndroidLogAdapter() {
        this.formatStrategy = PrettyFormatStrategy.newBuilder().build();
    }

    public AndroidLogAdapter(FormatStrategy formatStrategy) {
        this.formatStrategy = (FormatStrategy)Utils.checkNotNull((Object)formatStrategy);
    }

    public boolean isLoggable(int n, String string) {
        return true;
    }

    public void log(int n, String string, String string2) {
        this.formatStrategy.log(n, string, string2);
    }
}
