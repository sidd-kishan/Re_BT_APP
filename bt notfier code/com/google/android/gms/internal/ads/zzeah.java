/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcoo
 *  com.google.android.gms.internal.ads.zzeag
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcoo;
import com.google.android.gms.internal.ads.zzeag;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzeah
implements zzgla<zzeag> {
    private final zzgln<Context> zza;

    public zzeah(zzgln<Context> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzeag zza() {
        return new zzeag(((zzcoo)this.zza).zza());
    }
}
