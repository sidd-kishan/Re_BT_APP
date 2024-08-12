/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.zza
 *  com.google.android.gms.ads.internal.zzl
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbkk
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcmw
 *  com.google.android.gms.internal.ads.zzcmx
 *  com.google.android.gms.internal.ads.zzcob
 *  com.google.android.gms.internal.ads.zzddr
 *  com.google.android.gms.internal.ads.zzdsh
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbkk;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcmw;
import com.google.android.gms.internal.ads.zzcmx;
import com.google.android.gms.internal.ads.zzcob;
import com.google.android.gms.internal.ads.zzddr;
import com.google.android.gms.internal.ads.zzdsh;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;

public final class zzdss {
    private final zzcmx zza;
    private final Context zzb;
    private final zzaas zzc;
    private final zzbkk zzd;
    private final zzcgz zze;
    private final zza zzf;
    private final zzazb zzg;
    private final zzddr zzh;

    public zzdss(zzcmx zzcmx2, Context context, zzaas zzaas2, zzbkk zzbkk2, zzcgz zzcgz2, zza zza2, zzazb zzazb2, zzddr zzddr2) {
        this.zza = zzcmx2;
        this.zzb = context;
        this.zzc = zzaas2;
        this.zzd = zzbkk2;
        this.zze = zzcgz2;
        this.zzf = zza2;
        this.zzg = zzazb2;
        this.zzh = zzddr2;
    }

    static /* synthetic */ zzddr zza(zzdss zzdss2) {
        return zzdss2.zzh;
    }

    public final zzcml zzb(zzbdl zzbdl2, zzezz zzezz2, zzfac zzfac2) throws zzcmw {
        return zzcmx.zza((Context)this.zzb, (zzcob)zzcob.zza((zzbdl)zzbdl2), (String)zzbdl2.zza, (boolean)false, (boolean)false, (zzaas)this.zzc, (zzbkk)this.zzd, (zzcgz)this.zze, null, (zzl)new zzdsh(this), (zza)this.zzf, (zzazb)this.zzg, (zzezz)zzezz2, (zzfac)zzfac2);
    }
}
