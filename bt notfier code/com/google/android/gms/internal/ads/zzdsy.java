/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdsx
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdsx;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzdsy
implements zzgla<zzdsx> {
    private final zzgln<zzcml> zza;

    public zzdsy(zzgln<zzcml> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzdsx zza() {
        return new zzdsx((zzcml)this.zza.zzb());
    }
}
