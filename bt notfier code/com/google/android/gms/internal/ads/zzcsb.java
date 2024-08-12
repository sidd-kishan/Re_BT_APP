/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcsa
 *  com.google.android.gms.internal.ads.zzcsc
 *  com.google.android.gms.internal.ads.zzcsd
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgle
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcsa;
import com.google.android.gms.internal.ads.zzcsc;
import com.google.android.gms.internal.ads.zzcsd;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgle;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Map;

public final class zzcsb
implements zzgla<zzcsa> {
    private final zzgln<Map<String, zzcsd>> zza;
    private final zzgln<Map<String, zzcsc>> zzb;

    public zzcsb(zzgln<Map<String, zzcsd>> zzgln2, zzgln<Map<String, zzcsc>> zzgln3) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
    }

    public final zzcsa zza() {
        return new zzcsa(((zzgle)this.zza).zzd(), ((zzgle)this.zzb).zzd());
    }
}
