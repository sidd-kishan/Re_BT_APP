/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzebq
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzebq;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Callable;

final class zzebi
implements Callable {
    private final zzebq zza;
    private final zzfsm zzb;
    private final zzfsm zzc;
    private final zzcbj zzd;

    zzebi(zzebq zzebq2, zzfsm zzfsm2, zzfsm zzfsm3, zzcbj zzcbj2) {
        this.zza = zzebq2;
        this.zzb = zzfsm2;
        this.zzc = zzfsm3;
        this.zzd = zzcbj2;
    }

    public final Object call() {
        return this.zza.zzj(this.zzb, this.zzc, this.zzd);
    }
}
