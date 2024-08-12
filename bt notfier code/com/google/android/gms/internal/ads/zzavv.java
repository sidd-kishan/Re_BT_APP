/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  com.google.android.gms.internal.ads.zzavx
 */
package com.google.android.gms.internal.ads;

import android.view.Surface;
import com.google.android.gms.internal.ads.zzavx;

final class zzavv
implements Runnable {
    final Surface zza;
    final zzavx zzb;

    zzavv(zzavx zzavx2, Surface surface) {
        this.zzb = zzavx2;
        this.zza = surface;
    }

    @Override
    public final void run() {
        zzavx.zza((zzavx)this.zzb).zzo(this.zza);
    }
}
