/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfrj
 *  com.google.android.gms.internal.ads.zzfsl
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzftb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfrj;
import com.google.android.gms.internal.ads.zzfsl;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzftb;

final class zzfsz
extends zzfsl<zzfsm> {
    final zzftb zza;
    private final zzfrj zzb;

    zzfsz(zzftb zzftb2, zzfrj zzfrj2) {
        this.zza = zzftb2;
        if (zzfrj2 == null) throw null;
        this.zzb = zzfrj2;
    }

    final String zzc() {
        return this.zzb.toString();
    }

    final boolean zzd() {
        return this.zza.isDone();
    }

    final void zzg(Throwable throwable) {
        this.zza.zzq(throwable);
    }
}
