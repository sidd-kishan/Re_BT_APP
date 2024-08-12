/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzcxe
 *  com.google.android.gms.internal.ads.zzfbi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzcxe;
import com.google.android.gms.internal.ads.zzfbi;

final class zzeff
implements zzcxe {
    private final zzfbi zza;

    private zzeff(zzfbi zzfbi2) {
        this.zza = zzfbi2;
    }

    static zzcxe zzb(zzfbi zzfbi2) {
        return new zzeff(zzfbi2);
    }

    public final zzbhc zza() {
        return this.zza.zzt();
    }
}
