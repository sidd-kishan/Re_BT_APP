/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnSuccessListener
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.zzm
 *  com.google.android.gms.tasks.zzq
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzm;
import com.google.android.gms.tasks.zzq;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class zzn<TResult>
implements zzq<TResult> {
    private final Executor zza;
    private final Object zzb = new Object();
    @Nullable
    private OnSuccessListener<? super TResult> zzc;

    public zzn(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.zza = executor;
        this.zzc = onSuccessListener;
    }

    static /* synthetic */ Object zzc(zzn zzn2) {
        return zzn2.zzb;
    }

    static /* synthetic */ OnSuccessListener zzd(zzn zzn2) {
        return zzn2.zzc;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza(Task<TResult> task) {
        if (!task.isSuccessful()) return;
        Object object = this.zzb;
        synchronized (object) {
            if (this.zzc == null) {
                return;
            }
        }
        this.zza.execute((Runnable)new zzm(this, task));
    }

    public final void zzb() {
        Object object = this.zzb;
        synchronized (object) {
            this.zzc = null;
            return;
        }
    }
}
