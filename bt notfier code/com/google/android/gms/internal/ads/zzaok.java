/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioTrack
 *  com.google.android.gms.internal.ads.zzaot
 */
package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import com.google.android.gms.internal.ads.zzaot;

final class zzaok
extends Thread {
    final AudioTrack zza;
    final zzaot zzb;

    zzaok(zzaot zzaot2, AudioTrack audioTrack) {
        this.zzb = zzaot2;
        this.zza = audioTrack;
    }

    @Override
    public final void run() {
        try {
            this.zza.flush();
            this.zza.release();
            return;
        }
        finally {
            zzaot.zza((zzaot)this.zzb).open();
        }
    }
}
