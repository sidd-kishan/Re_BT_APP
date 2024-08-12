/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzefw
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefw;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import java.util.concurrent.Callable;

final class zzeft
implements Callable {
    private final zzefw zza;
    private final zzfal zzb;
    private final zzezz zzc;

    zzeft(zzefw zzefw2, zzfal zzfal2, zzezz zzezz2) {
        this.zza = zzefw2;
        this.zzb = zzfal2;
        this.zzc = zzezz2;
    }

    public final Object call() {
        return this.zza.zze(this.zzb, this.zzc);
    }
}
