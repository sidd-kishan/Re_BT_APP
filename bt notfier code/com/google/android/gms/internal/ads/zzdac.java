/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcbz
 *  com.google.android.gms.internal.ads.zzdaa
 *  com.google.android.gms.internal.ads.zzdab
 *  com.google.android.gms.internal.ads.zzdbc
 *  com.google.android.gms.internal.ads.zzdbs
 *  com.google.android.gms.internal.ads.zzdbu
 *  com.google.android.gms.internal.ads.zzdfx
 *  com.google.android.gms.internal.ads.zzdhz
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcbz;
import com.google.android.gms.internal.ads.zzdaa;
import com.google.android.gms.internal.ads.zzdab;
import com.google.android.gms.internal.ads.zzdbc;
import com.google.android.gms.internal.ads.zzdbs;
import com.google.android.gms.internal.ads.zzdbu;
import com.google.android.gms.internal.ads.zzdfx;
import com.google.android.gms.internal.ads.zzdhz;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsu;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzdac
implements zzdbc,
zzdhz,
zzdfx,
zzdbs {
    private final zzdbu zza;
    private final zzezz zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final zzfsu<Boolean> zze = zzfsu.zza();
    private ScheduledFuture<?> zzf;

    public zzdac(zzdbu zzdbu2, zzezz zzezz2, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zza = zzdbu2;
        this.zzb = zzezz2;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
    }

    static /* synthetic */ zzdbu zza(zzdac zzdac2) {
        return zzdac2.zza;
    }

    public final void zzb() {
        zzbjd zzbjd2 = zzbjl.zzba;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        zzbjd2 = this.zzb;
        if (zzbjd2.zzU != 2) return;
        if (zzbjd2.zzq == 0) {
            this.zza.zza();
            return;
        }
        zzfsd.zzp(this.zze, (zzfrz)new zzdab(this), (Executor)this.zzd);
        this.zzf = this.zzc.schedule((Runnable)new zzdaa(this), (long)this.zzb.zzq, TimeUnit.MILLISECONDS);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzc() {
        synchronized (this) {
            boolean bl = this.zze.isDone();
            if (bl) {
                return;
            }
            ScheduledFuture<?> scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzp((Object)true);
            return;
        }
    }

    public final void zzd() {
    }

    public final void zze() {
    }

    final /* synthetic */ void zzf() {
        synchronized (this) {
            if (this.zze.isDone()) {
                return;
            }
            this.zze.zzp((Object)true);
            return;
        }
    }

    public final void zzh() {
        int n = this.zzb.zzU;
        if (n != 0) {
            if (n != 1) return;
        }
        this.zza.zza();
    }

    public final void zzi() {
    }

    public final void zzj() {
    }

    public final void zzk(zzcbz zzcbz2, String string, String string2) {
    }

    public final void zzl() {
    }

    public final void zzm() {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzn(zzbcz object) {
        synchronized (this) {
            boolean bl = this.zze.isDone();
            if (bl) {
                return;
            }
            object = this.zzf;
            if (object != null) {
                object.cancel(true);
            }
            object = this.zze;
            Exception exception = new Exception();
            object.zzq((Throwable)exception);
            return;
        }
    }
}
