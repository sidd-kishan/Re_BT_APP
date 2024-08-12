/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public final class zzop {
    public static List<byte[]> zza(byte[] byArray) {
        byte by = byArray[11];
        byte by2 = byArray[10];
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>(3);
        arrayList.add(byArray);
        arrayList.add(zzop.zzb(zzop.zzc((by & 0xFF) << 8 | by2 & 0xFF)));
        arrayList.add(zzop.zzb(zzop.zzc(3840L)));
        return arrayList;
    }

    private static byte[] zzb(long l) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(l).array();
    }

    private static long zzc(long l) {
        return l * 1000000000L / 48000L;
    }
}
