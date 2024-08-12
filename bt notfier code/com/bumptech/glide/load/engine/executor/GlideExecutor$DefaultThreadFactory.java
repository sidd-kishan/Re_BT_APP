/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.executor.GlideExecutor$DefaultThreadFactory$1
 *  com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy
 */
package com.bumptech.glide.load.engine.executor;

import com.bumptech.glide.load.engine.executor.GlideExecutor;
import java.util.concurrent.ThreadFactory;

private static final class GlideExecutor.DefaultThreadFactory
implements ThreadFactory {
    private static final int DEFAULT_PRIORITY = 9;
    private final String name;
    final boolean preventNetworkOperations;
    private int threadNum;
    final GlideExecutor.UncaughtThrowableStrategy uncaughtThrowableStrategy;

    GlideExecutor.DefaultThreadFactory(String string, GlideExecutor.UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean bl) {
        this.name = string;
        this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
        this.preventNetworkOperations = bl;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        synchronized (this) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("glide-");
            stringBuilder.append(this.name);
            stringBuilder.append("-thread-");
            stringBuilder.append(this.threadNum);
            1 var3_3 = new /* Unavailable Anonymous Inner Class!! */;
            ++this.threadNum;
            return var3_3;
        }
    }
}
