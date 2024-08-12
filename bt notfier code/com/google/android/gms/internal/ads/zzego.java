/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzdkf
 *  com.google.android.gms.internal.ads.zzegn
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzdkf;
import com.google.android.gms.internal.ads.zzegn;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzego
implements zzgla<zzegn> {
    private final zzgln<Context> zza;
    private final zzgln<zzdkf> zzb;

    public zzego(zzgln<Context> zzgln2, zzgln<zzdkf> zzgln3) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
    }

    public final zzegn zza() {
        return new zzegn((Context)this.zza.zzb(), (zzdkf)this.zzb.zzb());
    }
}
