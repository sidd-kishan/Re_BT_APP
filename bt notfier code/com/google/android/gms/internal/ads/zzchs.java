/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzchn
 *  com.google.android.gms.internal.ads.zzchp
 *  com.google.android.gms.internal.ads.zzchq
 *  com.google.android.gms.internal.ads.zzchr
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzchn;
import com.google.android.gms.internal.ads.zzchp;
import com.google.android.gms.internal.ads.zzchq;
import com.google.android.gms.internal.ads.zzchr;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public class zzchs<T> {
    private final zzchl<T> zza = new zzchl();
    private final AtomicInteger zzb = new AtomicInteger(0);

    public zzchs() {
        zzfsd.zzp(this.zza, (zzfrz)new zzchq(this), (Executor)zzchg.zzf);
    }

    static /* synthetic */ AtomicInteger zze(zzchs zzchs2) {
        return zzchs2.zzb;
    }

    @Deprecated
    public final void zzf(zzchp<T> zzchp2, zzchn zzchn2) {
        zzfsd.zzp(this.zza, (zzfrz)new zzchr(this, zzchp2, zzchn2), (Executor)zzchg.zzf);
    }

    @Deprecated
    public final void zzg(T t) {
        this.zza.zzc(t);
    }

    @Deprecated
    public final void zzh() {
        this.zza.zzd((Throwable)new Exception());
    }

    @Deprecated
    public final int zzi() {
        return this.zzb.get();
    }
}
