/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzcql
 *  com.google.android.gms.internal.ads.zzcqu
 *  com.google.android.gms.internal.ads.zzeko
 *  com.google.android.gms.internal.ads.zzeli
 *  com.google.android.gms.internal.ads.zzelj
 *  com.google.android.gms.internal.ads.zzelm
 *  com.google.android.gms.internal.ads.zzelo
 *  com.google.android.gms.internal.ads.zzewj
 *  com.google.android.gms.internal.ads.zzewk
 *  com.google.android.gms.internal.ads.zzewm
 *  com.google.android.gms.internal.ads.zzfat
 *  com.google.android.gms.internal.ads.zzgkz
 *  com.google.android.gms.internal.ads.zzglb
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzcql;
import com.google.android.gms.internal.ads.zzcqu;
import com.google.android.gms.internal.ads.zzeko;
import com.google.android.gms.internal.ads.zzeli;
import com.google.android.gms.internal.ads.zzelj;
import com.google.android.gms.internal.ads.zzelm;
import com.google.android.gms.internal.ads.zzelo;
import com.google.android.gms.internal.ads.zzewj;
import com.google.android.gms.internal.ads.zzewk;
import com.google.android.gms.internal.ads.zzewm;
import com.google.android.gms.internal.ads.zzfat;
import com.google.android.gms.internal.ads.zzgkz;
import com.google.android.gms.internal.ads.zzglb;
import com.google.android.gms.internal.ads.zzgln;

final class zzcpy
implements zzewm {
    private final Context zza;
    private final zzbdl zzb;
    private final String zzc;
    private final zzcqu zzd;
    private final zzcpy zze = this;
    private final zzgln<Context> zzf;
    private final zzgln<zzbdl> zzg;
    private final zzgln<zzeli> zzh;
    private final zzgln<zzelm> zzi;
    private final zzgln<zzewj> zzj;

    /* synthetic */ zzcpy(zzcqu zzcqu2, Context context, String string, zzbdl zzbdl2, zzcql zzcql2) {
        this.zzd = zzcqu2;
        this.zza = context;
        this.zzb = zzbdl2;
        this.zzc = string;
        this.zzf = zzglb.zza((Object)context);
        this.zzg = zzglb.zza((Object)zzbdl2);
        this.zzh = zzgkz.zza((zzgln)new zzelj(zzcqu.zzH((zzcqu)this.zzd)));
        this.zzi = zzgkz.zza((zzgln)zzelo.zza());
        this.zzj = zzgkz.zza((zzgln)new zzewk(this.zzf, zzcqu.zzI((zzcqu)this.zzd), this.zzg, zzcqu.zzV((zzcqu)this.zzd), this.zzh, this.zzi, (zzgln)zzfat.zza()));
    }

    public final zzeko zza() {
        return new zzeko(this.zza, this.zzb, this.zzc, (zzewj)this.zzj.zzb(), (zzeli)this.zzh.zzb());
    }
}
