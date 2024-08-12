/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfsl
 *  com.google.android.gms.internal.ads.zzftb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfsl;
import com.google.android.gms.internal.ads.zzftb;
import java.util.concurrent.Callable;

final class zzfta
extends zzfsl {
    final zzftb zza;
    private final Callable zzb;

    zzfta(zzftb zzftb2, Callable callable) {
        this.zza = zzftb2;
        if (callable == null) throw null;
        this.zzb = callable;
    }

    final Object zza() throws Exception {
        return this.zzb.call();
    }

    final String zzc() {
        return this.zzb.toString();
    }

    final boolean zzd() {
        return this.zza.isDone();
    }

    final void zzf(Object object) {
        this.zza.zzp(object);
    }

    final void zzg(Throwable throwable) {
        this.zza.zzq(throwable);
    }
}
