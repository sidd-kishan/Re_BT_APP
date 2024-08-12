/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.google.android.gms.internal.ads.zzcds
 */
package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import com.google.android.gms.internal.ads.zzcds;

final class zzcdn
implements Runnable {
    private final zzcds zza;
    private final Bitmap zzb;

    zzcdn(zzcds zzcds2, Bitmap bitmap) {
        this.zza = zzcds2;
        this.zzb = bitmap;
    }

    @Override
    public final void run() {
        this.zza.zzi(this.zzb);
    }
}
