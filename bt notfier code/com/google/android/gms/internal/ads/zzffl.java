/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcoo
 *  com.google.android.gms.internal.ads.zzcox
 *  com.google.android.gms.internal.ads.zzffk
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcoo;
import com.google.android.gms.internal.ads.zzcox;
import com.google.android.gms.internal.ads.zzffk;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzffl
implements zzgla<zzffk> {
    private final zzgln<Context> zza;
    private final zzgln<zzcgz> zzb;

    public zzffl(zzgln<Context> zzgln2, zzgln<zzcgz> zzgln3) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
    }

    public final zzffk zza() {
        return new zzffk(((zzcoo)this.zza).zza(), ((zzcox)this.zzb).zza());
    }
}
