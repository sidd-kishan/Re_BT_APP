/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.zzi
 *  com.google.android.gms.tasks.zzq
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzi;
import com.google.android.gms.tasks.zzq;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class zzj<TResult>
implements zzq<TResult> {
    private final Executor zza;
    private final Object zzb = new Object();
    @Nullable
    private OnCompleteListener<TResult> zzc;

    public zzj(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.zza = executor;
        this.zzc = onCompleteListener;
    }

    static /* synthetic */ Object zzc(zzj zzj2) {
        return zzj2.zzb;
    }

    static /* synthetic */ OnCompleteListener zzd(zzj zzj2) {
        return zzj2.zzc;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza(Task<TResult> task) {
        Object object = this.zzb;
        synchronized (object) {
            if (this.zzc == null) {
                return;
            }
        }
        this.zza.execute((Runnable)new zzi(this, task));
    }

    public final void zzb() {
        Object object = this.zzb;
        synchronized (object) {
            this.zzc = null;
            return;
        }
    }
}
