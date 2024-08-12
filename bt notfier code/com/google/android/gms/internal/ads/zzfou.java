/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfql
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfql;
import java.util.NoSuchElementException;

final class zzfou
extends zzfql {
    boolean zza;
    final Object zzb;

    zzfou(Object object) {
        this.zzb = object;
    }

    public final boolean hasNext() {
        if (this.zza) return false;
        return true;
    }

    public final Object next() {
        if (this.zza) throw new NoSuchElementException();
        this.zza = true;
        return this.zzb;
    }
}
