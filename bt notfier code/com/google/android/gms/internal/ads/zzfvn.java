/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftg
 *  com.google.android.gms.internal.ads.zzfum
 *  com.google.android.gms.internal.ads.zzgau
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftg;
import com.google.android.gms.internal.ads.zzfum;
import com.google.android.gms.internal.ads.zzgau;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzfvn
implements zzftg {
    private static final byte[] zza = new byte[0];
    private final zzgau zzb;
    private final zzftg zzc;

    public zzfvn(zzgau zzgau2, zzftg zzftg2) {
        this.zzb = zzgau2;
        this.zzc = zzftg2;
    }

    public final byte[] zza(byte[] byArray, byte[] byArray2) throws GeneralSecurityException {
        byte[] byArray3 = zzfum.zzh((zzgau)this.zzb).zzao();
        byte[] byArray4 = this.zzc.zza(byArray3, zza);
        byArray = ((zzftg)zzfum.zzj((String)this.zzb.zza(), (byte[])byArray3, zzftg.class)).zza(byArray, byArray2);
        int n = byArray4.length;
        return ByteBuffer.allocate(n + 4 + byArray.length).putInt(n).put(byArray4).put(byArray).array();
    }
}
