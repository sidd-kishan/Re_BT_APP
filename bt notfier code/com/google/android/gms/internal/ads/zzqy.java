/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzny
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzny;

final class zzqy {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzamf zzf;
    private final zzamf zzg;
    private int zzh;
    private int zzi;

    public zzqy(zzamf zzamf2, zzamf zzamf3, boolean bl) throws zzaha {
        this.zzg = zzamf2;
        this.zzf = zzamf3;
        this.zze = bl;
        zzamf3.zzh(12);
        this.zza = zzamf3.zzB();
        zzamf2.zzh(12);
        this.zzi = zzamf2.zzB();
        int n = zzamf2.zzv();
        bl = true;
        if (n != 1) {
            bl = false;
        }
        zzny.zza((boolean)bl, (String)"first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        int n;
        this.zzb = n = this.zzb + 1;
        if (n == this.zza) {
            return false;
        }
        long l = this.zze ? this.zzf.zzD() : this.zzf.zzt();
        this.zzd = l;
        if (this.zzb != this.zzh) return true;
        this.zzc = this.zzg.zzB();
        this.zzg.zzk(4);
        int n2 = this.zzi;
        n = -1;
        this.zzi = --n2;
        if (n2 > 0) {
            n = -1 + this.zzg.zzB();
        }
        this.zzh = n;
        return true;
    }
}
