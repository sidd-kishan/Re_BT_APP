/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.CancellationToken
 *  com.google.android.gms.tasks.OnTokenCanceledListener
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.zzs
 *  com.google.android.gms.tasks.zzw
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzs;
import com.google.android.gms.tasks.zzw;

public class TaskCompletionSource<TResult> {
    private final zzw<TResult> zza = new zzw();

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested((OnTokenCanceledListener)new zzs(this));
    }

    static /* synthetic */ zzw zza(TaskCompletionSource taskCompletionSource) {
        return taskCompletionSource.zza;
    }

    public Task<TResult> getTask() {
        return this.zza;
    }

    public void setException(Exception exception) {
        this.zza.zzc(exception);
    }

    public void setResult(TResult TResult) {
        this.zza.zza(TResult);
    }

    public boolean trySetException(Exception exception) {
        return this.zza.zzd(exception);
    }

    public boolean trySetResult(TResult TResult) {
        return this.zza.zzb(TResult);
    }
}
