/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzdyq
 *  com.google.android.gms.internal.ads.zzdzf
 *  com.google.android.gms.internal.ads.zzdzy
 *  com.google.android.gms.internal.ads.zzebq
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgkz
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzdyq;
import com.google.android.gms.internal.ads.zzdzf;
import com.google.android.gms.internal.ads.zzdzy;
import com.google.android.gms.internal.ads.zzebq;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgkz;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;

public final class zzdyr
implements zzgla<zzdyq> {
    private final zzgln<zzfsn> zza;
    private final zzgln<zzfsn> zzb;
    private final zzgln<zzdzy> zzc;
    private final zzgln<zzebq> zzd;

    public zzdyr(zzgln<zzfsn> zzgln2, zzgln<zzfsn> zzgln3, zzgln<zzdzy> zzgln4, zzgln<zzebq> zzgln5) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
        this.zzd = zzgln5;
    }

    public final zzdyq zza() {
        zzfsn zzfsn2 = zzchg.zzb;
        zzgli.zzb((Object)zzfsn2);
        zzfsn zzfsn3 = zzchg.zza;
        zzgli.zzb((Object)zzfsn3);
        return new zzdyq(zzfsn2, zzfsn3, ((zzdzf)this.zzc).zza(), zzgkz.zzc(this.zzd));
    }
}
