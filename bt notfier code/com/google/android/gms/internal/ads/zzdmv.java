/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.SimpleArrayMap
 *  com.google.android.gms.internal.ads.zzbnf
 *  com.google.android.gms.internal.ads.zzbni
 *  com.google.android.gms.internal.ads.zzbnl
 *  com.google.android.gms.internal.ads.zzbno
 *  com.google.android.gms.internal.ads.zzbns
 *  com.google.android.gms.internal.ads.zzbnv
 *  com.google.android.gms.internal.ads.zzbsg
 *  com.google.android.gms.internal.ads.zzdmx
 */
package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import com.google.android.gms.internal.ads.zzbnf;
import com.google.android.gms.internal.ads.zzbni;
import com.google.android.gms.internal.ads.zzbnl;
import com.google.android.gms.internal.ads.zzbno;
import com.google.android.gms.internal.ads.zzbns;
import com.google.android.gms.internal.ads.zzbnv;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzdmx;

public final class zzdmv {
    zzbni zza;
    zzbnf zzb;
    zzbnv zzc;
    zzbns zzd;
    zzbsg zze;
    final SimpleArrayMap<String, zzbno> zzf = new SimpleArrayMap();
    final SimpleArrayMap<String, zzbnl> zzg = new SimpleArrayMap();

    public final zzdmv zza(zzbni zzbni2) {
        this.zza = zzbni2;
        return this;
    }

    public final zzdmv zzb(zzbnf zzbnf2) {
        this.zzb = zzbnf2;
        return this;
    }

    public final zzdmv zzc(zzbnv zzbnv2) {
        this.zzc = zzbnv2;
        return this;
    }

    public final zzdmv zzd(zzbns zzbns2) {
        this.zzd = zzbns2;
        return this;
    }

    public final zzdmv zze(zzbsg zzbsg2) {
        this.zze = zzbsg2;
        return this;
    }

    public final zzdmv zzf(String string, zzbno zzbno2, zzbnl zzbnl2) {
        this.zzf.put((Object)string, (Object)zzbno2);
        if (zzbnl2 == null) return this;
        this.zzg.put((Object)string, (Object)zzbnl2);
        return this;
    }

    public final zzdmx zzg() {
        return new zzdmx(this, null);
    }
}
