/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.internal.ads.zzamv
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzdbc
 *  com.google.android.gms.internal.ads.zzdbf
 *  com.google.android.gms.internal.ads.zzdbs
 *  com.google.android.gms.internal.ads.zzdbw
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzdcu
 *  com.google.android.gms.internal.ads.zzddb
 *  com.google.android.gms.internal.ads.zzddn
 *  com.google.android.gms.internal.ads.zzddx
 *  com.google.android.gms.internal.ads.zzdgp
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzdio
 *  com.google.android.gms.internal.ads.zzexl
 *  com.google.android.gms.internal.ads.zzfid
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.internal.ads.zzamv;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzdbc;
import com.google.android.gms.internal.ads.zzdbf;
import com.google.android.gms.internal.ads.zzdbs;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzdcu;
import com.google.android.gms.internal.ads.zzddb;
import com.google.android.gms.internal.ads.zzddn;
import com.google.android.gms.internal.ads.zzddx;
import com.google.android.gms.internal.ads.zzdgp;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzdio;
import com.google.android.gms.internal.ads.zzexl;
import com.google.android.gms.internal.ads.zzfid;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzdgn {
    private final Set<zzdih<zzdcu>> zza = new HashSet<zzdih<zzdcu>>();
    private final Set<zzdih<zzddx>> zzb = new HashSet<zzdih<zzddx>>();
    private final Set<zzdih<zzbcv>> zzc = new HashSet<zzdih<zzbcv>>();
    private final Set<zzdih<zzdio>> zzd = new HashSet<zzdih<zzdio>>();
    private final Set<zzdih<zzdbc>> zze = new HashSet<zzdih<zzdbc>>();
    private final Set<zzdih<zzdbw>> zzf = new HashSet<zzdih<zzdbw>>();
    private final Set<zzdih<zzddb>> zzg = new HashSet<zzdih<zzddb>>();
    private final Set<zzdih<zzdcq>> zzh = new HashSet<zzdih<zzdcq>>();
    private final Set<zzdih<zzdbf>> zzi = new HashSet<zzdih<zzdbf>>();
    private final Set<zzdih<zzfid>> zzj = new HashSet<zzdih<zzfid>>();
    private final Set<zzdih<zzamv>> zzk = new HashSet<zzdih<zzamv>>();
    private final Set<zzdih<zzdbs>> zzl = new HashSet<zzdih<zzdbs>>();
    private final Set<zzdih<zzddn>> zzm = new HashSet<zzdih<zzddn>>();
    private final Set<zzdih<zzo>> zzn = new HashSet<zzdih<zzo>>();
    private zzexl zzo;

    static /* synthetic */ Set zza(zzdgn zzdgn2) {
        return zzdgn2.zza;
    }

    static /* synthetic */ Set zzb(zzdgn zzdgn2) {
        return zzdgn2.zzb;
    }

    static /* synthetic */ Set zzc(zzdgn zzdgn2) {
        return zzdgn2.zzc;
    }

    static /* synthetic */ Set zzd(zzdgn zzdgn2) {
        return zzdgn2.zzd;
    }

    static /* synthetic */ Set zze(zzdgn zzdgn2) {
        return zzdgn2.zze;
    }

    static /* synthetic */ Set zzf(zzdgn zzdgn2) {
        return zzdgn2.zzf;
    }

    static /* synthetic */ Set zzg(zzdgn zzdgn2) {
        return zzdgn2.zzg;
    }

    static /* synthetic */ Set zzh(zzdgn zzdgn2) {
        return zzdgn2.zzh;
    }

    static /* synthetic */ Set zzi(zzdgn zzdgn2) {
        return zzdgn2.zzi;
    }

    static /* synthetic */ Set zzj(zzdgn zzdgn2) {
        return zzdgn2.zzj;
    }

    static /* synthetic */ Set zzk(zzdgn zzdgn2) {
        return zzdgn2.zzk;
    }

    static /* synthetic */ Set zzl(zzdgn zzdgn2) {
        return zzdgn2.zzl;
    }

    static /* synthetic */ Set zzm(zzdgn zzdgn2) {
        return zzdgn2.zzm;
    }

    static /* synthetic */ Set zzn(zzdgn zzdgn2) {
        return zzdgn2.zzn;
    }

    static /* synthetic */ zzexl zzo(zzdgn zzdgn2) {
        return zzdgn2.zzo;
    }

    public final zzdgn zzA(zzexl zzexl2) {
        this.zzo = zzexl2;
        return this;
    }

    public final zzdgn zzB(zzddx zzddx2, Executor executor) {
        this.zzb.add((zzdih<zzddx>)new zzdih((Object)zzddx2, executor));
        return this;
    }

    public final zzdgp zzC() {
        return new zzdgp(this, null);
    }

    public final zzdgn zzp(zzdbc zzdbc2, Executor executor) {
        this.zze.add((zzdih<zzdbc>)new zzdih((Object)zzdbc2, executor));
        return this;
    }

    public final zzdgn zzq(zzdcq zzdcq2, Executor executor) {
        this.zzh.add((zzdih<zzdcq>)new zzdih((Object)zzdcq2, executor));
        return this;
    }

    public final zzdgn zzr(zzdbf zzdbf2, Executor executor) {
        this.zzi.add((zzdih<zzdbf>)new zzdih((Object)zzdbf2, executor));
        return this;
    }

    public final zzdgn zzs(zzdbs zzdbs2, Executor executor) {
        this.zzl.add((zzdih<zzdbs>)new zzdih((Object)zzdbs2, executor));
        return this;
    }

    public final zzdgn zzt(zzamv zzamv2, Executor executor) {
        this.zzk.add((zzdih<zzamv>)new zzdih((Object)zzamv2, executor));
        return this;
    }

    public final zzdgn zzu(zzbcv zzbcv2, Executor executor) {
        this.zzc.add((zzdih<zzbcv>)new zzdih((Object)zzbcv2, executor));
        return this;
    }

    public final zzdgn zzv(zzdio zzdio2, Executor executor) {
        this.zzd.add((zzdih<zzdio>)new zzdih((Object)zzdio2, executor));
        return this;
    }

    public final zzdgn zzw(zzdbw zzdbw2, Executor executor) {
        this.zzf.add((zzdih<zzdbw>)new zzdih((Object)zzdbw2, executor));
        return this;
    }

    public final zzdgn zzx(zzddb zzddb2, Executor executor) {
        this.zzg.add((zzdih<zzddb>)new zzdih((Object)zzddb2, executor));
        return this;
    }

    public final zzdgn zzy(zzo zzo2, Executor executor) {
        this.zzn.add((zzdih<zzo>)new zzdih((Object)zzo2, executor));
        return this;
    }

    public final zzdgn zzz(zzddn zzddn2, Executor executor) {
        this.zzm.add((zzdih<zzddn>)new zzdih((Object)zzddn2, executor));
        return this;
    }
}
