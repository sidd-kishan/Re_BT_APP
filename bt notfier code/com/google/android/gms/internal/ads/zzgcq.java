/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgco
 *  com.google.android.gms.internal.ads.zzgdl
 *  com.google.android.gms.internal.ads.zzgds
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgco;
import com.google.android.gms.internal.ads.zzgdl;
import com.google.android.gms.internal.ads.zzgds;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

abstract class zzgcq
implements zzgdl {
    private static final int[] zzb = zzgcq.zzi(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});
    int[] zza;
    private final int zzc;

    zzgcq(byte[] byArray, int n) throws InvalidKeyException {
        if (byArray.length != 32) throw new InvalidKeyException("The key length in bytes must be 32.");
        this.zza = zzgcq.zzi(byArray);
        this.zzc = n;
    }

    static void zzf(int[] nArray, int[] nArray2) {
        int[] nArray3 = zzb;
        System.arraycopy(nArray3, 0, nArray, 0, nArray3.length);
        System.arraycopy(nArray2, 0, nArray, zzb.length, 8);
    }

    static void zzg(int[] nArray) {
        int n = 0;
        while (n < 10) {
            zzgcq.zzh(nArray, 0, 4, 8, 12);
            zzgcq.zzh(nArray, 1, 5, 9, 13);
            zzgcq.zzh(nArray, 2, 6, 10, 14);
            zzgcq.zzh(nArray, 3, 7, 11, 15);
            zzgcq.zzh(nArray, 0, 5, 10, 15);
            zzgcq.zzh(nArray, 1, 6, 11, 12);
            zzgcq.zzh(nArray, 2, 7, 8, 13);
            zzgcq.zzh(nArray, 3, 4, 9, 14);
            ++n;
        }
    }

    static void zzh(int[] nArray, int n, int n2, int n3, int n4) {
        int n5;
        nArray[n] = n5 = nArray[n] + nArray[n2];
        n5 ^= nArray[n4];
        nArray[n4] = n5 = n5 >>> -16 | n5 << 16;
        nArray[n3] = n5 = nArray[n3] + n5;
        n5 = nArray[n2] ^ n5;
        nArray[n2] = n5 = n5 >>> -12 | n5 << 12;
        nArray[n] = n5 = nArray[n] + n5;
        n = nArray[n4] ^ n5;
        nArray[n4] = n = n >>> -8 | n << 8;
        nArray[n3] = n = nArray[n3] + n;
        n = nArray[n2] ^ n;
        nArray[n2] = n >>> -7 | n << 7;
    }

    static int[] zzi(byte[] object) {
        object = ByteBuffer.wrap((byte[])object).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] nArray = new int[((Buffer)object).remaining()];
        ((IntBuffer)object).get(nArray);
        return nArray;
    }

    public final byte[] zza(byte[] byArray) throws GeneralSecurityException {
        int n = byArray.length;
        if (n > Integer.MAX_VALUE - this.zzc()) throw new GeneralSecurityException("plaintext too long");
        ByteBuffer byteBuffer = ByteBuffer.allocate(this.zzc() + n);
        this.zzd(byteBuffer, byArray);
        return byteBuffer.array();
    }

    abstract int[] zzb(int[] var1, int var2);

    abstract int zzc();

    final void zzd(ByteBuffer object, byte[] object2) throws GeneralSecurityException {
        if (((Buffer)object).remaining() - this.zzc() < ((byte[])object2).length) {
            object = new IllegalArgumentException("Given ByteBuffer output is too small");
            throw object;
        }
        byte[] byArray = zzgds.zza((int)this.zzc());
        ((ByteBuffer)object).put(byArray);
        ByteBuffer byteBuffer = ByteBuffer.wrap(object2);
        int n = byteBuffer.remaining();
        int n2 = n / 64 + 1;
        int n3 = 0;
        while (n3 < n2) {
            object2 = this.zze(byArray, this.zzc + n3);
            if (n3 == n2 - 1) {
                zzgco.zzc((ByteBuffer)object, (ByteBuffer)byteBuffer, (ByteBuffer)object2, (int)(n % 64));
            } else {
                zzgco.zzc((ByteBuffer)object, (ByteBuffer)byteBuffer, (ByteBuffer)object2, (int)64);
            }
            ++n3;
        }
    }

    final ByteBuffer zze(byte[] objectArray, int n) {
        objectArray = this.zzb(zzgcq.zzi(objectArray), n);
        Object object = (int[])objectArray.clone();
        zzgcq.zzg((int[])object);
        n = 0;
        while (true) {
            if (n >= 16) {
                object = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
                ((ByteBuffer)object).asIntBuffer().put((int[])objectArray, 0, 16);
                return object;
            }
            objectArray[n] = objectArray[n] + object[n];
            ++n;
        }
    }
}
