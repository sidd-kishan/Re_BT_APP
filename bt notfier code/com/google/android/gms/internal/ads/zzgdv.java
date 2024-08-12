/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgcq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgcq;
import java.security.InvalidKeyException;
import java.util.Arrays;

final class zzgdv
extends zzgcq {
    zzgdv(byte[] byArray, int n) throws InvalidKeyException {
        super(byArray, n);
    }

    final int[] zzb(int[] nArray, int n) {
        int n2 = nArray.length;
        if (n2 != 6) throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", n2 * 32));
        int[] nArray2 = new int[16];
        int[] nArray3 = this.zza;
        int[] nArray4 = new int[16];
        zzgcq.zzf((int[])nArray4, (int[])nArray3);
        nArray4[12] = nArray[0];
        nArray4[13] = nArray[1];
        nArray4[14] = nArray[2];
        nArray4[15] = nArray[3];
        zzgcq.zzg((int[])nArray4);
        nArray4[4] = nArray4[12];
        nArray4[5] = nArray4[13];
        nArray4[6] = nArray4[14];
        nArray4[7] = nArray4[15];
        zzgcq.zzf((int[])nArray2, (int[])Arrays.copyOf(nArray4, 8));
        nArray2[12] = n;
        nArray2[13] = 0;
        nArray2[14] = nArray[4];
        nArray2[15] = nArray[5];
        return nArray2;
    }

    final int zzc() {
        return 24;
    }
}
