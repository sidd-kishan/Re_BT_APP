/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzesf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzesf;
import java.util.concurrent.Callable;

final class zzese
implements Callable {
    private final zzesf zza;

    zzese(zzesf zzesf2) {
        this.zza = zzesf2;
    }

    public final Object call() {
        return this.zza.zzb();
    }
}
