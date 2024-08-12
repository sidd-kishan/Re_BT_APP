/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzaed
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzaed;

public final class zzaee {
    public static final zzaee zza = new zzaee(0, 0, 0);
    public static final zzadw<zzaee> zze = zzaed.zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;

    public zzaee(int n, int n2, int n3) {
        this.zzb = 0;
        this.zzc = n2;
        this.zzd = n3;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzaee)) {
            return false;
        }
        object = (zzaee)object;
        int n = ((zzaee)object).zzb;
        if (this.zzc != ((zzaee)object).zzc) return false;
        if (this.zzd != ((zzaee)object).zzd) return false;
        return true;
    }

    public final int hashCode() {
        return (this.zzc + 16337) * 31 + this.zzd;
    }
}
