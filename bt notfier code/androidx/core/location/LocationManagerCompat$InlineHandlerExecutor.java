/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.core.util.Preconditions
 */
package androidx.core.location;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

private static final class LocationManagerCompat.InlineHandlerExecutor
implements Executor {
    private final Handler mHandler;

    LocationManagerCompat.InlineHandlerExecutor(Handler handler) {
        this.mHandler = (Handler)Preconditions.checkNotNull((Object)handler);
    }

    @Override
    public void execute(Runnable object) {
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            if (this.mHandler.post((Runnable)Preconditions.checkNotNull((Object)object))) return;
            object = new StringBuilder();
            ((StringBuilder)object).append(this.mHandler);
            ((StringBuilder)object).append(" is shutting down");
            throw new RejectedExecutionException(((StringBuilder)object).toString());
        }
        object.run();
    }
}
