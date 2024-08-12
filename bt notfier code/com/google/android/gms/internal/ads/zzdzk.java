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
 *  com.google.android.gms.internal.ads.zzdzj
 *  com.google.android.gms.internal.ads.zzeaa
 *  com.google.android.gms.internal.ads.zzeab
 *  com.google.android.gms.internal.ads.zzeac
 *  com.google.android.gms.internal.ads.zzeap
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
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzdzj;
import com.google.android.gms.internal.ads.zzeaa;
import com.google.android.gms.internal.ads.zzeab;
import com.google.android.gms.internal.ads.zzeac;
import com.google.android.gms.internal.ads.zzeap;
import com.google.android.gms.internal.ads.zzebq;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgku;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzdzk {
    private final ScheduledExecutorService zza;
    private final zzfsn zzb;
    private final zzeac zzc;
    private final zzgku<zzebq> zzd;

    public zzdzk(ScheduledExecutorService scheduledExecutorService, zzfsn zzfsn2, zzeac zzeac2, zzgku<zzebq> zzgku2) {
        this.zza = scheduledExecutorService;
        this.zzb = zzfsn2;
        this.zzc = zzeac2;
        this.zzd = zzgku2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final zzfsm<InputStream> zza(zzcbj zzcbj2) {
        Object object;
        Object object2;
        String string = zzcbj2.zzd;
        zzt.zzc();
        if (zzs.zzF((String)string)) {
            string = zzfsd.zzc((Throwable)new zzeap(1));
        } else {
            string = this.zzc;
            object2 = ((zzeac)string).zzb;
            synchronized (object2) {
                if (((zzeac)string).zzc) {
                    string = ((zzeac)string).zza;
                } else {
                    ((zzeac)string).zzc = true;
                    ((zzeac)string).zze = zzcbj2;
                    ((zzeaa)string).zzf.checkAvailabilityAndConnect();
                    object = ((zzeac)string).zza;
                    zzeab zzeab2 = new zzeab((zzeac)string);
                    object.zze((Runnable)zzeab2, (Executor)zzchg.zzf);
                    string = ((zzeac)string).zza;
                }
            }
        }
        int n = Binder.getCallingUid();
        string = zzfru.zzw((zzfsm)string);
        object2 = zzbjl.zzdP;
        int n2 = (Integer)zzbet.zzc().zzc((zzbjd)object2);
        object2 = TimeUnit.SECONDS;
        object = this.zza;
        return zzfsd.zzg((zzfsm)((zzfru)zzfsd.zzh((zzfsm)string, (long)n2, (TimeUnit)((Object)object2), (ScheduledExecutorService)object)), Throwable.class, (zzfrk)new zzdzj(this, zzcbj2, n), (Executor)this.zzb);
    }

    final /* synthetic */ zzfsm zzb(zzcbj zzcbj2, int n, Throwable throwable) throws Exception {
        return ((zzebq)this.zzd.zzb()).zzi(zzcbj2, n);
    }
}
