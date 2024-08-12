/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzdc
 *  com.google.android.gms.internal.ads.zzdd
 *  com.google.android.gms.internal.ads.zzeb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzdc;
import com.google.android.gms.internal.ads.zzdd;
import com.google.android.gms.internal.ads.zzeb;
import java.nio.ByteBuffer;

final class zzeo
extends zzeb {
    private static final int zzd = Float.floatToIntBits(Float.NaN);

    zzeo() {
    }

    private static void zzo(int n, ByteBuffer byteBuffer) {
        int n2;
        double d = n;
        Double.isNaN(d);
        n = n2 = Float.floatToIntBits((float)(d * 4.656612875245797E-10));
        if (n2 == zzd) {
            n = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(n);
    }

    public final void zzc(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int n = byteBuffer.position();
        int n2 = byteBuffer.limit();
        int n3 = n2 - n;
        int n4 = this.zzb.zzd;
        if (n4 != 0x20000000) {
            if (n4 != 0x30000000) throw new IllegalStateException();
            ByteBuffer byteBuffer3 = this.zzi(n3);
            while (true) {
                byteBuffer2 = byteBuffer3;
                if (n < n2) {
                    zzeo.zzo(byteBuffer.get(n) & 0xFF | (byteBuffer.get(n + 1) & 0xFF) << 8 | (byteBuffer.get(n + 2) & 0xFF) << 16 | (byteBuffer.get(n + 3) & 0xFF) << 24, byteBuffer3);
                    n += 4;
                    continue;
                }
                break;
            }
        } else {
            ByteBuffer byteBuffer4 = this.zzi(n3 / 3 * 4);
            while (true) {
                byteBuffer2 = byteBuffer4;
                if (n >= n2) break;
                zzeo.zzo((byteBuffer.get(n) & 0xFF) << 8 | (byteBuffer.get(n + 1) & 0xFF) << 16 | (byteBuffer.get(n + 2) & 0xFF) << 24, byteBuffer4);
                n += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    public final zzdc zzk(zzdc zzdc2) throws zzdd {
        int n = zzdc2.zzd;
        if (!zzamq.zzQ((int)n)) throw new zzdd(zzdc2);
        zzdc2 = n != 4 ? new zzdc(zzdc2.zzb, zzdc2.zzc, 4) : zzdc.zza;
        return zzdc2;
    }
}
