/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  okhttp3.internal.concurrent.Task
 */
package okhttp3.internal.concurrent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okhttp3.internal.concurrent.Task;

@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2={"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class TaskQueue.execute.1
extends Task {
    final Function0<Unit> $block;
    final boolean $cancelable;
    final String $name;

    TaskQueue.execute.1(Function0<Unit> function0, String string, boolean bl) {
        this.$block = function0;
        this.$name = string;
        this.$cancelable = bl;
        super(string, bl);
    }

    public long runOnce() {
        this.$block.invoke();
        return -1L;
    }
}
