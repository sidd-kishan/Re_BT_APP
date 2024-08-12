/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzetr
 *  com.google.android.gms.internal.ads.zzets
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzetr;
import com.google.android.gms.internal.ads.zzets;
import java.util.concurrent.Callable;

final class zzetq
implements Callable {
    private final zzetr zza;

    zzetq(zzetr zzetr2) {
        this.zza = zzetr2;
    }

    public final Object call() {
        return new zzets(this.zza.zzb);
    }
}
