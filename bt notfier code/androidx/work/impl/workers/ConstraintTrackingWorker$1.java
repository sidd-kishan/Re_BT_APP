/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.workers.ConstraintTrackingWorker
 */
package androidx.work.impl.workers;

import androidx.work.impl.workers.ConstraintTrackingWorker;

class ConstraintTrackingWorker.1
implements Runnable {
    final ConstraintTrackingWorker this$0;

    ConstraintTrackingWorker.1(ConstraintTrackingWorker constraintTrackingWorker) {
        this.this$0 = constraintTrackingWorker;
    }

    @Override
    public void run() {
        this.this$0.setupAndRunConstraintTrackingWork();
    }
}
