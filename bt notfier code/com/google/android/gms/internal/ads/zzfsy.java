/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfrr
 *  com.google.android.gms.internal.ads.zzfrt
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfrr;
import com.google.android.gms.internal.ads.zzfrt;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsv;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

final class zzfsy<V>
extends zzfrt<V> {
    @CheckForNull
    private zzfsm<V> zza;
    @CheckForNull
    private ScheduledFuture<?> zzb;

    private zzfsy(zzfsm<V> zzfsm2) {
        if (zzfsm2 == null) throw null;
        this.zza = zzfsm2;
    }

    static /* synthetic */ zzfsm zza(zzfsy zzfsy2) {
        return zzfsy2.zza;
    }

    static /* synthetic */ ScheduledFuture zzb(zzfsy zzfsy2) {
        return zzfsy2.zzb;
    }

    static /* synthetic */ ScheduledFuture zzx(zzfsy zzfsy2, ScheduledFuture scheduledFuture) {
        zzfsy2.zzb = null;
        return null;
    }

    static <V> zzfsm<V> zzy(zzfsm<V> zzfsm2, long l, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzfsy<V> zzfsy2 = new zzfsy<V>(zzfsm2);
        zzfsv zzfsv2 = new zzfsv(zzfsy2);
        zzfsy2.zzb = scheduledExecutorService.schedule((Runnable)zzfsv2, l, timeUnit);
        zzfsm2.zze((Runnable)zzfsv2, (Executor)zzfrr.zza);
        return zzfsy2;
    }

    @CheckForNull
    protected final String zzc() {
        Object object = this.zza;
        ScheduledFuture<?> scheduledFuture = this.zzb;
        if (object == null) return null;
        String string = object.toString();
        object = new StringBuilder(string.length() + 14);
        ((StringBuilder)object).append("inputFuture=[");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append("]");
        string = ((StringBuilder)object).toString();
        object = string;
        if (scheduledFuture == null) return object;
        long l = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        object = string;
        if (l <= 0L) return object;
        object = new StringBuilder(string.length() + 43);
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(", remaining delay=[");
        ((StringBuilder)object).append(l);
        ((StringBuilder)object).append(" ms]");
        object = ((StringBuilder)object).toString();
        return object;
    }

    protected final void zzd() {
        this.zzv((Future)this.zza);
        ScheduledFuture<?> scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }
}
