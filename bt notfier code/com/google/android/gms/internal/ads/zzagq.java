/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzhf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzhf;

final class zzagq {
    public final zzhf zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;

    zzagq(zzhf zzhf2, long l, long l2, long l3, long l4, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        boolean bl5 = true;
        bl = !bl4 || bl2;
        zzakt.zza((boolean)bl);
        bl = bl5;
        if (bl3) {
            bl = bl2 ? bl5 : false;
        }
        zzakt.zza((boolean)bl);
        this.zza = zzhf2;
        this.zzb = l;
        this.zzc = l2;
        this.zzd = l3;
        this.zze = l4;
        this.zzf = false;
        this.zzg = bl2;
        this.zzh = bl3;
        this.zzi = bl4;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzagq)object;
        if (this.zzb != ((zzagq)object).zzb) return false;
        if (this.zzc != ((zzagq)object).zzc) return false;
        if (this.zzd != ((zzagq)object).zzd) return false;
        if (this.zze != ((zzagq)object).zze) return false;
        if (this.zzg != ((zzagq)object).zzg) return false;
        if (this.zzh != ((zzagq)object).zzh) return false;
        if (this.zzi != ((zzagq)object).zzi) return false;
        if (!zzamq.zzc((Object)this.zza, (Object)((zzagq)object).zza)) return false;
        return true;
    }

    public final int hashCode() {
        return (((((((this.zza.hashCode() + 527) * 31 + (int)this.zzb) * 31 + (int)this.zzc) * 31 + (int)this.zzd) * 31 + (int)this.zze) * 961 + this.zzg) * 31 + this.zzh) * 31 + this.zzi;
    }

    public final zzagq zza(long l) {
        if (l != this.zzb) return new zzagq(this.zza, l, this.zzc, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
        return this;
    }

    public final zzagq zzb(long l) {
        if (l != this.zzc) return new zzagq(this.zza, this.zzb, l, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
        return this;
    }
}
