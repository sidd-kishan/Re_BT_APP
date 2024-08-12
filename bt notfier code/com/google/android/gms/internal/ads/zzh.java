/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzh {
    public final int zza;
    public final float zzb;

    public zzh(int n, float f) {
        this.zza = 0;
        this.zzb = 0.0f;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzh)object;
        if (Float.compare(0.0f, 0.0f) != 0) return false;
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(0.0f) + 16337;
    }
}
