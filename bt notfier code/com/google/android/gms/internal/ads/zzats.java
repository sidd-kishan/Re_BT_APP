/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzatk
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzatk;
import java.util.Arrays;

public final class zzats {
    private int zza;
    private final zzatk[] zzb;

    public zzats(zzatk[] zzatkArray, byte ... byArray) {
        this.zzb = zzatkArray;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzats)object;
        return Arrays.equals(this.zzb, ((zzats)object).zzb);
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zza;
        if (n != 0) return n2;
        this.zza = n2 = Arrays.hashCode(this.zzb) + 527;
        return n2;
    }

    public final zzatk zza(int n) {
        return this.zzb[n];
    }

    public final zzatk[] zzb() {
        return (zzatk[])this.zzb.clone();
    }
}
