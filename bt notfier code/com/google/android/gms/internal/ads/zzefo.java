/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcwe
 *  com.google.android.gms.internal.ads.zzefn
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcwe;
import com.google.android.gms.internal.ads.zzefn;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzefo
implements zzgla<zzefn> {
    private final zzgln<Context> zza;
    private final zzgln<zzcwe> zzb;

    public zzefo(zzgln<Context> zzgln2, zzgln<zzcwe> zzgln3) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
    }

    public final zzefn zza() {
        return new zzefn((Context)this.zza.zzb(), (zzcwe)this.zzb.zzb());
    }
}
