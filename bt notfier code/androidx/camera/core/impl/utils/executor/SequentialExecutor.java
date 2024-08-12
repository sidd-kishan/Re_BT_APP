/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.executor.SequentialExecutor$1
 *  androidx.camera.core.impl.utils.executor.SequentialExecutor$QueueWorker
 *  androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.core.util.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

final class SequentialExecutor
implements Executor {
    private static final String TAG = "SequentialExecutor";
    private final Executor mExecutor;
    final Deque<Runnable> mQueue = new ArrayDeque<Runnable>();
    private final QueueWorker mWorker = new QueueWorker(this);
    long mWorkerRunCount = 0L;
    WorkerRunningState mWorkerRunningState = WorkerRunningState.IDLE;

    SequentialExecutor(Executor executor) {
        this.mExecutor = (Executor)Preconditions.checkNotNull((Object)executor);
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    @Override
    public void execute(Runnable runnable) {
        Preconditions.checkNotNull((Object)runnable);
        Deque<Runnable> deque = this.mQueue;
        synchronized (deque) {
            if (this.mWorkerRunningState != WorkerRunningState.RUNNING && this.mWorkerRunningState != WorkerRunningState.QUEUED) {
                boolean bl;
                1 var6_7;
                block13: {
                    Deque<Runnable> deque2;
                    long l = this.mWorkerRunCount;
                    var6_7 = new /* Unavailable Anonymous Inner Class!! */;
                    this.mQueue.add((Runnable)var6_7);
                    this.mWorkerRunningState = WorkerRunningState.QUEUING;
                    // MONITOREXIT @DISABLED, blocks:[5, 12] lbl11 : MonitorExitStatement: MONITOREXIT : var7_5
                    bl = true;
                    boolean bl2 = true;
                    try {
                        this.mExecutor.execute((Runnable)this.mWorker);
                        bl = this.mWorkerRunningState != WorkerRunningState.QUEUING ? bl2 : false;
                        if (bl) {
                            return;
                        }
                        deque2 = this.mQueue;
                    }
                    catch (Error error) {
                        break block13;
                    }
                    catch (RuntimeException runtimeException) {
                        // empty catch block
                        break block13;
                    }
                    synchronized (deque2) {
                        if (this.mWorkerRunCount != l) return;
                        if (this.mWorkerRunningState != WorkerRunningState.QUEUING) return;
                        this.mWorkerRunningState = WorkerRunningState.QUEUED;
                        return;
                    }
                }
                deque = this.mQueue;
                synchronized (deque) {
                    void var1_4;
                    if (this.mWorkerRunningState != WorkerRunningState.IDLE && this.mWorkerRunningState != WorkerRunningState.QUEUING || !this.mQueue.removeLastOccurrence(var6_7)) {
                        bl = false;
                    }
                    if (!(var1_4 instanceof RejectedExecutionException)) throw var1_4;
                    if (bl) throw var1_4;
                    return;
                }
            }
            this.mQueue.add(runnable);
            return;
        }
    }
}
