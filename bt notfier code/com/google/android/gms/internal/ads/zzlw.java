/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzlv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzlv;

final class zzlw {
    private zzlv zza = new zzlv();
    private zzlv zzb = new zzlv();
    private boolean zzc;
    private long zzd = -9223372036854775807L;
    private int zze;

    public final void zza() {
        this.zza.zza();
        this.zzb.zza();
        this.zzc = false;
        this.zzd = -9223372036854775807L;
        this.zze = 0;
    }

    public final void zzb(long l) {
        this.zza.zzf(l);
        boolean bl = this.zza.zzb();
        int n = 0;
        if (bl) {
            this.zzc = false;
        } else if (this.zzd != -9223372036854775807L) {
            if (!this.zzc || this.zzb.zzc()) {
                this.zzb.zza();
                this.zzb.zzf(this.zzd);
            }
            this.zzc = true;
            this.zzb.zzf(l);
        }
        if (this.zzc && this.zzb.zzb()) {
            zzlv zzlv2 = this.zza;
            this.zza = this.zzb;
            this.zzb = zzlv2;
            this.zzc = false;
        }
        this.zzd = l;
        if (!this.zza.zzb()) {
            n = this.zze + 1;
        }
        this.zze = n;
    }

    public final boolean zzc() {
        return this.zza.zzb();
    }

    public final int zzd() {
        return this.zze;
    }

    public final long zze() {
        if (!this.zza.zzb()) return -9223372036854775807L;
        return this.zza.zzd();
    }

    public final long zzf() {
        if (!this.zza.zzb()) return -9223372036854775807L;
        return this.zza.zze();
    }

    public final float zzg() {
        if (!this.zza.zzb()) return -1.0f;
        double d = this.zza.zze();
        Double.isNaN(d);
        return (float)(1.0E9 / d);
    }
}
