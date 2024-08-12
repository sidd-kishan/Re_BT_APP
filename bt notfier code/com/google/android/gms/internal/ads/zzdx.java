/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioTimestamp
 *  android.media.AudioTrack
 */
package com.google.android.gms.internal.ads;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

final class zzdx {
    private final AudioTrack zza;
    private final AudioTimestamp zzb;
    private long zzc;
    private long zzd;
    private long zze;

    public zzdx(AudioTrack audioTrack) {
        this.zza = audioTrack;
        this.zzb = new AudioTimestamp();
    }

    public final boolean zza() {
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

    public final long zzb() {
        return this.zzb.nanoTime / 1000L;
    }

    public final long zzc() {
        return this.zze;
    }
}
