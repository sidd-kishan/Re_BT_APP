/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.os.StrictMode$ThreadPolicy$Builder
 *  com.bumptech.glide.load.engine.executor.GlideExecutor$DefaultThreadFactory
 */
package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import com.bumptech.glide.load.engine.executor.GlideExecutor;

class GlideExecutor.DefaultThreadFactory.1
extends Thread {
    final GlideExecutor.DefaultThreadFactory this$0;

    GlideExecutor.DefaultThreadFactory.1(GlideExecutor.DefaultThreadFactory defaultThreadFactory, Runnable runnable, String string) {
        this.this$0 = defaultThreadFactory;
        super(runnable, string);
    }

    @Override
    public void run() {
        Process.setThreadPriority((int)9);
        if (this.this$0.preventNetworkOperations) {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
        }
        try {
            super.run();
        }
        catch (Throwable throwable) {
            this.this$0.uncaughtThrowableStrategy.handle(throwable);
        }
    }
}
