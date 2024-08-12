/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzatf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzatf;
import java.util.Arrays;

public final class zzatg {
    public static final zzatg zza = new zzatg(new zzatf[0]);
    public final int zzb;
    private final zzatf[] zzc;
    private int zzd;

    public zzatg(zzatf ... zzatfArray) {
        this.zzc = zzatfArray;
        this.zzb = zzatfArray.length;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzatg)object;
        if (this.zzb != ((zzatg)object).zzb) return false;
        if (!Arrays.equals(this.zzc, ((zzatg)object).zzc)) return false;
        return true;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zzd;
        if (n != 0) return n2;
        this.zzd = n2 = Arrays.hashCode(this.zzc);
        return n2;
    }

    public final zzatf zza(int n) {
        return this.zzc[n];
    }

    public final int zzb(zzatf zzatf2) {
        int n = 0;
        while (n < this.zzb) {
            if (this.zzc[n] == zzatf2) {
                return n;
            }
            ++n;
        }
        return -1;
    }
}
