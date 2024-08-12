/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.ListenableWorker$Result
 *  androidx.work.Logger
 *  androidx.work.impl.WorkerWrapper
 *  androidx.work.impl.utils.futures.SettableFuture
 */
package androidx.work.impl;

import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

class WorkerWrapper.2
implements Runnable {
    final WorkerWrapper this$0;
    final SettableFuture val$future;
    final String val$workDescription;

    WorkerWrapper.2(WorkerWrapper workerWrapper, SettableFuture settableFuture, String string) {
        this.this$0 = workerWrapper;
        this.val$future = settableFuture;
        this.val$workDescription = string;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    @Override
    public void run() {
        Throwable throwable2222222222;
        block9: {
            block8: {
                void var1_5;
                try {
                    ListenableWorker.Result result = (ListenableWorker.Result)this.val$future.get();
                    if (result == null) {
                        Logger.get().error(WorkerWrapper.TAG, String.format("%s returned a null result. Treating it as a failure.", this.this$0.mWorkSpec.workerClassName), new Throwable[0]);
                    } else {
                        Logger.get().debug(WorkerWrapper.TAG, String.format("%s returned a %s result.", this.this$0.mWorkSpec.workerClassName, result), new Throwable[0]);
                        this.this$0.mResult = result;
                    }
                    break block8;
                }
                catch (Throwable throwable2222222222) {
                    break block9;
                }
                catch (ExecutionException executionException) {
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
                catch (CancellationException cancellationException) {
                    Logger.get().info(WorkerWrapper.TAG, String.format("%s was cancelled", this.val$workDescription), new Throwable[]{cancellationException});
                    break block8;
                }
                Logger.get().error(WorkerWrapper.TAG, String.format("%s failed because it threw an exception/error", this.val$workDescription), new Throwable[]{var1_5});
            }
            this.this$0.onWorkFinished();
            return;
        }
        this.this$0.onWorkFinished();
        throw throwable2222222222;
    }
}
