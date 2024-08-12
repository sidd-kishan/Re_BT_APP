/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaeg
 *  com.google.android.gms.internal.ads.zzahf
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzaiv
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzka
 *  com.google.android.gms.internal.ads.zzs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaeg;
import com.google.android.gms.internal.ads.zzahf;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzaiv;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzka;
import com.google.android.gms.internal.ads.zzs;
import java.util.List;

final class zzahd {
    private static final zzhf zzt = new zzhf(new Object());
    public final zzaiq zza;
    public final zzhf zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    public final zzaeg zzf;
    public final boolean zzg;
    public final zzs zzh;
    public final zzka zzi;
    public final List<zzaiv> zzj;
    public final zzhf zzk;
    public final boolean zzl;
    public final int zzm;
    public final zzahf zzn;
    public final boolean zzo;
    public final boolean zzp;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;

    public zzahd(zzaiq zzaiq2, zzhf zzhf2, long l, long l2, int n, zzaeg zzaeg2, boolean bl, zzs zzs2, zzka zzka2, List<zzaiv> list, zzhf zzhf3, boolean bl2, int n2, zzahf zzahf2, long l3, long l4, long l5, boolean bl3, boolean bl4) {
        this.zza = zzaiq2;
        this.zzb = zzhf2;
        this.zzc = l;
        this.zzd = l2;
        this.zze = n;
        this.zzf = zzaeg2;
        this.zzg = bl;
        this.zzh = zzs2;
        this.zzi = zzka2;
        this.zzj = list;
        this.zzk = zzhf3;
        this.zzl = bl2;
        this.zzm = n2;
        this.zzn = zzahf2;
        this.zzq = l3;
        this.zzr = l4;
        this.zzs = l5;
        this.zzo = bl3;
        this.zzp = bl4;
    }

    public static zzahd zza(zzka zzka2) {
        return new zzahd(zzaiq.zzc, zzt, -9223372036854775807L, 0L, 1, null, false, com.google.android.gms.internal.ads.zzs.zza, zzka2, (List<zzaiv>)zzfoj.zzi(), zzt, false, 0, zzahf.zza, 0L, 0L, 0L, false, false);
    }

    public static zzhf zzb() {
        return zzt;
    }

    public final zzahd zzc(zzhf zzhf2, long l, long l2, long l3, long l4, zzs zzs2, zzka zzka2, List<zzaiv> list) {
        return new zzahd(this.zza, zzhf2, l2, l3, this.zze, this.zzf, this.zzg, zzs2, zzka2, list, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, l4, l, this.zzo, this.zzp);
    }

    public final zzahd zzd(zzaiq zzaiq2) {
        return new zzahd(zzaiq2, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }

    public final zzahd zze(int n) {
        return new zzahd(this.zza, this.zzb, this.zzc, this.zzd, n, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }

    public final zzahd zzf(zzaeg zzaeg2) {
        return new zzahd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzaeg2, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }

    public final zzahd zzg(zzhf zzhf2) {
        return new zzahd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzhf2, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }

    public final zzahd zzh(boolean bl, int n) {
        return new zzahd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, bl, n, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }

    public final zzahd zzi(boolean bl) {
        return new zzahd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, bl, this.zzp);
    }
}
