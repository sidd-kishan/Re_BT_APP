/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcfa
 *  com.google.android.gms.internal.ads.zzeai
 *  com.google.android.gms.internal.ads.zzfbv
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcfa;
import com.google.android.gms.internal.ads.zzeai;
import com.google.android.gms.internal.ads.zzfbv;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzeaj
implements zzgla<zzeai> {
    private final zzgln<Context> zza;
    private final zzgln<zzcfa> zzb;

    public zzeaj(zzgln<Context> zzgln2, zzgln<zzcfa> zzgln3) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
    }

    public final zzeai zza() {
        return new zzeai(((zzfbv)this.zza).zza(), (zzcfa)this.zzb.zzb());
    }
}
