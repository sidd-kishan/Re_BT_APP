/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy
 */
package com.bumptech.glide.load.engine.executor;

import com.bumptech.glide.load.engine.executor.GlideExecutor;

class GlideExecutor.UncaughtThrowableStrategy.3
implements GlideExecutor.UncaughtThrowableStrategy {
    GlideExecutor.UncaughtThrowableStrategy.3() {
    }

    public void handle(Throwable throwable) {
        if (throwable != null) throw new RuntimeException("Request threw uncaught throwable", throwable);
    }
}
