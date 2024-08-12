/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCanceledListener
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.zzg
 *  com.google.android.gms.tasks.zzq
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzg;
import com.google.android.gms.tasks.zzq;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class zzh<TResult>
implements zzq<TResult> {
    private final Executor zza;
    private final Object zzb = new Object();
    @Nullable
    private OnCanceledListener zzc;

    public zzh(Executor executor, OnCanceledListener onCanceledListener) {
        this.zza = executor;
        this.zzc = onCanceledListener;
    }

    static /* synthetic */ Object zzc(zzh zzh2) {
        return zzh2.zzb;
    }

    static /* synthetic */ OnCanceledListener zzd(zzh zzh2) {
        return zzh2.zzc;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza(Task<TResult> task) {
        if (!task.isCanceled()) return;
        Object object = this.zzb;
        synchronized (object) {
            if (this.zzc == null) {
                return;
            }
        }
        this.zza.execute((Runnable)new zzg(this));
    }

    public final void zzb() {
        Object object = this.zzb;
        synchronized (object) {
            this.zzc = null;
            return;
        }
    }
}
