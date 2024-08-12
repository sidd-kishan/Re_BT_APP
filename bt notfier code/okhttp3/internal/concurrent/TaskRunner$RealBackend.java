/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.concurrent.TaskRunner
 *  okhttp3.internal.concurrent.TaskRunner$Backend
 */
package okhttp3.internal.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.TaskRunner;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lokhttp3/internal/concurrent/TaskRunner$RealBackend;", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(Ljava/util/concurrent/ThreadFactory;)V", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "beforeTask", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "coordinatorNotify", "coordinatorWait", "nanos", "", "execute", "runnable", "Ljava/lang/Runnable;", "nanoTime", "shutdown", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class TaskRunner.RealBackend
implements TaskRunner.Backend {
    private final ThreadPoolExecutor executor;

    public TaskRunner.RealBackend(ThreadFactory threadFactory) {
        Intrinsics.checkNotNullParameter((Object)threadFactory, (String)"threadFactory");
        this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, (BlockingQueue<Runnable>)new SynchronousQueue(), threadFactory);
    }

    public void beforeTask(TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter((Object)taskRunner, (String)"taskRunner");
    }

    public void coordinatorNotify(TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter((Object)taskRunner, (String)"taskRunner");
        ((Object)taskRunner).notify();
    }

    public void coordinatorWait(TaskRunner taskRunner, long l) throws InterruptedException {
        Intrinsics.checkNotNullParameter((Object)taskRunner, (String)"taskRunner");
        long l2 = l / 1000000L;
        if (l2 <= 0L) {
            if (l <= 0L) return;
        }
        ((Object)taskRunner).wait(l2, (int)(l - 1000000L * l2));
    }

    public void execute(Runnable runnable) {
        Intrinsics.checkNotNullParameter((Object)runnable, (String)"runnable");
        this.executor.execute(runnable);
    }

    public long nanoTime() {
        return System.nanoTime();
    }

    public final void shutdown() {
        this.executor.shutdown();
    }
}
