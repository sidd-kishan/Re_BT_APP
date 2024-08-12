/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeto
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeto;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Callable;

final class zzetm
implements Callable {
    private final zzfsm zza;
    private final zzfsm zzb;

    zzetm(zzfsm zzfsm2, zzfsm zzfsm3) {
        this.zza = zzfsm2;
        this.zzb = zzfsm3;
    }

    public final Object call() {
        zzfsm zzfsm2 = this.zza;
        zzfsm zzfsm3 = this.zzb;
        return new zzeto((String)zzfsm2.get(), (String)zzfsm3.get());
    }
}
