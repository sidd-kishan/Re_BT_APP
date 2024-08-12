/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeqe
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeqe;
import java.util.concurrent.Callable;

final class zzeqd
implements Callable {
    private final zzeqe zza;

    zzeqd(zzeqe zzeqe2) {
        this.zza = zzeqe2;
    }

    public final Object call() {
        return this.zza.zzb();
    }
}
