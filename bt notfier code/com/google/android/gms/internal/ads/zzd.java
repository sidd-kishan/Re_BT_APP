/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zza
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zza;
import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzc;
import java.util.Arrays;

public final class zzd {
    public static final zzd zza = new zzd(null, new zzc[0], 0L, -9223372036854775807L, 0);
    public static final zzadw<zzd> zzc;
    private static final zzc zzd;
    public final long zzb;
    private final zzc[] zze;

    static {
        zzd = new zzc(0L).zzb(0);
        zzc = com.google.android.gms.internal.ads.zza.zza;
    }

    private zzd(Object object, zzc[] zzcArray, long l, long l2, int n) {
        this.zzb = 0L;
        this.zze = zzcArray;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzd)object;
        if (!zzamq.zzc(null, null)) return false;
        if (!Arrays.equals(this.zze, ((zzd)object).zze)) return false;
        return true;
    }

    public final int hashCode() {
        return (int)-9223372036854775807L * 961 + Arrays.hashCode(this.zze);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdPlaybackState(adsId=");
        stringBuilder.append((Object)null);
        stringBuilder.append(", adResumePositionUs=0, adGroups=[");
        stringBuilder.append("])");
        return stringBuilder.toString();
    }

    public final zzc zza(int n) {
        zzc zzc2 = n < 0 ? zzd : this.zze[n];
        return zzc2;
    }
}
