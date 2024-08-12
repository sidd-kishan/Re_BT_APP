/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzagc
 *  com.google.android.gms.internal.ads.zzagi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzagc;
import com.google.android.gms.internal.ads.zzagi;

public final class zzagd {
    public static final zzadw<zzagd> zzf = zzagc.zza;
    public final long zza;
    public final long zzb = Long.MIN_VALUE;
    public final boolean zzc;
    public final boolean zzd;
    public final boolean zze;

    /* synthetic */ zzagd(long l, long l2, boolean bl, boolean bl2, boolean bl3, zzagi zzagi2) {
        this.zza = 0L;
        this.zzc = false;
        this.zzd = false;
        this.zze = false;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzagd)) {
            return false;
        }
        object = (zzagd)object;
        long l = ((zzagd)object).zza;
        l = ((zzagd)object).zzb;
        boolean bl = ((zzagd)object).zzc;
        bl = ((zzagd)object).zzd;
        bl = ((zzagd)object).zze;
        return true;
    }

    public final int hashCode() {
        return (int)-9223372034707292160L * 29791;
    }
}
