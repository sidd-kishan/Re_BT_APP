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

final class zzes
extends zzeb {
    zzes() {
    }

    public final void zzc(ByteBuffer byteBuffer) {
        int n;
        int n2;
        int n3;
        int n4;
        block15: {
            block13: {
                block14: {
                    int n5;
                    block16: {
                        n4 = byteBuffer.position();
                        n3 = byteBuffer.limit();
                        n2 = n3 - n4;
                        n5 = this.zzb.zzd;
                        n = n2;
                        if (n5 == 3) break block13;
                        if (n5 == 4) break block14;
                        n = n2;
                        if (n5 == 0x10000000) break block15;
                        if (n5 != 0x20000000) break block16;
                        n = n2 / 3;
                        break block13;
                    }
                    if (n5 != 0x30000000) throw new IllegalStateException();
                }
                n = n2 / 2;
                break block15;
            }
            n += n;
        }
        ByteBuffer byteBuffer2 = this.zzi(n);
        n2 = this.zzb.zzd;
        if (n2 != 3) {
            if (n2 != 4) {
                if (n2 != 0x10000000) {
                    if (n2 != 0x20000000) {
                        if (n2 != 0x30000000) throw new IllegalStateException();
                        while (n4 < n3) {
                            byteBuffer2.put(byteBuffer.get(n4 + 2));
                            byteBuffer2.put(byteBuffer.get(n4 + 3));
                            n4 += 4;
                        }
                    } else {
                        for (n = n4; n < n3; n += 3) {
                            byteBuffer2.put(byteBuffer.get(n + 1));
                            byteBuffer2.put(byteBuffer.get(n + 2));
                        }
                    }
                } else {
                    for (n = n4; n < n3; n += 2) {
                        byteBuffer2.put(byteBuffer.get(n + 1));
                        byteBuffer2.put(byteBuffer.get(n));
                    }
                }
            } else {
                for (n = n4; n < n3; n += 4) {
                    n4 = (short)(zzamq.zzz((float)byteBuffer.getFloat(n), (float)-1.0f, (float)1.0f) * 32767.0f);
                    byteBuffer2.put((byte)(n4 & 0xFF));
                    byteBuffer2.put((byte)(n4 >> 8 & 0xFF));
                }
            }
        } else {
            for (n = n4; n < n3; ++n) {
                byteBuffer2.put((byte)0);
                byteBuffer2.put((byte)((byteBuffer.get(n) & 0xFF) - 128));
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    /*
     * Enabled force condition propagation
     */
    public final zzdc zzk(zzdc zzdc2) throws zzdd {
        int n = zzdc2.zzd;
        if (n == 3) return new zzdc(zzdc2.zzb, zzdc2.zzc, 2);
        if (n == 2) {
            return zzdc.zza;
        }
        if (n == 0x10000000) return new zzdc(zzdc2.zzb, zzdc2.zzc, 2);
        if (n == 0x20000000) return new zzdc(zzdc2.zzb, zzdc2.zzc, 2);
        if (n == 0x30000000) return new zzdc(zzdc2.zzb, zzdc2.zzc, 2);
        if (n != 4) throw new zzdd(zzdc2);
        return new zzdc(zzdc2.zzb, zzdc2.zzc, 2);
    }
}
