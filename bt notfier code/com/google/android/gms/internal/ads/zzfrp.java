/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfrq
 *  com.google.android.gms.internal.ads.zzfsl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfrq;
import com.google.android.gms.internal.ads.zzfsl;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

abstract class zzfrp<T>
extends zzfsl<T> {
    private final Executor zza;
    final zzfrq zzb;

    zzfrp(zzfrq zzfrq2, Executor executor) {
        this.zzb = zzfrq2;
        if (executor == null) throw null;
        this.zza = executor;
    }

    abstract void zzb(T var1);

    final boolean zzd() {
        return this.zzb.isDone();
    }

    final void zze() {
        try {
            this.zza.execute((Runnable)((Object)this));
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            this.zzb.zzq((Throwable)rejectedExecutionException);
            return;
        }
    }

    final void zzf(T t) {
        zzfrq.zzJ((zzfrq)this.zzb, null);
        this.zzb(t);
    }

    final void zzg(Throwable throwable) {
        zzfrq.zzJ((zzfrq)this.zzb, null);
        if (throwable instanceof ExecutionException) {
            this.zzb.zzq(((ExecutionException)throwable).getCause());
            return;
        }
        if (throwable instanceof CancellationException) {
            this.zzb.cancel(false);
            return;
        }
        this.zzb.zzq(throwable);
    }
}
