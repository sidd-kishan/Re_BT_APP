/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzgco {
    public static byte[] zza(byte[] ... byArray) throws GeneralSecurityException {
        int n;
        int n2;
        int n3 = byArray.length;
        int n4 = 0;
        for (n = 0; n < n3; n4 += n2, ++n) {
            n2 = byArray[n].length;
            if (n4 > Integer.MAX_VALUE - n2) throw new GeneralSecurityException("exceeded size limit");
        }
        byte[] byArray2 = new byte[n4];
        n3 = byArray.length;
        n = 0;
        n4 = 0;
        while (n < n3) {
            byte[] byArray3 = byArray[n];
            n2 = byArray3.length;
            System.arraycopy(byArray3, 0, byArray2, n4, n2);
            n4 += n2;
            ++n;
        }
        return byArray2;
    }

    public static final byte[] zzb(byte[] object, int n, byte[] byArray, int n2, int n3) {
        if (((byte[])object).length - n3 >= n && byArray.length - n3 >= n2) {
            byte[] byArray2 = new byte[n3];
            int n4 = 0;
            while (n4 < n3) {
                byArray2[n4] = (byte)(object[n4 + n] ^ byArray[n4 + n2]);
                ++n4;
            }
            return byArray2;
        }
        object = new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        throw object;
    }

    public static final void zzc(ByteBuffer object, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int n) {
        if (n >= 0 && byteBuffer.remaining() >= n && byteBuffer2.remaining() >= n && ((Buffer)object).remaining() >= n) {
            int n2 = 0;
            while (n2 < n) {
                ((ByteBuffer)object).put((byte)(byteBuffer.get() ^ byteBuffer2.get()));
                ++n2;
            }
            return;
        }
        object = new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        throw object;
    }

    public static final byte[] zzd(byte[] byArray, byte[] byArray2) {
        int n = byArray.length;
        if (n != byArray2.length) throw new IllegalArgumentException("The lengths of x and y should match.");
        return zzgco.zzb(byArray, 0, byArray2, 0, n);
    }
}
