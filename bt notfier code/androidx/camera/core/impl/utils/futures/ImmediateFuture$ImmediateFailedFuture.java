/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.futures.ImmediateFuture
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.ImmediateFuture;
import java.util.concurrent.ExecutionException;

static class ImmediateFuture.ImmediateFailedFuture<V>
extends ImmediateFuture<V> {
    private final Throwable mCause;

    ImmediateFuture.ImmediateFailedFuture(Throwable throwable) {
        this.mCause = throwable;
    }

    public V get() throws ExecutionException {
        throw new ExecutionException(this.mCause);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("[status=FAILURE, cause=[");
        stringBuilder.append(this.mCause);
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}
