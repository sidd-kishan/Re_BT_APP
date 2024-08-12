/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.ImmediateFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

static final class ImmediateFuture.ImmediateFailedScheduledFuture<V>
extends ImmediateFuture.ImmediateFailedFuture<V>
implements ScheduledFuture<V> {
    ImmediateFuture.ImmediateFailedScheduledFuture(Throwable throwable) {
        super(throwable);
    }

    @Override
    public int compareTo(Delayed delayed) {
        return -1;
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        return 0L;
    }
}
