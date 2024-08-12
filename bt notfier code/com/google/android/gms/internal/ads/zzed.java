/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioTrack
 *  com.google.android.gms.internal.ads.zzen
 */
package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import com.google.android.gms.internal.ads.zzen;

final class zzed
extends Thread {
    final AudioTrack zza;
    final zzen zzb;

    zzed(zzen zzen2, String string, AudioTrack audioTrack) {
        this.zzb = zzen2;
        this.zza = audioTrack;
        super("ExoPlayer:AudioTrackReleaseThread");
    }

    @Override
    public final void run() {
        try {
            this.zza.flush();
            this.zza.release();
            return;
        }
        finally {
            zzen.zzv((zzen)this.zzb).open();
        }
    }
}
