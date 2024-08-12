/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfrq
 *  com.google.android.gms.internal.ads.zzfsc
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfrq;
import com.google.android.gms.internal.ads.zzfsc;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzfsb<V> {
    private final boolean zza;
    private final zzfoj<zzfsm<? extends V>> zzb;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzfsb(boolean bl, zzfoj zzfoj2, zzfsc zzfsc2) {
        this.zza = bl;
        this.zzb = zzfoj2;
    }

    public final <C> zzfsm<C> zza(Callable<C> callable, Executor executor) {
        return new zzfrq(this.zzb, this.zza, executor, callable);
    }
}
