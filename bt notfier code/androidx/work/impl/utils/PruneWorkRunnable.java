/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Operation
 *  androidx.work.Operation$State
 *  androidx.work.Operation$State$FAILURE
 *  androidx.work.impl.OperationImpl
 *  androidx.work.impl.WorkManagerImpl
 */
package androidx.work.impl.utils;

import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkManagerImpl;

public class PruneWorkRunnable
implements Runnable {
    private final OperationImpl mOperation;
    private final WorkManagerImpl mWorkManagerImpl;

    public PruneWorkRunnable(WorkManagerImpl workManagerImpl) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mOperation = new OperationImpl();
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    @Override
    public void run() {
        try {
            this.mWorkManagerImpl.getWorkDatabase().workSpecDao().pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();
            this.mOperation.setState((Operation.State)Operation.SUCCESS);
        }
        catch (Throwable throwable) {
            this.mOperation.setState((Operation.State)new Operation.State.FAILURE(throwable));
        }
    }
}
