/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzq
 *  com.google.android.gms.internal.ads.zzr
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzq;
import com.google.android.gms.internal.ads.zzr;
import java.util.Arrays;

public final class zzs {
    public static final zzs zza = new zzs(new zzq[0]);
    public static final zzadw<zzs> zzc = zzr.zza;
    public final int zzb;
    private final zzq[] zzd;
    private int zze;

    public zzs(zzq ... zzqArray) {
        this.zzd = zzqArray;
        this.zzb = zzqArray.length;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzs)object;
        if (this.zzb != ((zzs)object).zzb) return false;
        if (!Arrays.equals(this.zzd, ((zzs)object).zzd)) return false;
        return true;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zze;
        if (n != 0) return n2;
        this.zze = n2 = Arrays.hashCode(this.zzd);
        return n2;
    }

    public final zzq zza(int n) {
        return this.zzd[n];
    }

    public final int zzb(zzq zzq2) {
        int n = 0;
        while (n < this.zzb) {
            if (this.zzd[n] == zzq2) {
                return n;
            }
            ++n;
        }
        return -1;
    }
}
