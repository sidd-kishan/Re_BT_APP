/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzfal
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzfal;

public final class zzcxv {
    private final zzfal zza;
    private final zzezz zzb;
    private final String zzc;

    public zzcxv(zzfal object, zzezz zzezz2, String string) {
        this.zza = object;
        this.zzb = zzezz2;
        object = string;
        if (string == null) {
            object = "com.google.ads.mediation.admob.AdMobAdapter";
        }
        this.zzc = object;
    }

    public final zzfal zza() {
        return this.zza;
    }

    public final zzezz zzb() {
        return this.zzb;
    }

    public final zzfac zzc() {
        return this.zza.zzb.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }
}
