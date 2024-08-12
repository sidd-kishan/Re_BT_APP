/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdbg
 *  com.google.android.gms.internal.ads.zzdbh
 *  com.google.android.gms.internal.ads.zzdbi
 *  com.google.android.gms.internal.ads.zzdbj
 *  com.google.android.gms.internal.ads.zzdbk
 *  com.google.android.gms.internal.ads.zzdbo
 *  com.google.android.gms.internal.ads.zzdgl
 *  com.google.android.gms.internal.ads.zzdgm
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzdkm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdbg;
import com.google.android.gms.internal.ads.zzdbh;
import com.google.android.gms.internal.ads.zzdbi;
import com.google.android.gms.internal.ads.zzdbj;
import com.google.android.gms.internal.ads.zzdbk;
import com.google.android.gms.internal.ads.zzdbo;
import com.google.android.gms.internal.ads.zzdgl;
import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzdkm;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzdbp
extends zzdgm<zzdbg>
implements zzdbg {
    private final ScheduledExecutorService zzb;
    private ScheduledFuture<?> zzc;
    private boolean zzd = false;
    private final boolean zze;

    public zzdbp(zzdbo zzdbo2, Set<zzdih<zzdbg>> zzbjd2, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        super(zzbjd2);
        this.zzb = scheduledExecutorService;
        zzbjd2 = zzbjl.zzgX;
        this.zze = (Boolean)zzbet.zzc().zzc(zzbjd2);
        this.zzi(zzdbo2, executor);
    }

    public final void zza(zzbcz zzbcz2) {
        this.zzk((zzdgl)new zzdbh(zzbcz2));
    }

    public final void zzb(zzdkm zzdkm2) {
        if (this.zze) {
            if (this.zzd) {
                return;
            }
            ScheduledFuture<?> scheduledFuture = this.zzc;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
        }
        this.zzk((zzdgl)new zzdbi(zzdkm2));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzc() {
        synchronized (this) {
            boolean bl = this.zze;
            if (!bl) {
                return;
            }
            ScheduledFuture<?> scheduledFuture = this.zzc;
            if (scheduledFuture == null) return;
            scheduledFuture.cancel(true);
            return;
        }
    }

    public final void zzd() {
        this.zzk(zzdbj.zza);
    }

    public final void zze() {
        if (!this.zze) {
            return;
        }
        zzbjd zzbjd2 = zzbjl.zzgY;
        int n = (Integer)zzbet.zzc().zzc(zzbjd2);
        this.zzc = this.zzb.schedule((Runnable)new zzdbk(this), (long)n, TimeUnit.MILLISECONDS);
    }

    final /* synthetic */ void zzf() {
        synchronized (this) {
            com.google.android.gms.ads.internal.util.zze.zzf((String)"Timeout waiting for show call succeed to be called.");
            zzdkm zzdkm2 = new zzdkm("Timeout for show call succeed.");
            this.zzb(zzdkm2);
            this.zzd = true;
            return;
        }
    }
}
