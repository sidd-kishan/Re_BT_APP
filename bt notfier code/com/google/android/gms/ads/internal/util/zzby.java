/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzfla
 */
package com.google.android.gms.ads.internal.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzfla;

public final class zzby {
    private HandlerThread zza = null;
    private Handler zzb = null;
    private int zzc = 0;
    private final Object zzd = new Object();

    public final Looper zza() {
        Object object = this.zzd;
        synchronized (object) {
            HandlerThread handlerThread;
            if (this.zzc == 0) {
                if (this.zza == null) {
                    zze.zza((String)"Starting the looper thread.");
                    this.zza = handlerThread = new HandlerThread("LooperProvider");
                    handlerThread.start();
                    handlerThread = new zzfla(this.zza.getLooper());
                    this.zzb = handlerThread;
                    zze.zza((String)"Looper thread started.");
                } else {
                    zze.zza((String)"Resuming the looper thread");
                    this.zzd.notifyAll();
                }
            } else {
                Preconditions.checkNotNull((Object)this.zza, (Object)"Invalid state: mHandlerThread should already been initialized.");
            }
            ++this.zzc;
            handlerThread = this.zza.getLooper();
            return handlerThread;
        }
    }

    public final Handler zzb() {
        return this.zzb;
    }
}
