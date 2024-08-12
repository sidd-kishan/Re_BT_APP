/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbla
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzerx
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzerz
 *  com.google.android.gms.internal.ads.zzesa
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbla;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzerx;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzerz;
import com.google.android.gms.internal.ads.zzesa;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzesb<T> {
    private final Set<zzery<? extends zzerx<T>>> zza;
    private final Executor zzb;

    public zzesb(Executor executor, Set<zzery<? extends zzerx<T>>> set) {
        this.zzb = executor;
        this.zza = set;
    }

    public final zzfsm<T> zza(T t) {
        ArrayList<zzfsm> arrayList = new ArrayList<zzfsm>(this.zza.size());
        Iterator<zzery<zzerx<T>>> iterator = this.zza.iterator();
        while (iterator.hasNext()) {
            zzery<? extends zzerx<T>> zzery2 = iterator.next();
            zzfsm zzfsm2 = zzery2.zza();
            if (((Boolean)zzbla.zza.zze()).booleanValue()) {
                zzfsm2.zze((Runnable)new zzerz(zzery2, zzt.zzj().elapsedRealtime()), (Executor)zzchg.zzf);
            }
            arrayList.add(zzfsm2);
        }
        return zzfsd.zzo(arrayList).zza((Callable)new zzesa(arrayList, t), this.zzb);
    }
}
