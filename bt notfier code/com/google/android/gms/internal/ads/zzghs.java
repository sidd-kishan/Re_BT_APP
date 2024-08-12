/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzghf
 *  com.google.android.gms.internal.ads.zzghi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzghf;
import com.google.android.gms.internal.ads.zzghi;

final class zzghs
implements zzghf {
    private final zzghi zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    zzghs(zzghi zzghi2, String string, Object[] objectArray) {
        this.zza = zzghi2;
        this.zzb = string;
        this.zzc = objectArray;
        int n = string.charAt(0);
        if (n < 55296) {
            this.zzd = n;
            return;
        }
        int n2 = n & 0x1FFF;
        int n3 = 13;
        n = 1;
        while (true) {
            char c;
            if ((c = string.charAt(n)) < '\ud800') {
                this.zzd = n2 | c << n3;
                return;
            }
            n2 |= (c & 0x1FFF) << n3;
            n3 += 13;
            ++n;
        }
    }

    public final boolean zza() {
        if ((this.zzd & 2) != 2) return false;
        return true;
    }

    public final zzghi zzb() {
        return this.zza;
    }

    public final int zzc() {
        if ((this.zzd & 1) != 1) return 2;
        return 1;
    }

    final String zzd() {
        return this.zzb;
    }

    final Object[] zze() {
        return this.zzc;
    }
}
