/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.zzab
 *  com.google.android.gms.tasks.zzw
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.zzab;
import com.google.android.gms.tasks.zzw;
import java.util.concurrent.ExecutionException;

final class zzac
implements zzab {
    private final Object zza = new Object();
    private final int zzb;
    private final zzw<Void> zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private Exception zzg;
    private boolean zzh;

    public zzac(int n, zzw<Void> zzw2) {
        this.zzb = n;
        this.zzc = zzw2;
    }

    private final void zza() {
        int n = this.zzd;
        int n2 = this.zze;
        int n3 = this.zzf;
        int n4 = this.zzb;
        if (n + n2 + n3 != n4) return;
        if (this.zzg != null) {
            zzw<Void> zzw2 = this.zzc;
            StringBuilder stringBuilder = new StringBuilder(54);
            stringBuilder.append(n2);
            stringBuilder.append(" out of ");
            stringBuilder.append(n4);
            stringBuilder.append(" underlying tasks failed");
            zzw2.zzc((Exception)new ExecutionException(stringBuilder.toString(), this.zzg));
            return;
        }
        if (this.zzh) {
            this.zzc.zze();
            return;
        }
        this.zzc.zza(null);
    }

    public final void onCanceled() {
        Object object = this.zza;
        synchronized (object) {
            ++this.zzf;
            this.zzh = true;
            this.zza();
            return;
        }
    }

    public final void onFailure(Exception exception) {
        Object object = this.zza;
        synchronized (object) {
            ++this.zze;
            this.zzg = exception;
            this.zza();
            return;
        }
    }

    public final void onSuccess(Object object) {
        Object object2 = this.zza;
        synchronized (object2) {
            ++this.zzd;
            this.zza();
            return;
        }
    }
}
