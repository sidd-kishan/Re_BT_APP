/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfqw
 *  com.google.android.gms.internal.ads.zzfqw$zza
 *  com.google.android.gms.internal.ads.zzfqw$zzd
 *  com.google.android.gms.internal.ads.zzfqw$zzl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfqw;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import javax.annotation.CheckForNull;

final class zzfqw$zzf
extends zzfqw.zza {
    final AtomicReferenceFieldUpdater<zzfqw.zzl, Thread> zza;
    final AtomicReferenceFieldUpdater<zzfqw.zzl, zzfqw.zzl> zzb;
    final AtomicReferenceFieldUpdater<zzfqw, zzfqw.zzl> zzc;
    final AtomicReferenceFieldUpdater<zzfqw, zzfqw.zzd> zzd;
    final AtomicReferenceFieldUpdater<zzfqw, Object> zze;

    zzfqw$zzf(AtomicReferenceFieldUpdater<zzfqw.zzl, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzfqw.zzl, zzfqw.zzl> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzfqw, zzfqw.zzl> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzfqw, zzfqw.zzd> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzfqw, Object> atomicReferenceFieldUpdater5) {
        super(null);
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicReferenceFieldUpdater2;
        this.zzc = atomicReferenceFieldUpdater3;
        this.zzd = atomicReferenceFieldUpdater4;
        this.zze = atomicReferenceFieldUpdater5;
    }

    final void zza(zzfqw.zzl zzl2, Thread thread) {
        this.zza.lazySet(zzl2, thread);
    }

    final void zzb(zzfqw.zzl zzl2, @CheckForNull zzfqw.zzl zzl3) {
        this.zzb.lazySet(zzl2, zzl3);
    }

    final boolean zzc(zzfqw<?> zzfqw2, @CheckForNull zzfqw.zzl zzl2, @CheckForNull zzfqw.zzl zzl3) {
        return this.zzc.compareAndSet(zzfqw2, zzl2, zzl3);
    }

    final boolean zzd(zzfqw<?> zzfqw2, @CheckForNull zzfqw.zzd zzd2, zzfqw.zzd zzd3) {
        return this.zzd.compareAndSet(zzfqw2, zzd2, zzd3);
    }

    final boolean zze(zzfqw<?> zzfqw2, @CheckForNull Object object, Object object2) {
        return this.zze.compareAndSet(zzfqw2, object, object2);
    }
}
