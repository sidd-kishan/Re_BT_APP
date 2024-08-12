/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzfdw
 *  com.google.android.gms.internal.ads.zzfdy
 *  com.google.android.gms.internal.ads.zzfeb
 *  com.google.android.gms.internal.ads.zzfee
 *  com.google.android.gms.internal.ads.zzfef
 *  com.google.android.gms.internal.ads.zzfeg
 *  com.google.android.gms.internal.ads.zzfeh
 *  com.google.android.gms.internal.ads.zzfei
 *  com.google.android.gms.internal.ads.zzfek
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzfdw;
import com.google.android.gms.internal.ads.zzfdy;
import com.google.android.gms.internal.ads.zzfeb;
import com.google.android.gms.internal.ads.zzfee;
import com.google.android.gms.internal.ads.zzfef;
import com.google.android.gms.internal.ads.zzfeg;
import com.google.android.gms.internal.ads.zzfeh;
import com.google.android.gms.internal.ads.zzfei;
import com.google.android.gms.internal.ads.zzfek;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzfej<O> {
    final zzfek zza;
    private final Object zzb;
    private final String zzc;
    private final zzfsm<?> zzd;
    private final List<zzfsm<?>> zze;
    private final zzfsm<O> zzf;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private zzfej(zzfek zzfek2, Object object, String string, zzfsm zzfsm2, List list, zzfsm zzfsm3) {
        this.zza = zzfek2;
        this.zzb = object;
        this.zzc = string;
        this.zzd = zzfsm2;
        this.zze = list;
        this.zzf = zzfsm3;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzfej(zzfek zzfek2, Object object, String string, zzfsm zzfsm2, List list, zzfsm zzfsm3, zzfeb zzfeb2) {
        this(zzfek2, object, null, zzfsm2, list, zzfsm3);
    }

    public final zzfej<O> zza(String string) {
        return new zzfej<O>(this.zza, this.zzb, string, this.zzd, this.zze, this.zzf);
    }

    public final <O2> zzfej<O2> zzb(zzfdw<O, O2> zzfdw2) {
        return this.zzc((zzfrk<O, O2>)new zzfee(zzfdw2));
    }

    public final <O2> zzfej<O2> zzc(zzfrk<O, O2> zzfrk2) {
        return this.zzd(zzfrk2, (Executor)zzfek.zzb((zzfek)this.zza));
    }

    public final <O2> zzfej<O2> zzd(zzfrk<O, O2> zzfrk2, Executor executor) {
        return new zzfej<O>(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzfsd.zzi(this.zzf, zzfrk2, (Executor)executor));
    }

    public final <O2> zzfej<O2> zze(zzfsm<O2> zzfsm2) {
        return this.zzd((zzfrk<O, O2>)new zzfef(zzfsm2), (Executor)zzchg.zzf);
    }

    public final <T extends Throwable> zzfej<O> zzf(Class<T> clazz, zzfdw<T, O> zzfdw2) {
        return this.zzg(clazz, (zzfrk<T, O>)new zzfeg(zzfdw2));
    }

    public final <T extends Throwable> zzfej<O> zzg(Class<T> clazz, zzfrk<T, O> zzfrk2) {
        zzfek zzfek2 = this.zza;
        return new zzfej<O>(zzfek2, this.zzb, this.zzc, this.zzd, this.zze, zzfsd.zzg(this.zzf, clazz, zzfrk2, (Executor)zzfek.zzb((zzfek)zzfek2)));
    }

    public final zzfej<O> zzh(long l, TimeUnit timeUnit) {
        zzfek zzfek2 = this.zza;
        return new zzfej<O>(zzfek2, this.zzb, this.zzc, this.zzd, this.zze, zzfsd.zzh(this.zzf, (long)l, (TimeUnit)timeUnit, (ScheduledExecutorService)zzfek.zzc((zzfek)zzfek2)));
    }

    public final zzfdy zzi() {
        String string;
        Object object = this.zzb;
        String string2 = string = this.zzc;
        if (string == null) {
            string2 = this.zza.zzg(object);
        }
        string2 = new zzfdy(object, string2, this.zzf);
        zzfek.zzd((zzfek)this.zza).zza((zzfdy)string2);
        this.zzd.zze((Runnable)new zzfeh(this, (zzfdy)string2), (Executor)zzchg.zzf);
        zzfsd.zzp((zzfsm)string2, (zzfrz)new zzfei(this, (zzfdy)string2), (Executor)zzchg.zzf);
        return string2;
    }

    public final zzfej<O> zzj(Object object) {
        zzfdy zzfdy2 = this.zzi();
        return this.zza.zze(object, (zzfsm)zzfdy2);
    }
}
