/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftg
 *  com.google.android.gms.internal.ads.zzftj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftg;
import com.google.android.gms.internal.ads.zzftj;
import java.security.GeneralSecurityException;

public final class zzfwr {
    private final zzftg zza;
    private final zzftj zzb;

    public zzfwr(zzftg zzftg2) {
        this.zza = zzftg2;
        this.zzb = null;
    }

    public zzfwr(zzftj zzftj2) {
        this.zza = null;
        this.zzb = zzftj2;
    }

    public final byte[] zza(byte[] byArray, byte[] byArray2) throws GeneralSecurityException {
        zzftg zzftg2 = this.zza;
        if (zzftg2 == null) return this.zzb.zza(byArray, byArray2);
        return zzftg2.zza(byArray, byArray2);
    }
}
