/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdly
 *  com.google.android.gms.internal.ads.zzdmm
 *  com.google.android.gms.internal.ads.zzdne
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdly;
import com.google.android.gms.internal.ads.zzdmm;
import com.google.android.gms.internal.ads.zzdne;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzdlz
implements zzgla<zzdly> {
    private final zzgln<zzdmm> zza;

    public zzdlz(zzgln<zzdmm> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzdly zza() {
        return new zzdly(((zzdne)this.zza).zza());
    }
}
