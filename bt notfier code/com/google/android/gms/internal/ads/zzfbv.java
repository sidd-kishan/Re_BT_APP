/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcoo
 *  com.google.android.gms.internal.ads.zzfbt
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcoo;
import com.google.android.gms.internal.ads.zzfbt;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzfbv
implements zzgla<Context> {
    private final zzfbt zza;
    private final zzgln<Context> zzb;

    public zzfbv(zzfbt zzfbt2, zzgln<Context> zzgln2) {
        this.zza = zzfbt2;
        this.zzb = zzgln2;
    }

    public final Context zza() {
        return ((zzcoo)this.zzb).zza();
    }
}
