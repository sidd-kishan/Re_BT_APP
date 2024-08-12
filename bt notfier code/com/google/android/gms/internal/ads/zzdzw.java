/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzcox
 *  com.google.android.gms.internal.ads.zzdat
 *  com.google.android.gms.internal.ads.zzddv
 *  com.google.android.gms.internal.ads.zzddw
 *  com.google.android.gms.internal.ads.zzddz
 *  com.google.android.gms.internal.ads.zzdea
 *  com.google.android.gms.internal.ads.zzdzv
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfbv
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzcox;
import com.google.android.gms.internal.ads.zzdat;
import com.google.android.gms.internal.ads.zzddv;
import com.google.android.gms.internal.ads.zzddw;
import com.google.android.gms.internal.ads.zzddz;
import com.google.android.gms.internal.ads.zzdea;
import com.google.android.gms.internal.ads.zzdzv;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfbv;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;
import java.util.concurrent.Executor;

public final class zzdzw
implements zzgla<zzdzv> {
    private final zzgln<zzcoj> zza;
    private final zzgln<Context> zzb;
    private final zzgln<zzcgz> zzc;
    private final zzgln<zzfar> zzd;
    private final zzgln<Executor> zze;
    private final zzgln<String> zzf;
    private final zzgln<zzddv> zzg;
    private final zzgln<zzddz> zzh;

    public zzdzw(zzgln<zzcoj> zzgln2, zzgln<Context> zzgln3, zzgln<zzcgz> zzgln4, zzgln<zzfar> zzgln5, zzgln<Executor> zzgln6, zzgln<String> zzgln7, zzgln<zzddv> zzgln8, zzgln<zzddz> zzgln9) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
        this.zzd = zzgln5;
        this.zze = zzgln6;
        this.zzf = zzgln7;
        this.zzg = zzgln8;
        this.zzh = zzgln9;
    }

    public final zzdzv zza() {
        zzcoj zzcoj2 = (zzcoj)this.zza.zzb();
        Context context = ((zzfbv)this.zzb).zza();
        zzcgz zzcgz2 = ((zzcox)this.zzc).zza();
        zzfar zzfar2 = ((zzdat)this.zzd).zza();
        zzfsn zzfsn2 = zzchg.zza;
        zzgli.zzb((Object)zzfsn2);
        return new zzdzv(zzcoj2, context, zzcgz2, zzfar2, (Executor)zzfsn2, (String)this.zzf.zzb(), ((zzddw)this.zzg).zza(), ((zzdea)this.zzh).zza());
    }
}
