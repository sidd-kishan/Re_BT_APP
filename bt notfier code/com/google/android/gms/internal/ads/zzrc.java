/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzqw
 *  com.google.android.gms.internal.ads.zzqz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzqw;
import com.google.android.gms.internal.ads.zzqz;

final class zzrc
implements zzqz {
    private final zzamf zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzrc(zzqw zzqw2) {
        zzqw2 = zzqw2.zza;
        this.zza = zzqw2;
        zzqw2.zzh(12);
        this.zzc = this.zza.zzB() & 0xFF;
        this.zzb = this.zza.zzB();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return -1;
    }

    public final int zzc() {
        int n = this.zzc;
        if (n == 8) {
            return this.zza.zzn();
        }
        if (n == 16) {
            return this.zza.zzo();
        }
        n = this.zzd;
        this.zzd = n + 1;
        if (n % 2 != 0) return this.zze & 0xF;
        this.zze = n = this.zza.zzn();
        return (n & 0xF0) >> 4;
    }
}
