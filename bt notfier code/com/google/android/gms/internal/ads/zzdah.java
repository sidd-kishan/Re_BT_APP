/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdai
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdai;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Callable;

final class zzdah
implements Callable {
    private final zzdai zza;
    private final zzfsm zzb;

    zzdah(zzdai zzdai2, zzfsm zzfsm2) {
        this.zza = zzdai2;
        this.zzb = zzfsm2;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb);
    }
}
