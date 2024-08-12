/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzox
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzox;

final class zztl {
    private final zzox zza;
    private long zzb;
    private boolean zzc;
    private int zzd;
    private long zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private boolean zzm;

    public zztl(zzox zzox2) {
        this.zza = zzox2;
    }

    private final void zze(int n) {
        long l = this.zzl;
        if (l == -9223372036854775807L) {
            return;
        }
        int n2 = this.zzm;
        long l2 = this.zzb;
        long l3 = this.zzk;
        this.zza.zzv(l, n2, (int)(l2 - l3), n, null);
    }

    public final void zza() {
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = false;
        this.zzj = false;
    }

    public final void zzb(long l, int n, int n2, long l2, boolean bl) {
        block8: {
            block7: {
                boolean bl2 = false;
                this.zzg = false;
                this.zzh = false;
                this.zze = l2;
                this.zzd = 0;
                this.zzb = l;
                if (n2 >= 32 && n2 != 40) {
                    if (this.zzi && !this.zzj) {
                        if (bl) {
                            this.zze(n);
                        }
                        this.zzi = false;
                    }
                    if (n2 <= 35 || n2 == 39) {
                        this.zzh = this.zzj ^ true;
                        this.zzj = true;
                    }
                }
                bl = n2 >= 16 && n2 <= 21;
                this.zzc = bl;
                if (bl) break block7;
                bl = bl2;
                if (n2 > 9) break block8;
            }
            bl = true;
        }
        this.zzf = bl;
    }

    public final void zzc(byte[] byArray, int n, int n2) {
        if (!this.zzf) return;
        int n3 = this.zzd;
        int n4 = n + 2 - n3;
        if (n4 >= n2) {
            this.zzd = n3 + (n2 - n);
            return;
        }
        boolean bl = (byArray[n4] & 0x80) != 0;
        this.zzg = bl;
        this.zzf = false;
    }

    public final void zzd(long l, int n, boolean bl) {
        if (this.zzj && this.zzg) {
            this.zzm = this.zzc;
            this.zzj = false;
            return;
        }
        if (!this.zzh) {
            if (!this.zzg) return;
        }
        if (bl && this.zzi) {
            this.zze(n + (int)(l - this.zzb));
        }
        this.zzk = this.zzb;
        this.zzl = this.zze;
        this.zzm = this.zzc;
        this.zzi = true;
    }
}
