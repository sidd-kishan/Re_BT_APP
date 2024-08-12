/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaqj
 *  com.google.android.gms.internal.ads.zzaqm
 *  com.google.android.gms.internal.ads.zzaux
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaqj;
import com.google.android.gms.internal.ads.zzaqm;
import com.google.android.gms.internal.ads.zzaux;

final class zzaqp
implements zzaqm {
    private final zzaux zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzaqp(zzaqj zzaqj2) {
        zzaqj2 = zzaqj2.zza;
        this.zza = zzaqj2;
        zzaqj2.zzi(12);
        this.zzc = this.zza.zzu() & 0xFF;
        this.zzb = this.zza.zzu();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        int n = this.zzc;
        if (n == 8) {
            return this.zza.zzl();
        }
        if (n == 16) {
            return this.zza.zzm();
        }
        n = this.zzd;
        this.zzd = n + 1;
        if (n % 2 != 0) return this.zze & 0xF;
        this.zze = n = this.zza.zzl();
        return (n & 0xF0) >> 4;
    }

    public final boolean zzc() {
        return false;
    }
}
