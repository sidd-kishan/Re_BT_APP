/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbsn
 *  com.google.android.gms.internal.ads.zzbtf
 *  com.google.android.gms.internal.ads.zzbtr
 *  com.google.android.gms.internal.ads.zzbts
 *  com.google.android.gms.internal.ads.zzchg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbtf;
import com.google.android.gms.internal.ads.zzbtr;
import com.google.android.gms.internal.ads.zzbts;
import com.google.android.gms.internal.ads.zzchg;

final class zzbtg
implements Runnable {
    final zzbtr zza;
    final zzbsn zzb;
    final zzbts zzc;

    zzbtg(zzbts zzbts2, zzbtr zzbtr2, zzbsn zzbsn2) {
        this.zzc = zzbts2;
        this.zza = zzbtr2;
        this.zzb = zzbsn2;
    }

    @Override
    public final void run() {
        Object object = zzbts.zza((zzbts)this.zzc);
        synchronized (object) {
            if (this.zza.zzi() == -1) return;
            if (this.zza.zzi() == 1) {
                return;
            }
            this.zza.zzh();
            zzchg.zze.execute(zzbtf.zza((zzbsn)this.zzb));
            zze.zza((String)"Could not receive loaded message in a timely manner. Rejecting.");
            return;
        }
    }
}
