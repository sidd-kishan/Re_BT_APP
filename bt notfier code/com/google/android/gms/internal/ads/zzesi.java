/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzesj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzesj;
import java.util.concurrent.Callable;

final class zzesi
implements Callable {
    private final zzesj zza;

    zzesi(zzesj zzesj2) {
        this.zza = zzesj2;
    }

    public final Object call() {
        return this.zza.zzb();
    }
}
