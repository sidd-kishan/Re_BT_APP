/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.zzn
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzn;

final class zzm
implements Runnable {
    final Task zza;
    final zzn zzb;

    zzm(zzn zzn2, Task task) {
        this.zzb = zzn2;
        this.zza = task;
    }

    @Override
    public final void run() {
        Object object = zzn.zzc((zzn)this.zzb);
        synchronized (object) {
            if (zzn.zzd((zzn)this.zzb) == null) return;
            zzn.zzd((zzn)this.zzb).onSuccess(this.zza.getResult());
            return;
        }
    }
}
