/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.os.OperationCanceledException
 *  androidx.loader.content.AsyncTaskLoader
 *  androidx.loader.content.ModernAsyncTask
 */
package androidx.loader.content;

import androidx.core.os.OperationCanceledException;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.ModernAsyncTask;
import java.util.concurrent.CountDownLatch;

final class AsyncTaskLoader.LoadTask
extends ModernAsyncTask<Void, Void, D>
implements Runnable {
    private final CountDownLatch mDone;
    final AsyncTaskLoader this$0;
    boolean waiting;

    AsyncTaskLoader.LoadTask(AsyncTaskLoader asyncTaskLoader) {
        this.this$0 = asyncTaskLoader;
        this.mDone = new CountDownLatch(1);
    }

    protected D doInBackground(Void ... object) {
        try {
            object = this.this$0.onLoadInBackground();
        }
        catch (OperationCanceledException operationCanceledException) {
            if (!this.isCancelled()) throw operationCanceledException;
            return null;
        }
        return object;
    }

    protected void onCancelled(D d) {
        try {
            this.this$0.dispatchOnCancelled(this, d);
            return;
        }
        finally {
            this.mDone.countDown();
        }
    }

    protected void onPostExecute(D d) {
        try {
            this.this$0.dispatchOnLoadComplete(this, d);
            return;
        }
        finally {
            this.mDone.countDown();
        }
    }

    @Override
    public void run() {
        this.waiting = false;
        this.this$0.executePendingTask();
    }

    /*
     * Enabled force condition propagation
     */
    public void waitForLoader() {
        try {
            this.mDone.await();
            return;
        }
        catch (InterruptedException interruptedException) {
            return;
        }
    }
}
