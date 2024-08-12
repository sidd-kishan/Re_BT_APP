/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  androidx.core.util.Preconditions
 */
package androidx.core.os;

import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

private static class ExecutorCompat.HandlerExecutor
implements Executor {
    private final Handler mHandler;

    ExecutorCompat.HandlerExecutor(Handler handler) {
        this.mHandler = (Handler)Preconditions.checkNotNull((Object)handler);
    }

    @Override
    public void execute(Runnable object) {
        if (this.mHandler.post((Runnable)Preconditions.checkNotNull((Object)object))) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(this.mHandler);
        ((StringBuilder)object).append(" is shutting down");
        throw new RejectedExecutionException(((StringBuilder)object).toString());
    }
}
