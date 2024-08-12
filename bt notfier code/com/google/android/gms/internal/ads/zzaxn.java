/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaxe
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaxe;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzaxn
extends zzaxe {
    private MessageDigest zzb;
    private final int zzc;
    private final int zzd;

    public zzaxn(int n) {
        int n2;
        int n3 = n2 = n >> 3;
        if ((n & 7) > 0) {
            n3 = n2 + 1;
        }
        this.zzc = n3;
        this.zzd = n;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final byte[] zza(String object) {
        Object object2 = this.zza;
        synchronized (object2) {
            Object object3 = this.zzb();
            this.zzb = object3;
            int n = 0;
            if (object3 == null) {
                return new byte[0];
            }
            ((MessageDigest)object3).reset();
            this.zzb.update(((String)object).getBytes(Charset.forName("UTF-8")));
            object3 = this.zzb.digest();
            int n2 = ((Object)object3).length;
            int n3 = this.zzc;
            int n4 = n2;
            if (n2 > n3) {
                n4 = n3;
            }
            object = new byte[n4];
            System.arraycopy(object3, 0, object, 0, n4);
            if ((this.zzd & 7) <= 0) return object;
            long l = 0L;
            while (n < n4) {
                long l2 = l;
                if (n > 0) {
                    l2 = l << 8;
                }
                l = l2 + (long)(object[n] & 0xFF);
                ++n;
            }
            {
                l >>>= 8 - (this.zzd & 7);
                n4 = this.zzc;
            }
            while (--n4 >= 0) {
                object[n4] = (byte)(0xFFL & l);
                l >>>= 8;
            }
            return object;
        }
    }
}
