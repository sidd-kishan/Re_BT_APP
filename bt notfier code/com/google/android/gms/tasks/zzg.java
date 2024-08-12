/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.zzh
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.zzh;

final class zzg
implements Runnable {
    final zzh zza;

    zzg(zzh zzh2) {
        this.zza = zzh2;
    }

    @Override
    public final void run() {
        Object object = zzh.zzc((zzh)this.zza);
        synchronized (object) {
            if (zzh.zzd((zzh)this.zza) == null) return;
            zzh.zzd((zzh)this.zza).onCanceled();
            return;
        }
    }
}
