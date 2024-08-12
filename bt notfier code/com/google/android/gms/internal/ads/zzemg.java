/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzemh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzemh;
import java.util.concurrent.Callable;

final class zzemg
implements Callable {
    private final zzemh zza;

    zzemg(zzemh zzemh2) {
        this.zza = zzemh2;
    }

    public final Object call() {
        return this.zza.zzb();
    }
}
