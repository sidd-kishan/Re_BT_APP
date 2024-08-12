/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdlm
 *  com.google.android.gms.internal.ads.zzdlo
 *  com.google.android.gms.internal.ads.zzdmu
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdlm;
import com.google.android.gms.internal.ads.zzdlo;
import com.google.android.gms.internal.ads.zzdmu;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;

public final class zzdls
implements zzgla<zzdmu> {
    private final zzdlo zza;
    private final zzgln<zzdlm> zzb;

    public zzdls(zzdlo zzdlo2, zzgln<zzdlm> zzgln2) {
        this.zza = zzdlo2;
        this.zzb = zzgln2;
    }

    public final zzdmu zza() {
        zzdlm zzdlm2 = (zzdlm)this.zzb.zzb();
        zzgli.zzb((Object)zzdlm2);
        return zzdlm2;
    }
}
