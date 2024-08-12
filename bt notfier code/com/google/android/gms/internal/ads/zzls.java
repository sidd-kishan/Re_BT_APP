/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Message
 *  com.google.android.gms.internal.ads.zzalb
 *  com.google.android.gms.internal.ads.zzaln
 *  com.google.android.gms.internal.ads.zzlu
 */
package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.gms.internal.ads.zzalb;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzlu;

final class zzls
extends HandlerThread
implements Handler.Callback {
    private zzalb zza;
    private Handler zzb;
    private Error zzc;
    private RuntimeException zzd;
    private zzlu zze;

    public zzls() {
        super("ExoPlayer:DummySurface");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final boolean handleMessage(Message message) {
        Throwable throwable322;
        block25: {
            int n = message.what;
            if (n != 1) {
                if (n != 2) {
                    return true;
                }
                try {
                    message = this.zza;
                    if (message == null) throw null;
                    message.zzb();
                    return true;
                }
                catch (Throwable throwable2) {
                    try {
                        zzaln.zzb((String)"DummySurface", (String)"Failed to release dummy surface", (Throwable)throwable2);
                        return true;
                    }
                    finally {
                        this.quit();
                    }
                }
            }
            n = message.arg1;
            message = this.zza;
            if (message == null) throw null;
            message.zza(n);
            SurfaceTexture surfaceTexture = this.zza.zzc();
            boolean bl = n != 0;
            message = new zzlu(this, surfaceTexture, bl, null);
            this.zze = message;
            {
                catch (Throwable throwable322) {
                    break block25;
                }
                catch (Error error) {
                    zzaln.zzb((String)"DummySurface", (String)"Failed to initialize dummy surface", (Throwable)error);
                    this.zzc = error;
                    synchronized (this) {
                        ((Object)((Object)this)).notify();
                        return true;
                    }
                }
                catch (RuntimeException runtimeException) {}
                {
                    zzaln.zzb((String)"DummySurface", (String)"Failed to initialize dummy surface", (Throwable)runtimeException);
                    this.zzd = runtimeException;
                }
                synchronized (this) {
                    ((Object)((Object)this)).notify();
                    return true;
                }
            }
            synchronized (this) {
                ((Object)((Object)this)).notify();
                return true;
            }
        }
        synchronized (this) {
            ((Object)((Object)this)).notify();
            throw throwable322;
            {
                catch (Throwable throwable4) {}
                {
                    throw throwable4;
                }
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final zzlu zza(int n) {
        this.start();
        this.zzb = new Handler(this.getLooper(), (Handler.Callback)this);
        this.zza = new zzalb(this.zzb, null);
        synchronized (this) {
            Object object = this.zzb;
            int n2 = 0;
            object.obtainMessage(1, n, 0).sendToTarget();
            n = n2;
            while (this.zze == null && this.zzd == null && (object = this.zzc) == null) {
                try {
                    ((Object)((Object)this)).wait();
                }
                catch (InterruptedException interruptedException) {
                    n = 1;
                }
            }
            // MONITOREXIT @DISABLED, blocks:[0, 3] lbl17 : MonitorExitStatement: MONITOREXIT : this
            if (n != 0) {
                Thread.currentThread().interrupt();
            }
            if ((object = this.zzd) != null) throw object;
            object = this.zzc;
            if (object != null) throw object;
            object = this.zze;
            if (object == null) throw null;
            return object;
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
    }

    public final void zzb() {
        Handler handler = this.zzb;
        if (handler == null) throw null;
        handler.sendEmptyMessage(2);
    }
}
