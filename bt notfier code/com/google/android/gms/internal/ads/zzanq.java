/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzanq {
    public static final zzanq zza = new zzanq(1.0f, 1.0f);
    public final float zzb;
    public final float zzc;
    private final int zzd;

    public zzanq(float f, float f2) {
        this.zzb = f;
        this.zzc = 1.0f;
        this.zzd = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzanq)object;
        if (this.zzb != ((zzanq)object).zzb) return false;
        return true;
    }

    public final int hashCode() {
        return (Float.floatToRawIntBits(this.zzb) + 527) * 31 + Float.floatToRawIntBits(1.0f);
    }

    public final long zza(long l) {
        return l * (long)this.zzd;
    }
}
