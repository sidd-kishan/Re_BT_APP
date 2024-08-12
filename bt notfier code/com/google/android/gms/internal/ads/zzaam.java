/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.ConditionVariable
 *  com.google.android.gms.internal.ads.zzaan
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzfkk
 */
package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzfkk;

final class zzaam
implements Runnable {
    final zzaan zza;

    zzaam(zzaan zzaan2) {
        this.zza = zzaan2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public final void run() {
        if (this.zza.zzb != null) {
            return;
        }
        ConditionVariable conditionVariable = zzaan.zzb();
        synchronized (conditionVariable) {
            boolean bl;
            if (this.zza.zzb != null) {
                return;
            }
            boolean bl2 = false;
            try {
                bl = (Boolean)zzbjl.zzbF.zze();
            }
            catch (IllegalStateException illegalStateException) {
                bl = false;
            }
            if (bl) {
                try {
                    zzfkk zzfkk2;
                    zzaan.zza = zzfkk2 = new zzfkk(zzaan.zza((zzaan)this.zza).zza, "ADSHIELD", null);
                }
                catch (Throwable throwable) {
                    bl = bl2;
                }
            }
            this.zza.zzb = bl;
            zzaan.zzb().open();
            return;
        }
    }
}
