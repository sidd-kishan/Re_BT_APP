/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzdyn
 *  com.google.android.gms.internal.ads.zzdyo
 *  com.google.android.gms.internal.ads.zzdyp
 *  com.google.android.gms.internal.ads.zzdzx
 *  com.google.android.gms.internal.ads.zzdzy
 *  com.google.android.gms.internal.ads.zzeap
 *  com.google.android.gms.internal.ads.zzebq
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgku
 */
package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzdyn;
import com.google.android.gms.internal.ads.zzdyo;
import com.google.android.gms.internal.ads.zzdyp;
import com.google.android.gms.internal.ads.zzdzx;
import com.google.android.gms.internal.ads.zzdzy;
import com.google.android.gms.internal.ads.zzeap;
import com.google.android.gms.internal.ads.zzebq;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgku;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzdyq {
    private final zzfsn zza;
    private final zzfsn zzb;
    private final zzdzy zzc;
    private final zzgku<zzebq> zzd;

    public zzdyq(zzfsn zzfsn2, zzfsn zzfsn3, zzdzy zzdzy2, zzgku<zzebq> zzgku2) {
        this.zza = zzfsn2;
        this.zzb = zzfsn3;
        this.zzc = zzdzy2;
        this.zzd = zzgku2;
    }

    public final zzfsm<InputStream> zza(zzcbj zzcbj2) {
        String string = zzcbj2.zzd;
        zzt.zzc();
        string = zzs.zzF((String)string) ? zzfsd.zzc((Throwable)new zzeap(1)) : zzfsd.zzg((zzfsm)this.zza.zzb((Callable)new zzdyn(this, zzcbj2)), ExecutionException.class, (zzfrk)zzdyo.zza, (Executor)this.zzb);
        return zzfsd.zzg((zzfsm)string, zzeap.class, (zzfrk)new zzdyp(this, zzcbj2, Binder.getCallingUid()), (Executor)this.zzb);
    }

    final /* synthetic */ zzfsm zzb(zzcbj zzcbj2, int n, zzeap zzeap2) throws Exception {
        return ((zzebq)this.zzd.zzb()).zzb(zzcbj2, n);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    final /* synthetic */ InputStream zzc(zzcbj zzcbj2) throws Exception {
        zzdzy zzdzy2 = this.zzc;
        Object object = zzdzy2.zzb;
        synchronized (object) {
            if (zzdzy2.zzc) {
                zzcbj2 = zzdzy2.zza;
            } else {
                zzdzy2.zzc = true;
                zzdzy2.zze = zzcbj2;
                zzdzy2.zzf.checkAvailabilityAndConnect();
                zzcbj2 = zzdzy2.zza;
                zzdzx zzdzx2 = new zzdzx(zzdzy2);
                zzcbj2.zze((Runnable)zzdzx2, (Executor)zzchg.zzf);
                zzcbj2 = zzdzy2.zza;
            }
        }
        object = zzbjl.zzdP;
        return (InputStream)zzcbj2.get((long)((Integer)zzbet.zzc().zzc((zzbjd)object)).intValue(), TimeUnit.SECONDS);
    }
}
