/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioTrack
 *  android.os.SystemClock
 *  com.google.android.gms.internal.ads.zzaoq
 */
package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzaoq;

class zzaol {
    protected AudioTrack zza;
    private boolean zzb;
    private int zzc;
    private long zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;

    private zzaol() {
    }

    /* synthetic */ zzaol(zzaoq zzaoq2) {
    }

    public void zza(AudioTrack audioTrack, boolean bl) {
        this.zza = audioTrack;
        this.zzb = bl;
        this.zzg = -9223372036854775807L;
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        if (audioTrack == null) return;
        this.zzc = audioTrack.getSampleRate();
    }

    public final void zzb(long l) {
        this.zzh = this.zzd();
        this.zzg = SystemClock.elapsedRealtime() * 1000L;
        this.zzi = l;
        this.zza.stop();
    }

    public final void zzc() {
        if (this.zzg != -9223372036854775807L) {
            return;
        }
        this.zza.pause();
    }

    public final long zzd() {
        long l;
        if (this.zzg != -9223372036854775807L) {
            long l2 = SystemClock.elapsedRealtime();
            long l3 = this.zzg;
            int n = this.zzc;
            return Math.min(this.zzi, this.zzh + (l2 * 1000L - l3) * (long)n / 1000000L);
        }
        int n = this.zza.getPlayState();
        if (n == 1) {
            return 0L;
        }
        long l4 = l = (long)this.zza.getPlaybackHeadPosition() & 0xFFFFFFFFL;
        if (this.zzb) {
            if (n == 2 && l == 0L) {
                this.zzf = this.zzd;
            }
            l4 = l + this.zzf;
        }
        if (this.zzd > l4) {
            ++this.zze;
        }
        this.zzd = l4;
        return l4 + (this.zze << 32);
    }

    public final long zze() {
        return this.zzd() * 1000000L / (long)this.zzc;
    }

    public boolean zzf() {
        return false;
    }

    public long zzg() {
        throw new UnsupportedOperationException();
    }

    public long zzh() {
        throw new UnsupportedOperationException();
    }
}
