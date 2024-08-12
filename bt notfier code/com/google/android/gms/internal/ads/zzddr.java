/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzddq
 *  com.google.android.gms.internal.ads.zzdds
 *  com.google.android.gms.internal.ads.zzdgm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzddq;
import com.google.android.gms.internal.ads.zzdds;
import com.google.android.gms.internal.ads.zzdgm;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzddr
extends zzdgm<zzdds> {
    private final ScheduledExecutorService zzb;
    private final Clock zzc;
    private long zzd = -1L;
    private long zze = -1L;
    private boolean zzf = false;
    private ScheduledFuture<?> zzg;

    public zzddr(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzb = scheduledExecutorService;
        this.zzc = clock;
    }

    private final void zze(long l) {
        synchronized (this) {
            Object object = this.zzg;
            if (object != null && !object.isDone()) {
                this.zzg.cancel(true);
            }
            this.zzd = this.zzc.elapsedRealtime() + l;
            object = this.zzb;
            zzddq zzddq2 = new zzddq(this, null);
            this.zzg = object.schedule((Runnable)zzddq2, l, TimeUnit.MILLISECONDS);
            return;
        }
    }

    public final void zza() {
        synchronized (this) {
            if (this.zzf) return;
            ScheduledFuture<?> scheduledFuture = this.zzg;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.zzg.cancel(true);
                this.zze = this.zzd - this.zzc.elapsedRealtime();
            } else {
                this.zze = -1L;
            }
            this.zzf = true;
            return;
        }
    }

    public final void zzb() {
        synchronized (this) {
            if (!this.zzf) return;
            if (this.zze > 0L && this.zzg.isCancelled()) {
                this.zze(this.zze);
            }
            this.zzf = false;
            return;
        }
    }

    public final void zzc() {
        synchronized (this) {
            this.zzf = false;
            this.zze(0L);
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final void zzd(int n) {
        synchronized (this) {
            long l;
            if (n <= 0) {
                return;
            }
            long l2 = TimeUnit.SECONDS.toMillis(n);
            if (this.zzf) {
                long l3 = this.zze;
                if (l3 <= 0L || l2 >= l3) {
                    l2 = l3;
                }
                this.zze = l2;
                return;
            }
            long l4 = this.zzc.elapsedRealtime();
            if (l4 <= (l = this.zzd)) {
                l4 = this.zzc.elapsedRealtime();
                if (l - l4 <= l2) return;
            }
            {
                this.zze(l2);
                return;
            }
        }
    }
}
