/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzdoy
 *  com.google.android.gms.internal.ads.zzdpl
 *  com.google.android.gms.internal.ads.zzdpm
 *  com.google.android.gms.internal.ads.zzdpq
 *  com.google.android.gms.internal.ads.zzdpr
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzdoy;
import com.google.android.gms.internal.ads.zzdpl;
import com.google.android.gms.internal.ads.zzdpm;
import com.google.android.gms.internal.ads.zzdpq;
import com.google.android.gms.internal.ads.zzdpr;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;

public final class zzdoz
implements zzgla<zzdoy> {
    private final zzgln<zzfsn> zza;
    private final zzgln<zzdpl> zzb;
    private final zzgln<zzdpq> zzc;

    public zzdoz(zzgln<zzfsn> zzgln2, zzgln<zzdpl> zzgln3, zzgln<zzdpq> zzgln4) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
    }

    public final zzdoy zza() {
        zzfsn zzfsn2 = zzchg.zza;
        zzgli.zzb((Object)zzfsn2);
        return new zzdoy(zzfsn2, ((zzdpm)this.zzb).zza(), ((zzdpr)this.zzc).zza());
    }
}
