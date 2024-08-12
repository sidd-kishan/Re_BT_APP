/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbtr
 *  com.google.android.gms.internal.ads.zzbts
 *  com.google.android.gms.internal.ads.zzchn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbtr;
import com.google.android.gms.internal.ads.zzbts;
import com.google.android.gms.internal.ads.zzchn;

final class zzbti
implements zzchn {
    final zzbtr zza;
    final zzbts zzb;

    zzbti(zzbts zzbts2, zzbtr zzbtr2) {
        this.zzb = zzbts2;
        this.zza = zzbtr2;
    }

    public final void zza() {
        Object object = zzbts.zza((zzbts)this.zzb);
        synchronized (object) {
            zzbts.zzd((zzbts)this.zzb, (int)1);
            zze.zza((String)"Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzc();
            return;
        }
    }
}
