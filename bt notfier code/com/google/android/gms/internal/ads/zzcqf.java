/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzbqm
 *  com.google.android.gms.internal.ads.zzcqc
 *  com.google.android.gms.internal.ads.zzcql
 *  com.google.android.gms.internal.ads.zzcqu
 *  com.google.android.gms.internal.ads.zzdwi
 *  com.google.android.gms.internal.ads.zzdwm
 *  com.google.android.gms.internal.ads.zzdwn
 *  com.google.android.gms.internal.ads.zzdwo
 *  com.google.android.gms.internal.ads.zzdwp
 *  com.google.android.gms.internal.ads.zzdwr
 *  com.google.android.gms.internal.ads.zzgkz
 *  com.google.android.gms.internal.ads.zzglb
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbqm;
import com.google.android.gms.internal.ads.zzcqc;
import com.google.android.gms.internal.ads.zzcql;
import com.google.android.gms.internal.ads.zzcqu;
import com.google.android.gms.internal.ads.zzdwi;
import com.google.android.gms.internal.ads.zzdwm;
import com.google.android.gms.internal.ads.zzdwn;
import com.google.android.gms.internal.ads.zzdwo;
import com.google.android.gms.internal.ads.zzdwp;
import com.google.android.gms.internal.ads.zzdwr;
import com.google.android.gms.internal.ads.zzgkz;
import com.google.android.gms.internal.ads.zzglb;
import com.google.android.gms.internal.ads.zzgln;

final class zzcqf
implements zzdwr {
    private final Context zza;
    private final zzbqm zzb;
    private final zzcqu zzc;
    private final zzcqf zzd = this;
    private final zzgln<zzdwr> zze;
    private final zzgln<zzbqm> zzf;
    private final zzgln<zzdwm> zzg;
    private final zzgln<zzdwo> zzh;

    /* synthetic */ zzcqf(zzcqu zzcqu2, Context context, zzbqm zzbqm2, zzcql zzcql2) {
        this.zzc = zzcqu2;
        this.zza = context;
        this.zzb = zzbqm2;
        this.zze = zzglb.zza((Object)this);
        this.zzf = zzcqu2 = zzglb.zza((Object)zzbqm2);
        this.zzg = zzcqu2 = new zzdwn((zzgln)zzcqu2);
        this.zzh = zzgkz.zza((zzgln)new zzdwp(this.zze, (zzgln)zzcqu2));
    }

    static /* synthetic */ Context zza(zzcqf zzcqf2) {
        return zzcqf2.zza;
    }

    static /* synthetic */ zzdwm zzb(zzcqf zzcqf2) {
        return zzdwn.zzc((zzbqm)zzcqf2.zzb);
    }

    public final zzdwo zzc() {
        return (zzdwo)this.zzh.zzb();
    }

    public final zzdwi zzd() {
        return new zzcqc(this.zzc, this.zzd, null);
    }
}
