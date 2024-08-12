/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzblj
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzcxn
 *  com.google.android.gms.internal.ads.zzcxo
 *  com.google.android.gms.internal.ads.zzcxp
 *  com.google.android.gms.internal.ads.zzcxq
 *  com.google.android.gms.internal.ads.zzcxr
 *  com.google.android.gms.internal.ads.zzcxs
 *  com.google.android.gms.internal.ads.zzcxt
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzcxn;
import com.google.android.gms.internal.ads.zzcxo;
import com.google.android.gms.internal.ads.zzcxp;
import com.google.android.gms.internal.ads.zzcxq;
import com.google.android.gms.internal.ads.zzcxr;
import com.google.android.gms.internal.ads.zzcxs;
import com.google.android.gms.internal.ads.zzcxt;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcxu {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzfsm<zzcxn> zzc;
    private volatile boolean zzd = true;

    public zzcxu(Executor executor, ScheduledExecutorService scheduledExecutorService, zzfsm<zzcxn> zzfsm2) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzfsm2;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ void zzb(zzcxu zzcxu2, List list, zzfrz zzfrz2) {
        if (list != null && !list.isEmpty()) {
            zzfsm zzfsm2 = zzfsd.zza(null);
            Iterator iterator = list.iterator();
            list = zzfsm2;
            while (true) {
                if (!iterator.hasNext()) {
                    zzfsd.zzp((zzfsm)list, (zzfrz)new zzcxt(zzcxu2, zzfrz2), (Executor)zzcxu2.zza);
                    return;
                }
                zzfsm2 = (zzfsm)iterator.next();
                list = zzfsd.zzi((zzfsm)zzfsd.zzg((zzfsm)list, Throwable.class, (zzfrk)new zzcxp(zzfrz2), (Executor)zzcxu2.zza), (zzfrk)new zzcxq(zzcxu2, zzfrz2, zzfsm2), (Executor)zzcxu2.zza);
            }
        }
        zzcxu2.zza.execute((Runnable)new zzcxo(zzfrz2));
    }

    static /* synthetic */ void zzd(zzcxu zzcxu2) {
        zzchg.zze.execute((Runnable)new zzcxr(zzcxu2));
    }

    public final void zza(zzfrz<zzcxg> zzfrz2) {
        zzfsd.zzp(this.zzc, (zzfrz)new zzcxs(this, zzfrz2), (Executor)this.zza);
    }

    public final boolean zzc() {
        return this.zzd;
    }

    final /* synthetic */ void zze() {
        this.zzd = false;
    }

    final /* synthetic */ zzfsm zzf(zzfrz zzfrz2, zzfsm zzfsm2, zzcxg zzcxg2) throws Exception {
        if (zzcxg2 == null) return zzfsd.zzh((zzfsm)zzfsm2, (long)((Long)zzblj.zzb.zze()), (TimeUnit)TimeUnit.MILLISECONDS, (ScheduledExecutorService)this.zzb);
        zzfrz2.zzb((Object)zzcxg2);
        return zzfsd.zzh((zzfsm)zzfsm2, (long)((Long)zzblj.zzb.zze()), (TimeUnit)TimeUnit.MILLISECONDS, (ScheduledExecutorService)this.zzb);
    }
}
