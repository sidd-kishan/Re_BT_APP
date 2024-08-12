/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  com.bumptech.glide.load.engine.ActiveResources
 */
package com.bumptech.glide.load.engine;

import android.os.Process;
import com.bumptech.glide.load.engine.ActiveResources;

class ActiveResources.2
implements Runnable {
    final ActiveResources this$0;

    ActiveResources.2(ActiveResources activeResources) {
        this.this$0 = activeResources;
    }

    @Override
    public void run() {
        Process.setThreadPriority((int)10);
        this.this$0.cleanReferenceQueue();
    }
}
