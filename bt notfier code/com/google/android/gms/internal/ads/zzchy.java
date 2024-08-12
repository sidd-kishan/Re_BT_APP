/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  com.google.android.gms.internal.ads.zzcig
 */
package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;
import com.google.android.gms.internal.ads.zzcig;

final class zzchy
implements Runnable {
    final MediaPlayer zza;
    final zzcig zzb;

    zzchy(zzcig zzcig2, MediaPlayer mediaPlayer) {
        this.zzb = zzcig2;
        this.zza = mediaPlayer;
    }

    @Override
    public final void run() {
        zzcig.zzu((zzcig)this.zzb, (MediaPlayer)this.zza);
        if (zzcig.zza((zzcig)this.zzb) == null) return;
        zzcig.zza((zzcig)this.zzb).zzb();
    }
}
