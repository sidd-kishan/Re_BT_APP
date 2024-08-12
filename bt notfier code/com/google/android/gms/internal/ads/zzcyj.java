/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzcsa
 *  com.google.android.gms.internal.ads.zzcye
 *  com.google.android.gms.internal.ads.zzcyf
 *  com.google.android.gms.internal.ads.zzcyg
 *  com.google.android.gms.internal.ads.zzcyh
 *  com.google.android.gms.internal.ads.zzcyi
 *  com.google.android.gms.internal.ads.zzdai
 *  com.google.android.gms.internal.ads.zzdgh
 *  com.google.android.gms.internal.ads.zzdzv
 *  com.google.android.gms.internal.ads.zzeam
 *  com.google.android.gms.internal.ads.zzeaz
 *  com.google.android.gms.internal.ads.zzeeh
 *  com.google.android.gms.internal.ads.zzehu
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfbm
 *  com.google.android.gms.internal.ads.zzfcj
 *  com.google.android.gms.internal.ads.zzfdw
 *  com.google.android.gms.internal.ads.zzfed
 *  com.google.android.gms.internal.ads.zzfej
 *  com.google.android.gms.internal.ads.zzfek
 *  com.google.android.gms.internal.ads.zzfem
 *  com.google.android.gms.internal.ads.zzfes
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzcsa;
import com.google.android.gms.internal.ads.zzcye;
import com.google.android.gms.internal.ads.zzcyf;
import com.google.android.gms.internal.ads.zzcyg;
import com.google.android.gms.internal.ads.zzcyh;
import com.google.android.gms.internal.ads.zzcyi;
import com.google.android.gms.internal.ads.zzdai;
import com.google.android.gms.internal.ads.zzdgh;
import com.google.android.gms.internal.ads.zzdzv;
import com.google.android.gms.internal.ads.zzeam;
import com.google.android.gms.internal.ads.zzeaz;
import com.google.android.gms.internal.ads.zzeeh;
import com.google.android.gms.internal.ads.zzehu;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfcj;
import com.google.android.gms.internal.ads.zzfdw;
import com.google.android.gms.internal.ads.zzfed;
import com.google.android.gms.internal.ads.zzfej;
import com.google.android.gms.internal.ads.zzfek;
import com.google.android.gms.internal.ads.zzfem;
import com.google.android.gms.internal.ads.zzfes;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzcyj<T> {
    private final zzdzv zza;
    private final zzfar zzb;
    private final zzfes zzc;
    private final zzcsa zzd;
    private final zzehu<T> zze;
    private final zzdgh zzf;
    private zzfal zzg;
    private final zzeaz zzh;
    private final zzdai zzi;
    private final Executor zzj;
    private final zzeam zzk;
    private final zzeeh zzl;

    zzcyj(zzdzv zzdzv2, zzfar zzfar2, zzfes zzfes2, zzcsa zzcsa2, zzehu<T> zzehu2, zzdgh zzdgh2, zzfal zzfal2, zzeaz zzeaz2, zzdai zzdai2, Executor executor, zzeam zzeam2, zzeeh zzeeh2) {
        this.zza = zzdzv2;
        this.zzb = zzfar2;
        this.zzc = zzfes2;
        this.zzd = zzcsa2;
        this.zze = zzehu2;
        this.zzf = zzdgh2;
        this.zzg = zzfal2;
        this.zzh = zzeaz2;
        this.zzi = zzdai2;
        this.zzj = executor;
        this.zzk = zzeam2;
        this.zzl = zzeeh2;
    }

    static /* synthetic */ zzdgh zza(zzcyj zzcyj2) {
        return zzcyj2.zzf;
    }

    public final zzfsm<zzfal> zzb(zzfsm<zzcbj> zzfes2) {
        if (this.zzg != null) {
            zzfes2 = this.zzc;
            zzfem zzfem2 = zzfem.zzc;
            return zzfed.zza((zzfsm)zzfsd.zza((Object)this.zzg), (Object)zzfem2, (zzfek)zzfes2).zzi();
        }
        zzt.zzi().zze();
        return this.zzc.zze((Object)zzfem.zzc, (zzfsm)zzfes2).zzc(zzcye.zzb((zzeam)this.zzk)).zzi();
    }

    public final zzfsm<zzfal> zzc() {
        zzbdg zzbdg2 = this.zzb.zzd;
        if (zzbdg2.zzx == null) {
            if (zzbdg2.zzs == null) return this.zzb((zzfsm<zzcbj>)this.zzi.zzb());
        }
        zzfes zzfes2 = this.zzc;
        zzbdg2 = zzfem.zzc;
        return zzfed.zza((zzfsm)this.zza.zzc(), (Object)zzbdg2, (zzfek)zzfes2).zzi();
    }

    public final zzfsm<T> zzd(zzfsm<zzfal> zzfej2) {
        zzfej zzfej3 = this.zzc.zze((Object)zzfem.zzd, zzfej2).zzb((zzfdw)new zzcyf(this)).zzc(this.zze);
        zzbjd zzbjd2 = zzbjl.zzdO;
        zzfej2 = zzfej3;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) != false) return zzfej2.zzi();
        zzfej2 = zzbjl.zzdP;
        zzfej2 = zzfej3.zzh((long)((Integer)zzbet.zzc().zzc((zzbjd)zzfej2)).intValue(), TimeUnit.SECONDS);
        return zzfej2.zzi();
    }

    public final zzdgh zze() {
        return this.zzf;
    }

    public final zzfsm<zzcbj> zzf(zzfcj zzfcj2) {
        zzfcj2 = this.zzc.zze((Object)zzfem.zzu, this.zzi.zzb()).zzc((zzfrk)new zzcyg(this, zzfcj2)).zzi();
        zzfsd.zzp((zzfsm)zzfcj2, (zzfrz)new zzcyh(this), (Executor)this.zzj);
        return zzfcj2;
    }

    public final zzfsm<Void> zzg(zzcbj zzcbj2) {
        zzcbj2 = this.zzc.zze((Object)zzfem.zzv, this.zzh.zzb(zzcbj2)).zzi();
        zzfsd.zzp((zzfsm)zzcbj2, (zzfrz)new zzcyi(this), (Executor)this.zzj);
        return zzcbj2;
    }

    public final zzbcz zzh(Throwable throwable) {
        return zzfbm.zzb((Throwable)throwable, (zzeeh)this.zzl);
    }

    public final void zzi(zzfal zzfal2) {
        this.zzg = zzfal2;
    }

    final /* synthetic */ zzfsm zzj(zzfcj zzfcj2, zzcbj zzcbj2) throws Exception {
        zzcbj2.zzi = zzfcj2;
        return this.zzh.zza(zzcbj2);
    }

    final /* synthetic */ zzfal zzk(zzfal zzfal2) throws Exception {
        this.zzd.zza(zzfal2);
        return zzfal2;
    }
}
