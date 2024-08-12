/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzeag
 *  com.google.android.gms.internal.ads.zzeah
 *  com.google.android.gms.internal.ads.zzeaz
 *  com.google.android.gms.internal.ads.zzebq
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgkz
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzeag;
import com.google.android.gms.internal.ads.zzeah;
import com.google.android.gms.internal.ads.zzeaz;
import com.google.android.gms.internal.ads.zzebq;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgkz;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;

public final class zzeba
implements zzgla<zzeaz> {
    private final zzgln<zzfsn> zza;
    private final zzgln<zzeag> zzb;
    private final zzgln<zzebq> zzc;

    public zzeba(zzgln<zzfsn> zzgln2, zzgln<zzeag> zzgln3, zzgln<zzebq> zzgln4) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
    }

    public final zzeaz zza() {
        zzfsn zzfsn2 = zzchg.zza;
        zzgli.zzb((Object)zzfsn2);
        return new zzeaz(zzfsn2, ((zzeah)this.zzb).zza(), zzgkz.zzc(this.zzc));
    }
}
