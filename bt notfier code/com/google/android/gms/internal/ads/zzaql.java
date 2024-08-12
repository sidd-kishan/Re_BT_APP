/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzaux
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzaux;

final class zzaql {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzaux zzf;
    private final zzaux zzg;
    private int zzh;
    private int zzi;

    public zzaql(zzaux zzaux2, zzaux zzaux3, boolean bl) {
        this.zzg = zzaux2;
        this.zzf = zzaux3;
        this.zze = bl;
        zzaux3.zzi(12);
        this.zza = zzaux3.zzu();
        zzaux2.zzi(12);
        this.zzi = zzaux2.zzu();
        int n = zzaux2.zzr();
        bl = true;
        if (n != 1) {
            bl = false;
        }
        zzaup.zze((boolean)bl, (Object)"first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        int n;
        this.zzb = n = this.zzb + 1;
        if (n == this.zza) {
            return false;
        }
        long l = this.zze ? this.zzf.zzv() : this.zzf.zzp();
        this.zzd = l;
        if (this.zzb != this.zzh) return true;
        this.zzc = this.zzg.zzu();
        this.zzg.zzj(4);
        int n2 = this.zzi;
        n = -1;
        this.zzi = --n2;
        if (n2 > 0) {
            n = -1 + this.zzg.zzu();
        }
        this.zzh = n;
        return true;
    }
}
