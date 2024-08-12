/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfoa
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfoa;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class zzfrw<V>
extends zzfoa
implements Future<V> {
    protected zzfrw() {
    }

    @Override
    public boolean cancel(boolean bl) {
        return this.zzb().cancel(bl);
    }

    @Override
    public final V get() throws InterruptedException, ExecutionException {
        return this.zzb().get();
    }

    @Override
    public final V get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzb().get(l, timeUnit);
    }

    @Override
    public final boolean isCancelled() {
        return this.zzb().isCancelled();
    }

    @Override
    public final boolean isDone() {
        return this.zzb().isDone();
    }

    protected abstract Future<? extends V> zzb();
}
