/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzepl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzepl;
import java.util.concurrent.Callable;

final class zzepk
implements Callable {
    private final zzepl zza;

    zzepk(zzepl zzepl2) {
        this.zza = zzepl2;
    }

    public final Object call() {
        return this.zza.zzb();
    }
}
