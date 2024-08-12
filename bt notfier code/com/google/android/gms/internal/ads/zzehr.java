/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdtc
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzehq
 *  com.google.android.gms.internal.ads.zzfbe
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdtc;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzehq;
import com.google.android.gms.internal.ads.zzfbe;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzehr
implements zzgla<zzehq> {
    private final zzgln<zzfbe> zza;
    private final zzgln<zzdtc> zzb;
    private final zzgln<zzdvi> zzc;
    private final zzgln<zzffc> zzd;

    public zzehr(zzgln<zzfbe> zzgln2, zzgln<zzdtc> zzgln3, zzgln<zzdvi> zzgln4, zzgln<zzffc> zzgln5) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
        this.zzd = zzgln5;
    }

    public final zzehq zza() {
        return new zzehq((zzfbe)this.zza.zzb(), (zzdtc)this.zzb.zzb(), (zzdvi)this.zzc.zzb(), (zzffc)this.zzd.zzb());
    }
}
