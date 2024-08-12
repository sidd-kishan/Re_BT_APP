/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcxe
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcxe;

final class zzeey
implements zzcxe {
    private final zzcml zza;

    private zzeey(zzcml zzcml2) {
        this.zza = zzcml2;
    }

    static zzcxe zzb(zzcml zzcml2) {
        return new zzeey(zzcml2);
    }

    public final zzbhc zza() {
        return this.zza.zzh();
    }
}
