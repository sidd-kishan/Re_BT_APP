/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.zzq
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzq;
import java.util.ArrayDeque;
import java.util.Queue;

final class zzr<TResult> {
    private final Object zza = new Object();
    private Queue<zzq<TResult>> zzb;
    private boolean zzc;

    zzr() {
    }

    public final void zza(zzq<TResult> zzq2) {
        Object object = this.zza;
        synchronized (object) {
            if (this.zzb == null) {
                ArrayDeque<zzq<TResult>> arrayDeque = new ArrayDeque<zzq<TResult>>();
                this.zzb = arrayDeque;
            }
            this.zzb.add(zzq2);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final void zzb(Task<TResult> task) {
        Object object;
        block10: {
            object = this.zza;
            // MONITORENTER : object
            if (this.zzb != null && !this.zzc) {
                this.zzc = true;
                // MONITOREXIT : object
                break block10;
            }
            // MONITOREXIT : object
            return;
        }
        while (true) {
            object = this.zza;
            // MONITORENTER : object
            zzq<TResult> zzq2 = this.zzb.poll();
            if (zzq2 == null) {
                this.zzc = false;
                // MONITOREXIT : object
                return;
            }
            // MONITOREXIT : object
            zzq2.zza(task);
        }
    }
}
