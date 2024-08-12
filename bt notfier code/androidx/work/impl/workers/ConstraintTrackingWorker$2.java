/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.workers.ConstraintTrackingWorker
 */
package androidx.work.impl.workers;

import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.common.util.concurrent.ListenableFuture;

class ConstraintTrackingWorker.2
implements Runnable {
    final ConstraintTrackingWorker this$0;
    final ListenableFuture val$innerFuture;

    ConstraintTrackingWorker.2(ConstraintTrackingWorker constraintTrackingWorker, ListenableFuture listenableFuture) {
        this.this$0 = constraintTrackingWorker;
        this.val$innerFuture = listenableFuture;
    }

    @Override
    public void run() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            if (this.this$0.mAreConstraintsUnmet) {
                this.this$0.setFutureRetry();
            } else {
                this.this$0.mFuture.setFuture(this.val$innerFuture);
            }
            return;
        }
    }
}
