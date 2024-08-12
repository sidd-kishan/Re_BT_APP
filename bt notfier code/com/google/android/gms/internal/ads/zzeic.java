/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzdsb
 *  com.google.android.gms.internal.ads.zzeib
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzdsb;
import com.google.android.gms.internal.ads.zzeib;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzeic
implements zzgla<zzeib> {
    private final zzgln<Context> zza;
    private final zzgln<zzdsb> zzb;

    public zzeic(zzgln<Context> zzgln2, zzgln<zzdsb> zzgln3) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
    }

    public final zzeib zza() {
        return new zzeib((Context)this.zza.zzb(), (zzdsb)this.zzb.zzb());
    }
}
