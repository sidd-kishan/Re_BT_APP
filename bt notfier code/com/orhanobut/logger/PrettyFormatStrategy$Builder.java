/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.orhanobut.logger.LogStrategy
 *  com.orhanobut.logger.LogcatLogStrategy
 *  com.orhanobut.logger.PrettyFormatStrategy
 */
package com.orhanobut.logger;

import com.orhanobut.logger.LogStrategy;
import com.orhanobut.logger.LogcatLogStrategy;
import com.orhanobut.logger.PrettyFormatStrategy;

public static class PrettyFormatStrategy.Builder {
    LogStrategy logStrategy;
    int methodCount = 2;
    int methodOffset = 0;
    boolean showThreadInfo = true;
    String tag = "PRETTY_LOGGER";

    private PrettyFormatStrategy.Builder() {
    }

    public PrettyFormatStrategy build() {
        if (this.logStrategy != null) return new PrettyFormatStrategy(this, null);
        this.logStrategy = new LogcatLogStrategy();
        return new PrettyFormatStrategy(this, null);
    }

    public PrettyFormatStrategy.Builder logStrategy(LogStrategy logStrategy) {
        this.logStrategy = logStrategy;
        return this;
    }

    public PrettyFormatStrategy.Builder methodCount(int n) {
        this.methodCount = n;
        return this;
    }

    public PrettyFormatStrategy.Builder methodOffset(int n) {
        this.methodOffset = n;
        return this;
    }

    public PrettyFormatStrategy.Builder showThreadInfo(boolean bl) {
        this.showThreadInfo = bl;
        return this;
    }

    public PrettyFormatStrategy.Builder tag(String string) {
        this.tag = string;
        return this;
    }
}
