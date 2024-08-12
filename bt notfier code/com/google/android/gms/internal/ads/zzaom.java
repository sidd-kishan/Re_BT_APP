/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioTimestamp
 *  android.media.AudioTrack
 *  com.google.android.gms.internal.ads.zzaol
 */
package com.google.android.gms.internal.ads;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.google.android.gms.internal.ads.zzaol;

final class zzaom
extends zzaol {
    private final AudioTimestamp zzb = new AudioTimestamp();
    private long zzc;
    private long zzd;
    private long zze;

    public zzaom() {
        super(null);
    }

    public final void zza(AudioTrack audioTrack, boolean bl) {
        super.zza(audioTrack, bl);
        this.zzc = 0L;
        this.zzd = 0L;
        this.zze = 0L;
    }

    public final boolean zzf() {
        boolean bl = this.zza.getTimestamp(this.zzb);
        if (!bl) return bl;
        long l = this.zzb.framePosition;
        if (this.zzd > l) {
            ++this.zzc;
        }
        this.zzd = l;
        this.zze = l + (this.zzc << 32);
        return bl;
    }

    public final long zzg() {
        return this.zzb.nanoTime;
    }

    public final long zzh() {
        return this.zze;
    }
}
