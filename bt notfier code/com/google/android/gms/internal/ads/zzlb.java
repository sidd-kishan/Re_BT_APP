/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.SystemClock
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzaln
 *  com.google.android.gms.internal.ads.zzamo
 *  com.google.android.gms.internal.ads.zzkz
 *  com.google.android.gms.internal.ads.zzla
 *  com.google.android.gms.internal.ads.zzlc
 *  com.google.android.gms.internal.ads.zzlg
 *  com.google.android.gms.internal.ads.zzlh
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzamo;
import com.google.android.gms.internal.ads.zzkz;
import com.google.android.gms.internal.ads.zzla;
import com.google.android.gms.internal.ads.zzlc;
import com.google.android.gms.internal.ads.zzlg;
import com.google.android.gms.internal.ads.zzlh;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

final class zzlb<T extends zzlc>
extends Handler
implements Runnable {
    final zzlh zza;
    private final T zzb;
    private final long zzc;
    private zzkz<T> zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zzlb(zzlh zzlh2, Looper looper, zzlc zzlc2, zzkz zzkz2, int n, long l) {
        this.zza = zzlh2;
        super(looper);
        this.zzb = zzlc2;
        this.zzd = zzkz2;
        this.zzc = l;
    }

    private final void zzd() {
        this.zze = null;
        ExecutorService executorService = zzlh.zza((zzlh)this.zza);
        zzlb zzlb2 = zzlh.zzb((zzlh)this.zza);
        if (zzlb2 == null) throw null;
        executorService.execute(zzlb2);
    }

    public final void handleMessage(Message object) {
        if (this.zzi) {
            return;
        }
        if (object.what == 0) {
            this.zzd();
            return;
        }
        if (object.what == 3) throw (Error)object.obj;
        zzlh.zzc((zzlh)this.zza, null);
        long l = SystemClock.elapsedRealtime();
        long l2 = l - this.zzc;
        zzkz<T> zzkz2 = this.zzd;
        if (zzkz2 == null) throw null;
        if (this.zzh) {
            zzkz2.zzI(this.zzb, l, l2, false);
            return;
        }
        int n = object.what;
        if (n != 1) {
            if (n != 2) return;
            object = (IOException)object.obj;
            this.zze = object;
            this.zzf = n = this.zzf + 1;
            if (zzla.zza((zzla)(object = zzkz2.zzH(this.zzb, l, l2, (IOException)object, n))) == 3) {
                zzlh.zzd((zzlh)this.zza, (IOException)this.zze);
                return;
            }
            if (zzla.zza((zzla)object) == 2) return;
            if (zzla.zza((zzla)object) == 1) {
                this.zzf = 1;
            }
            l = zzla.zzb((zzla)object) != -9223372036854775807L ? zzla.zzb((zzla)object) : (long)Math.min((this.zzf - 1) * 1000, 5000);
            this.zzb(l);
            return;
        }
        try {
            zzkz2.zzJ(this.zzb, l, l2);
            return;
        }
        catch (RuntimeException runtimeException) {
            zzaln.zzb((String)"LoadTask", (String)"Unexpected exception handling load completed", (Throwable)runtimeException);
            zzlh.zzd((zzlh)this.zza, (IOException)new zzlg((Throwable)runtimeException));
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    @Override
    public final void run() {
        boolean bl = this.zzh;
        this.zzg = Thread.currentThread();
        // MONITOREXIT : this
        if (bl ^ true) {
            String string = String.valueOf(this.zzb.getClass().getSimpleName());
            string = string.length() != 0 ? "load:".concat(string) : new String("load:");
            zzamo.zza((String)string);
            this.zzb.zzh();
            {
                catch (Throwable throwable) {
                    zzamo.zzb();
                    throw throwable;
                }
            }
            zzamo.zzb();
            // MONITORENTER : this
        }
        this.zzg = null;
        Thread.interrupted();
        // MONITOREXIT : this
        try {
            if (this.zzi) return;
            this.sendEmptyMessage(1);
            return;
        }
        catch (Error error) {
            if (this.zzi) throw error;
            zzaln.zzb((String)"LoadTask", (String)"Unexpected error loading stream", (Throwable)error);
            this.obtainMessage(3, error).sendToTarget();
            throw error;
        }
        catch (OutOfMemoryError outOfMemoryError) {
            if (this.zzi) return;
            zzaln.zzb((String)"LoadTask", (String)"OutOfMemory error loading stream", (Throwable)outOfMemoryError);
            this.obtainMessage(2, new zzlg((Throwable)outOfMemoryError)).sendToTarget();
            return;
        }
        catch (Exception exception) {
            if (this.zzi) return;
            zzaln.zzb((String)"LoadTask", (String)"Unexpected exception loading stream", (Throwable)exception);
            this.obtainMessage(2, new zzlg((Throwable)exception)).sendToTarget();
            return;
        }
        catch (IOException iOException) {
            if (this.zzi) return;
            this.obtainMessage(2, iOException).sendToTarget();
        }
    }

    public final void zza(int n) throws IOException {
        IOException iOException = this.zze;
        if (iOException == null) return;
        if (this.zzf > n) throw iOException;
    }

    public final void zzb(long l) {
        boolean bl = zzlh.zzb((zzlh)this.zza) == null;
        zzakt.zzd((boolean)bl);
        zzlh.zzc((zzlh)this.zza, (zzlb)this);
        if (l > 0L) {
            this.sendEmptyMessageDelayed(0, l);
            return;
        }
        this.zzd();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzc(boolean bl) {
        zzkz<T> zzkz2;
        this.zzi = bl;
        this.zze = null;
        if (this.hasMessages(0)) {
            this.zzh = true;
            this.removeMessages(0);
            if (!bl) {
                this.sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.zzh = true;
                this.zzb.zzg();
                zzkz2 = this.zzg;
                if (zzkz2 != null) {
                    zzkz2.interrupt();
                }
            }
        }
        if (!bl) return;
        zzlh.zzc((zzlh)this.zza, null);
        long l = SystemClock.elapsedRealtime();
        zzkz2 = this.zzd;
        if (zzkz2 == null) throw null;
        zzkz2.zzI(this.zzb, l, l - this.zzc, true);
        this.zzd = null;
    }
}
