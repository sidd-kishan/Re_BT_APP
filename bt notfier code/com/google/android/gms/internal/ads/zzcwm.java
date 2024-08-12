/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbny
 *  com.google.android.gms.internal.ads.zzdat
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbny;
import com.google.android.gms.internal.ads.zzdat;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzcwm
implements zzgla<Boolean> {
    private final zzgln<zzfar> zza;

    public zzcwm(zzgln<zzfar> zzgln2) {
        this.zza = zzgln2;
    }

    public final Boolean zza() {
        boolean bl;
        zzbny zzbny2 = ((zzdat)this.zza).zza().zza();
        boolean bl2 = bl = true;
        if (zzbny2 != null) return bl2;
        zzbny2 = zzbjl.zzdQ;
        bl2 = (Boolean)zzbet.zzc().zzc((zzbjd)zzbny2) != false ? bl : false;
        return bl2;
    }
}
