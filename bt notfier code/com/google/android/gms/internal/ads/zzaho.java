/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzagk
 *  com.google.android.gms.internal.ads.zzahn
 *  com.google.android.gms.internal.ads.zzflt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzahn;
import com.google.android.gms.internal.ads.zzflt;
import java.util.Arrays;

public final class zzaho {
    public static final zzadw<zzaho> zzj = zzahn.zza;
    public final Object zza;
    public final int zzb;
    public final zzagk zzc;
    public final Object zzd;
    public final int zze;
    public final long zzf;
    public final long zzg;
    public final int zzh;
    public final int zzi;

    public zzaho(Object object, int n, zzagk zzagk2, Object object2, int n2, long l, long l2, int n3, int n4) {
        this.zza = object;
        this.zzb = n;
        this.zzc = zzagk2;
        this.zzd = object2;
        this.zze = n2;
        this.zzf = l;
        this.zzg = l2;
        this.zzh = n3;
        this.zzi = n4;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzaho)object;
        if (this.zzb != ((zzaho)object).zzb) return false;
        if (this.zze != ((zzaho)object).zze) return false;
        if (this.zzf != ((zzaho)object).zzf) return false;
        if (this.zzg != ((zzaho)object).zzg) return false;
        if (this.zzh != ((zzaho)object).zzh) return false;
        if (this.zzi != ((zzaho)object).zzi) return false;
        if (!zzflt.zza((Object)this.zza, (Object)((zzaho)object).zza)) return false;
        if (!zzflt.zza((Object)this.zzd, (Object)((zzaho)object).zzd)) return false;
        if (!zzflt.zza((Object)this.zzc, (Object)((zzaho)object).zzc)) return false;
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzb, this.zzf, this.zzg, this.zzh, this.zzi});
    }
}
