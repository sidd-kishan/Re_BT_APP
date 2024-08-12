/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.ExecutionListener
 */
package androidx.work.impl;

import androidx.work.impl.ExecutionListener;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

private static class Processor.FutureListener
implements Runnable {
    private ExecutionListener mExecutionListener;
    private ListenableFuture<Boolean> mFuture;
    private String mWorkSpecId;

    Processor.FutureListener(ExecutionListener executionListener, String string, ListenableFuture<Boolean> listenableFuture) {
        this.mExecutionListener = executionListener;
        this.mWorkSpecId = string;
        this.mFuture = listenableFuture;
    }

    @Override
    public void run() {
        boolean bl;
        try {
            bl = (Boolean)this.mFuture.get();
        }
        catch (InterruptedException | ExecutionException exception) {
            bl = true;
        }
        this.mExecutionListener.onExecuted(this.mWorkSpecId, bl);
    }
}
