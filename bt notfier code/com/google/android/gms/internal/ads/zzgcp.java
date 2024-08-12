/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgcq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgcq;
import java.security.InvalidKeyException;

final class zzgcp
extends zzgcq {
    zzgcp(byte[] byArray, int n) throws InvalidKeyException {
        super(byArray, n);
    }

    final int[] zzb(int[] nArray, int n) {
        int n2 = nArray.length;
        if (n2 != 3) throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", n2 * 32));
        int[] nArray2 = new int[16];
        zzgcq.zzf((int[])nArray2, (int[])this.zza);
        nArray2[12] = n;
        System.arraycopy(nArray, 0, nArray2, 13, 3);
        return nArray2;
    }

    final int zzc() {
        return 12;
    }
}
