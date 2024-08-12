/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbjj
 *  com.google.android.gms.internal.ads.zzblm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbjj;
import com.google.android.gms.internal.ads.zzblm;

final class zzbji
implements zzblm {
    final zzbjj zza;

    zzbji(zzbjj zzbjj2) {
        this.zza = zzbjj2;
    }

    public final Boolean zza(String string, boolean bl) {
        return zzbjj.zza((zzbjj)this.zza).getBoolean(string, bl);
    }

    public final Long zzb(String string, long l) {
        long l2;
        try {
            l2 = zzbjj.zza((zzbjj)this.zza).getLong(string, l);
        }
        catch (ClassCastException classCastException) {
            return zzbjj.zza((zzbjj)this.zza).getInt(string, (int)l);
        }
        return l2;
    }

    public final Double zzc(String string, double d) {
        return zzbjj.zza((zzbjj)this.zza).getFloat(string, (float)d);
    }

    public final String zzd(String string, String string2) {
        return zzbjj.zza((zzbjj)this.zza).getString(string, string2);
    }
}
