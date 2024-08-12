/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaFormat
 */
package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.List;

public final class zzalq {
    public static void zza(MediaFormat mediaFormat, List<byte[]> list) {
        int n = 0;
        while (n < list.size()) {
            StringBuilder stringBuilder = new StringBuilder(15);
            stringBuilder.append("csd-");
            stringBuilder.append(n);
            mediaFormat.setByteBuffer(stringBuilder.toString(), ByteBuffer.wrap(list.get(n)));
            ++n;
        }
    }

    public static void zzb(MediaFormat mediaFormat, String string, int n) {
        if (n == -1) return;
        mediaFormat.setInteger(string, n);
    }
}
