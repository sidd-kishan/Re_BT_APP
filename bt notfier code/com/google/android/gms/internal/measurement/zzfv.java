/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.measurement;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzfv
extends WeakReference<Throwable> {
    private final int zza;

    public zzfv(Throwable throwable, ReferenceQueue<Throwable> referenceQueue) {
        super(throwable, referenceQueue);
        this.zza = System.identityHashCode(throwable);
    }

    public final boolean equals(Object object) {
        if (object == null) return false;
        if (object.getClass() != this.getClass()) {
            return false;
        }
        if (this == object) {
            return true;
        }
        object = (zzfv)object;
        if (this.zza != ((zzfv)object).zza) return false;
        if (this.get() != ((Reference)object).get()) return false;
        return true;
    }

    public final int hashCode() {
        return this.zza;
    }
}
