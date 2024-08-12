/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdvg
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdvg;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzdvh {
    final zzdvi zza;
    private final Map<String, String> zzb;

    zzdvh(zzdvi zzdvi2) {
        this.zza = zzdvi2;
        this.zzb = new ConcurrentHashMap<String, String>();
    }

    static /* synthetic */ zzdvh zza(zzdvh zzdvh2) {
        zzdvh2.zzb.putAll(zzdvi.zzc((zzdvi)zzdvh2.zza));
        return zzdvh2;
    }

    public final zzdvh zzb(zzfac zzfac2) {
        this.zzb.put("gqi", zzfac2.zzb);
        return this;
    }

    public final zzdvh zzc(zzezz zzezz2) {
        this.zzb.put("aai", zzezz2.zzw);
        return this;
    }

    public final zzdvh zzd(String string, String string2) {
        this.zzb.put(string, string2);
        return this;
    }

    public final void zze() {
        zzdvi.zzb((zzdvi)this.zza).execute((Runnable)new zzdvg(this));
    }

    public final String zzf() {
        return zzdvi.zza((zzdvi)this.zza).zzc(this.zzb);
    }

    final /* synthetic */ void zzg() {
        zzdvi.zza((zzdvi)this.zza).zzb(this.zzb);
    }
}
