/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzakt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzakt;

public final class zzba {
    public final String zza;
    public final zzafv zzb;
    public final zzafv zzc;
    public final int zzd;
    public final int zze;

    public zzba(String string, zzafv zzafv2, zzafv zzafv3, int n, int n2) {
        int n3;
        boolean bl;
        block3: {
            block2: {
                bl = false;
                n3 = n2;
                if (n == 0) break block2;
                n3 = n2;
                if (n2 != 0) break block3;
                n3 = 0;
            }
            bl = true;
        }
        zzakt.zza((boolean)bl);
        zzakt.zzf((String)string);
        this.zza = string;
        if (zzafv2 == null) throw null;
        this.zzb = zzafv2;
        if (zzafv3 == null) throw null;
        this.zzc = zzafv3;
        this.zzd = n;
        this.zze = n3;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzba)object;
        if (this.zzd != ((zzba)object).zzd) return false;
        if (this.zze != ((zzba)object).zze) return false;
        if (!this.zza.equals(((zzba)object).zza)) return false;
        if (!this.zzb.equals((Object)((zzba)object).zzb)) return false;
        if (!this.zzc.equals((Object)((zzba)object).zzc)) return false;
        return true;
    }

    public final int hashCode() {
        return ((((this.zzd + 527) * 31 + this.zze) * 31 + this.zza.hashCode()) * 31 + this.zzb.hashCode()) * 31 + this.zzc.hashCode();
    }
}
