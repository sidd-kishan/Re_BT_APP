/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.concurrent.Task
 *  okhttp3.internal.concurrent.TaskQueue
 *  okhttp3.internal.concurrent.TaskRunner$Backend
 *  okhttp3.internal.concurrent.TaskRunner$Companion
 *  okhttp3.internal.concurrent.TaskRunner$RealBackend
 */
package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 (2\u00020\u0001:\u0003'()B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010!\u001a\u00020\u001bJ\u0015\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u000bH\u0000\u00a2\u0006\u0002\b$J\u0006\u0010%\u001a\u00020\u000bJ\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\n\n\u0002\b\u0012\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2={"Lokhttp3/internal/concurrent/TaskRunner;", "", "backend", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "logger", "Ljava/util/logging/Logger;", "(Lokhttp3/internal/concurrent/TaskRunner$Backend;Ljava/util/logging/Logger;)V", "getBackend", "()Lokhttp3/internal/concurrent/TaskRunner$Backend;", "busyQueues", "", "Lokhttp3/internal/concurrent/TaskQueue;", "coordinatorWaiting", "", "coordinatorWakeUpAt", "", "getLogger$okhttp", "()Ljava/util/logging/Logger;", "logger$1", "nextQueueName", "", "readyQueues", "runnable", "Ljava/lang/Runnable;", "activeQueues", "", "afterRun", "", "task", "Lokhttp3/internal/concurrent/Task;", "delayNanos", "awaitTaskToRun", "beforeRun", "cancelAll", "kickCoordinator", "taskQueue", "kickCoordinator$okhttp", "newQueue", "runTask", "Backend", "Companion", "RealBackend", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class TaskRunner {
    public static final Companion Companion = new Companion(null);
    public static final TaskRunner INSTANCE;
    private static final Logger logger;
    private final Backend backend;
    private final List<TaskQueue> busyQueues;
    private boolean coordinatorWaiting;
    private long coordinatorWakeUpAt;
    private final Logger logger$1;
    private int nextQueueName;
    private final List<TaskQueue> readyQueues;
    private final Runnable runnable;

    static {
        Logger logger = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(TaskRunner::class.java.name)");
        TaskRunner.logger = logger;
        INSTANCE = new TaskRunner((Backend)new RealBackend(Util.threadFactory((String)Intrinsics.stringPlus((String)Util.okHttpName, (Object)" TaskRunner"), (boolean)true)), null, 2, null);
    }

    public TaskRunner(Backend backend, Logger logger) {
        Intrinsics.checkNotNullParameter((Object)backend, (String)"backend");
        Intrinsics.checkNotNullParameter((Object)logger, (String)"logger");
        this.backend = backend;
        this.logger$1 = logger;
        this.nextQueueName = 10000;
        this.busyQueues = new ArrayList();
        this.readyQueues = new ArrayList();
        this.runnable = (Runnable)new /* Unavailable Anonymous Inner Class!! */;
    }

    public /* synthetic */ TaskRunner(Backend backend, Logger logger, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            logger = TaskRunner.logger;
        }
        this(backend, logger);
    }

    public static final /* synthetic */ Logger access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ void access$runTask(TaskRunner taskRunner, Task task) {
        taskRunner.runTask(task);
    }

    private final void afterRun(Task object, long l) {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Thread ");
            ((StringBuilder)object).append((Object)Thread.currentThread().getName());
            ((StringBuilder)object).append(" MUST hold lock on ");
            ((StringBuilder)object).append(this);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        TaskQueue taskQueue = object.getQueue$okhttp();
        Intrinsics.checkNotNull((Object)taskQueue);
        boolean bl = taskQueue.getActiveTask$okhttp() == object;
        if (!bl) throw (Throwable)new IllegalStateException("Check failed.".toString());
        boolean bl2 = taskQueue.getCancelActiveTask$okhttp();
        taskQueue.setCancelActiveTask$okhttp(false);
        taskQueue.setActiveTask$okhttp(null);
        this.busyQueues.remove(taskQueue);
        if (l != -1L && !bl2 && !taskQueue.getShutdown$okhttp()) {
            taskQueue.scheduleAndDecide$okhttp((Task)object, l, true);
        }
        if (!(((Collection)taskQueue.getFutureTasks$okhttp()).isEmpty() ^ true)) return;
        this.readyQueues.add(taskQueue);
    }

    private final void beforeRun(Task object) {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Thread ");
            ((StringBuilder)object).append((Object)Thread.currentThread().getName());
            ((StringBuilder)object).append(" MUST hold lock on ");
            ((StringBuilder)object).append(this);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        object.setNextExecuteNanoTime$okhttp(-1L);
        TaskQueue taskQueue = object.getQueue$okhttp();
        Intrinsics.checkNotNull((Object)taskQueue);
        taskQueue.getFutureTasks$okhttp().remove(object);
        this.readyQueues.remove(taskQueue);
        taskQueue.setActiveTask$okhttp((Task)object);
        this.busyQueues.add(taskQueue);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final void runTask(Task object) {
        long l;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Thread ");
            ((StringBuilder)object).append((Object)Thread.currentThread().getName());
            ((StringBuilder)object).append(" MUST NOT hold lock on ");
            ((StringBuilder)object).append(this);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        Thread thread = Thread.currentThread();
        String string = thread.getName();
        thread.setName(object.getName());
        try {
            l = object.runOnce();
        }
        catch (Throwable throwable) {
            synchronized (this) {
                this.afterRun((Task)object, -1L);
                object = Unit.INSTANCE;
            }
            thread.setName(string);
            throw throwable;
        }
        synchronized (this) {
            this.afterRun((Task)object, l);
            object = Unit.INSTANCE;
        }
        thread.setName(string);
    }

    public final List<TaskQueue> activeQueues() {
        synchronized (this) {
            List list = CollectionsKt.plus((Collection)this.busyQueues, (Iterable)this.readyQueues);
            return list;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public final Task awaitTaskToRun() {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            var8_1 = new StringBuilder();
            var8_1.append("Thread ");
            var8_1.append((Object)Thread.currentThread().getName());
            var8_1.append(" MUST hold lock on ");
            var8_1.append(this);
            throw new AssertionError((Object)var8_1.toString());
        }
        block4: while (true) {
            block14: {
                if (this.readyQueues.isEmpty()) {
                    return null;
                }
                var4_7 = this.backend.nanoTime();
                var2_6 = 0x7FFFFFFFFFFFFFFFL;
                var10_10 = this.readyQueues.iterator();
                var8_2 = null;
                while (var10_10.hasNext()) {
                    var9_9 = (Task)var10_10.next().getFutureTasks$okhttp().get(0);
                    var6_8 = Math.max(0L, var9_9.getNextExecuteNanoTime$okhttp() - var4_7);
                    if (var6_8 > 0L) {
                        var2_6 = Math.min(var6_8, var2_6);
                        continue;
                    }
                    if (var8_2 != null) {
                        var1_5 = true;
                        break block14;
                    }
                    var8_2 = var9_9;
                }
                var1_5 = false;
            }
            if (var8_2 != null) {
                this.beforeRun(var8_2);
                if (!var1_5) {
                    if (this.coordinatorWaiting != false) return var8_2;
                    if ((((Collection)this.readyQueues).isEmpty() ^ true) == false) return var8_2;
                }
                this.backend.execute(this.runnable);
                return var8_2;
            }
            if (this.coordinatorWaiting) {
                if (var2_6 >= this.coordinatorWakeUpAt - var4_7) return null;
                this.backend.coordinatorNotify(this);
                return null;
            }
            this.coordinatorWaiting = true;
            this.coordinatorWakeUpAt = var4_7 + var2_6;
            this.backend.coordinatorWait(this, var2_6);
lbl47:
            // 2 sources

            while (true) {
                this.coordinatorWaiting = false;
                continue block4;
                break;
            }
            {
                catch (Throwable var8_3) {
                    break;
                }
                catch (InterruptedException var8_4) {}
                {
                    this.cancelAll();
                    ** continue;
                }
            }
        }
        this.coordinatorWaiting = false;
        throw var8_3;
    }

    public final void cancelAll() {
        int n;
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(this);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        int n2 = this.busyQueues.size() - 1;
        if (n2 >= 0) {
            while (true) {
                n = n2 - 1;
                this.busyQueues.get(n2).cancelAllAndDecide$okhttp();
                if (n < 0) break;
                n2 = n;
            }
        }
        if ((n2 = this.readyQueues.size() - 1) < 0) return;
        while (true) {
            n = n2 - 1;
            TaskQueue taskQueue = this.readyQueues.get(n2);
            taskQueue.cancelAllAndDecide$okhttp();
            if (taskQueue.getFutureTasks$okhttp().isEmpty()) {
                this.readyQueues.remove(n2);
            }
            if (n < 0) {
                return;
            }
            n2 = n;
        }
    }

    public final Backend getBackend() {
        return this.backend;
    }

    public final Logger getLogger$okhttp() {
        return this.logger$1;
    }

    public final void kickCoordinator$okhttp(TaskQueue object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"taskQueue");
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Thread ");
            ((StringBuilder)object).append((Object)Thread.currentThread().getName());
            ((StringBuilder)object).append(" MUST hold lock on ");
            ((StringBuilder)object).append(this);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        if (object.getActiveTask$okhttp() == null) {
            if (((Collection)object.getFutureTasks$okhttp()).isEmpty() ^ true) {
                Util.addIfAbsent(this.readyQueues, (Object)object);
            } else {
                this.readyQueues.remove(object);
            }
        }
        if (this.coordinatorWaiting) {
            this.backend.coordinatorNotify(this);
        } else {
            this.backend.execute(this.runnable);
        }
    }

    public final TaskQueue newQueue() {
        int n;
        synchronized (this) {
            n = this.nextQueueName;
            this.nextQueueName = n + 1;
        }
        return new TaskQueue(this, Intrinsics.stringPlus((String)"Q", (Object)n));
    }
}
