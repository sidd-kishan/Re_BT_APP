/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzftb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzftb;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

public abstract class zzfqx
extends AbstractExecutorService
implements zzfsn {
    @Override
    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return zzftb.zza((Runnable)runnable, t);
    }

    @Override
    protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new zzftb(callable);
    }

    public final zzfsm<?> zza(Runnable runnable) {
        return (zzfsm)super.submit(runnable);
    }

    public final <T> zzfsm<T> zzb(Callable<T> callable) {
        return (zzfsm)super.submit(callable);
    }
}
