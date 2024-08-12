/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeiv
 *  com.google.android.gms.internal.ads.zzejz
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeiv;
import com.google.android.gms.internal.ads.zzejz;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzeiw
implements zzgla<zzeiv> {
    private final zzgln<zzejz> zza;

    public zzeiw(zzgln<zzejz> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzeiv zza() {
        return new zzeiv((zzejz)this.zza.zzb());
    }
}
