/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzgdy
extends WeakReference<Throwable> {
    private final int zza;

    public zzgdy(Throwable throwable, ReferenceQueue<Throwable> referenceQueue) {
        super(throwable, referenceQueue);
        if (throwable == null) throw new NullPointerException("The referent cannot be null");
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
        object = (zzgdy)object;
        if (this.zza != ((zzgdy)object).zza) return false;
        if (this.get() != ((Reference)object).get()) return false;
        return true;
    }

    public final int hashCode() {
        return this.zza;
    }
}
