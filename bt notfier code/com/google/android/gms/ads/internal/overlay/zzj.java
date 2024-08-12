/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  com.google.android.gms.ads.internal.overlay.zzk
 */
package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;
import com.google.android.gms.ads.internal.overlay.zzk;

final class zzj
implements Runnable {
    private final zzk zza;
    private final Drawable zzb;

    zzj(zzk zzk2, Drawable drawable) {
        this.zza = zzk2;
        this.zzb = drawable;
    }

    @Override
    public final void run() {
        zzk zzk2 = this.zza;
        Drawable drawable = this.zzb;
        zzk2.zza.zzb.getWindow().setBackgroundDrawable(drawable);
    }
}
