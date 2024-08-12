/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzqw
 *  com.google.android.gms.internal.ads.zzqz
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzqw;
import com.google.android.gms.internal.ads.zzqz;

final class zzrb
implements zzqz {
    private final int zza;
    private final int zzb;
    private final zzamf zzc;

    public zzrb(zzqw object, zzafv zzafv2) {
        int n;
        int n2;
        block4: {
            int n3;
            block5: {
                object = ((zzqw)object).zza;
                this.zzc = object;
                object.zzh(12);
                n2 = n3 = this.zzc.zzB();
                if (!"audio/raw".equals(zzafv2.zzl)) break block4;
                n = zzamq.zzS((int)zzafv2.zzA, (int)zzafv2.zzy);
                if (n3 == 0) break block5;
                n2 = n3;
                if (n3 % n == 0) break block4;
            }
            object = new StringBuilder(88);
            ((StringBuilder)object).append("Audio sample size mismatch. stsd sample size: ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(", stsz sample size: ");
            ((StringBuilder)object).append(n3);
            Log.w((String)"AtomParsers", (String)((StringBuilder)object).toString());
            n2 = n;
        }
        n = n2;
        if (n2 == 0) {
            n = -1;
        }
        this.zza = n;
        this.zzb = this.zzc.zzB();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        int n;
        int n2 = n = this.zza;
        if (n != -1) return n2;
        n2 = this.zzc.zzB();
        return n2;
    }
}
