/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.utils.executor.SequentialExecutor
 *  androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import java.util.Deque;

final class SequentialExecutor.QueueWorker
implements Runnable {
    final SequentialExecutor this$0;

    SequentialExecutor.QueueWorker(SequentialExecutor sequentialExecutor) {
        this.this$0 = sequentialExecutor;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void workOnQueue() {
        var3_1 = false;
        var1_2 = false;
        while (true) {
            var4_4 = var1_2;
            var7_9 = this.this$0.mQueue;
            var4_4 = var1_2;
            synchronized (var7_9) {
                var2_3 = var3_1;
                if (!var3_1) {
                }
                ** GOTO lbl27
            }
            {
                catch (Throwable var6_8) {
                    if (var4_4 == false) throw var6_8;
                    Thread.currentThread().interrupt();
                    throw var6_8;
                }
                {
                    try {
                        if (this.this$0.mWorkerRunningState == SequentialExecutor.WorkerRunningState.RUNNING) {
                            // MONITOREXIT @DISABLED, blocks:[1, 8, 10, 12, 14] lbl18 : MonitorExitStatement: MONITOREXIT : var7_9
                            if (var1_2 == false) return;
                            Thread.currentThread().interrupt();
                            return;
                        }
                        var6_6 = this.this$0;
                        ++var6_6.mWorkerRunCount;
                        this.this$0.mWorkerRunningState = SequentialExecutor.WorkerRunningState.RUNNING;
                        var2_3 = true;
lbl27:
                        // 2 sources

                        if ((var6_6 = (Runnable)this.this$0.mQueue.poll()) == null) {
                            this.this$0.mWorkerRunningState = SequentialExecutor.WorkerRunningState.IDLE;
                            // MONITOREXIT @DISABLED, blocks:[1, 8, 10, 12, 13] lbl28 : MonitorExitStatement: MONITOREXIT : var7_9
                            if (var1_2 == false) return;
                            Thread.currentThread().interrupt();
                            return;
                        }
                        // MONITOREXIT @DISABLED, blocks:[1, 8, 10, 12] lbl32 : MonitorExitStatement: MONITOREXIT : var7_9
                        var4_4 = var1_2;
                    }
                    catch (Throwable var6_7) {}
                    {
                        // MONITOREXIT @DISABLED, blocks:[6, 8, 10, 12] lbl55 : MonitorExitStatement: MONITOREXIT : var7_9
                        var4_4 = var1_2;
                    }
                    {
                        throw var6_7;
                    }
                    {
                        var5_5 = Thread.interrupted();
                        var4_4 = var1_2 |= var5_5;
                        try {
                            var6_6.run();
                            var3_1 = var2_3;
                        }
                        catch (RuntimeException var8_10) {
                            var4_4 = var1_2;
                            var4_4 = var1_2;
                            var7_9 = new StringBuilder();
                            var4_4 = var1_2;
                            var7_9.append("Exception while executing runnable ");
                            var4_4 = var1_2;
                            var7_9.append(var6_6);
                            var4_4 = var1_2;
                            Logger.e((String)"SequentialExecutor", (String)var7_9.toString(), (Throwable)var8_10);
                            var3_1 = var2_3;
                        }
                        continue;
                    }
                }
            }
            break;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        try {
            this.workOnQueue();
            return;
        }
        catch (Error error) {
            Deque deque = this.this$0.mQueue;
            synchronized (deque) {
                this.this$0.mWorkerRunningState = SequentialExecutor.WorkerRunningState.IDLE;
                throw error;
            }
        }
    }
}
