/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.concurrent.Task
 *  okhttp3.internal.concurrent.TaskLoggerKt
 *  okhttp3.internal.concurrent.TaskQueue$AwaitIdleTask
 *  okhttp3.internal.concurrent.TaskRunner
 */
package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskLoggerKt;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00013B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\r\u0010#\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b$J0\u0010%\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u000e2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0*J\u0006\u0010+\u001a\u00020,J&\u0010-\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020'0*J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020'J%\u0010/\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u00100\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b1J\u0006\u0010\u001c\u001a\u00020\"J\b\u00102\u001a\u00020\u0005H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u000eX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u00064"}, d2={"Lokhttp3/internal/concurrent/TaskQueue;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "name", "", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/String;)V", "activeTask", "Lokhttp3/internal/concurrent/Task;", "getActiveTask$okhttp", "()Lokhttp3/internal/concurrent/Task;", "setActiveTask$okhttp", "(Lokhttp3/internal/concurrent/Task;)V", "cancelActiveTask", "", "getCancelActiveTask$okhttp", "()Z", "setCancelActiveTask$okhttp", "(Z)V", "futureTasks", "", "getFutureTasks$okhttp", "()Ljava/util/List;", "getName$okhttp", "()Ljava/lang/String;", "scheduledTasks", "", "getScheduledTasks", "shutdown", "getShutdown$okhttp", "setShutdown$okhttp", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "cancelAll", "", "cancelAllAndDecide", "cancelAllAndDecide$okhttp", "execute", "delayNanos", "", "cancelable", "block", "Lkotlin/Function0;", "idleLatch", "Ljava/util/concurrent/CountDownLatch;", "schedule", "task", "scheduleAndDecide", "recurrence", "scheduleAndDecide$okhttp", "toString", "AwaitIdleTask", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class TaskQueue {
    private Task activeTask;
    private boolean cancelActiveTask;
    private final List<Task> futureTasks;
    private final String name;
    private boolean shutdown;
    private final TaskRunner taskRunner;

    public TaskQueue(TaskRunner taskRunner, String string) {
        Intrinsics.checkNotNullParameter((Object)taskRunner, (String)"taskRunner");
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        this.taskRunner = taskRunner;
        this.name = string;
        this.futureTasks = new ArrayList();
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String string, long l, boolean bl, Function0 function0, int n, Object object) {
        if ((n & 2) != 0) {
            l = 0L;
        }
        if ((n & 4) != 0) {
            bl = true;
        }
        taskQueue.execute(string, l, bl, (Function0<Unit>)function0);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String string, long l, Function0 function0, int n, Object object) {
        if ((n & 2) != 0) {
            l = 0L;
        }
        taskQueue.schedule(string, l, (Function0<Long>)function0);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long l, int n, Object object) {
        if ((n & 2) != 0) {
            l = 0L;
        }
        taskQueue.schedule(task, l);
    }

    public final void cancelAll() {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(this);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        TaskRunner taskRunner = this.taskRunner;
        synchronized (taskRunner) {
            if (this.cancelAllAndDecide$okhttp()) {
                this.getTaskRunner$okhttp().kickCoordinator$okhttp(this);
            }
            Unit unit = Unit.INSTANCE;
            return;
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Object object = this.activeTask;
        if (object != null) {
            Intrinsics.checkNotNull((Object)object);
            if (object.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean bl = false;
        boolean bl2 = false;
        int n = this.futureTasks.size() - 1;
        if (n < 0) return bl;
        bl = bl2;
        while (true) {
            int n2 = n - 1;
            if (this.futureTasks.get(n).getCancelable()) {
                object = this.taskRunner.getLogger$okhttp();
                Task task = this.futureTasks.get(n);
                if (((Logger)object).isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log((Logger)object, (Task)task, (TaskQueue)this, (String)"canceled");
                }
                this.futureTasks.remove(n);
                bl = true;
            }
            if (n2 < 0) {
                return bl;
            }
            n = n2;
        }
    }

    public final void execute(String string, long l, boolean bl, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter(function0, (String)"block");
        this.schedule((Task)new /* Unavailable Anonymous Inner Class!! */, l);
    }

    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final String getName$okhttp() {
        return this.name;
    }

    public final List<Task> getScheduledTasks() {
        TaskRunner taskRunner = this.taskRunner;
        synchronized (taskRunner) {
            List list = CollectionsKt.toList((Iterable)this.getFutureTasks$okhttp());
            return list;
        }
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final CountDownLatch idleLatch() {
        TaskRunner taskRunner = this.taskRunner;
        synchronized (taskRunner) {
            try {
                if (this.getActiveTask$okhttp() == null && this.getFutureTasks$okhttp().isEmpty()) {
                    CountDownLatch countDownLatch = new CountDownLatch(0);
                    return countDownLatch;
                }
                Object object2 = this.getActiveTask$okhttp();
                if (object2 instanceof AwaitIdleTask) {
                    object2 = ((AwaitIdleTask)object2).getLatch();
                    return object2;
                }
                for (Object object2 : this.getFutureTasks$okhttp()) {
                    if (!(object2 instanceof AwaitIdleTask)) continue;
                    object2 = ((AwaitIdleTask)object2).getLatch();
                    return object2;
                }
                object2 = new AwaitIdleTask();
                if (this.scheduleAndDecide$okhttp((Task)object2, 0L, false)) {
                    this.getTaskRunner$okhttp().kickCoordinator$okhttp(this);
                }
                object2 = object2.getLatch();
                return object2;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final void schedule(String string, long l, Function0<Long> function0) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter(function0, (String)"block");
        this.schedule((Task)new /* Unavailable Anonymous Inner Class!! */, l);
    }

    public final void schedule(Task object, long l) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"task");
        TaskRunner taskRunner = this.taskRunner;
        synchronized (taskRunner) {
            if (this.getShutdown$okhttp()) {
                if (object.getCancelable()) {
                    Logger logger = this.getTaskRunner$okhttp().getLogger$okhttp();
                    if (!logger.isLoggable(Level.FINE)) return;
                    TaskLoggerKt.access$log((Logger)logger, (Task)object, (TaskQueue)this, (String)"schedule canceled (queue is shutdown)");
                    return;
                }
                Logger logger = this.getTaskRunner$okhttp().getLogger$okhttp();
                if (logger.isLoggable(Level.FINE)) {
                    TaskLoggerKt.access$log((Logger)logger, (Task)object, (TaskQueue)this, (String)"schedule failed (queue is shutdown)");
                }
                object = new RejectedExecutionException();
                throw object;
            }
            if (this.scheduleAndDecide$okhttp((Task)object, l, false)) {
                this.getTaskRunner$okhttp().kickCoordinator$okhttp(this);
            }
            object = Unit.INSTANCE;
            return;
        }
    }

    public final boolean scheduleAndDecide$okhttp(Task task, long l, boolean bl) {
        int n;
        boolean bl2;
        int n2;
        block6: {
            Object object;
            Intrinsics.checkNotNullParameter((Object)task, (String)"task");
            task.initQueue$okhttp(this);
            long l2 = this.taskRunner.getBackend().nanoTime();
            long l3 = l2 + l;
            n2 = this.futureTasks.indexOf(task);
            bl2 = false;
            if (n2 != -1) {
                if (task.getNextExecuteNanoTime$okhttp() <= l3) {
                    Logger logger = this.taskRunner.getLogger$okhttp();
                    if (!logger.isLoggable(Level.FINE)) return false;
                    TaskLoggerKt.access$log((Logger)logger, (Task)task, (TaskQueue)this, (String)"already scheduled");
                    return false;
                }
                this.futureTasks.remove(n2);
            }
            task.setNextExecuteNanoTime$okhttp(l3);
            Logger logger = this.taskRunner.getLogger$okhttp();
            if (logger.isLoggable(Level.FINE)) {
                object = bl ? Intrinsics.stringPlus((String)"run again after ", (Object)TaskLoggerKt.formatDuration((long)(l3 - l2))) : Intrinsics.stringPlus((String)"scheduled after ", (Object)TaskLoggerKt.formatDuration((long)(l3 - l2)));
                TaskLoggerKt.access$log((Logger)logger, (Task)task, (TaskQueue)this, (String)object);
            }
            object = this.futureTasks.iterator();
            n2 = 0;
            while (object.hasNext()) {
                n = ((Task)object.next()).getNextExecuteNanoTime$okhttp() - l2 > l ? 1 : 0;
                if (n == 0) {
                    ++n2;
                    continue;
                }
                break block6;
            }
            n2 = -1;
        }
        n = n2;
        if (n2 == -1) {
            n = this.futureTasks.size();
        }
        this.futureTasks.add(n, task);
        bl = bl2;
        if (n != 0) return bl;
        bl = true;
        return bl;
    }

    public final void setActiveTask$okhttp(Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean bl) {
        this.cancelActiveTask = bl;
    }

    public final void setShutdown$okhttp(boolean bl) {
        this.shutdown = bl;
    }

    public final void shutdown() {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(this);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        TaskRunner taskRunner = this.taskRunner;
        synchronized (taskRunner) {
            this.setShutdown$okhttp(true);
            if (this.cancelAllAndDecide$okhttp()) {
                this.getTaskRunner$okhttp().kickCoordinator$okhttp(this);
            }
            Unit unit = Unit.INSTANCE;
            return;
        }
    }

    public String toString() {
        return this.name;
    }
}
