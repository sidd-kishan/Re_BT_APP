/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamn
 *  com.google.android.gms.internal.ads.zztb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zztb;

final class zzty {
    private final zztb zza;
    private final zzamn zzb;
    private final zzame zzc;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzty(zztb zztb2, zzamn zzamn2) {
        this.zza = zztb2;
        this.zzb = zzamn2;
        this.zzc = new zzame(new byte[64], 64);
    }

    public final void zza() {
        this.zzf = false;
        this.zza.zza();
    }

    public final void zzb(zzamf zzamf2) throws zzaha {
        long l;
        zzamf2.zzm(this.zzc.zza, 0, 3);
        this.zzc.zzd(0);
        this.zzc.zzf(8);
        this.zzd = this.zzc.zzg();
        this.zze = this.zzc.zzg();
        this.zzc.zzf(6);
        int n = this.zzc.zzh(8);
        zzamf2.zzm(this.zzc.zza, 0, n);
        this.zzc.zzd(0);
        if (this.zzd) {
            this.zzc.zzf(4);
            n = this.zzc.zzh(3);
            this.zzc.zzf(1);
            int n2 = this.zzc.zzh(15);
            this.zzc.zzf(1);
            l = n;
            long l2 = n2 << 15;
            long l3 = this.zzc.zzh(15);
            this.zzc.zzf(1);
            if (!this.zzf && this.zze) {
                this.zzc.zzf(4);
                n = this.zzc.zzh(3);
                this.zzc.zzf(1);
                n2 = this.zzc.zzh(15);
                this.zzc.zzf(1);
                int n3 = this.zzc.zzh(15);
                this.zzc.zzf(1);
                this.zzb.zze((long)n << 30 | (long)(n2 << 15) | (long)n3);
                this.zzf = true;
            }
            l = this.zzb.zze(l << 30 | l2 | l3);
        } else {
            l = 0L;
        }
        this.zza.zzc(l, 4);
        this.zza.zzd(zzamf2);
        this.zza.zze();
    }
}
