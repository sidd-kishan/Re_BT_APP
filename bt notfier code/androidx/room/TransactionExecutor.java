/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.TransactionExecutor$1
 */
package androidx.room;

import androidx.room.TransactionExecutor;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

class TransactionExecutor
implements Executor {
    private Runnable mActive;
    private final Executor mExecutor;
    private final ArrayDeque<Runnable> mTasks = new ArrayDeque();

    TransactionExecutor(Executor executor) {
        this.mExecutor = executor;
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (this) {
            ArrayDeque<Runnable> arrayDeque = this.mTasks;
            1 var3_4 = new /* Unavailable Anonymous Inner Class!! */;
            arrayDeque.offer((Runnable)var3_4);
            if (this.mActive != null) return;
            this.scheduleNext();
            return;
        }
    }

    void scheduleNext() {
        synchronized (this) {
            Runnable runnable;
            this.mActive = runnable = this.mTasks.poll();
            if (runnable == null) return;
            this.mExecutor.execute(runnable);
            return;
        }
    }
}
