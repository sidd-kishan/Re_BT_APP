/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Process
 */
package androidx.core.provider;

import android.os.Process;

private static class RequestExecutor.DefaultThreadFactory.ProcessPriorityThread
extends Thread {
    private final int mPriority;

    RequestExecutor.DefaultThreadFactory.ProcessPriorityThread(Runnable runnable, String string, int n) {
        super(runnable, string);
        this.mPriority = n;
    }

    @Override
    public void run() {
        Process.setThreadPriority((int)this.mPriority);
        super.run();
    }
}
