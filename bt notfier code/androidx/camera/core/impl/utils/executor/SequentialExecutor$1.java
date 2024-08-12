/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.executor.SequentialExecutor
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.SequentialExecutor;

class SequentialExecutor.1
implements Runnable {
    final SequentialExecutor this$0;
    final Runnable val$task;

    SequentialExecutor.1(SequentialExecutor sequentialExecutor, Runnable runnable) {
        this.this$0 = sequentialExecutor;
        this.val$task = runnable;
    }

    @Override
    public void run() {
        this.val$task.run();
    }
}
