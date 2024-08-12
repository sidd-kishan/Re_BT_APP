/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.ListenableWorker$Result
 *  androidx.work.Worker
 */
package androidx.work;

import androidx.work.ListenableWorker;
import androidx.work.Worker;

class Worker.1
implements Runnable {
    final Worker this$0;

    Worker.1(Worker worker) {
        this.this$0 = worker;
    }

    @Override
    public void run() {
        try {
            ListenableWorker.Result result = this.this$0.doWork();
            this.this$0.mFuture.set((Object)result);
        }
        catch (Throwable throwable) {
            this.this$0.mFuture.setException(throwable);
        }
    }
}
