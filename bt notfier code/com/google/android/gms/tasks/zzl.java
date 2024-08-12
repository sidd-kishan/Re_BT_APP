/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnFailureListener
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.zzk
 *  com.google.android.gms.tasks.zzq
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzk;
import com.google.android.gms.tasks.zzq;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class zzl<TResult>
implements zzq<TResult> {
    private final Executor zza;
    private final Object zzb = new Object();
    @Nullable
    private OnFailureListener zzc;

    public zzl(Executor executor, OnFailureListener onFailureListener) {
        this.zza = executor;
        this.zzc = onFailureListener;
    }

    static /* synthetic */ Object zzc(zzl zzl2) {
        return zzl2.zzb;
    }

    static /* synthetic */ OnFailureListener zzd(zzl zzl2) {
        return zzl2.zzc;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza(Task<TResult> task) {
        if (task.isSuccessful()) return;
        if (task.isCanceled()) return;
        Object object = this.zzb;
        synchronized (object) {
            if (this.zzc == null) {
                return;
            }
        }
        this.zza.execute((Runnable)new zzk(this, task));
    }

    public final void zzb() {
        Object object = this.zzb;
        synchronized (object) {
            this.zzc = null;
            return;
        }
    }
}
