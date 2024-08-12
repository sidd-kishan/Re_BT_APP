/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;

public final class zzahz {
    public static final zzahz zza = new zzahz(0L, 0L);
    public static final zzahz zzb = new zzahz(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final zzahz zzc = new zzahz(Long.MAX_VALUE, 0L);
    public static final zzahz zzd = new zzahz(0L, Long.MAX_VALUE);
    public static final zzahz zze = zza;
    public final long zzf;
    public final long zzg;

    public zzahz(long l, long l2) {
        boolean bl = true;
        boolean bl2 = l >= 0L;
        zzakt.zza((boolean)bl2);
        bl2 = l2 >= 0L ? bl : false;
        zzakt.zza((boolean)bl2);
        this.zzf = l;
        this.zzg = l2;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzahz)object;
        if (this.zzf != ((zzahz)object).zzf) return false;
        if (this.zzg != ((zzahz)object).zzg) return false;
        return true;
    }

    public final int hashCode() {
        return (int)this.zzf * 31 + (int)this.zzg;
    }
}
