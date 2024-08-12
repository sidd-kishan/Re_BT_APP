/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzfdz
 *  com.google.android.gms.internal.ads.zzfeb
 *  com.google.android.gms.internal.ads.zzfej
 *  com.google.android.gms.internal.ads.zzfek
 *  com.google.android.gms.internal.ads.zzfsb
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzfdz;
import com.google.android.gms.internal.ads.zzfeb;
import com.google.android.gms.internal.ads.zzfej;
import com.google.android.gms.internal.ads.zzfek;
import com.google.android.gms.internal.ads.zzfsb;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzfea {
    final zzfek zza;
    private final Object zzb;
    private final List<zzfsm<?>> zzc;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzfea(zzfek zzfek2, Object object, List list, zzfeb zzfeb2) {
        this.zza = zzfek2;
        this.zzb = object;
        this.zzc = list;
    }

    public final <O> zzfej<O> zza(Callable<O> callable) {
        zzfsb zzfsb2 = zzfsd.zzo(this.zzc);
        zzfsm zzfsm2 = zzfsb2.zza(zzfdz.zza, (Executor)zzchg.zzf);
        zzfek zzfek2 = this.zza;
        return new zzfej(zzfek2, this.zzb, null, zzfsm2, this.zzc, zzfsb2.zza(callable, (Executor)zzfek.zzb((zzfek)zzfek2)), null);
    }
}
