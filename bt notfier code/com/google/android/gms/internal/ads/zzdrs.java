/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdmm
 *  com.google.android.gms.internal.ads.zzdne
 *  com.google.android.gms.internal.ads.zzdrr
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdmm;
import com.google.android.gms.internal.ads.zzdne;
import com.google.android.gms.internal.ads.zzdrr;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzdrs
implements zzgla<zzdrr> {
    private final zzgln<zzdmm> zza;

    public zzdrs(zzgln<zzdmm> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzdrr zza() {
        return new zzdrr(((zzdne)this.zza).zza());
    }
}
