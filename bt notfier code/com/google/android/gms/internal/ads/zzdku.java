/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcvh
 *  com.google.android.gms.internal.ads.zzcxj
 *  com.google.android.gms.internal.ads.zzcxn
 *  com.google.android.gms.internal.ads.zzdmh
 *  com.google.android.gms.internal.ads.zzdmx
 *  com.google.android.gms.internal.ads.zzeec
 *  com.google.android.gms.internal.ads.zzegq
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcvh;
import com.google.android.gms.internal.ads.zzcxj;
import com.google.android.gms.internal.ads.zzcxn;
import com.google.android.gms.internal.ads.zzdmh;
import com.google.android.gms.internal.ads.zzdmx;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzegq;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Map;

final class zzdku
implements zzcxj<zzcxn> {
    private final Map<String, zzeec<zzcxn>> zza;
    private final Map<String, zzeec<zzdmh>> zzb;
    private final Map<String, zzegq<zzdmh>> zzc;
    private final zzgln<zzcxj<zzcvh>> zzd;
    private final zzdmx zze;

    zzdku(Map<String, zzeec<zzcxn>> map, Map<String, zzeec<zzdmh>> map2, Map<String, zzegq<zzdmh>> map3, zzgln<zzcxj<zzcvh>> zzgln2, zzdmx zzdmx2) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzgln2;
        this.zze = zzdmx2;
    }

    public final zzeec<zzcxn> zza(int n, String zzeec2) {
        zzeec<zzcxn> zzeec3 = this.zza.get(zzeec2);
        if (zzeec3 != null) {
            return zzeec3;
        }
        zzeec3 = null;
        if (n != 1) {
            if (n != 4) {
                return null;
            }
            zzegq<zzdmh> zzegq2 = this.zzc.get(zzeec2);
            if (zzegq2 != null) {
                zzeec2 = zzcxn.zza(zzegq2);
            } else {
                if ((zzeec2 = this.zzb.get(zzeec2)) != null) return zzcxn.zzb(zzeec2);
                zzeec2 = zzeec3;
            }
            return zzeec2;
        }
        if (this.zze.zzd() == null) {
            return null;
        }
        zzeec2 = ((zzcxj)this.zzd.zzb()).zza(n, (String)zzeec2);
        if (zzeec2 == null) return null;
        return zzcxn.zzb((zzeec)zzeec2);
    }
}
