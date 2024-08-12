/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzgiz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzgiz;
import java.nio.Buffer;
import java.nio.ByteBuffer;

abstract class zzgja {
    zzgja() {
    }

    static final String zzd(ByteBuffer object, int n, int n2) throws zzggm {
        byte by;
        if ((n | n2 | ((Buffer)object).limit() - n - n2) < 0) {
            object = new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", ((Buffer)object).limit(), n, n2));
            throw object;
        }
        int n3 = n + n2;
        char[] cArray = new char[n2];
        n2 = 0;
        while (n < n3 && zzgiz.zza((byte)(by = ((ByteBuffer)object).get(n)))) {
            ++n;
            cArray[n2] = (char)by;
            ++n2;
        }
        int n4 = n2;
        n2 = n;
        n = n4;
        block1: while (n2 < n3) {
            int n5;
            n4 = n2 + 1;
            by = ((ByteBuffer)object).get(n2);
            if (!zzgiz.zza((byte)by)) {
                if (zzgiz.zzb((byte)by)) {
                    if (n4 >= n3) throw zzggm.zzl();
                    zzgiz.zzd((byte)by, (byte)((ByteBuffer)object).get(n4), (char[])cArray, (int)n);
                    n2 = n4 + 1;
                    ++n;
                    continue;
                }
                if (zzgiz.zzc((byte)by)) {
                    if (n4 >= n3 - 1) throw zzggm.zzl();
                    n2 = n4 + 1;
                    zzgiz.zze((byte)by, (byte)((ByteBuffer)object).get(n4), (byte)((ByteBuffer)object).get(n2), (char[])cArray, (int)n);
                    ++n2;
                    ++n;
                    continue;
                }
                if (n4 >= n3 - 2) throw zzggm.zzl();
                n5 = n4 + 1;
                n2 = n5 + 1;
                zzgiz.zzf((byte)by, (byte)((ByteBuffer)object).get(n4), (byte)((ByteBuffer)object).get(n5), (byte)((ByteBuffer)object).get(n2), (char[])cArray, (int)n);
                n += 2;
                ++n2;
                continue;
            }
            n2 = n + 1;
            cArray[n] = (char)by;
            n = n2;
            while (true) {
                n = n5 = n;
                n2 = ++n4;
                if (n4 >= n3) continue block1;
                by = ((ByteBuffer)object).get(n4);
                if (!zzgiz.zza((byte)by)) {
                    n = n5;
                    n2 = n4;
                    continue block1;
                }
                n = n5 + 1;
                cArray[n5] = (char)by;
            }
            break;
        }
        return new String(cArray, 0, n);
    }

    final boolean zza(byte[] byArray, int n, int n2) {
        if (this.zzb(0, byArray, n, n2) != 0) return false;
        return true;
    }

    abstract int zzb(int var1, byte[] var2, int var3, int var4);

    abstract String zzc(byte[] var1, int var2, int var3) throws zzggm;
}
