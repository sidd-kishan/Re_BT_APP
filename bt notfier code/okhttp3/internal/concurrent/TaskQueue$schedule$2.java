/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  okhttp3.internal.concurrent.Task
 */
package okhttp3.internal.concurrent;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import okhttp3.internal.concurrent.Task;

@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2={"okhttp3/internal/concurrent/TaskQueue$schedule$2", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class TaskQueue.schedule.2
extends Task {
    final Function0<Long> $block;
    final String $name;

    TaskQueue.schedule.2(Function0<Long> function0, String string) {
        this.$block = function0;
        this.$name = string;
        super(string, false, 2, null);
    }

    public long runOnce() {
        return ((Number)this.$block.invoke()).longValue();
    }
}
