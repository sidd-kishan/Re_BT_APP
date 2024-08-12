/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

final class zzgfl {
    private final Object zza;
    private final int zzb;

    zzgfl(Object object, int n) {
        this.zza = object;
        this.zzb = n;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof zzgfl)) {
            return false;
        }
        object = (zzgfl)object;
        if (this.zza != ((zzgfl)object).zza) return false;
        if (this.zzb != ((zzgfl)object).zzb) return false;
        return true;
    }

    public final int hashCode() {
        return System.identityHashCode(this.zza) * 65535 + this.zzb;
    }
}
