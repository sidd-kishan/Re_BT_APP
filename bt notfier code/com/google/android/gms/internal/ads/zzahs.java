/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.SystemClock
 *  com.google.android.gms.internal.ads.zzahq
 *  com.google.android.gms.internal.ads.zzahr
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzaku
 */
package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzahq;
import com.google.android.gms.internal.ads.zzahr;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzaku;
import java.util.concurrent.TimeoutException;

public final class zzahs {
    private final zzahr zza;
    private final zzahq zzb;
    private final zzaku zzc;
    private final zzaiq zzd;
    private int zze;
    private Object zzf;
    private final Looper zzg;
    private final int zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    public zzahs(zzahq zzahq2, zzahr zzahr2, zzaiq zzaiq2, int n, zzaku zzaku2, Looper looper) {
        this.zzb = zzahq2;
        this.zza = zzahr2;
        this.zzd = zzaiq2;
        this.zzg = looper;
        this.zzc = zzaku2;
        this.zzh = n;
    }

    public final zzahr zza() {
        return this.zza;
    }

    public final zzahs zzb(int n) {
        zzakt.zzd((boolean)(this.zzi ^ true));
        this.zze = n;
        return this;
    }

    public final int zzc() {
        return this.zze;
    }

    public final zzahs zzd(Object object) {
        zzakt.zzd((boolean)(this.zzi ^ true));
        this.zzf = object;
        return this;
    }

    public final Object zze() {
        return this.zzf;
    }

    public final Looper zzf() {
        return this.zzg;
    }

    public final zzahs zzg() {
        zzakt.zzd((boolean)(this.zzi ^ true));
        this.zzi = true;
        this.zzb.zzi(this);
        return this;
    }

    /*
     * Converted monitor instructions to comments
     */
    public final boolean zzh() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return false;
    }

    public final void zzi(boolean bl) {
        synchronized (this) {
            this.zzj = bl | this.zzj;
            this.zzk = true;
            this.notifyAll();
            return;
        }
    }

    public final boolean zzj(long l) throws InterruptedException, TimeoutException {
        synchronized (this) {
            try {
                zzakt.zzd((boolean)this.zzi);
                boolean bl = this.zzg.getThread() != Thread.currentThread();
                zzakt.zzd((boolean)bl);
                long l2 = SystemClock.elapsedRealtime();
                l = 2000L;
                while (true) {
                    if (this.zzk) {
                        bl = this.zzj;
                        return bl;
                    }
                    if (l <= 0L) {
                        TimeoutException timeoutException = new TimeoutException("Message delivery timed out.");
                        throw timeoutException;
                    }
                    this.wait(l);
                    l = l2 + 2000L - SystemClock.elapsedRealtime();
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
