/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaxe
 *  com.google.android.gms.internal.ads.zzaxi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaxe;
import com.google.android.gms.internal.ads.zzaxi;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

public final class zzaxj
extends zzaxe {
    private MessageDigest zzb;

    public final byte[] zza(String object) {
        Object object2;
        Object object3 = ((String)object).split(" ");
        int n = ((String[])object3).length;
        int n2 = 4;
        if (n == 1) {
            n = zzaxi.zza((String)object3[0]);
            object = ByteBuffer.allocate(4);
            ((ByteBuffer)object).order(ByteOrder.LITTLE_ENDIAN);
            ((ByteBuffer)object).putInt(n);
            object = ((ByteBuffer)object).array();
        } else if (n < 5) {
            object2 = new byte[n + n];
            n = 0;
            while (true) {
                object = object2;
                if (n < ((String[])object3).length) {
                    int n3 = zzaxi.zza((String)object3[n]);
                    n3 = n3 >> 16 ^ (char)n3;
                    object = new byte[2];
                    object[0] = (byte)n3;
                    object[1] = (byte)(n3 >> 8);
                    n3 = n + n;
                    object2[n3] = (byte)object[0];
                    object2[n3 + 1] = (byte)object[1];
                    ++n;
                    continue;
                }
                break;
            }
        } else {
            object2 = new byte[n];
            n = 0;
            while (true) {
                object = object2;
                if (n >= ((String[])object3).length) break;
                int n4 = zzaxi.zza((String)object3[n]);
                object2[n] = (byte)(n4 >> 24 ^ (n4 & 0xFF ^ n4 >> 8 & 0xFF ^ n4 >> 16 & 0xFF));
                ++n;
            }
        }
        this.zzb = this.zzb();
        object2 = this.zza;
        synchronized (object2) {
            try {
                object3 = this.zzb;
                if (object3 == null) {
                    return new byte[0];
                }
                object3.reset();
                this.zzb.update((byte[])object);
                object = this.zzb.digest();
                n = ((Object)object).length;
                if (n > 4) {
                    n = n2;
                }
                object3 = new byte[n];
                System.arraycopy(object, 0, object3, 0, n);
                return object3;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
