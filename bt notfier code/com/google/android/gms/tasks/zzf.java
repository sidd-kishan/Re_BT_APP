/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.Continuation
 *  com.google.android.gms.tasks.OnCanceledListener
 *  com.google.android.gms.tasks.OnFailureListener
 *  com.google.android.gms.tasks.OnSuccessListener
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.zze
 *  com.google.android.gms.tasks.zzq
 *  com.google.android.gms.tasks.zzw
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zze;
import com.google.android.gms.tasks.zzq;
import com.google.android.gms.tasks.zzw;
import java.util.concurrent.Executor;

final class zzf<TResult, TContinuationResult>
implements OnSuccessListener<TContinuationResult>,
OnFailureListener,
OnCanceledListener,
zzq {
    private final Executor zza;
    private final Continuation<TResult, Task<TContinuationResult>> zzb;
    private final zzw<TContinuationResult> zzc;

    public zzf(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation, zzw<TContinuationResult> zzw2) {
        this.zza = executor;
        this.zzb = continuation;
        this.zzc = zzw2;
    }

    static /* synthetic */ Continuation zzc(zzf zzf2) {
        return zzf2.zzb;
    }

    static /* synthetic */ zzw zzd(zzf zzf2) {
        return zzf2.zzc;
    }

    public final void onCanceled() {
        this.zzc.zze();
    }

    public final void onFailure(Exception exception) {
        this.zzc.zzc(exception);
    }

    public final void onSuccess(TContinuationResult TContinuationResult) {
        this.zzc.zza(TContinuationResult);
    }

    public final void zza(Task<TResult> task) {
        this.zza.execute((Runnable)new zze(this, task));
    }

    public final void zzb() {
        throw new UnsupportedOperationException();
    }
}
