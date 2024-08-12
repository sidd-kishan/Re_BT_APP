/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.utils.SerialExecutor
 */
package androidx.work.impl.utils;

import androidx.work.impl.utils.SerialExecutor;

static class SerialExecutor.Task
implements Runnable {
    final Runnable mRunnable;
    final SerialExecutor mSerialExecutor;

    SerialExecutor.Task(SerialExecutor serialExecutor, Runnable runnable) {
        this.mSerialExecutor = serialExecutor;
        this.mRunnable = runnable;
    }

    @Override
    public void run() {
        try {
            this.mRunnable.run();
            return;
        }
        finally {
            this.mSerialExecutor.scheduleNext();
        }
    }
}
