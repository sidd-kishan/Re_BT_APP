/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.ads.internal.zzf
 *  com.google.android.gms.internal.ads.zzdjj
 *  com.google.android.gms.internal.ads.zzejx
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.internal.ads.zzdjj;
import com.google.android.gms.internal.ads.zzejx;

final class zzejw
implements zzf {
    final zzdjj zza;

    zzejw(zzejx zzejx2, zzdjj zzdjj2) {
        this.zza = zzdjj2;
    }

    public final void zza(View view) {
    }

    public final void zzb() {
        this.zza.zzc().onAdClicked();
    }

    public final void zzc() {
        this.zza.zzd().zza();
        this.zza.zze().zza();
    }
}
