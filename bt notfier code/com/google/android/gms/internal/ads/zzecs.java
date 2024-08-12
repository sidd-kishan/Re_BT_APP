/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdbf
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzedb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdbf;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzedb;

public final class zzecs
implements zzdcq,
zzdbf {
    private static final Object zza = new Object();
    private static int zzb = 0;
    private final zzg zzc;
    private final zzedb zzd;

    public zzecs(zzedb zzedb2, zzg zzg2) {
        this.zzd = zzedb2;
        this.zzc = zzg2;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    private final void zzb(boolean bl) {
        Object object = zzbjl.zzex;
        if (!((Boolean)zzbet.zzc().zzc(object)).booleanValue()) {
            return;
        }
        if (this.zzc.zzC()) return;
        object = zza;
        // MONITORENTER : object
        int n = zzb++;
        zzbjd zzbjd2 = zzbjl.zzey;
        int n2 = (Integer)zzbet.zzc().zzc(zzbjd2);
        // MONITOREXIT : object
        if (n >= n2) {
            return;
        }
        this.zzd.zzf(bl);
        object = zza;
        // MONITORENTER : object
        // MONITOREXIT : object
    }

    public final void zzbD(zzbcz zzbcz2) {
        this.zzb(false);
    }

    public final void zzf() {
        this.zzb(true);
    }
}
