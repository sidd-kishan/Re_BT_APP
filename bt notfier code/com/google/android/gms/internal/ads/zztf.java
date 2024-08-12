/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzox
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzox;

final class zztf {
    private final zzox zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private int zze;
    private int zzf;
    private long zzg;
    private long zzh;

    public zztf(zzox zzox2) {
        this.zza = zzox2;
    }

    public final void zza() {
        this.zzb = false;
        this.zzc = false;
        this.zzd = false;
        this.zze = -1;
    }

    /*
     * Unable to fully structure code
     */
    public final void zzb(int var1_1, long var2_2) {
        this.zze = var1_1;
        this.zzd = false;
        var6_3 = true;
        var4_4 = var1_1;
        if (var1_1 == 182) ** GOTO lbl10
        if (var1_1 != 179) {
            var5_5 = false;
        } else {
            var4_4 = 179;
lbl10:
            // 2 sources

            var5_5 = true;
            var1_1 = var4_4;
        }
        this.zzb = var5_5;
        var5_5 = var1_1 == 182 ? var6_3 : false;
        this.zzc = var5_5;
        this.zzf = 0;
        this.zzh = var2_2;
    }

    public final void zzc(byte[] byArray, int n, int n2) {
        if (!this.zzc) return;
        int n3 = this.zzf;
        int n4 = n + 1 - n3;
        if (n4 >= n2) {
            this.zzf = n3 + (n2 - n);
            return;
        }
        boolean bl = (byArray[n4] & 0xC0) >> 6 == 0;
        this.zzd = bl;
        this.zzc = false;
    }

    public final void zzd(long l, int n, boolean bl) {
        long l2;
        if (this.zze == 182 && bl && this.zzb && (l2 = this.zzh) != -9223372036854775807L) {
            long l3 = this.zzg;
            int n2 = this.zzd;
            this.zza.zzv(l2, n2, (int)(l - l3), n, null);
        }
        if (this.zze == 179) return;
        this.zzg = l;
    }
}
