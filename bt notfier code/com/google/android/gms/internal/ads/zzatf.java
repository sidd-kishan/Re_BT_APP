/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzanm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzanm;
import java.util.Arrays;

public final class zzatf {
    public final int zza;
    private final zzanm[] zzb;
    private int zzc;

    public zzatf(zzanm ... zzanmArray) {
        this.zzb = zzanmArray;
        this.zza = 1;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzatf)object;
        if (!Arrays.equals(this.zzb, ((zzatf)object).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zzc;
        if (n != 0) return n2;
        this.zzc = n2 = Arrays.hashCode(this.zzb) + 527;
        return n2;
    }

    public final zzanm zza(int n) {
        return this.zzb[n];
    }

    public final int zzb(zzanm zzanm2) {
        int n = 0;
        while (n <= 0) {
            if (zzanm2 == this.zzb[n]) {
                return n;
            }
            ++n;
        }
        return -1;
    }
}
