/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgd;

final class zzcgc {
    private final Object zza = new Object();
    private volatile long zzb = 0L;
    private volatile int zzc = 1;

    private zzcgc() {
    }

    /* synthetic */ zzcgc(zzcgd zzcgd2) {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza() {
        Object object;
        long l;
        long l2 = zzt.zzj().currentTimeMillis();
        Object object2 = this.zza;
        synchronized (object2) {
            if (this.zzc == 3) {
                l = this.zzb;
                object = zzbjl.zzel;
                if (l + (Long)zzbet.zzc().zzc(object) <= l2) {
                    this.zzc = 1;
                }
            }
        }
        l = zzt.zzj().currentTimeMillis();
        object = this.zza;
        synchronized (object) {
            if (this.zzc != 2) {
                return;
            }
            this.zzc = 3;
            if (this.zzc != 3) return;
            this.zzb = l;
            return;
        }
    }
}
