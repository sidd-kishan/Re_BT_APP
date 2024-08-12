/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzni
 *  com.google.android.gms.internal.ads.zzoh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzni;
import com.google.android.gms.internal.ads.zzoh;

final class zzpf
implements zzni {
    private final zzoh zza;

    private zzpf(zzoh zzoh2) {
        this.zza = zzoh2;
    }

    static zzni zzb(zzoh zzoh2) {
        return new zzpf(zzoh2);
    }

    public final long zza(long l) {
        return this.zza.zzb(l);
    }
}
