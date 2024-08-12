/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzapw {
    public final int zza;
    public final byte[] zzb;

    public zzapw(int n, byte[] byArray) {
        this.zza = 1;
        this.zzb = byArray;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzapw)object;
        if (!Arrays.equals(this.zzb, ((zzapw)object).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzb) + 31;
    }
}
