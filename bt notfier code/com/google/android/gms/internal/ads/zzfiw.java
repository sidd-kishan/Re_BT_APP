/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfjb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfjb;
import java.util.concurrent.Callable;

final class zzfiw
implements Callable {
    private final zzfjb zza;

    zzfiw(zzfjb zzfjb2) {
        this.zza = zzfjb2;
    }

    public final Object call() {
        return this.zza.zze();
    }
}
