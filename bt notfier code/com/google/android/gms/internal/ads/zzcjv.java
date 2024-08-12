/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcjx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcjx;
import java.util.concurrent.Callable;

final class zzcjv
implements Callable {
    private final zzcjx zza;

    zzcjv(zzcjx zzcjx2) {
        this.zza = zzcjx2;
    }

    public final Object call() {
        return this.zza.zzk();
    }
}
