/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftg
 *  com.google.android.gms.internal.ads.zzfty
 *  com.google.android.gms.internal.ads.zzgco
 *  com.google.android.gms.internal.ads.zzgdl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftg;
import com.google.android.gms.internal.ads.zzfty;
import com.google.android.gms.internal.ads.zzgco;
import com.google.android.gms.internal.ads.zzgdl;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class zzgda
implements zzftg {
    private final zzgdl zza;
    private final zzfty zzb;

    public zzgda(zzgdl zzgdl2, zzfty zzfty2, int n) {
        this.zza = zzgdl2;
        this.zzb = zzfty2;
    }

    public final byte[] zza(byte[] byArray, byte[] byArray2) throws GeneralSecurityException {
        byArray = this.zza.zza(byArray);
        byte[] byArray3 = Arrays.copyOf(ByteBuffer.allocate(8).putLong(0L).array(), 8);
        return zzgco.zza((byte[][])new byte[][]{byArray, this.zzb.zza(zzgco.zza((byte[][])new byte[][]{byArray2, byArray, byArray3}))});
    }
}
