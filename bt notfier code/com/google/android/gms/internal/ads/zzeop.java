/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeos
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeos;
import java.util.concurrent.Callable;

final class zzeop
implements Callable {
    private final zzeos zza;

    zzeop(zzeos zzeos2) {
        this.zza = zzeos2;
    }

    public final Object call() {
        return this.zza.zzb();
    }
}
