/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Logger
 *  androidx.work.impl.WorkerWrapper
 *  androidx.work.impl.utils.futures.SettableFuture
 */
package androidx.work.impl;

import androidx.work.Logger;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

class WorkerWrapper.1
implements Runnable {
    final WorkerWrapper this$0;
    final SettableFuture val$future;
    final ListenableFuture val$runExpedited;

    WorkerWrapper.1(WorkerWrapper workerWrapper, ListenableFuture listenableFuture, SettableFuture settableFuture) {
        this.this$0 = workerWrapper;
        this.val$runExpedited = listenableFuture;
        this.val$future = settableFuture;
    }

    @Override
    public void run() {
        try {
            this.val$runExpedited.get();
            Logger.get().debug(WorkerWrapper.TAG, String.format("Starting work for %s", this.this$0.mWorkSpec.workerClassName), new Throwable[0]);
            this.this$0.mInnerFuture = this.this$0.mWorker.startWork();
            this.val$future.setFuture(this.this$0.mInnerFuture);
        }
        catch (Throwable throwable) {
            this.val$future.setException(throwable);
        }
    }
}
