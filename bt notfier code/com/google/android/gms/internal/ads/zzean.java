/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzddv
 *  com.google.android.gms.internal.ads.zzddw
 *  com.google.android.gms.internal.ads.zzeam
 *  com.google.android.gms.internal.ads.zzeao
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzglh
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzddv;
import com.google.android.gms.internal.ads.zzddw;
import com.google.android.gms.internal.ads.zzeam;
import com.google.android.gms.internal.ads.zzeao;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzglh;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Map;

public final class zzean
implements zzgla<zzeam> {
    private final zzgln<Map<String, zzgln<zzeao>>> zza;
    private final zzgln<zzfsn> zzb;
    private final zzgln<zzddv> zzc;

    public zzean(zzgln<Map<String, zzgln<zzeao>>> zzgln2, zzgln<zzfsn> zzgln3, zzgln<zzddv> zzgln4) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
    }

    public final zzeam zza() {
        Map map = ((zzglh)this.zza).zzd();
        zzfsn zzfsn2 = zzchg.zza;
        zzgli.zzb((Object)zzfsn2);
        return new zzeam(map, zzfsn2, ((zzddw)this.zzc).zza());
    }
}
