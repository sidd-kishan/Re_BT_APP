/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzebn
 *  com.google.android.gms.internal.ads.zzebp
 *  com.google.android.gms.internal.ads.zzebt
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebn;
import com.google.android.gms.internal.ads.zzebp;
import com.google.android.gms.internal.ads.zzebt;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Callable;

final class zzebd
implements Callable {
    private final zzfsm zza;
    private final zzfsm zzb;

    zzebd(zzfsm zzfsm2, zzfsm zzfsm3) {
        this.zza = zzfsm2;
        this.zzb = zzfsm3;
    }

    public final Object call() {
        zzfsm zzfsm2 = this.zza;
        zzfsm zzfsm3 = this.zzb;
        return new zzebp((zzebt)zzfsm2.get(), ((zzebn)zzfsm3.get()).zzb, ((zzebn)zzfsm3.get()).zza);
    }
}
