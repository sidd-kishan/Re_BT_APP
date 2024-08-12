/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.RuntimeExecutionException
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.zzd
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzd;

final class zzc
implements Runnable {
    final Task zza;
    final zzd zzb;

    zzc(zzd zzd2, Task task) {
        this.zzb = zzd2;
        this.zza = task;
    }

    @Override
    public final void run() {
        Object object;
        if (this.zza.isCanceled()) {
            zzd.zzc((zzd)this.zzb).zze();
            return;
        }
        try {
            object = zzd.zzd((zzd)this.zzb).then(this.zza);
        }
        catch (Exception exception) {
            zzd.zzc((zzd)this.zzb).zzc(exception);
            return;
        }
        catch (RuntimeExecutionException runtimeExecutionException) {
            if (runtimeExecutionException.getCause() instanceof Exception) {
                zzd.zzc((zzd)this.zzb).zzc((Exception)runtimeExecutionException.getCause());
                return;
            }
            zzd.zzc((zzd)this.zzb).zzc((Exception)((Object)runtimeExecutionException));
            return;
        }
        zzd.zzc((zzd)this.zzb).zza(object);
    }
}
