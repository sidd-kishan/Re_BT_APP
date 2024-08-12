/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzjg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzjg;
import java.util.Arrays;

public final class zzt {
    private int zza;
    private final zzjg[] zzb;

    public zzt(zzjg[] zzjgArray, byte ... byArray) {
        this.zzb = zzjgArray;
        int n = zzjgArray.length;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzt)object;
        return Arrays.equals(this.zzb, ((zzt)object).zzb);
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zza;
        if (n != 0) return n2;
        this.zza = n2 = Arrays.hashCode(this.zzb) + 527;
        return n2;
    }
}
