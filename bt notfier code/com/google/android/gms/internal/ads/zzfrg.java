/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfre
 *  com.google.android.gms.internal.ads.zzfri
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfre;
import com.google.android.gms.internal.ads.zzfri;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import javax.annotation.CheckForNull;

final class zzfrg
extends zzfre {
    final AtomicReferenceFieldUpdater<zzfri<?>, Set<Throwable>> zza;
    final AtomicIntegerFieldUpdater<zzfri<?>> zzb;

    zzfrg(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        super(null);
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicIntegerFieldUpdater;
    }

    final void zza(zzfri<?> zzfri2, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
        this.zza.compareAndSet(zzfri2, null, set2);
    }

    final int zzb(zzfri<?> zzfri2) {
        return this.zzb.decrementAndGet(zzfri2);
    }
}
