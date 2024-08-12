/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

final class zzie {
    public final int zza;
    public final boolean zzb;

    public zzie(int n, boolean bl) {
        this.zza = n;
        this.zzb = bl;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzie)object;
        if (this.zza != ((zzie)object).zza) return false;
        if (this.zzb != ((zzie)object).zzb) return false;
        return true;
    }

    public final int hashCode() {
        return this.zza * 31 + this.zzb;
    }
}
