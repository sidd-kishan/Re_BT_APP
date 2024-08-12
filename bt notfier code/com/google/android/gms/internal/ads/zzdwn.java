/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbqm
 *  com.google.android.gms.internal.ads.zzdwm
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqm;
import com.google.android.gms.internal.ads.zzdwm;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzdwn
implements zzgla<zzdwm> {
    private final zzgln<zzbqm> zza;

    public zzdwn(zzgln<zzbqm> zzgln2) {
        this.zza = zzgln2;
    }

    public static zzdwm zzc(zzbqm zzbqm2) {
        return new zzdwm(zzbqm2);
    }

    public final zzdwm zza() {
        return new zzdwm((zzbqm)this.zza.zzb());
    }
}
