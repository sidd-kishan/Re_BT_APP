/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfea
 *  com.google.android.gms.internal.ads.zzfej
 *  com.google.android.gms.internal.ads.zzfel
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfea;
import com.google.android.gms.internal.ads.zzfej;
import com.google.android.gms.internal.ads.zzfel;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

public abstract class zzfek<E> {
    private static final zzfsm<?> zza = zzfsd.zza(null);
    private final zzfsn zzb;
    private final ScheduledExecutorService zzc;
    private final zzfel<E> zzd;

    public zzfek(zzfsn zzfsn2, ScheduledExecutorService scheduledExecutorService, zzfel<E> zzfel2) {
        this.zzb = zzfsn2;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfel2;
    }

    static /* synthetic */ zzfsm zza() {
        return zza;
    }

    static /* synthetic */ zzfsn zzb(zzfek zzfek2) {
        return zzfek2.zzb;
    }

    static /* synthetic */ ScheduledExecutorService zzc(zzfek zzfek2) {
        return zzfek2.zzc;
    }

    static /* synthetic */ zzfel zzd(zzfek zzfek2) {
        return zzfek2.zzd;
    }

    public final <I> zzfej<I> zze(E e, zzfsm<I> zzfsm2) {
        return new zzfej(this, e, null, zzfsm2, Collections.singletonList(zzfsm2), zzfsm2, null);
    }

    public final zzfea zzf(E e, zzfsm<?> ... zzfsmArray) {
        return new zzfea(this, e, Arrays.asList(zzfsmArray), null);
    }

    protected abstract String zzg(E var1);
}
