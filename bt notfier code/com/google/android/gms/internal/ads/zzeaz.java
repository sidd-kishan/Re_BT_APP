/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzabu
 *  com.google.android.gms.internal.ads.zzbld
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzdym
 *  com.google.android.gms.internal.ads.zzeag
 *  com.google.android.gms.internal.ads.zzeap
 *  com.google.android.gms.internal.ads.zzeaq
 *  com.google.android.gms.internal.ads.zzear
 *  com.google.android.gms.internal.ads.zzeas
 *  com.google.android.gms.internal.ads.zzeat
 *  com.google.android.gms.internal.ads.zzeau
 *  com.google.android.gms.internal.ads.zzeav
 *  com.google.android.gms.internal.ads.zzeaw
 *  com.google.android.gms.internal.ads.zzeax
 *  com.google.android.gms.internal.ads.zzeay
 *  com.google.android.gms.internal.ads.zzebq
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfru
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgku
 */
package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzbld;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzdym;
import com.google.android.gms.internal.ads.zzeag;
import com.google.android.gms.internal.ads.zzeap;
import com.google.android.gms.internal.ads.zzeaq;
import com.google.android.gms.internal.ads.zzear;
import com.google.android.gms.internal.ads.zzeas;
import com.google.android.gms.internal.ads.zzeat;
import com.google.android.gms.internal.ads.zzeau;
import com.google.android.gms.internal.ads.zzeav;
import com.google.android.gms.internal.ads.zzeaw;
import com.google.android.gms.internal.ads.zzeax;
import com.google.android.gms.internal.ads.zzeay;
import com.google.android.gms.internal.ads.zzebq;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgku;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class zzeaz {
    private final zzfsn zza;
    private final zzeag zzb;
    private final zzgku<zzebq> zzc;

    public zzeaz(zzfsn zzfsn2, zzeag zzeag2, zzgku<zzebq> zzgku2) {
        this.zza = zzfsn2;
        this.zzb = zzeag2;
        this.zzc = zzgku2;
    }

    private final <RetT> zzfsm<RetT> zzg(zzcbj zzcbj2, zzeay<InputStream> zzfsm2, zzeay<InputStream> zzeay2, zzfrk<InputStream, RetT> zzfrk2) {
        String string = zzcbj2.zzd;
        zzt.zzc();
        zzfsm2 = zzs.zzF((String)string) ? zzfsd.zzc((Throwable)new zzeap(1)) : zzfsd.zzg((zzfsm)zzfsm2.zzb(zzcbj2), ExecutionException.class, (zzfrk)zzeaq.zza, (Executor)this.zza);
        return zzfsd.zzg((zzfsm)zzfsd.zzi((zzfsm)zzfru.zzw((zzfsm)zzfsm2), zzfrk2, (Executor)this.zza), zzeap.class, (zzfrk)new zzear(this, zzeay2, zzcbj2, zzfrk2), (Executor)this.zza);
    }

    public final zzfsm<zzcbj> zza(zzcbj zzcbj2) {
        zzeas zzeas2 = new zzeas(zzcbj2);
        return this.zzg(zzcbj2, (zzeay<InputStream>)zzeat.zza((zzeag)this.zzb), (zzeay<InputStream>)new zzeau(this), (zzfrk)zzeas2);
    }

    public final zzfsm<Void> zzb(zzcbj zzcbj2) {
        if (zzabu.zze((String)zzcbj2.zzj)) {
            return zzfsd.zzc((Throwable)new zzdym(2, "Pool key missing from removeUrl call."));
        }
        zzfrk zzfrk2 = zzeav.zza;
        return this.zzg(zzcbj2, (zzeay<InputStream>)new zzeaw(this), (zzeay<InputStream>)new zzeax(this), zzfrk2);
    }

    final /* synthetic */ zzfsm zzc(zzcbj object) {
        zzebq zzebq2 = (zzebq)this.zzc.zzb();
        object = (Boolean)zzbld.zzd.zze() != false ? object.zzh : object.zzj;
        return zzebq2.zzd((String)object);
    }

    final /* synthetic */ zzfsm zzd(zzcbj object) {
        zzeag zzeag2 = this.zzb;
        object = (Boolean)zzbld.zzd.zze() != false ? object.zzh : object.zzj;
        return zzeag2.zzc((String)object);
    }

    final /* synthetic */ zzfsm zze(zzcbj zzcbj2) {
        return ((zzebq)this.zzc.zzb()).zzc(zzcbj2, Binder.getCallingUid());
    }

    final /* synthetic */ zzfsm zzf(zzeay zzeay2, zzcbj zzcbj2, zzfrk zzfrk2, zzeap zzeap2) throws Exception {
        return zzfsd.zzi((zzfsm)zzeay2.zzb(zzcbj2), (zzfrk)zzfrk2, (Executor)this.zza);
    }
}
