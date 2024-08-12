/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzagg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzagg;

public final class zzagh {
    public static final zzagh zza = new zzagh(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, -3.4028235E38f, -3.4028235E38f);
    public static final zzadw<zzagh> zzg = zzagg.zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final float zze;
    public final float zzf;

    public zzagh(long l, long l2, long l3, float f, float f2) {
        this.zzb = -9223372036854775807L;
        this.zzc = -9223372036854775807L;
        this.zzd = -9223372036854775807L;
        this.zze = -3.4028235E38f;
        this.zzf = -3.4028235E38f;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzagh)) {
            return false;
        }
        object = (zzagh)object;
        long l = ((zzagh)object).zzb;
        l = ((zzagh)object).zzc;
        l = ((zzagh)object).zzd;
        float f = ((zzagh)object).zze;
        f = ((zzagh)object).zzf;
        return true;
    }

    public final int hashCode() {
        int n = (int)-9223372034707292159L;
        return (((n * 31 + n) * 31 + n) * 31 + Float.floatToIntBits(-3.4028235E38f)) * 31 + Float.floatToIntBits(-3.4028235E38f);
    }
}
