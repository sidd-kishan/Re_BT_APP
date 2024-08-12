/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCanceledListener
 *  com.google.android.gms.tasks.OnFailureListener
 *  com.google.android.gms.tasks.OnSuccessListener
 *  com.google.android.gms.tasks.RuntimeExecutionException
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.TaskExecutors
 *  com.google.android.gms.tasks.zzf
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzf;

final class zze
implements Runnable {
    final Task zza;
    final zzf zzb;

    zze(zzf zzf2, Task task) {
        this.zzb = zzf2;
        this.zza = task;
    }

    @Override
    public final void run() {
        Task task;
        block4: {
            try {
                task = (Task)zzf.zzc((zzf)this.zzb).then(this.zza);
                if (task != null) break block4;
            }
            catch (Exception exception) {
                zzf.zzd((zzf)this.zzb).zzc(exception);
                return;
            }
            catch (RuntimeExecutionException runtimeExecutionException) {
                if (runtimeExecutionException.getCause() instanceof Exception) {
                    zzf.zzd((zzf)this.zzb).zzc((Exception)runtimeExecutionException.getCause());
                    return;
                }
                zzf.zzd((zzf)this.zzb).zzc((Exception)((Object)runtimeExecutionException));
                return;
            }
            this.zzb.onFailure((Exception)new NullPointerException("Continuation returned null"));
            return;
        }
        task.addOnSuccessListener(TaskExecutors.zza, (OnSuccessListener)this.zzb);
        task.addOnFailureListener(TaskExecutors.zza, (OnFailureListener)this.zzb);
        task.addOnCanceledListener(TaskExecutors.zza, (OnCanceledListener)this.zzb);
    }
}
