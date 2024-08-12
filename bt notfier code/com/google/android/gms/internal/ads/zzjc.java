/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzjc {
    public final long zza;
    public final long zzb;

    public zzjc(long l, long l2) {
        this.zza = l;
        this.zzb = l2;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzjc)) {
            return false;
        }
        object = (zzjc)object;
        if (this.zza != ((zzjc)object).zza) return false;
        if (this.zzb != ((zzjc)object).zzb) return false;
        return true;
    }

    public final int hashCode() {
        return (int)this.zza * 31 + (int)this.zzb;
    }
}
