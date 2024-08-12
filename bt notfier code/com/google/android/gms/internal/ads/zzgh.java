/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  android.os.Bundle
 *  android.view.Surface
 *  com.google.android.gms.internal.ads.zzac
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzgg
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import com.google.android.gms.internal.ads.zzac;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzgg;
import java.nio.ByteBuffer;

public final class zzgh {
    private final MediaCodec zza;
    private ByteBuffer[] zzb;
    private ByteBuffer[] zzc;

    /* synthetic */ zzgh(MediaCodec mediaCodec, Surface surface, zzgg zzgg2) {
        this.zza = mediaCodec;
        if (zzamq.zza >= 21) return;
        this.zzb = this.zza.getInputBuffers();
        this.zzc = this.zza.getOutputBuffers();
    }

    public final int zza() {
        return this.zza.dequeueInputBuffer(0L);
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        int n;
        do {
            int n2;
            n = n2 = this.zza.dequeueOutputBuffer(bufferInfo, 0L);
            if (n2 != -3) continue;
            if (zzamq.zza < 21) {
                this.zzc = this.zza.getOutputBuffers();
            }
            n = -3;
        } while (n == -3);
        return n;
    }

    public final MediaFormat zzc() {
        return this.zza.getOutputFormat();
    }

    public final ByteBuffer zzd(int n) {
        if (zzamq.zza < 21) return ((ByteBuffer[])zzamq.zzd((Object)this.zzb))[n];
        return this.zza.getInputBuffer(n);
    }

    public final ByteBuffer zze(int n) {
        if (zzamq.zza < 21) return ((ByteBuffer[])zzamq.zzd((Object)this.zzc))[n];
        return this.zza.getOutputBuffer(n);
    }

    public final void zzf(int n, int n2, int n3, long l, int n4) {
        this.zza.queueInputBuffer(n, 0, n3, l, n4);
    }

    public final void zzg(int n, int n2, zzac zzac2, long l, int n3) {
        this.zza.queueSecureInputBuffer(n, 0, zzac2.zzb(), l, 0);
    }

    public final void zzh(int n, boolean bl) {
        this.zza.releaseOutputBuffer(n, bl);
    }

    public final void zzi(int n, long l) {
        this.zza.releaseOutputBuffer(n, l);
    }

    public final void zzj() {
        this.zza.flush();
    }

    public final void zzk() {
        this.zzb = null;
        this.zzc = null;
        this.zza.release();
    }

    public final void zzl(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    public final void zzm(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    public final void zzn(int n) {
        this.zza.setVideoScalingMode(n);
    }
}
