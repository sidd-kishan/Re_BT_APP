/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzflt
 *  com.google.android.gms.internal.ads.zzhf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzflt;
import com.google.android.gms.internal.ads.zzhf;
import java.util.Arrays;

public final class zzcz {
    public final long zza;
    public final zzaiq zzb;
    public final int zzc;
    public final zzhf zzd;
    public final long zze;
    public final zzaiq zzf;
    public final int zzg;
    public final zzhf zzh;
    public final long zzi;
    public final long zzj;

    public zzcz(long l, zzaiq zzaiq2, int n, zzhf zzhf2, long l2, zzaiq zzaiq3, int n2, zzhf zzhf3, long l3, long l4) {
        this.zza = l;
        this.zzb = zzaiq2;
        this.zzc = n;
        this.zzd = zzhf2;
        this.zze = l2;
        this.zzf = zzaiq3;
        this.zzg = n2;
        this.zzh = zzhf3;
        this.zzi = l3;
        this.zzj = l4;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzcz)object;
        if (this.zza != ((zzcz)object).zza) return false;
        if (this.zzc != ((zzcz)object).zzc) return false;
        if (this.zze != ((zzcz)object).zze) return false;
        if (this.zzg != ((zzcz)object).zzg) return false;
        if (this.zzi != ((zzcz)object).zzi) return false;
        if (this.zzj != ((zzcz)object).zzj) return false;
        if (!zzflt.zza((Object)this.zzb, (Object)((zzcz)object).zzb)) return false;
        if (!zzflt.zza((Object)this.zzd, (Object)((zzcz)object).zzd)) return false;
        if (!zzflt.zza((Object)this.zzf, (Object)((zzcz)object).zzf)) return false;
        if (!zzflt.zza((Object)this.zzh, (Object)((zzcz)object).zzh)) return false;
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj});
    }
}
