/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy
 */
package com.bumptech.glide.load.engine.executor;

import android.util.Log;
import com.bumptech.glide.load.engine.executor.GlideExecutor;

class GlideExecutor.UncaughtThrowableStrategy.2
implements GlideExecutor.UncaughtThrowableStrategy {
    GlideExecutor.UncaughtThrowableStrategy.2() {
    }

    public void handle(Throwable throwable) {
        if (throwable == null) return;
        if (!Log.isLoggable((String)"GlideExecutor", (int)6)) return;
        Log.e((String)"GlideExecutor", (String)"Request threw uncaught throwable", (Throwable)throwable);
    }
}
