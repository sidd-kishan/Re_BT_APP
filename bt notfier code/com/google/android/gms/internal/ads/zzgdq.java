/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfty
 *  com.google.android.gms.internal.ads.zzfxc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfty;
import com.google.android.gms.internal.ads.zzfxc;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

public final class zzgdq
implements zzfty {
    private final zzfxc zza;
    private final int zzb;

    public zzgdq(zzfxc zzfxc2, int n) throws GeneralSecurityException {
        this.zza = zzfxc2;
        this.zzb = n;
        if (n < 10) throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        zzfxc2.zza(new byte[0], n);
    }

    public final byte[] zza(byte[] byArray) throws GeneralSecurityException {
        return this.zza.zza(byArray, this.zzb);
    }
}
