/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbtm
 *  com.google.android.gms.internal.ads.zzbtv
 *  com.google.android.gms.internal.ads.zzbuk
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzchn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbtm;
import com.google.android.gms.internal.ads.zzbtv;
import com.google.android.gms.internal.ads.zzbuk;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzchn;

final class zzbui
implements zzchn {
    final zzchl zza;
    final zzbtm zzb;

    zzbui(zzbuk zzbuk2, zzchl zzchl2, zzbtm zzbtm2) {
        this.zza = zzchl2;
        this.zzb = zzbtm2;
    }

    public final void zza() {
        this.zza.zzd((Throwable)new zzbtv("Unable to obtain a JavascriptEngine."));
        this.zzb.zzb();
    }
}
