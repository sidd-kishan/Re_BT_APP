/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzaww
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzaww;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzcuc
implements zzaww {
    private final ScheduledExecutorService zza;
    private final Clock zzb;
    private ScheduledFuture<?> zzc;
    private long zzd = -1L;
    private long zze = -1L;
    private Runnable zzf = null;
    private boolean zzg = false;

    public zzcuc(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zza = scheduledExecutorService;
        this.zzb = clock;
        zzt.zzf().zzb((zzaww)this);
    }

    public final void zza(boolean bl) {
        if (bl) {
            this.zzd();
            return;
        }
        this.zzc();
    }

    public final void zzb(int n, Runnable runnable) {
        synchronized (this) {
            this.zzf = runnable;
            long l = n;
            this.zzd = this.zzb.elapsedRealtime() + l;
            this.zzc = this.zza.schedule(runnable, l, TimeUnit.MILLISECONDS);
            return;
        }
    }

    final void zzc() {
        synchronized (this) {
            if (this.zzg) return;
            ScheduledFuture<?> scheduledFuture = this.zzc;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                this.zzc.cancel(true);
                this.zze = this.zzd - this.zzb.elapsedRealtime();
            } else {
                this.zze = -1L;
            }
            this.zzg = true;
            return;
        }
    }

    final void zzd() {
        synchronized (this) {
            ScheduledFuture<?> scheduledFuture;
            if (!this.zzg) return;
            if (this.zze > 0L && (scheduledFuture = this.zzc) != null && scheduledFuture.isCancelled()) {
                this.zzc = this.zza.schedule(this.zzf, this.zze, TimeUnit.MILLISECONDS);
            }
            this.zzg = false;
            return;
        }
    }
}
