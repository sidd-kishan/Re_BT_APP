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
 *  com.google.android.gms.tasks.zzp
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzp;
import java.util.concurrent.CancellationException;

final class zzo
implements Runnable {
    final Task zza;
    final zzp zzb;

    zzo(zzp zzp2, Task task) {
        this.zzb = zzp2;
        this.zza = task;
    }

    @Override
    public final void run() {
        Task task;
        block5: {
            try {
                task = zzp.zzc((zzp)this.zzb).then(this.zza.getResult());
                if (task != null) break block5;
            }
            catch (Exception exception) {
                this.zzb.onFailure(exception);
                return;
            }
            catch (CancellationException cancellationException) {
                this.zzb.onCanceled();
                return;
            }
            catch (RuntimeExecutionException runtimeExecutionException) {
                if (runtimeExecutionException.getCause() instanceof Exception) {
                    this.zzb.onFailure((Exception)runtimeExecutionException.getCause());
                    return;
                }
                this.zzb.onFailure((Exception)((Object)runtimeExecutionException));
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
