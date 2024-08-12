/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.zzj
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzj;

final class zzi
implements Runnable {
    final Task zza;
    final zzj zzb;

    zzi(zzj zzj2, Task task) {
        this.zzb = zzj2;
        this.zza = task;
    }

    @Override
    public final void run() {
        Object object = zzj.zzc((zzj)this.zzb);
        synchronized (object) {
            if (zzj.zzd((zzj)this.zzb) == null) return;
            zzj.zzd((zzj)this.zzb).onComplete(this.zza);
            return;
        }
    }
}
