/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfrx
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfrx;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzfsq<V>
extends zzfrx<V>
implements ScheduledFuture<V>,
zzfsm {
    private final ScheduledFuture<?> zza;

    public zzfsq(zzfsm<V> zzfsm2, ScheduledFuture<?> scheduledFuture) {
        super(zzfsm2);
        this.zza = scheduledFuture;
    }

    @Override
    public final boolean cancel(boolean bl) {
        boolean bl2 = this.zzb().cancel(bl);
        if (!bl2) return bl2;
        this.zza.cancel(bl);
        return bl2;
    }

    @Override
    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }
}
