/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.OptionalPendingResult
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.PendingResult$StatusListener
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.ResultCallback
 *  com.google.android.gms.common.api.ResultTransform
 *  com.google.android.gms.common.api.TransformedResult
 *  com.google.android.gms.common.api.internal.BasePendingResult
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.concurrent.TimeUnit;

public final class OptionalPendingResultImpl<R extends Result>
extends OptionalPendingResult<R> {
    private final BasePendingResult<R> zaa;

    public OptionalPendingResultImpl(PendingResult<R> pendingResult) {
        this.zaa = (BasePendingResult)pendingResult;
    }

    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        this.zaa.addStatusListener(statusListener);
    }

    public final R await() {
        return (R)this.zaa.await();
    }

    public final R await(long l, TimeUnit timeUnit) {
        return (R)this.zaa.await(l, timeUnit);
    }

    public final void cancel() {
        this.zaa.cancel();
    }

    public final R get() {
        if (!this.zaa.isReady()) throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return (R)this.zaa.await(0L, timeUnit);
    }

    public final boolean isCanceled() {
        return this.zaa.isCanceled();
    }

    public final boolean isDone() {
        return this.zaa.isReady();
    }

    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        this.zaa.setResultCallback(resultCallback);
    }

    public final void setResultCallback(ResultCallback<? super R> resultCallback, long l, TimeUnit timeUnit) {
        this.zaa.setResultCallback(resultCallback, l, timeUnit);
    }

    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        return this.zaa.then(resultTransform);
    }
}
