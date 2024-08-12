/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import com.google.android.gms.internal.ads.zzamq;

final class zzmh
implements Choreographer.FrameCallback,
Handler.Callback {
    private static final zzmh zzb = new zzmh();
    public volatile long zza = -9223372036854775807L;
    private final Handler zzc;
    private final HandlerThread zzd;
    private Choreographer zze;
    private int zzf;

    private zzmh() {
        HandlerThread handlerThread;
        this.zzd = handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        handlerThread.start();
        handlerThread = zzamq.zzi((Looper)this.zzd.getLooper(), (Handler.Callback)this);
        this.zzc = handlerThread;
        handlerThread.sendEmptyMessage(0);
    }

    public static zzmh zza() {
        return zzb;
    }

    public final void doFrame(long l) {
        this.zza = l;
        Choreographer choreographer = this.zze;
        if (choreographer == null) throw null;
        choreographer.postFrameCallbackDelayed((Choreographer.FrameCallback)this, 500L);
    }

    public final boolean handleMessage(Message message) {
        int n = message.what;
        if (n == 0) {
            this.zze = Choreographer.getInstance();
            return true;
        }
        if (n == 1) {
            this.zzf = n = this.zzf + 1;
            if (n != 1) return true;
            message = this.zze;
            if (message == null) throw null;
            message.postFrameCallback((Choreographer.FrameCallback)this);
            return true;
        }
        if (n != 2) {
            return false;
        }
        this.zzf = n = this.zzf - 1;
        if (n != 0) return true;
        message = this.zze;
        if (message == null) throw null;
        message.removeFrameCallback((Choreographer.FrameCallback)this);
        this.zza = -9223372036854775807L;
        return true;
    }

    public final void zzb() {
        this.zzc.sendEmptyMessage(1);
    }

    public final void zzc() {
        this.zzc.sendEmptyMessage(2);
    }
}
