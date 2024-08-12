/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.Objects
 */
package com.google.android.gms.ads.internal.util;

import com.google.android.gms.common.internal.Objects;

public final class zzbf {
    public final String zza;
    public final double zzb;
    public final double zzc;
    public final double zzd;
    public final int zze;

    public zzbf(String string, double d, double d2, double d3, int n) {
        this.zza = string;
        this.zzc = d;
        this.zzb = d2;
        this.zzd = d3;
        this.zze = n;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof zzbf)) {
            return false;
        }
        object = (zzbf)object;
        if (!Objects.equal((Object)this.zza, (Object)((zzbf)object).zza)) return false;
        if (this.zzb != ((zzbf)object).zzb) return false;
        if (this.zzc != ((zzbf)object).zzc) return false;
        if (this.zze != ((zzbf)object).zze) return false;
        if (Double.compare(this.zzd, ((zzbf)object).zzd) != 0) return false;
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode((Object[])new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze});
    }

    public final String toString() {
        return Objects.toStringHelper((Object)this).add("name", (Object)this.zza).add("minBound", (Object)this.zzc).add("maxBound", (Object)this.zzb).add("percent", (Object)this.zzd).add("count", (Object)this.zze).toString();
    }
}
