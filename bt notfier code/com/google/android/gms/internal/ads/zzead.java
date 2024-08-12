/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcoo
 *  com.google.android.gms.internal.ads.zzeac
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcoo;
import com.google.android.gms.internal.ads.zzeac;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzead
implements zzgla<zzeac> {
    private final zzgln<Context> zza;

    public zzead(zzgln<Context> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzeac zza() {
        return new zzeac(((zzcoo)this.zza).zza());
    }
}
