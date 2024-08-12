/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzxo {
    public static long zza(ByteBuffer byteBuffer) {
        long l;
        long l2 = l = (long)byteBuffer.getInt();
        if (l >= 0L) return l2;
        l2 = l + 0x100000000L;
        return l2;
    }

    public static int zzb(ByteBuffer byteBuffer) {
        return (zzxo.zzc(byteBuffer.get()) << 8) + zzxo.zzc(byteBuffer.get());
    }

    public static int zzc(byte n) {
        int n2 = n;
        if (n >= 0) return n2;
        n2 = n + 256;
        return n2;
    }

    public static long zzd(ByteBuffer byteBuffer) {
        long l = zzxo.zza(byteBuffer) << 32;
        if (l < 0L) throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
        return l + zzxo.zza(byteBuffer);
    }

    public static double zze(ByteBuffer byteBuffer) {
        byte[] byArray = new byte[4];
        byteBuffer.get(byArray);
        double d = byArray[0] << 24 & 0xFF000000 | byArray[1] << 16 & 0xFF0000 | byArray[2] << 8 & 0xFF00 | byArray[3] & 0xFF;
        Double.isNaN(d);
        return d / 65536.0;
    }

    public static double zzf(ByteBuffer byteBuffer) {
        byte[] byArray = new byte[4];
        byteBuffer.get(byArray);
        double d = byArray[0] << 24 & 0xFF000000 | byArray[1] << 16 & 0xFF0000 | byArray[2] << 8 & 0xFF00 | byArray[3] & 0xFF;
        Double.isNaN(d);
        return d / 1.073741824E9;
    }
}
