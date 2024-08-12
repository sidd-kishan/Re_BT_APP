/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzp;
import java.util.Arrays;

public final class zzq {
    public static final zzadw<zzq> zzb = zzp.zza;
    public final int zza;
    private final zzafv[] zzc;
    private int zzd;

    public zzq(zzafv ... zzafvArray) {
        this.zzc = zzafvArray;
        this.zza = 1;
        zzq.zzc(zzafvArray[0].zzc);
        int n = this.zzc[0].zze;
    }

    private static String zzc(String string) {
        if (string == null) return "";
        if (!string.equals("und")) return string;
        return "";
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzq)object;
        if (!Arrays.equals(this.zzc, ((zzq)object).zzc)) return false;
        return true;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zzd;
        if (n != 0) return n2;
        this.zzd = n2 = Arrays.hashCode(this.zzc) + 527;
        return n2;
    }

    public final zzafv zza(int n) {
        return this.zzc[n];
    }

    public final int zzb(zzafv zzafv2) {
        int n = 0;
        while (n <= 0) {
            if (zzafv2 == this.zzc[n]) {
                return n;
            }
            ++n;
        }
        return -1;
    }
}
