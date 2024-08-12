/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzenw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzenw;
import java.util.concurrent.Callable;

final class zzenv
implements Callable {
    private final zzenw zza;

    zzenv(zzenw zzenw2) {
        this.zza = zzenw2;
    }

    public final Object call() {
        return this.zza.zzb();
    }
}
