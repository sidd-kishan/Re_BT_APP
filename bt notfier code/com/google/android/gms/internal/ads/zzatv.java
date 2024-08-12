/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzant
 *  com.google.android.gms.internal.ads.zzatg
 *  com.google.android.gms.internal.ads.zzats
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzant;
import com.google.android.gms.internal.ads.zzatg;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzave;

public final class zzatv {
    public final zzatg zza;
    public final zzats zzb;
    public final Object zzc;
    public final zzant[] zzd;

    public zzatv(zzatg zzatg2, zzats zzats2, Object object, zzant[] zzantArray) {
        this.zza = zzatg2;
        this.zzb = zzats2;
        this.zzc = object;
        this.zzd = zzantArray;
    }

    public final boolean zza(zzatv zzatv2, int n) {
        if (zzatv2 == null) {
            return false;
        }
        if (!zzave.zza((Object)this.zzb.zza(n), (Object)zzatv2.zzb.zza(n))) return false;
        if (!zzave.zza((Object)this.zzd[n], (Object)zzatv2.zzd[n])) return false;
        return true;
    }
}
