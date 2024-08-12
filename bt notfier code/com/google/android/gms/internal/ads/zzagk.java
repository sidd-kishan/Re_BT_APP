/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzafz
 *  com.google.android.gms.internal.ads.zzagb
 *  com.google.android.gms.internal.ads.zzagd
 *  com.google.android.gms.internal.ads.zzagh
 *  com.google.android.gms.internal.ads.zzagi
 *  com.google.android.gms.internal.ads.zzagj
 *  com.google.android.gms.internal.ads.zzago
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzafz;
import com.google.android.gms.internal.ads.zzagb;
import com.google.android.gms.internal.ads.zzagd;
import com.google.android.gms.internal.ads.zzagh;
import com.google.android.gms.internal.ads.zzagi;
import com.google.android.gms.internal.ads.zzagj;
import com.google.android.gms.internal.ads.zzago;
import com.google.android.gms.internal.ads.zzamq;

public final class zzagk {
    public static final zzagk zza = new zzagb().zzc();
    public static final zzadw<zzagk> zzg = zzafz.zza;
    public final String zzb;
    public final zzagj zzc;
    public final zzagh zzd;
    public final zzago zze;
    public final zzagd zzf;

    /* synthetic */ zzagk(String string, zzagd zzagd2, zzagj zzagj2, zzagh zzagh2, zzago zzago2, zzagi zzagi2) {
        this.zzb = string;
        this.zzc = zzagj2;
        this.zzd = zzagh2;
        this.zze = zzago2;
        this.zzf = zzagd2;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzagk)) {
            return false;
        }
        object = (zzagk)object;
        if (!zzamq.zzc((Object)this.zzb, (Object)((zzagk)object).zzb)) return false;
        if (!this.zzf.equals((Object)((zzagk)object).zzf)) return false;
        if (!zzamq.zzc((Object)this.zzc, (Object)((zzagk)object).zzc)) return false;
        if (!zzamq.zzc((Object)this.zzd, (Object)((zzagk)object).zzd)) return false;
        if (!zzamq.zzc((Object)this.zze, (Object)((zzagk)object).zze)) return false;
        return true;
    }

    public final int hashCode() {
        int n = this.zzb.hashCode();
        zzagj zzagj2 = this.zzc;
        int n2 = zzagj2 != null ? zzagj2.hashCode() : 0;
        return (((n * 31 + n2) * 31 + this.zzd.hashCode()) * 31 + this.zzf.hashCode()) * 31 + this.zze.hashCode();
    }
}
