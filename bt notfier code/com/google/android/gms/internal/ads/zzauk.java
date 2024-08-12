/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.SystemClock
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzauj
 *  com.google.android.gms.internal.ads.zzaul
 *  com.google.android.gms.internal.ads.zzaum
 *  com.google.android.gms.internal.ads.zzaun
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzavc
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzauj;
import com.google.android.gms.internal.ads.zzaul;
import com.google.android.gms.internal.ads.zzaum;
import com.google.android.gms.internal.ads.zzaun;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzavc;
import java.io.IOException;

final class zzauk<T extends zzaul>
extends Handler
implements Runnable {
    public final int zza;
    final zzaun zzb;
    private final T zzc;
    private final zzauj<T> zzd;
    private final long zze;
    private IOException zzf;
    private int zzg;
    private volatile Thread zzh;
    private volatile boolean zzi;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zzauk(zzaun zzaun2, Looper looper, zzaul zzaul2, zzauj zzauj2, int n, long l) {
        this.zzb = zzaun2;
        super(looper);
        this.zzc = zzaul2;
        this.zzd = zzauj2;
        this.zza = n;
        this.zze = l;
    }

    private final void zzd() {
        this.zzf = null;
        zzaun.zza((zzaun)this.zzb).execute(zzaun.zzb((zzaun)this.zzb));
    }

    public final void handleMessage(Message object) {
        if (this.zzi) {
            return;
        }
        if (object.what == 0) {
            this.zzd();
            return;
        }
        if (object.what == 4) throw (Error)object.obj;
        zzaun.zzc((zzaun)this.zzb, null);
        long l = SystemClock.elapsedRealtime();
        long l2 = l - this.zze;
        if (this.zzc.zzd()) {
            this.zzd.zzz(this.zzc, l, l2, false);
            return;
        }
        int n = object.what;
        int n2 = 1;
        if (n == 1) {
            this.zzd.zzz(this.zzc, l, l2, false);
            return;
        }
        if (n == 2) {
            this.zzd.zzA(this.zzc, l, l2);
            return;
        }
        if (n != 3) return;
        object = (IOException)object.obj;
        this.zzf = object;
        n = this.zzd.zzy(this.zzc, l, l2, (IOException)object);
        if (n == 3) {
            zzaun.zzd((zzaun)this.zzb, (IOException)this.zzf);
            return;
        }
        if (n == 2) return;
        if (n != 1) {
            n2 = 1 + this.zzg;
        }
        this.zzg = n2;
        this.zzb(Math.min((n2 - 1) * 1000, 5000));
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    @Override
    public final void run() {
        block11: {
            try {
                this.zzh = Thread.currentThread();
                if (!this.zzc.zzd()) {
                    var1_1 = String.valueOf(this.zzc.getClass().getSimpleName());
                    var1_1 = var1_1.length() != 0 ? "load:".concat(var1_1) : new String("load:");
                    zzavc.zza((String)var1_1);
                }
                ** GOTO lbl-1000
            }
            catch (Error var1_3) {
                Log.e((String)"LoadTask", (String)"Unexpected error loading stream", (Throwable)var1_3);
                if (this.zzi != false) throw var1_3;
                this.obtainMessage(4, var1_3).sendToTarget();
                throw var1_3;
            }
            catch (OutOfMemoryError var1_4) {
                Log.e((String)"LoadTask", (String)"OutOfMemory error loading stream", (Throwable)var1_4);
                if (this.zzi != false) return;
                this.obtainMessage(3, new zzaum((Throwable)var1_4)).sendToTarget();
                return;
            }
            catch (Exception var1_5) {
                Log.e((String)"LoadTask", (String)"Unexpected exception loading stream", (Throwable)var1_5);
                if (this.zzi != false) return;
                this.obtainMessage(3, new zzaum((Throwable)var1_5)).sendToTarget();
                return;
            }
            catch (InterruptedException var1_6) {
                zzaup.zzd((boolean)this.zzc.zzd());
                if (this.zzi != false) return;
                this.sendEmptyMessage(2);
                return;
            }
            catch (IOException var1_7) {
                if (this.zzi != false) return;
                this.obtainMessage(3, var1_7).sendToTarget();
                break block11;
            }
            try {
                this.zzc.zze();
            }
            finally {
                zzavc.zzb();
            }
lbl-1000:
            // 2 sources

            {
                if (this.zzi != false) return;
                this.sendEmptyMessage(2);
                return;
            }
        }
    }

    public final void zza(int n) throws IOException {
        IOException iOException = this.zzf;
        if (iOException == null) return;
        if (this.zzg > n) throw iOException;
    }

    public final void zzb(long l) {
        boolean bl = zzaun.zzb((zzaun)this.zzb) == null;
        zzaup.zzd((boolean)bl);
        zzaun.zzc((zzaun)this.zzb, (zzauk)this);
        if (l > 0L) {
            this.sendEmptyMessageDelayed(0, l);
            return;
        }
        this.zzd();
    }

    public final void zzc(boolean bl) {
        this.zzi = bl;
        this.zzf = null;
        if (this.hasMessages(0)) {
            this.removeMessages(0);
            if (!bl) {
                this.sendEmptyMessage(1);
                return;
            }
        } else {
            this.zzc.zzc();
            if (this.zzh != null) {
                this.zzh.interrupt();
            }
            if (!bl) {
                return;
            }
        }
        zzaun.zzc((zzaun)this.zzb, null);
        long l = SystemClock.elapsedRealtime();
        this.zzd.zzz(this.zzc, l, l - this.zze, true);
    }
}
