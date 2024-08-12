/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.measurement;

final class zzhc {
    private final Object zza;
    private final int zzb;

    zzhc(Object object, int n) {
        this.zza = object;
        this.zzb = n;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof zzhc)) {
            return false;
        }
        object = (zzhc)object;
        if (this.zza != ((zzhc)object).zza) return false;
        if (this.zzb != ((zzhc)object).zzb) return false;
        return true;
    }

    public final int hashCode() {
        return System.identityHashCode(this.zza) * 65535 + this.zzb;
    }
}
