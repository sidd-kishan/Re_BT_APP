/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzduq
 *  com.google.android.gms.internal.ads.zzdur
 *  com.google.android.gms.internal.ads.zzfem
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgle
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzduq;
import com.google.android.gms.internal.ads.zzdur;
import com.google.android.gms.internal.ads.zzfem;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgle;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Map;

public final class zzdus
implements zzgla<zzdur> {
    private final zzgln<zzazb> zza;
    private final zzgln<Map<zzfem, zzduq>> zzb;

    public zzdus(zzgln<zzazb> zzgln2, zzgln<Map<zzfem, zzduq>> zzgln3) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
    }

    public final zzdur zza() {
        return new zzdur((zzazb)this.zza.zzb(), ((zzgle)this.zzb).zzd());
    }
}
