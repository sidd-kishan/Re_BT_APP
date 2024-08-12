/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.zzl
 */
package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzl;

final class zzk
implements Runnable {
    final Task zza;
    final zzl zzb;

    zzk(zzl zzl2, Task task) {
        this.zzb = zzl2;
        this.zza = task;
    }

    @Override
    public final void run() {
        Object object = zzl.zzc((zzl)this.zzb);
        synchronized (object) {
            if (zzl.zzd((zzl)this.zzb) == null) return;
            zzl.zzd((zzl)this.zzb).onFailure((Exception)Preconditions.checkNotNull((Object)this.zza.getException()));
            return;
        }
    }
}
