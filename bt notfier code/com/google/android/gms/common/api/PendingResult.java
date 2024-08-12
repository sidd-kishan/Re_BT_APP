/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.PendingResult$StatusListener
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.ResultCallback
 *  com.google.android.gms.common.api.ResultTransform
 *  com.google.android.gms.common.api.TransformedResult
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends Result> {
    public void addStatusListener(StatusListener statusListener) {
        throw new UnsupportedOperationException();
    }

    public abstract R await();

    public abstract R await(long var1, TimeUnit var3);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(ResultCallback<? super R> var1);

    public abstract void setResultCallback(ResultCallback<? super R> var1, long var2, TimeUnit var4);

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        throw new UnsupportedOperationException();
    }
}
