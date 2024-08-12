/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzfu
 *  com.google.android.gms.internal.measurement.zzfw
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfw;

final class zzfx
extends zzfu {
    private final zzfw zza = new zzfw();

    zzfx() {
    }

    public final void zza(Throwable throwable, Throwable throwable2) {
        if (throwable2 == throwable) throw new IllegalArgumentException("Self suppression is not allowed.", throwable2);
        this.zza.zza(throwable, true).add(throwable2);
    }
}
