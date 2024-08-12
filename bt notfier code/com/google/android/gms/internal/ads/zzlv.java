/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzlv {
    private long zza;
    private long zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private long zzf;
    private final boolean[] zzg = new boolean[15];
    private int zzh;

    public final void zza() {
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzh = 0;
        Arrays.fill(this.zzg, false);
    }

    public final boolean zzb() {
        if (this.zzd <= 15L) return false;
        if (this.zzh != 0) return false;
        return true;
    }

    public final boolean zzc() {
        long l = this.zzd;
        if (l != 0L) return this.zzg[(int)((l - 1L) % 15L)];
        return false;
    }

    public final long zzd() {
        return this.zzf;
    }

    public final long zze() {
        long l = this.zze;
        if (l != 0L) return this.zzf / l;
        return 0L;
    }

    public final void zzf(long l) {
        long l2 = this.zzd;
        if (l2 == 0L) {
            this.zza = l;
        } else if (l2 == 1L) {
            this.zzb = l2 = l - this.zza;
            this.zzf = l2;
            this.zze = 1L;
        } else {
            long l3 = l - this.zzc;
            int n = (int)(l2 % 15L);
            if (Math.abs(l3 - this.zzb) <= 1000000L) {
                ++this.zze;
                this.zzf += l3;
                boolean[] blArray = this.zzg;
                if (blArray[n]) {
                    blArray[n] = false;
                    --this.zzh;
                }
            } else {
                boolean[] blArray = this.zzg;
                if (!blArray[n]) {
                    blArray[n] = true;
                    ++this.zzh;
                }
            }
        }
        ++this.zzd;
        this.zzc = l;
    }
}
