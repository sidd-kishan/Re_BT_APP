/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfqn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfqn;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Queue;

public final class zzfqo {
    private static final OutputStream zza = new zzfqn();

    public static byte[] zza(InputStream object) throws IOException {
        if (object == null) throw null;
        ArrayDeque<byte[]> arrayDeque = new ArrayDeque<byte[]>(20);
        int n = 8192;
        int n2 = 0;
        block0: while (true) {
            int n3;
            byte[] byArray;
            int n4;
            if (n2 < 0x7FFFFFF7) {
                n4 = Math.min(n, 0x7FFFFFF7 - n2);
                byArray = new byte[n4];
                arrayDeque.add(byArray);
            } else {
                if (((InputStream)object).read() != -1) throw new OutOfMemoryError("input is too large to fit in a byte array");
                object = zzfqo.zzb(arrayDeque, 0x7FFFFFF7);
                break;
            }
            for (int i = 0; i < n4; i += n3, n2 += n3) {
                n3 = ((InputStream)object).read(byArray, i, n4 - i);
                if (n3 != -1) continue;
                object = zzfqo.zzb(arrayDeque, n2);
                break block0;
            }
            long l = n;
            if ((l += l) > Integer.MAX_VALUE) {
                n = Integer.MAX_VALUE;
                continue;
            }
            if (l < Integer.MIN_VALUE) {
                n = Integer.MIN_VALUE;
                continue;
            }
            n = (int)l;
        }
        return object;
    }

    private static byte[] zzb(Queue<byte[]> queue, int n) {
        byte[] byArray = new byte[n];
        int n2 = n;
        while (n2 > 0) {
            byte[] byArray2 = queue.remove();
            int n3 = Math.min(n2, byArray2.length);
            System.arraycopy(byArray2, 0, byArray, n - n2, n3);
            n2 -= n3;
        }
        return byArray;
    }
}
