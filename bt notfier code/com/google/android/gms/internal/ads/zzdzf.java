/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzdzy
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzdzy;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzdzf
implements zzgla<zzdzy> {
    private final zzgln<Context> zza;

    public zzdzf(zzgln<Context> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzdzy zza() {
        return new zzdzy((Context)this.zza.zzb());
    }
}
