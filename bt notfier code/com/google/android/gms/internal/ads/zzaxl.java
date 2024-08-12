/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzaxl {
    final long zza;
    final String zzb;
    final int zzc;

    zzaxl(long l, String string, int n) {
        this.zza = l;
        this.zzb = string;
        this.zzc = n;
    }

    public final boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof zzaxl)) {
            return false;
        }
        object = (zzaxl)object;
        if (((zzaxl)object).zza != this.zza) return false;
        if (((zzaxl)object).zzc != this.zzc) return false;
        return true;
    }

    public final int hashCode() {
        return (int)this.zza;
    }
}
