/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzecu
 *  com.google.android.gms.internal.ads.zzecx
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecu;
import com.google.android.gms.internal.ads.zzecx;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzecy
implements zzgla<zzecx> {
    private final zzgln<zzecu> zza;

    public zzecy(zzgln<zzecu> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzecx zza() {
        return new zzecx((zzecu)this.zza.zzb());
    }
}
