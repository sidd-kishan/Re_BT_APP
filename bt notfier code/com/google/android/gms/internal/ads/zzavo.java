/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Message
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

final class zzavo
implements Choreographer.FrameCallback,
Handler.Callback {
    private static final zzavo zzb = new zzavo();
    public volatile long zza;
    private final Handler zzc;
    private final HandlerThread zzd;
    private Choreographer zze;
    private int zzf;

    private zzavo() {
        HandlerThread handlerThread;
        this.zzd = handlerThread = new HandlerThread("ChoreographerOwner:Handler");
        handlerThread.start();
        handlerThread = new Handler(this.zzd.getLooper(), (Handler.Callback)this);
        this.zzc = handlerThread;
        handlerThread.sendEmptyMessage(0);
    }

    public static zzavo zza() {
        return zzb;
    }

    public final void doFrame(long l) {
        this.zza = l;
        this.zze.postFrameCallbackDelayed((Choreographer.FrameCallback)this, 500L);
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
            this.zze.postFrameCallback((Choreographer.FrameCallback)this);
            return true;
        }
        if (n != 2) {
            return false;
        }
        this.zzf = n = this.zzf - 1;
        if (n != 0) return true;
        this.zze.removeFrameCallback((Choreographer.FrameCallback)this);
        this.zza = 0L;
        return true;
    }

    public final void zzb() {
        this.zzc.sendEmptyMessage(1);
    }

    public final void zzc() {
        this.zzc.sendEmptyMessage(2);
    }
}
