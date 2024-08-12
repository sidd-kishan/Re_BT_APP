/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.StringCompanionObject
 *  okhttp3.internal.concurrent.Task
 *  okhttp3.internal.concurrent.TaskQueue
 */
package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a$\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0002\u001a9\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fH\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a.\u0010\u0011\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0080\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0013"}, d2={"formatDuration", "", "ns", "", "log", "", "Ljava/util/logging/Logger;", "task", "Lokhttp3/internal/concurrent/Task;", "queue", "Lokhttp3/internal/concurrent/TaskQueue;", "message", "logElapsed", "T", "block", "Lkotlin/Function0;", "(Ljava/util/logging/Logger;Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "taskLog", "messageBlock", "okhttp"}, k=2, mv={1, 5, 1}, xi=48)
public final class TaskLoggerKt {
    public static final String formatDuration(long l) {
        CharSequence charSequence;
        if (l <= -999500000L) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((l - (long)500000000) / (long)1000000000);
            ((StringBuilder)charSequence).append(" s ");
            charSequence = ((StringBuilder)charSequence).toString();
        } else if (l <= -999500L) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((l - (long)500000) / (long)1000000);
            ((StringBuilder)charSequence).append(" ms");
            charSequence = ((StringBuilder)charSequence).toString();
        } else if (l <= 0L) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((l - (long)500) / (long)1000);
            ((StringBuilder)charSequence).append(" \u00b5s");
            charSequence = ((StringBuilder)charSequence).toString();
        } else if (l < 999500L) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((l + (long)500) / (long)1000);
            ((StringBuilder)charSequence).append(" \u00b5s");
            charSequence = ((StringBuilder)charSequence).toString();
        } else if (l < 999500000L) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((l + (long)500000) / (long)1000000);
            ((StringBuilder)charSequence).append(" ms");
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((l + (long)500000000) / (long)1000000000);
            ((StringBuilder)charSequence).append(" s ");
            charSequence = ((StringBuilder)charSequence).toString();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        charSequence = String.format("%6s", Arrays.copyOf(new Object[]{charSequence}, 1));
        Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"java.lang.String.format(format, *args)");
        return charSequence;
    }

    private static final void log(Logger logger, Task task, TaskQueue object, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(object.getName$okhttp());
        stringBuilder.append(' ');
        object = StringCompanionObject.INSTANCE;
        object = String.format("%-22s", Arrays.copyOf(new Object[]{string}, 1));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.lang.String.format(format, *args)");
        stringBuilder.append((String)object);
        stringBuilder.append(": ");
        stringBuilder.append(task.getName());
        logger.fine(stringBuilder.toString());
    }

    public static final <T> T logElapsed(Logger logger, Task task, TaskQueue taskQueue, Function0<? extends T> object) {
        long l;
        Intrinsics.checkNotNullParameter((Object)logger, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)task, (String)"task");
        Intrinsics.checkNotNullParameter((Object)taskQueue, (String)"queue");
        Intrinsics.checkNotNullParameter(object, (String)"block");
        boolean bl = logger.isLoggable(Level.FINE);
        if (bl) {
            l = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
            TaskLoggerKt.log(logger, task, taskQueue, "starting");
        } else {
            l = -1L;
        }
        try {
            object = object.invoke();
        }
        catch (Throwable throwable) {
            InlineMarker.finallyStart((int)1);
            if (bl) {
                TaskLoggerKt.log(logger, task, taskQueue, Intrinsics.stringPlus((String)"failed a run in ", (Object)TaskLoggerKt.formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - l)));
            }
            InlineMarker.finallyEnd((int)1);
            throw throwable;
        }
        InlineMarker.finallyStart((int)1);
        if (bl) {
            TaskLoggerKt.log(logger, task, taskQueue, Intrinsics.stringPlus((String)"finished run in ", (Object)TaskLoggerKt.formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - l)));
        }
        InlineMarker.finallyEnd((int)1);
        return (T)object;
    }

    public static final void taskLog(Logger logger, Task task, TaskQueue taskQueue, Function0<String> function0) {
        Intrinsics.checkNotNullParameter((Object)logger, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)task, (String)"task");
        Intrinsics.checkNotNullParameter((Object)taskQueue, (String)"queue");
        Intrinsics.checkNotNullParameter(function0, (String)"messageBlock");
        if (!logger.isLoggable(Level.FINE)) return;
        TaskLoggerKt.log(logger, task, taskQueue, (String)function0.invoke());
    }
}
