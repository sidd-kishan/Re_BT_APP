/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.concurrent.Task
 *  okhttp3.internal.concurrent.TaskLoggerKt
 *  okhttp3.internal.concurrent.TaskQueue
 *  okhttp3.internal.concurrent.TaskRunner
 */
package okhttp3.internal.concurrent;

import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskLoggerKt;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2={"okhttp3/internal/concurrent/TaskRunner$runnable$1", "Ljava/lang/Runnable;", "run", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class TaskRunner.runnable.1
implements Runnable {
    final TaskRunner this$0;

    TaskRunner.runnable.1(TaskRunner taskRunner) {
        this.this$0 = taskRunner;
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        Throwable throwable322222;
        boolean bl;
        long l;
        TaskRunner taskRunner;
        Logger logger;
        Task task;
        TaskRunner taskRunner2;
        while (true) {
            block10: {
                taskRunner2 = this.this$0;
                synchronized (taskRunner2) {
                    task = taskRunner2.awaitTaskToRun();
                    // MONITOREXIT @DISABLED, blocks:[0, 4, 8] lbl6 : MonitorExitStatement: MONITOREXIT : var5_5
                    if (task != null) break block10;
                    return;
                }
            }
            logger = this.this$0.getLogger$okhttp();
            taskRunner2 = task.getQueue$okhttp();
            Intrinsics.checkNotNull((Object)taskRunner2);
            taskRunner = this.this$0;
            l = -1L;
            bl = logger.isLoggable(Level.FINE);
            if (bl) {
                l = taskRunner2.getTaskRunner$okhttp().getBackend().nanoTime();
                TaskLoggerKt.access$log((Logger)logger, (Task)task, (TaskQueue)taskRunner2, (String)"starting");
            }
            TaskRunner.access$runTask((TaskRunner)taskRunner, (Task)task);
            Unit unit = Unit.INSTANCE;
            if (!bl) continue;
            TaskLoggerKt.access$log((Logger)logger, (Task)task, (TaskQueue)taskRunner2, (String)Intrinsics.stringPlus((String)"finished run in ", (Object)TaskLoggerKt.formatDuration((long)(taskRunner2.getTaskRunner$okhttp().getBackend().nanoTime() - l))));
        }
        catch (Throwable throwable2) {
            try {
                taskRunner.getBackend().execute((Runnable)this);
                throw throwable2;
            }
            catch (Throwable throwable322222) {}
        }
        if (!bl) throw throwable322222;
        TaskLoggerKt.access$log((Logger)logger, (Task)task, (TaskQueue)taskRunner2, (String)Intrinsics.stringPlus((String)"failed a run in ", (Object)TaskLoggerKt.formatDuration((long)(taskRunner2.getTaskRunner$okhttp().getBackend().nanoTime() - l))));
        throw throwable322222;
        {
            catch (Throwable throwable4) {
                throw throwable4;
            }
        }
    }
}
