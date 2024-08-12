/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCanceledListener
 *  com.google.android.gms.tasks.OnFailureListener
 *  com.google.android.gms.tasks.OnSuccessListener
 *  com.google.android.gms.tasks.SuccessContinuation
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.zzo
 *  com.google.android.gms.tasks.zzq
 *  com.google.android.gms.tasks.zzw
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzo;
import com.google.android.gms.tasks.zzq;
import com.google.android.gms.tasks.zzw;
import java.util.concurrent.Executor;

final class zzp<TResult, TContinuationResult>
implements OnSuccessListener<TContinuationResult>,
OnFailureListener,
OnCanceledListener,
zzq {
    private final Executor zza;
    private final SuccessContinuation<TResult, TContinuationResult> zzb;
    private final zzw<TContinuationResult> zzc;

    public zzp(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation, zzw<TContinuationResult> zzw2) {
        this.zza = executor;
        this.zzb = successContinuation;
        this.zzc = zzw2;
    }

    static /* synthetic */ SuccessContinuation zzc(zzp zzp2) {
        return zzp2.zzb;
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
        this.zza.execute((Runnable)new zzo(this, task));
    }

    public final void zzb() {
        throw new UnsupportedOperationException();
    }
}
