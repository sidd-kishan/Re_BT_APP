/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfrp
 *  com.google.android.gms.internal.ads.zzfrq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfrp;
import com.google.android.gms.internal.ads.zzfrq;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

final class zzfro
extends zzfrp {
    final zzfrq zza;
    private final Callable zzc;

    zzfro(zzfrq zzfrq2, Callable callable, Executor executor) {
        this.zza = zzfrq2;
        super(zzfrq2, executor);
        if (callable == null) throw null;
        this.zzc = callable;
    }

    final Object zza() throws Exception {
        return this.zzc.call();
    }

    final void zzb(Object object) {
        this.zza.zzp(object);
    }

    final String zzc() {
        return this.zzc.toString();
    }
}
