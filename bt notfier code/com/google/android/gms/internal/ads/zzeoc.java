/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcoo
 *  com.google.android.gms.internal.ads.zzeoa
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcoo;
import com.google.android.gms.internal.ads.zzeoa;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;

public final class zzeoc
implements zzgla<zzeoa> {
    private final zzgln<zzfsn> zza;
    private final zzgln<Context> zzb;

    public zzeoc(zzgln<zzfsn> zzgln2, zzgln<Context> zzgln3) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
    }

    public final zzeoa zza() {
        zzfsn zzfsn2 = zzchg.zza;
        zzgli.zzb((Object)zzfsn2);
        return new zzeoa(zzfsn2, ((zzcoo)this.zzb).zza());
    }
}