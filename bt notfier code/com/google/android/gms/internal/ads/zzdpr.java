/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzdpl
 *  com.google.android.gms.internal.ads.zzdpm
 *  com.google.android.gms.internal.ads.zzdpq
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzdpl;
import com.google.android.gms.internal.ads.zzdpm;
import com.google.android.gms.internal.ads.zzdpq;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;
import java.util.concurrent.Executor;

public final class zzdpr
implements zzgla<zzdpq> {
    private final zzgln<Executor> zza;
    private final zzgln<zzdpl> zzb;

    public zzdpr(zzgln<Executor> zzgln2, zzgln<zzdpl> zzgln3) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
    }

    public final zzdpq zza() {
        zzfsn zzfsn2 = zzchg.zza;
        zzgli.zzb((Object)zzfsn2);
        return new zzdpq((Executor)zzfsn2, ((zzdpm)this.zzb).zza());
    }
}
