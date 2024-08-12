/*
 * Decompiled with CFR 0.152.
 */
package com.luck.picture.lib.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

static final class PictureThreadUtils.UtilsThreadFactory
extends AtomicLong
implements ThreadFactory {
    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
    private static final long serialVersionUID = -9209200509960368598L;
    private final boolean isDaemon;
    private final String namePrefix;
    private final int priority;

    PictureThreadUtils.UtilsThreadFactory(String string, int n) {
        this(string, n, false);
    }

    PictureThreadUtils.UtilsThreadFactory(String string, int n, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("-pool-");
        stringBuilder.append(POOL_NUMBER.getAndIncrement());
        stringBuilder.append("-thread-");
        this.namePrefix = stringBuilder.toString();
        this.priority = n;
        this.isDaemon = bl;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.namePrefix);
        stringBuilder.append(this.getAndIncrement());
        runnable = new /* Unavailable Anonymous Inner Class!! */;
        ((Thread)runnable).setDaemon(this.isDaemon);
        ((Thread)runnable).setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new /* Unavailable Anonymous Inner Class!! */);
        ((Thread)runnable).setPriority(this.priority);
        return runnable;
    }
}
