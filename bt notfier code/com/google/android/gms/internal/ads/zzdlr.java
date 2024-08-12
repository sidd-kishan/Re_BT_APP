/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdlo
 *  com.google.android.gms.internal.ads.zzdmq
 *  com.google.android.gms.internal.ads.zzdmr
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdlo;
import com.google.android.gms.internal.ads.zzdmq;
import com.google.android.gms.internal.ads.zzdmr;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;

public final class zzdlr
implements zzgla<zzdmr> {
    private final zzdlo zza;
    private final zzgln<zzdmq> zzb;

    public zzdlr(zzdlo zzdlo2, zzgln<zzdmq> zzgln2) {
        this.zza = zzdlo2;
        this.zzb = zzgln2;
    }

    public final zzdmr zza() {
        zzdmq zzdmq2 = (zzdmq)this.zzb.zzb();
        zzgli.zzb((Object)zzdmq2);
        return zzdmq2;
    }
}
