/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioTrack
 *  android.media.AudioTrack$StreamEventCallback
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzek
 *  com.google.android.gms.internal.ads.zzel
 *  com.google.android.gms.internal.ads.zzen
 */
package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.Handler;
import com.google.android.gms.internal.ads.zzek;
import com.google.android.gms.internal.ads.zzel;
import com.google.android.gms.internal.ads.zzen;

final class zzem {
    final zzen zza;
    private final Handler zzb;
    private final AudioTrack.StreamEventCallback zzc;

    public zzem(zzen zzen2) {
        this.zza = zzen2;
        this.zzb = new Handler();
        this.zzc = new zzel(this, zzen2);
    }

    public final void zza(AudioTrack audioTrack) {
        audioTrack.registerStreamEventCallback(zzek.zza((Handler)this.zzb), this.zzc);
    }

    public final void zzb(AudioTrack audioTrack) {
        audioTrack.unregisterStreamEventCallback(this.zzc);
        this.zzb.removeCallbacksAndMessages(null);
    }
}
