/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzept
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzept;
import java.util.concurrent.Callable;

final class zzeps
implements Callable {
    private final zzept zza;

    zzeps(zzept zzept2) {
        this.zza = zzept2;
    }

    public final Object call() {
        return this.zza.zzb();
    }
}
