/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzahe
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzahe;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;

public final class zzahf {
    public static final zzahf zza = new zzahf(1.0f, 1.0f);
    public static final zzadw<zzahf> zzd = zzahe.zza;
    public final float zzb;
    public final float zzc;
    private final int zze;

    public zzahf(float f, float f2) {
        boolean bl = true;
        boolean bl2 = f > 0.0f;
        zzakt.zza((boolean)bl2);
        bl2 = f2 > 0.0f ? bl : false;
        zzakt.zza((boolean)bl2);
        this.zzb = f;
        this.zzc = f2;
        this.zze = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzahf)object;
        if (this.zzb != ((zzahf)object).zzb) return false;
        if (this.zzc != ((zzahf)object).zzc) return false;
        return true;
    }

    public final int hashCode() {
        return (Float.floatToRawIntBits(this.zzb) + 527) * 31 + Float.floatToRawIntBits(this.zzc);
    }

    public final String toString() {
        return zzamq.zzv((String)"PlaybackParameters(speed=%.2f, pitch=%.2f)", (Object[])new Object[]{Float.valueOf(this.zzb), Float.valueOf(this.zzc)});
    }

    public final long zza(long l) {
        return l * (long)this.zze;
    }
}
