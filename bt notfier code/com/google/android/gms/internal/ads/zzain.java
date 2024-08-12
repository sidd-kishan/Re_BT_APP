/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzaim
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzc
 *  com.google.android.gms.internal.ads.zzd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzaim;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzc;
import com.google.android.gms.internal.ads.zzd;

public final class zzain {
    public static final zzadw<zzain> zzg = zzaim.zza;
    public Object zza;
    public Object zzb;
    public int zzc;
    public long zzd;
    public long zze;
    public boolean zzf;
    private zzd zzh = com.google.android.gms.internal.ads.zzd.zza;

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (!this.getClass().equals(object.getClass())) {
            return false;
        }
        object = (zzain)object;
        if (!zzamq.zzc((Object)this.zza, (Object)((zzain)object).zza)) return false;
        if (!zzamq.zzc((Object)this.zzb, (Object)((zzain)object).zzb)) return false;
        if (this.zzc != ((zzain)object).zzc) return false;
        if (this.zzd != ((zzain)object).zzd) return false;
        if (this.zzf != ((zzain)object).zzf) return false;
        if (!zzamq.zzc((Object)this.zzh, (Object)((zzain)object).zzh)) return false;
        return true;
    }

    public final int hashCode() {
        Object object = this.zza;
        int n = 0;
        int n2 = object == null ? 0 : object.hashCode();
        object = this.zzb;
        if (object != null) {
            n = object.hashCode();
        }
        int n3 = this.zzc;
        long l = this.zzd;
        return (((((n2 + 217) * 31 + n) * 31 + n3) * 31 + (int)(l >>> 32 ^ l)) * 961 + this.zzf) * 31 + this.zzh.hashCode();
    }

    public final zzain zza(Object object, Object object2, int n, long l, long l2, zzd zzd2, boolean bl) {
        this.zza = object;
        this.zzb = object2;
        this.zzc = 0;
        this.zzd = l;
        this.zze = 0L;
        this.zzh = zzd2;
        this.zzf = bl;
        return this;
    }

    public final long zzb(int n) {
        long l = this.zzh.zza((int)n).zza;
        return 0L;
    }

    public final int zzc(int n) {
        return this.zzh.zza(n).zza(-1);
    }

    public final int zzd(int n, int n2) {
        return this.zzh.zza(n).zza(n2);
    }

    public final int zze(long l) {
        return -1;
    }

    public final int zzf(long l) {
        long l2 = this.zzd;
        if (l == Long.MIN_VALUE) return -1;
        if (l2 == -9223372036854775807L) return -1;
        return -1;
    }

    public final int zzg(int n) {
        return this.zzh.zza((int)n).zzb;
    }

    public final long zzh(int n, int n2) {
        zzc zzc2 = this.zzh.zza(n);
        if (zzc2.zzb == -1) return -9223372036854775807L;
        return zzc2.zze[n2];
    }

    public final long zzi() {
        long l = this.zzh.zzb;
        return 0L;
    }

    public final boolean zzj(int n) {
        boolean bl = this.zzh.zza((int)n).zzg;
        return false;
    }

    public final long zzk(int n) {
        long l = this.zzh.zza((int)n).zzf;
        return 0L;
    }
}
