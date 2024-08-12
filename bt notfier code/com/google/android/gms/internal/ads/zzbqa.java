/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.overlay.zzt
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbqc
 *  com.google.android.gms.internal.ads.zzbsi
 *  com.google.android.gms.internal.ads.zzdio
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbqc;
import com.google.android.gms.internal.ads.zzbsi;
import com.google.android.gms.internal.ads.zzdio;
import java.util.Map;

final class zzbqa
implements zzt {
    boolean zza;
    final boolean zzb;
    final zzbcv zzc;
    final Map zzd;
    final Map zze;

    zzbqa(zzbqc zzbqc2, boolean bl, zzbcv zzbcv2, Map map, Map map2) {
        this.zzb = bl;
        this.zzc = zzbcv2;
        this.zzd = map;
        this.zze = map2;
        this.zza = false;
    }

    public final void zza(boolean bl) {
        if (this.zza) return;
        if (bl && this.zzb) {
            ((zzdio)this.zzc).zzb();
        }
        this.zza = true;
        this.zzd.put((String)this.zze.get("event_id"), bl);
        ((zzbsi)this.zzc).zze("openIntentAsync", this.zzd);
    }

    public final void zzb(int n) {
    }
}
