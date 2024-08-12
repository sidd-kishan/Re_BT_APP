/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.Continuation
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.zzc
 *  com.google.android.gms.tasks.zzq
 *  com.google.android.gms.tasks.zzw
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzc;
import com.google.android.gms.tasks.zzq;
import com.google.android.gms.tasks.zzw;
import java.util.concurrent.Executor;

final class zzd<TResult, TContinuationResult>
implements zzq<TResult> {
    private final Executor zza;
    private final Continuation<TResult, TContinuationResult> zzb;
    private final zzw<TContinuationResult> zzc;

    public zzd(Executor executor, Continuation<TResult, TContinuationResult> continuation, zzw<TContinuationResult> zzw2) {
        this.zza = executor;
        this.zzb = continuation;
        this.zzc = zzw2;
    }

    static /* synthetic */ zzw zzc(zzd zzd2) {
        return zzd2.zzc;
    }

    static /* synthetic */ Continuation zzd(zzd zzd2) {
        return zzd2.zzb;
    }

    public final void zza(Task<TResult> task) {
        this.zza.execute((Runnable)new zzc(this, task));
    }

    public final void zzb() {
        throw new UnsupportedOperationException();
    }
}
