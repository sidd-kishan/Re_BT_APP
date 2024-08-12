/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class zzvj {
    static Pair<ByteBuffer, Long> zza(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22L) {
            return null;
        }
        Pair<ByteBuffer, Long> pair = zzvj.zze(randomAccessFile, 0);
        if (pair == null) return zzvj.zze(randomAccessFile, 65535);
        return pair;
    }

    public static long zzb(ByteBuffer byteBuffer) {
        zzvj.zzf(byteBuffer);
        return zzvj.zzg(byteBuffer, byteBuffer.position() + 16);
    }

    public static void zzc(ByteBuffer object, long l) {
        zzvj.zzf((ByteBuffer)object);
        int n = ((Buffer)object).position();
        if (l >= 0L && l <= 0xFFFFFFFFL) {
            ((ByteBuffer)object).putInt(((Buffer)object).position() + (n + 16), (int)l);
            return;
        }
        object = new StringBuilder(47);
        ((StringBuilder)object).append("uint32 value of out range: ");
        ((StringBuilder)object).append(l);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public static long zzd(ByteBuffer byteBuffer) {
        zzvj.zzf(byteBuffer);
        return zzvj.zzg(byteBuffer, byteBuffer.position() + 12);
    }

    /*
     * Enabled force condition propagation
     */
    private static Pair<ByteBuffer, Long> zze(RandomAccessFile object, int n) throws IOException {
        int n2;
        ByteBuffer byteBuffer;
        long l;
        block4: {
            l = ((RandomAccessFile)object).length();
            if (l < 22L) {
                return null;
            }
            byteBuffer = ByteBuffer.allocate((int)Math.min((long)n, -22L + l) + 22);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            ((RandomAccessFile)object).seek(l -= (long)byteBuffer.capacity());
            ((RandomAccessFile)object).readFully(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            zzvj.zzf(byteBuffer);
            n = byteBuffer.capacity();
            if (n < 22) return null;
            int n3 = n - 22;
            int n4 = Math.min(n3, 65535);
            n = 0;
            while (n < n4) {
                n2 = n3 - n;
                if (byteBuffer.getInt(n2) != 101010256 || (char)byteBuffer.getShort(n2 + 20) != n) {
                    ++n;
                    continue;
                }
                break block4;
            }
            return null;
        }
        n = n2;
        if (n == -1) {
            return null;
        }
        byteBuffer.position(n);
        object = byteBuffer.slice();
        ((ByteBuffer)object).order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create((Object)object, (Object)(l + (long)n));
    }

    private static void zzf(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    private static long zzg(ByteBuffer byteBuffer, int n) {
        return (long)byteBuffer.getInt(n) & 0xFFFFFFFFL;
    }
}
